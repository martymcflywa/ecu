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

--[[
    Using table listener here, method name == event name. 
--]]
function scene:touch(event)
    -- ai first turn, proxy event.x will be nil
    if(event.x == nil) then
        self.game.ai:turn(event);
    else
        if(not self:isGameOver()) then
            if(self.game.player:turn(event)) then
                if(not self:isGameOver()) then
                    self.game.ai:turn(event);
                    -- do one last check if game over, ai might take a winning turn
                    self:isGameOver();
                end
            end
        end
    end
end

function scene:init(sceneGroup, playerChar)
    self.options = {
        effect = "zoomInOutFade",
        time = 1000,
        params = {}
    };
    self.playerChar = playerChar;
    self.bg = self:initBg(sceneGroup);
    self.game = Game(playerChar, sceneGroup);
    self.game.board:draw();
    self.bg:addEventListener(_event, scene);

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

function scene:dispose(sceneGroup)
    if(self.game ~= nil) then
        self.game:dispose();
        self.game = nil;
        if(self.game.board ~= nil) then
            self.game.board:dispose();
            self.game.board = nil;
        end
        if(self.playerChar ~= nil) then
            self.playerChar = nil;
        end
    end
    collectgarbage();
end

--[[
    Checks if game is over. If so, goto appropriate scene.
--]]
function scene:isGameOver()
    if(self.game.board:isGameOver()) then
        if(self.game.board.winner == _chars["empty"]) then
            logger:log("PlayScreen", "isGameOver()", "game over, tie game!");
            self:handleDraw();
            return true;
        else
            logger:log("PlayScreen", "isGameOver()", string.format("game over, winner is %s!", self.game.board.winner));
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
    -- clear everything when restarting scene
    self:dispose(sceneGroup);
    self:init(sceneGroup, event.params.char);
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
        -- clear the board
        -- dispose(sceneGroup);
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