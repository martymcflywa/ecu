-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
]]--

-- scene objects
local bg;
local titleGame;
local titleMenu;
local buttonX;
local buttonO;

-- scene object parameters
local yOffset = _h * 0.2;
local font = "Arial";
local titleGameText = "x|o|x";
local titleMenuText = "choose your weapon";
local colors = {
    black = {0, 0, 0},
    white = {1, 1, 1},
    red = {1, 0, 0},
    green = {0, 1, 0}
};
local gameSceneOptions = {
    time = 1000,
    params = {}
};

--[[
    Defining initializers first.
]]
local function initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

local function initTitleGame(sceneGroup)
    local yOffset = _cy - yOffset;
    local titleGameOptions = {
        text = titleGameText,
        font = font,
        fontSize = 125,
        align = "center",
        x = _cx,
        y = yOffset
    };
    local titleGame = _d.newText(titleGameOptions);
    titleGame:setFillColor(unpack(colors["black"]));
    sceneGroup:insert(titleGame);
    return titleGame;
end

local function initTitleMenu(sceneGroup)
    local titleMenuOptions = {
        text = titleMenuText,
        font = font,
        fontSize = 25,
        align = "center",
        x = _cx,
        y = _cy
    };
    local titleMenu = _d.newText(titleMenuOptions);
    titleMenu:setFillColor(unpack(colors["black"]));
    sceneGroup:insert(titleMenu);
    return titleMenu;
end

local function initButton(sceneGroup, xPos, color, char)
    local buttonGroup = _d.newGroup();
    buttonGroup.char = char;
    local button = _d.newRect(
        buttonGroup,
        xPos,
        _cy + yOffset,
        _w * 0.43,
        _h * 0.23
    );
    button:setFillColor(unpack(color));

    local buttonTextOptions = {
        parent = buttonGroup,
        text = char,
        font = font,
        fontSize = 70,
        align = "center",
        x = xPos,
        y = _cy + yOffset
    };
    local buttonText = _d.newText(buttonTextOptions);
    buttonText:setFillColor(unpack(colors["white"]));

    sceneGroup:insert(buttonGroup);
    return buttonGroup;
end

--[[
    Dispatch to these functions when either x or o button is clicked.
]]--
local function playerIsX(event)
    if(event.phase == "ended") then
        gameSceneOptions.effect = "fromLeft";
        gameSceneOptions.params.char = "x";
        composer.gotoScene("scenes.Game", gameSceneOptions);
    end
end

local function playerIsO(event)
    if(event.phase == "ended") then
        gameSceneOptions.effect = "fromRight";
        gameSceneOptions.params.char = "o";
        composer.gotoScene("scenes.Game", gameSceneOptions);
    end
end

--[[
    Code in create() runs when the scene is first created,
    before appearing on the screen.
    Create ui/display objects here, ie. buttons, text, graphics etc
    so it's ready when show() is dispatched.
]]--
function scene:create(event)
    local sceneGroup = self.view;
    -- setup background
    bg = initBg(sceneGroup);
    -- setup title objects
    titleGame = initTitleGame(sceneGroup);
    titleMenu = initTitleMenu(sceneGroup);
    -- setup buttons
    buttonX = initButton(sceneGroup, _cx - (_cx * 0.43), colors["red"], "x");
    buttonO = initButton(sceneGroup, _cx + (_cx * 0.43), colors["green"], "o");
    -- add listeners to the buttons
    buttonX:addEventListener("touch", playerIsX);
    buttonO:addEventListener("touch", playerIsO);
end

function scene:show(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    --[[
        "will" code executed when scene is still off screen, but about to be shown.
        Reset variable values or reposition objects to start points,
        ie. restarting the level etc.
    ]]--
    if(phase == "will") then
        -- do stuff just before shown

    --[[
        "did" code executed when scene is completely on screen. Has become the active screen.
        Start transitions, timers, start music for the scene or physics etc.
    ]]--
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
    ]]--
    if(phase == "will") then
        -- do stuff just before hidden

    --[[
        "did" code executed when scene is completely hidden.
        Scene view remains initialized and stays in memory,
        could be reused without initializing.
    ]]--
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
]]--
function scene:destroy(event)
    local sceneGroup = self.view;
end

--[[
    These events will be dispatched when transitioning to the scene.
]]--
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
]]

return scene;