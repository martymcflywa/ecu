-- screens.creditSceen

local composer = require ("composer")       -- Include the Composer library. Please refer to -> http://docs.coronalabs.com/api/library/composer/index.html
local scene = composer.newScene()           -- Created a new scene

local mainGroup         -- Our main display group. We will add display elements to this group so Composer will handle these elements for us.
-- For more information about groups, please refer to this guide -> http://docs.coronalabs.com/guide/graphics/group.html


-- If not defined here, removeEventListener will not work because changeScene won't be visible.
-- You need to follow visibility rules or forward reference your variables and methods
local function changeScene (event)
	if ( event.phase == "ended" ) then
		composer.gotoScene( "screens.mainMenu", "crossFade", 1000 )
	end
	return true 		-- To prevent more than one click

	-- For more information about events, please refer to the following documents
    -- http://docs.coronalabs.com/api/event/index.html
    -- http://docs.coronalabs.com/guide/index.html#events-and-listeners
end

-- Clean up method for memory purposes. This can be named anything you want
local function cleanUp()
	-- Remove the Runtime event listener manually. Corona SDK doesn't handle Runtime listeners automatically.
	-- If not handled, it will probably throw out an error or show some unexpected behavior
    Runtime:removeEventListener( "touch", changeScene )

    -- Corona SDK will remove the listeners that are attached to objects if the object is destroyed.
end

function scene:create( event )
    local mainGroup = self.view         -- We've initialized our mainGroup. This is a MUST for Composer library.

    local sleepyBug = display.newImageRect( "assets/logo.png", 900, 285 )       -- Create a new image, logo.png (900px x 285px) from the assets folder. Default anchor point is center.
    sleepyBug.x = display.contentCenterX        -- Assign the x value of the image to the center of the X axis.
    sleepyBug.y = display.contentCenterY - sleepyBug.height / 2        -- Assign the y value of the image.
    mainGroup:insert(sleepyBug)         -- Add the image to the display group.


    local nameDev = display.newText( "Serkan Aksit", 0, 0, native.systemFontBold, 64 )		-- Create a new text in (0, 0) using the system font with a size of 64.
    -- Use ( "text", x, y, width, height, font, fontSize ) for multi-line text. Defining height = 0 will make the object automatically adjust to the height of the given text.
    nameDev.x = display.contentCenterX
    nameDev.y = display.contentCenterY + nameDev.height / 2
    mainGroup:insert(nameDev)


    -- Further reading of Display API -> http://docs.coronalabs.com/api/library/display/index.html
end


function scene:show( event )
    local phase = event.phase

    if ( phase == "will" ) then         -- Scene is not shown entirely

    elseif ( phase == "did" ) then      -- Scene is fully shown on the screen
    	Runtime:addEventListener( "touch", changeScene )
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