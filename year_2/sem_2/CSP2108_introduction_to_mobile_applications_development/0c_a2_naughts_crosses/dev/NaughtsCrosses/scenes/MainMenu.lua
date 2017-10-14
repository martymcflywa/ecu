-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

local function scores(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromLeft";
        composer.gotoScene("scenes.ScoreScreen", self.options);
    end
end

local function play(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromRight";
        composer.gotoScene("scenes.PlayMenu", self.options);
    end
end

function scene:init(sceneGroup)
    self.yOffset = _h * 0.2;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.25;
    self.font = "Arial";
    self.titleGameText = "xvso";
    self.titleMenuText = "main menu";
    self.options = {
        time = 200,
        params = {}
    };
    -- setup background
    self.bg = self:initBg(sceneGroup);
    -- setup title objects
    self.titleGame = self:initTitleGame(sceneGroup);
    self.titleMenu = self:initTitleMenu(sceneGroup);
    -- setup buttons
    local buttonScoresXPosOffset = _cx * 0.5;
    self.buttonPlay = self:initButton(sceneGroup, _cx - buttonScoresXPosOffset, _colors["green"], "PLAY");
    self.buttonPlay.touch = play;
    self.buttonPlay:addEventListener(_event, touch);
    self.buttonScores = self:initButton(sceneGroup, _cx + buttonScoresXPosOffset, _colors["red"], "SCORE");
    self.buttonScores.touch = scores;
    self.buttonScores:addEventListener(_event, touch);
end

function scene:dispose(sceneGroup)
    if(sceneGroup ~= nil) then
        sceneGroup:removeSelf();
    end
    if(self.buttonScores ~= nil) then
        self.buttonScores:removeEventListener(_event, playerX);
    end
    if(self.buttonPlay ~= nil) then
        self.buttonPlay:removeEventListener(_event, playerO);
    end
end

function scene:initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(_colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

function scene:initTitleGame(sceneGroup)
    local yOffset = _cy - self.yOffset;
    local titleGameOptions = {
        text = self.titleGameText,
        font = self.font,
        fontSize = 125,
        align = "center",
        x = _cx,
        y = yOffset
    };
    local titleGame = _d.newText(titleGameOptions);
    titleGame:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(titleGame);
    return titleGame;
end

function scene:initTitleMenu(sceneGroup)
    local titleMenuOptions = {
        text = self.titleMenuText,
        font = self.font,
        fontSize = 40,
        align = "center",
        x = _cx,
        y = _cy
    };
    local titleMenu = _d.newText(titleMenuOptions);
    titleMenu:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(titleMenu);
    return titleMenu;
end

function scene:initButton(sceneGroup, xPos, color, char)
    local buttonGroup = _d.newGroup();
    local yOffset = _cy + self.yOffset + 50;
    buttonGroup.char = char;
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
        text = char,
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
    self:init(sceneGroup);
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