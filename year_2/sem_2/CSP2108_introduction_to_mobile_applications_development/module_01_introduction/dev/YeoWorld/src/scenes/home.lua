------------------------- GamePractice -- this class is the base for the practice
local storyboard = require( "storyboard" )

local scene = storyboard.newScene()

------------------------- Variables

------------------------- Constants
local centerX = display.contentWidth / 2
local centerY = display.contentHeight / 2
local halfViewX = display.viewableContentWidth / 2
local halfViewY = display.viewableContentHeight / 2
local rightX = centerX + halfViewX
local leftX = centerX - halfViewX
local bottomY = centerY + halfViewY
local topY = centerY - halfViewY

------------------------- Functions

-- Commonly used resources must be loaded here
function scene:createScene(event)
	local group = self.view
end

function scene:enterScene( event )
	local group = self.view
	local hello = display.newText(group, "HELLO WORLD" , centerX, centerY, "Amatic-Bold", 80 )
end

function scene:willEnterScene(event)
	local group = self.view
end

-- Destroy everything created on createscene here 
function scene:destroyScene ( event )

end

-- Destroy any dynamic resource, mechanic or transition that was created during gameplay here.
function scene:exitScene ( event )

end

scene:addEventListener( "createScene", scene )
scene:addEventListener( "destroyScene", scene )
scene:addEventListener( "exitScene", scene )
scene:addEventListener( "enterScene", scene )
scene:addEventListener( "willEnterScene", scene )

return scene
