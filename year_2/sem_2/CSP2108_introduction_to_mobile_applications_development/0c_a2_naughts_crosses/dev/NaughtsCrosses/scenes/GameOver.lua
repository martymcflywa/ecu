-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

--[[
    Define the listeners for the buttons.
--]]

-- start all over again
local function replay(self, event)
    composer.gotoScene("scenes.ReplayScreen", self.options);
end

-- kill the game
local function back(self, event)
    -- TODO: add "are you sure" screen/overlay
    -- This does nothing on iOS
    -- could use os.back() to kill but not advised
    composer.gotoScene("scenes.MainMenu", self.options);
end

function scene:init(sceneGroup, params)
    self.yOffset = _h * 0.2;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.25;
    self.font = "Arial";
    self.gameOverText = "GAME\nOVER";
    self.replayText = "REPLAY";
    self.backText = "BACK";
    -- setup background
    self.bg = self:initBg(sceneGroup);
    -- setup title
    self.titleGameOver = self:initTitleGameOver(sceneGroup);
    self.titleMessage = self:initTitleMessage(sceneGroup, params.message);
    -- setup buttons
    local xOffset = _cx * 0.5;
    self.buttonReplay = self:initButton(
        sceneGroup, 
        _cx - xOffset, 
        _colors["red"], 
        self.replayText
    );
    self.buttonBack = self:initButton(
        sceneGroup,
        _cx + xOffset,
        _colors["green"],
        self.backText
    );
    self.options = {
        effect = "flipFadeOutIn",
        time = 100,
        params = {
            game = params.game
        }
    };
    -- add listeners to the buttons
    self.buttonReplay.options = self.options;
    self.buttonReplay.touch = replay;
    self.buttonReplay:addEventListener(_event, touch);
    self.buttonBack.options = self.options;
    self.buttonBack.touch = back;
    self.buttonBack:addEventListener(_event, touch);
end

function scene:initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(_colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

function scene:initTitleGameOver(sceneGroup)
    local yOffset = _cy - self.yOffset;
    local titleGameOverOptions = {
        text = self.gameOverText,
        font = self.font,
        fontSize = 70,
        align = "center",
        x = _cx,
        y = yOffset
    };
    local label = _d.newText(titleGameOverOptions);
    label:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(label);
    return label;
end

function scene:initTitleMessage(sceneGroup, message)
    local titleMessageOptions = {
        text = message,
        font = self.font,
        fontSize = 25,
        align = "center",
        x = _cx,
        y = _cy + (self.yOffset * 0.3)
    };
    local label = _d.newText(titleMessageOptions);
    label:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(label);
    return label;
end

function scene:initButton(sceneGroup, xPos, color, label)
    local yOffset = _cy + self.yOffset + 50;
    local buttonGroup = _d.newGroup();
    local button = _d.newRect(
        buttonGroup,
        xPos,
        yOffset,
        self.buttonW,
        self.buttonH
    );
    button:setFillColor(unpack(color));
    local buttonLabelOptions = {
        parent = buttonGroup,
        text = label,
        font = self.font,
        fontSize = 38,
        align = "center",
        x = xPos,
        y = yOffset
    };
    local buttonLabel = _d.newText(buttonLabelOptions);
    buttonLabel:setFillColor(unpack(_colors["white"]));
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
    self:init(sceneGroup, event.params);
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
        -- destroy play screen so it starts over again
        composer.removeScene("scenes.PlayScreen");
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

        -- TODO: hacky, but works.
        composer.removeScene("scenes.GameOver");
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