--screens.gameLevel

local composer = require ("composer")       -- Include the Composer library. Please refer to -> http://docs.coronalabs.com/api/library/composer/index.html
local scene = composer.newScene()           -- Created a new scene

local mainGroup         -- Our main display group. We will add display elements to this group so Composer will handle these elements for us.
-- For more information about groups, please refer to this guide -> http://docs.coronalabs.com/guide/graphics/group.html


local variableText = composer.getVariable( "variableString" )		-- Get the variable "variableString" defined in main.lua
local fontSize = composer.getVariable( "fontSize" )		-- Get the variable "fontSize" defined in main.lua


local nameDev		-- Forward reference to nameDev
local loopCount	= 0		-- Initialize loopCount



local function changeText()
	if ( loopCount == 120 ) then
		nameDev.text = "Corona SDK"		-- Access the text of nameDev object and change it.
	elseif ( loopCount == 240 ) then
		nameDev.text = "Empty Project Template"		-- Access the text of nameDev object and change it.
	elseif ( loopCount == 360 ) then
		nameDev.text = "By Serkan Aksit"		-- Access the text of nameDev object and change it.
		loopCount = 0
	end

	loopCount = loopCount + 1 		-- Increment the loop count
end


local function changeScene(event)
	if ( event.phase == "began" ) then
		print "event began"
	elseif ( event.phase == "moved" ) then
		print "event moved"
    elseif ( event.phase == "ended" or event.phase == "cancelled" ) then 		-- Check if the tap ended or cancelled
    	print "event ended"
    	

    	-- Define a variable <varName> to nameDev object for further access to transition. You can name it anything.
    	-- This function will cause nameDev to change its X position and its alpha value in 1500 ms. 
    	-- After it's done, onComplete will be called and it will change scene.
    	-- For more information about transitions, please refer to the following documents
    	-- http://docs.coronalabs.com/api/library/transition/index.html
    	-- http://docs.coronalabs.com/guide/media/transitionLib/index.html 
    	nameDev.trans = transition.to( nameDev, {time = 1500, alpha = 0, x = 0, onComplete = function ()
    			composer.gotoScene( "screens.mainMenu", "crossFade", 1000 )
    		end} )
    end
    return true 		-- To prevent more than one click

    -- For more information about events, please refer to the following documents
    -- http://docs.coronalabs.com/api/event/index.html
    -- http://docs.coronalabs.com/guide/index.html#events-and-listeners
end

local function cleanUp()
	-- Remove the Runtime event listener manually. Corona SDK doesn't handle Runtime listeners automatically.
	-- If not handled, it will probably throw out an error or show some unexpected behavior
	Runtime:removeEventListener(changeText)

	-- Corona SDK will remove the listeners that are attached to objects if the object is destroyed.

	-- Remove the transition manually.
	-- if ( nameDev.trans ) then
	transition.cancel( nameDev.trans )
	nameDev.trans = nil
	-- end
	-- If you are not sure if the nameDev.trans exists or want to take a defensive approach, you can check it with if clause
end

function scene:create( event )
    local mainGroup = self.view         -- We've initialized our mainGroup. This is a MUST for Composer library.

    local sleepyBug = display.newImageRect( "assets/logo.png", 900, 285 )       -- Create a new image, logo.png (900px x 285px) from the assets folder. Default anchor point is center.
    sleepyBug.x = display.contentCenterX        -- Assign the x value of the image to the center of the X axis.
    sleepyBug.y = sleepyBug.height / 2        -- Assign the y value of the image.
    mainGroup:insert(sleepyBug)         -- Add the image to the display group.


    nameDev = display.newText( variableText, 0, 0, native.systemFontBold, fontSize )		-- Create a new text "variableText" in (0, 0) using the system font with a size of "fontSize".
    -- Use ( "text", x, y, width, height, font, fontSize ) for multi-line text. Defining height = 0 will make the object automatically adjust to the height of the given text.
    nameDev.x = display.contentCenterX
    nameDev.y = display.contentCenterY + nameDev.height / 2
    mainGroup:insert(nameDev)

    -- Further reading of Display API -> http://docs.coronalabs.com/api/library/display/index.html


    sleepyBug:addEventListener( "touch", changeScene )		-- Add a "touch" listener to the image to call changeScene(). Automatically removed, once the object is destroyed.
    Runtime:addEventListener( "enterFrame", changeText )	-- Add an "enterFrame" listener to Runtime to changeText as the loop continues
end


function scene:show( event )
    local phase = event.phase

    if ( phase == "will" ) then         -- Scene is not shown entirely

    elseif ( phase == "did" ) then      -- Scene is fully shown on the screen
    	
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