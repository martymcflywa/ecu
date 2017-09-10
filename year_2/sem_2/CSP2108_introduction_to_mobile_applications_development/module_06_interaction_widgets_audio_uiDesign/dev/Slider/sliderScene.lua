-----------------------------------------------------------------------------------------
--
-- sliderScene.lua
--
-- This is the scene in which questions are asked and answers checked
--
-----------------------------------------------------------------------------------------

local composer = require( "composer" )

local scene = composer.newScene()

-- -----------------------------------------------------------------------------------
-- Code outside of the scene event functions below will only be executed ONCE unless
-- the scene is removed entirely (not recycled) via "composer.removeScene()"
-- -----------------------------------------------------------------------------------

-- load in slider
local slider = require( "slider" )

local SIZE = slider.SIZE

-- -----------------------------------------------------------------------------------
-- user interface stuff
-- -----------------------------------------------------------------------------------

local widget = require( "widget" )

local d = display;
local cw = d.contentWidth;
local ch = d.contentHeight;
local cx = d.contentCenterX;
local cy = d.contentCenterY;
local MARGIN_PX = 25;

-- sounds initialised in scene:create()
local soundTable = {}

-- image sheet for background image
local IMAGE_SIZE = 750 -- change this if using a different sized background image
local options =
{
    width = IMAGE_SIZE/SIZE,
    height = IMAGE_SIZE/SIZE,
    numFrames = SIZE*SIZE
}
local sheet = {} -- initialised in scene:create()

-- an array of "tiles"

local tiles = {} -- tiles created in makeTiles(), called in scene:create()

local function getTilesContainerSize()
	return cw - MARGIN_PX * 2;
end

local function getTileSize()
	local size = getTilesContainerSize();
	return size / SIZE;
end

local function getXPos(tileCol)
	local margin = 25;
	local tileContentWidth = getTilesContainerSize();
	local colWidth = tileContentWidth / SIZE;
	return margin + (tileCol - 1) * colWidth;
end

local function getYPos(tileRow)
	local margin = 25;
	local tileContentHeight = getTilesContainerSize();
	local colHeight = tileContentHeight / SIZE;
	return margin + (tileRow - 1) * colHeight;
end

-- moves tiles back to starting positions
local function resetTiles()
	for i = 1, #tiles do
		tiles[i].row = tiles[i].homeRow
		tiles[i].column = tiles[i].homeColumn
		-- tiles[i].x = marginXOffset + (tiles[i].column-1) * colW;
		tiles[i].x = getXPos(tiles[i].column);
		-- tiles[i].y = 25 + (tiles[i].row-1)*54
		tiles[i].y = getYPos(tiles[i].row);
	end
end

-- get the tile currently in this row and column
local function getTile( row, column )
	index = slider:getTile( row, column )
	if index == 0 then
		return nil
	else
		return tile[index]
	end
end

-- do the moves for selecting this tile
-- call with sound == true if sound is wanted
local function doMovesForTile(tile, sound)
	-- first figure out which tiles should move to where
	local moves = slider:getMoves(tile.row, tile.column)
	-- then if anything is supposed to move, do it
	if moves then
		-- update the game info
		slider:doMoves()
		-- make noise if needed
		if sound then audio.play(soundTable.slideSound) end
		-- move the tiles on the display
		for m, move in pairs(moves) do
			local moveTile = tiles[move.from.index]
			moveTile.row = move.to.row
			moveTile.column = move.to.column
			transition.to(
				moveTile, 
				{
					x = getXPos(move.to.column),
					y = getYPos(move.to.row),
					time = 100
				}
			);
		end
	end
end

-- do the moves for selecting this tile number
local function doMovesForIndex(index, sound)
	doMovesForTile(tiles[index], sound)
end

-- dispatch when tile tapped
local function tapTile(event)
	doMovesForTile(event.target, true);
end

-- make a tile
local function makeTile( row, column )
	local size = getTileSize();
	tile = display.newImageRect(sheet, 1 + (row-1)*SIZE + (column-1), size, size)
	tile.anchorX = 0
	tile.anchorY = 0

	tile.x = getXPos(column);
	tile.y = getXPos(row);
	
	tile.homeRow = row
	tile.homeColumn = column
	
	tile.row = row
	tile.column = column
	
	tile.strokeWidth = 3
	tile:setStrokeColor(0, 0, 1)
	
	tile:addEventListener("tap", tapTile);
	return tile
end

-- create this tiles and insert in a display group
local function makeTiles(group)
	for row = 1, SIZE do
		for column = 1, SIZE do
			if row ~= SIZE or column ~= SIZE then
				local tile = makeTile(row, column)
				group:insert(tile)
				tiles[#tiles+1] = tile
			end
		end
	end
end

-- restart by jumbling the tiles
local function jumbleTiles( event )
	slider:reset()
	resetTiles()
	
	for i = 1, 100 do
		doMovesForIndex(math.random(#tiles), false)
	end
end

local function initNewGameButton()
	local button = widget.newButton({
		left = 100,
		top = 200,
		id = "newGame";
		label = "New Game";
		onRelease = jumbleTiles,
		x = display.contentCenterX,
		y = getTilesContainerSize() + MARGIN_PX * 3,
		shape = "rect",
		fillColor = {
			default = {1, 0.1, 0.7, 0.4},
			over = {1, 0.8, 0.6, 1}
		}
	});
	return button;
end

-- -----------------------------------------------------------------------------------
-- Scene event functions
-- -----------------------------------------------------------------------------------

-- create()
function scene:create( event )

    local sceneGroup = self.view
    -- Code here runs when the scene is first created but has not yet appeared on screen
	
	-- load in sounds
	soundTable = {
		slideSound = audio.loadSound( "sounds/slide.wav" ),
	}

	-- load in image sheet
	sheet = graphics.newImageSheet( "images/felix.jpg", system.ResourceDirectory, options )
	
	-- create the border
	local top = display.newRect(20, 20, 280, 5)
	top.anchorX = 0
	top.anchorY = 0
	top:setFillColor(0.5, 0.5, 0)
	sceneGroup:insert(top)
	local bottom = display.newRect(20, 295, 280, 5)
	bottom.anchorX = 0
	bottom.anchorY = 0
	bottom:setFillColor(0.5, 0.5, 0)
	sceneGroup:insert(bottom)
	local left = display.newRect(20, 20, 5, 280)
	left.anchorX = 0
	left.anchorY = 0
	left:setFillColor(0.5, 0.5, 0)
	sceneGroup:insert(left)
	local right = display.newRect(295, 20, 5, 280)
	right.anchorX = 0
	right.anchorY = 0
	right:setFillColor(0.5, 0.5, 0)
	sceneGroup:insert(right)
	
	--create the inside
	inside = display.newRect(25, 25, 270, 270)
	inside.anchorX = 0
	inside.anchorY = 0
	inside:setFillColor(0.2, 0.2, 0)
	sceneGroup:insert(inside)
	
	-- add new game button
	local newGameButton = initNewGameButton();
	sceneGroup:insert(newGameButton);

	--add the tiles
	makeTiles(sceneGroup)
	
end

-- show()
function scene:show( event )

    local sceneGroup = self.view
    local phase = event.phase

    if ( phase == "will" ) then
        -- Code here runs when the scene is still off screen (but is about to come on screen)

    elseif ( phase == "did" ) then
        -- Code here runs when the scene is entirely on screen

		jumbleTiles()
    end
end

-- hide()
function scene:hide( event )

    local sceneGroup = self.view
    local phase = event.phase

    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)

    elseif ( phase == "did" ) then
        -- Code here runs immediately after the scene goes entirely off screen

    end
end

-- destroy()
function scene:destroy( event )

    local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view

	-- clean up audio stuff
	audio.stop()

	for s,v in pairs( soundTable ) do
		audio.dispose( soundTable[s] )
		soundTable[s] = nil
	end
end

-- -----------------------------------------------------------------------------------
-- Scene event function listeners
-- -----------------------------------------------------------------------------------
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )
-- -----------------------------------------------------------------------------------

return scene