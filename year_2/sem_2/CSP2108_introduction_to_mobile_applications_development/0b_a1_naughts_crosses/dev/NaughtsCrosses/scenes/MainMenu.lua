local composer = require("composer");
local scene = composer.newScene();

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
]]--

function scene:create(event)
    local sceneGroup = self.view;
    --[[
        Code in create() runs when the scene is first created,
        before appearing on the screen.
        Create ui/display objects here, ie. buttons, text, graphics etc
        so it's ready when show() is dispatched.
    ]]--
end

function scene:show(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    if(phase == "will") then
    --[[
        Code executed when scene is still off screen, but about to be shown.
        Reset variable values or reposition objects to start points,
        ie. restarting the level etc.
    ]]--

    elseif(phase == "did") then
    --[[
        Code executed when scene is completely on screen. Has become the active screen.
        Start transitions, timers, start music for the scene or physics etc.
    ]]--
    end
end

function scene:hide(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    if(phase == "will") then
    --[[
        Code executed when scene is still on screen, but about to be hidden.
        Pause/stop physics, cancel timers/transitions, stop music etc.
    ]]--
    elseif(phase == "did") then
    --[[
        Code executed when scene is completely off screen.
        Scene view remains initialized and stays in memory,
        could be reused without initializing.
    ]]--
    end
end

function scene:destroy(event)
    local sceneGroup = self.view;
    --[[
        Code executed before removing scene's view.
        Undo stuff from when create() was called, ie. dispose.

        To remove a scene, call composer.removeScene(name);
        Can also pass shouldRecycle bool: composer.removeScene(name, true);
        Recycled scenes stay in mem.
    ]]--
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