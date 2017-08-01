-- screens.logo

local composer = require ("composer")       -- Include the Composer library. Please refer to -> http://docs.coronalabs.com/api/library/composer/index.html
local scene = composer.newScene()           -- Created a new scene


local mainGroup         -- Our main display group. We will add display elements to this group so Composer will handle these elements for us.
-- For more information about groups, please refer to this guide -> http://docs.coronalabs.com/guide/graphics/group.html

local tmr       -- Forward reference to a timer.


-- Clean up method for memory purposes. This can be named anything you want
local function cleanUp()
    -- Cleaning up the Timer object tmr
    --if ( tmr ) then
        timer.cancel(tmr)
        tmr = nil
    --end

    -- If you are not sure if the tmr object exists or want to take a defensive approach, you can check it with if clause
end

local function changeScene()
    composer.gotoScene( "screens.mainMenu", "crossFade", 1500 )
end

function scene:create( event )
    local mainGroup = self.view         -- We've initialized our mainGroup. This is a MUST for Composer library.

    local sleepyBug = display.newImageRect( "assets/logo.png", 900, 285 )       -- Create a new image, logo.png (900px x 285px) from the assets folder. Default anchor point is center.
    sleepyBug.x = display.contentCenterX        -- Assign the x value of the image to the center of the X axis.
    sleepyBug.y = display.contentCenterY        -- Assign the y value of the image to the center of the Y axis.
    mainGroup:insert(sleepyBug)         -- Add the image to the display group.

    -- Further reading of Display API -> http://docs.coronalabs.com/api/library/display/index.html
end


function scene:show( event )
    local phase = event.phase

    if ( phase == "will" ) then         -- Scene is not shown entirely

    elseif ( phase == "did" ) then      -- Scene is fully shown on the screen

        -- Wait 4000 ms to show studio logo and then, call changeScene()
        -- This will happen once since its iteration number is defined as 1.
        -- You can define it as many as you want but consider the exceptional values 0 and -1, which will make the timer loop forever.
        -- For more information about timers, please refer to this document -> http://docs.coronalabs.com/api/library/timer/index.html
        tmr = timer.performWithDelay( 4000, changeScene, 1 )        

        --[[
        Another method for the line above using Lua closures:

        tmr = timer.performWithDelay( 4000, function () 
        composer.gotoScene( "screens.gameIntro", "crossFade", 1500 ) 
        end, 1 )

        For more information about Lua closures, please refer to this guide -> http://www.lua.org/pil/6.1.html
        ]]--
    end
end


function scene:hide( event )
    local phase = event.phase

    if ( phase == "will" ) then         -- Scene is not off the screen entirely

        cleanUp()       -- Clean up the scene from timers, transitions, listeners

    elseif ( phase == "did" ) then      -- Scene is off the screen

    end
end

function scene:destroy( event )
    -- Called before the scene is removed
end

-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene

-- You can refer to the official Composer template for more -> http://docs.coronalabs.com/api/library/composer/index.html#template