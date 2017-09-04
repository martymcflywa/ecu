-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

-- scene objects
local titleGameOver;
local titleMessage;
local buttonPlayAgain;
local buttonExit;

-- scene object parameters
local yOffset = _h * 0.2;
local buttonW = _w * 0.5;
local buttonH = _h * 0.25;
local font = "Arial";
local gameOverText = "GAME\nOVER";
local playAgainText = "AGAIN";
local exitText = "EXIT";

--[[
    Defining initializers first.
--]]
local function initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(_colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

local function initTitleGameOver(sceneGroup)
    local yOffset = _cy - yOffset;
    local titleGameOverOptions = {
        text = gameOverText,
        font = font,
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

local function initTitleMessage(sceneGroup, message)
    local titleMessageOptions = {
        text = message,
        font = font,
        fontSize = 25,
        align = "center",
        x = _cx,
        y = _cy + (yOffset * 0.3)
    };
    local label = _d.newText(titleMessageOptions);
    label:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(label);
    return label;
end

local function initButton(sceneGroup, xPos, color, label)
    local yOffset = _cy + yOffset + 50;
    local buttonGroup = _d.newGroup();
    local button = _d.newRect(
        buttonGroup,
        xPos,
        yOffset,
        buttonW,
        buttonH
    );
    button:setFillColor(unpack(color));
    local buttonLabelOptions = {
        parent = buttonGroup,
        text = label,
        font = font,
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
    Define the listeners for the buttons.
--]]

-- start all over again
local function playAgain(event)
    composer.gotoScene("scenes.MainMenu", {effect = "fade", time = 500});
end

-- kill the game
local function exit(event)
    -- TODO: add "are you sure" screen
    native.requestExit();
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
    -- setup background
    bg = initBg(sceneGroup);
    -- setup title
    titleGameOver = initTitleGameOver(sceneGroup);
    titleMessage = initTitleMessage(sceneGroup, message);
    -- setup buttons
    local xOffset = _cx * 0.5;
    buttonPlayAgain = initButton(
        sceneGroup, 
        _cx - xOffset, 
        _colors["green"], 
        playAgainText
    );
    buttonExit = initButton(
        sceneGroup,
        _cx + xOffset,
        _colors["red"],
        exitText
    );
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

        -- add listeners to the buttons
        buttonPlayAgain:addEventListener(_event, playAgain);
        buttonExit:addEventListener(_event, exit);
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