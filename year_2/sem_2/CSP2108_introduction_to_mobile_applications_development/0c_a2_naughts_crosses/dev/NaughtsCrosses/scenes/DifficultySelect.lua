-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

--[[
    Using table listeners to make it possible to pass options to it.
    See https://stackoverflow.com/questions/30262822/how-to-use-table-listeners-in-corona-sdk-and-how-it-works
--]]
local function easy(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromTop";
        self.options.params.difficulty = _difficulty["e"];
        logger:debug(composer.getSceneName("current"), "easy()", string.format("difficulty is %s", _difficulty["e"]));
        composer.gotoScene("scenes.PlayScreen", self.options);
    end
end

local function medium(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromTop";
        self.options.params.difficulty = _difficulty["m"];
        logger:debug(composer.getSceneName("current"), "medium()", string.format("difficulty is %s", _difficulty["m"]));
        composer.gotoScene("scenes.PlayScreen", self.options);
    end
end

local function hard(self, event)
    if(event.phase == "ended") then
        self.options.effect = "fromTop";
        self.options.params.difficulty = _difficulty["h"];
        logger:debug(composer.getSceneName("current"), "hard()", string.format("difficulty is %s", _difficulty["h"]));
        composer.gotoScene("scenes.PlayScreen", self.options);
    end
end

function scene:init(event, sceneGroup)
    self.yOffset = _h * 0.2;
    self.buttonW = _w * 0.5;
    self.buttonH = _h * 0.1;
    self.font = "Arial";
    self.titleGameText = "xvso";
    self.titleMenuText = "choose difficulty";
    self.buttonEasyText = "EASY";
    self.buttonMediumText = "MEDIUM";
    self.buttonHardText = "HARD";
    self.options = {
        time = 200,
        params = {
            char = event.params.char
        }
    };
    -- setup background
    self.bg = self:initBg(sceneGroup);
    -- setup title objects
    self.titleGame = self:initTitleGame(sceneGroup);
    self.titleMenu = self:initTitleMenu(sceneGroup);
    -- setup buttons
    local yOffset = _cy + self.yOffset - (self.buttonH * 0.5);
    self.easy = self:initButton(sceneGroup, yOffset, _colors["green"], self.buttonEasyText);
    self.easy.touch = easy;
    self.easy:addEventListener(_event, touch); 
    yOffset = yOffset + self.buttonH + (self.buttonH * 0.25);   
    self.medium = self:initButton(sceneGroup, yOffset, _colors["orange"], self.buttonMediumText);
    self.medium.touch = medium;
    self.medium:addEventListener(_event, touch);
    yOffset = yOffset + self.buttonH + (self.buttonH * 0.25);
    self.hard = self:initButton(sceneGroup, yOffset, _colors["red"], self.buttonHardText);
    self.hard.touch = hard;
    self.hard:addEventListener(_event, touch);
end

function scene:dispose(sceneGroup)
    if(sceneGroup ~= nil) then
        sceneGroup:removeSelf();
    end
    if(self.buttonX ~= nil) then
        self.buttonX:removeEventListener(_event, playerX);
    end
    if(self.buttonO ~= nil) then
        self.buttonO:removeEventListener(_event, playerO);
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
        fontSize = 25,
        align = "center",
        x = _cx,
        y = _cy
    };
    local titleMenu = _d.newText(titleMenuOptions);
    titleMenu:setFillColor(unpack(_colors["orange"]));
    sceneGroup:insert(titleMenu);
    return titleMenu;
end

function scene:initButton(sceneGroup, yPos, color, char)
    local buttonGroup = _d.newGroup();
    buttonGroup.char = char;
    local button = _d.newRect(
        buttonGroup,
        _cx,
        yPos,
        self.buttonW,
        self.buttonH
    );
    button:setFillColor(unpack(color));

    local buttonTextOptions = {
        parent = buttonGroup,
        text = char,
        font = self.font,
        fontSize = 35,
        align = "center",
        x = _cx,
        y = yPos
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
    self:init(event, sceneGroup);
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
        composer.removeScene("scenes.DifficultySelect");
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
    These listeners will be dispatched when transitioning to the scene.
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