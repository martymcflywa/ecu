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
local function playAgain(event)
    composer.gotoScene("scenes.MainMenu", {effect = "flipFadeOutIn", time = 100});
end

-- kill the game
local function exit(event)
    -- TODO: add "are you sure" screen/overlay
    -- This does nothing on iOS
    -- could use os.exit() to kill but not advised
    native.requestExit();
end

function scene:init(sceneGroup, message)
    self.yOffset = _h * 0.2;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.25;
    self.font = "Arial";
    self.gameOverText = "GAME\nOVER";
    self.playAgainText = "AGAIN";
    self.exitText = "EXIT";
    -- setup background
    self.bg = self:initBg(sceneGroup);
    -- setup title
    self.titleGameOver = self:initTitleGameOver(sceneGroup);
    self.titleMessage = self:initTitleMessage(sceneGroup, message);
    -- setup buttons
    local xOffset = _cx * 0.5;
    self.buttonPlayAgain = self:initButton(
        sceneGroup, 
        _cx - xOffset, 
        _colors["green"], 
        self.playAgainText
    );
    self.buttonExit = self:initButton(
        sceneGroup,
        _cx + xOffset,
        _colors["red"],
        self.exitText
    );
    -- add listeners to the buttons
    self.buttonPlayAgain:addEventListener(_event, playAgain);
    self.buttonExit:addEventListener(_event, exit);
end

function scene:dispose(sceneGroup)
    if(sceneGroup ~= nil) then
        sceneGroup:removeSelf();
    end
    if(self.buttonPlayAgain ~= nil) then
        self.buttonPlayAgain:removeEventListener(_event, playAgain);
    end
    if(self.buttonExit ~= nil) then
        self.buttonExit:removeEventListener(_event, buttonExit);
    end
    if(self.titleMessage ~= nil) then
        self.titleMessage:removeSelf();
    end
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
        fontSize = 40,
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
    local message = event.params.message;
    self:dispose(sceneGroup);
    self:init(sceneGroup, message);
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