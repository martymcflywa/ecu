-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

--[[
    Using table listener here, method name == event name. 
--]]

local function pushTurn(event)
    local board = event.source.params.board;
    local turns = event.source.params.turns;
    local turn = turns[event.count];
    board:pushMark(turn.row, turn.col, turn.char, turn.color, turn.textOptions);
    logger:debug(
        composer.getSceneName("current"), 
        "pushTurn()", 
        string.format("Replaying turn %d: isPlayer=%s, row=%d, col=%d, char=%s",
            event.count,
            tostring(turn.isPlayer),
            turn.row,
            turn.col,
            turn.char));
end

local function replay(self, event)
    if(event.phase == "ended") then
        self.board:newBoard();
        self.board.sceneGroup = self.sceneGroup;
        local turns = {};
        -- copy each turn to turns table, use turns with timer.performWithDelay
        for turn in self.board.turnLog:replay() do
            local t = {
                isPlayer = turn.isPlayer,
                row = turn.row,
                col = turn.col,
                char = turn.char,
                color = turn.color,
                textOptions = turn.textOptions
            };
            table.insert(turns, t);
        end
        local params = {
            turns = turns,
            board = self.board;
        };
        -- tm passes count to handle, use it to determine which turn to push
        local tm = timer.performWithDelay(1000, pushTurn, #turns);
        tm.params = params;
    end
end

local function back(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromRight";
        self.options.time = 200;
        composer.gotoScene("scenes.MainMenu", self.options);
    end
end

function scene:init(sceneGroup, game)
    self.yOffset = _h * 0.45;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.1;
    self.font = "Arial";
    self.buttonReplayLabel = "REPLAY";
    self.buttonBackLabel = "BACK";
    self.options = {
        effect = "zoomInOutFade",
        time = 1000,
        params = {}
    };
    self.playerChar = playerChar;
    self.bg = self:initBg(sceneGroup);
    self.bg:addEventListener(_event, scene);
    self.game = game;
    self.game.board:draw(sceneGroup);

    -- setup buttons
    local buttonXPosOffset = _cx * 0.5;    
    self.buttonReplay = self:initButton(sceneGroup, _cx - buttonXPosOffset, _colors["green"], self.buttonReplayLabel);
    self.buttonReplay.touch = replay;
    self.buttonReplay.board = self.game.board;
    self.buttonReplay.sceneGroup = sceneGroup;
    self.buttonReplay:addEventListener(_event, touch);
    self.buttonBack = self:initButton(sceneGroup, _cx + buttonXPosOffset, _colors["red"], self.buttonBackLabel);
    self.buttonBack.touch = back;
    self.buttonBack:addEventListener(_event, touch);
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
    Code in create() runs when the scene is first created,
    before appearing on the screen.
    Create ui/display objects here, ie. buttons, text, graphics etc
    so it's ready when show() is dispatched.
--]]
function scene:create(event)
    local sceneGroup = self.view;
    -- clear everything when restarting scene
    self:init(sceneGroup, event.params.game);
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
        composer.removeScene("scenes.ReplayScreen");
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