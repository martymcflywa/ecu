-----------------------------------------------------------------------------------------
--
-- main.lua
--
-- Use DisplayObjects and transitions to make an animated face
-- Starter code
--
-----------------------------------------------------------------------------------------

-- some constants define sizes and locations of parts of the face

-- centre of the face
local X = display.contentCenterX
local Y = display.contentCenterY

local HEAD_SIZE = display.contentWidth*0.35
local EYE_OFFSET_X = HEAD_SIZE/5
local EYE_OFFSET_Y = HEAD_SIZE/5
local MOUTH_OFFSET = HEAD_SIZE/4

-- create some functions to draw parts of my face

local function drawHead()
	local head = display.newCircle(X, Y, HEAD_SIZE)
	head:setFillColor(1, 0.5, 0.5)
	head:setStrokeColor(0.2, 0.2, 0)
	head.strokeWidth = 3
	return head
end

local function drawLeftEye()
	return display.newText("O", X-EYE_OFFSET_X, Y-EYE_OFFSET_Y, "Arial", 20)
end

local function drawRightEye()
	return display.newText("o", X+EYE_OFFSET_X, Y-EYE_OFFSET_Y, "Arial", 20)
end

local function drawNose()
	return display.newText(">", X, Y, "Arial", 20)
end

local function drawMouth()
	return display.newText("~~~", X, Y+MOUTH_OFFSET, "Arial", 20)
end

-- we will save some DisplayObjects so that we can animate them
local leftEye
local rightEye
local mouth

local function drawFace()
	drawHead()
	leftEye = drawLeftEye()
	rightEye = drawRightEye()
	drawNose()
	mouth = drawMouth()
end

-- OK all is in place, now do the drawing

drawFace()

-- and animate it

local function poke()
	leftEye.text = "-"
	rightEye.text = "-"
	display.newText("U", X, mouth.y+mouth.height, "Arial", 30)
end

transition.to(leftEye, {delay = 500, time = 1000, size = 40}) 
transition.to(rightEye, {delay = 500, time = 1000, size = 40, onComplete = poke}) 
