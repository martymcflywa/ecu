-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();
local Board = require("Board");
local Game = require("Game");
local Persist = require("Persist");

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

local delay = 5000;
local canUndo;

local function stopUndo()
    canUndo = false;
end

local undoTimer = timer.performWithDelay(delay, stopUndo);

--[[
    Using table listener here, method name == event name. 
--]]
function scene:touch(event)
    -- ai first turn, proxy event.x will be nil
    if(not event.x) then
        self.game.ai:turn(event);
    else
        if(not self:isGameOver()) then
            if(self.game.player:turn(event)) then
                canUndo = true;
                timer.cancel(undoTimer);
                timer.performWithDelay(delay, stopUndo);
                if(not self:isGameOver()) then
                    self.game.ai:turn(event);
                    -- do one last check if game over, ai might take a winning turn
                    self:isGameOver();
                end
            end
        end
    end
end

local function undo(self, event)
    if(event.phase == "ended") then
        if(canUndo) then
            self.board:popTurn();            
        else
            logger:debug(composer.getSceneName("current"), "undo()", string.format("Undo timer expired: %ds", delay / 1000));
        end
    end
end

local function back(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromRight";
        self.options.time = 200;
        composer.gotoScene("scenes.MainMenu", self.options);
    end
end

function scene:init(sceneGroup, playerChar, difficulty)
    self.yOffset = _h * 0.45;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.1;
    self.font = "Arial";
    self.buttonUndoLabel = "UNDO";
    self.buttonBackLabel = "BACK";
    self.options = {
        effect = "zoomInOutFade",
        time = 1000,
        params = {}
    };
    self.playerChar = playerChar;
    self.difficulty = difficulty;
    self.bg = self:initBg(sceneGroup);
    self.bg:addEventListener(_event, scene);
    self.game = Game(playerChar, difficulty, sceneGroup);
    self.game.board:draw(sceneGroup);

    -- setup buttons
    local buttonXPosOffset = _cx * 0.5;    
    self.buttonUndo = self:initButton(sceneGroup, _cx - buttonXPosOffset, _colors["red"], self.buttonUndoLabel);
    self.buttonUndo.touch = undo;
    self.buttonUndo.board = self.game.board;
    self.buttonUndo:addEventListener(_event, touch);
    self.buttonBack = self:initButton(sceneGroup, _cx + buttonXPosOffset, _colors["green"], self.buttonBackLabel);
    self.buttonBack.touch = back;
    self.buttonBack:addEventListener(_event, touch);

    -- add ref to game to params, need to pass it to replay screen
    self.options.params.game = self.game;

    -- if ai goes first, dispatch a proxy event to trigger gameplay
    if(self.playerChar == _chars[_o]) then
        local proxyEvent = {
            name = "touch",
            phase = "ended",
            target = bg
        };
        self.bg:dispatchEvent(proxyEvent);
    end
end

function scene:initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(_colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

function scene:initButton(sceneGroup, xPos, color, label)
    local buttonGroup = _d.newGroup();
    local yOffset = _cy + self.yOffset;
    local button = _d.newRect(
        buttonGroup,
        xPos,
        yOffset,
        self.buttonW,
        self.buttonH
    );
    button:setFillColor(unpack(color));

    local buttonTextOptions = {
        parent = buttonGroup,
        text = label,
        font = self.font,
        fontSize = 38,
        align = "center",
        x = xPos,
        y = yOffset
    };
    local buttonText = _d.newText(buttonTextOptions);
    buttonText:setFillColor(unpack(_colors["white"]));
    buttonGroup.options = self.options;
    sceneGroup:insert(buttonGroup);
    return buttonGroup;
end

--[[
    Checks if game is over. If so, goto appropriate scene.
--]]
function scene:isGameOver()
    if(self.game.board:isGameOver()) then
        if(self.game.board.winner == _chars["empty"]) then
            logger:debug("PlayScreen", "isGameOver()", "game over, tie game!");
            self:handleDraw();
            return true;
        else
            logger:debug("PlayScreen", "isGameOver()", string.format("game over, winner is %s!", self.game.board.winner));
            self:handleWin();
            return true;
        end
    end
    return false;
end

local function updateScores(result)
    local persist = Persist();
    local scores = persist:loadScores();
    if(result == "d") then
        scores.draw = scores.draw + 1;
    elseif(result == "w") then
        scores.win = scores.win + 1;
    elseif(result == "l") then
        scores.loss = scores.loss + 1;
    end
    persist:saveScores(scores);
end

function scene:handleDraw()
    updateScores("d");
    self.options.params.message = "tie game\nyou both lose";
    timer.performWithDelay(800, function() composer.gotoScene("scenes.GameOver", self.options); end);
end

function scene:handleWin()
    local message;
    local winChar;
    local isPlayerWinner = false;
    if(self.game.board.winner == _chars[_x]) then
        winChar = _x;
    else
        winChar = _o;
    end
    if(self.playerChar == _chars[winChar]) then
        updateScores("w");
        message = string.format("you won with '%s'\nwell done", winChar);
    else
        updateScores("l");
        message = string.format("you lose\nai beat you with '%s'", winChar);
    end
    self.options.params.message = message;
    timer.performWithDelay(500, function() composer.gotoScene("scenes.GameOver", self.options); end);
end

--[[
    Code in create() runs when the scene is first created,
    before appearing on the screen.
    Create ui/display objects here, ie. buttons, text, graphics etc
    so it's ready when show() is dispatched.
--]]
function scene:create(event)
    local sceneGroup = self.view;
    self:init(sceneGroup, event.params.char, event.params.difficulty);
end

function scene:show(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    --[[
        "will" code executed when scene is still off screen, but about to be shown.
        Reset variable values or reposition objects to start points,
        ie. restarting the level etc.
    --]]
    if(phase == "will") then
        -- do stuff just before shown
        -- setupGame(sceneGroup, event.params.char);
    --[[
        "did" code executed when scene is completely on screen. Has become the active screen.
        Start transitions, timers, start music for the scene or physics etc.
    --]]
    elseif(phase == "did") then
        -- do stuff when shown
    end
end

function scene:hide(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    --[[
        "will" code executed when scene is still on screen, but about to be hidden.
        Pause/stop physics, cancel timers/transitions, stop music etc.
    --]]
    if(phase == "will") then
        -- do stuff just before hidden

    --[[
        "did" code executed when scene is completely hidden.
        Scene view remains initialized and stays in memory,
        could be reused without initializing.
    --]]
    elseif(phase == "did") then
        -- do stuff when hidden
        composer.removeScene("scenes.PlayScreen");
    end
end

--[[
    Code executed before removing scene's view.
    Undo stuff from when create() was called, ie. dispose.

    To remove a scene, call composer.removeScene(name);
    Can also pass shouldRecycle bool: composer.removeScene(name, true);
    Recycled scenes stay in mem.
--]]
function scene:destroy(event)
    local sceneGroup = self.view;
    -- dispose(sceneGroup);
end

--[[
    These events will be dispatched when transitioning to the scene.
--]]
scene:addEventListener("create", scene);
scene:addEventListener("show", scene);
scene:addEventListener("hide", scene);
scene:addEventListener("destroy", scene);

--[[
    When done with a scene, remember to:
        - Remove runtime listeners
        - Cancel transitions/timers
        - Dispose audio
        - Close IO (files/db etc.)
--]]

return scene;