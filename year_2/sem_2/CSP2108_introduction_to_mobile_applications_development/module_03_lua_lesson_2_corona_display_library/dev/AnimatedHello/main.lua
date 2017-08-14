-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- Your code here

START_SIZE = 20
END_SIZE = 100

animatedHello = display.newText(
    "Hi hi hi",
	display.contentCenterX, 
    display.contentCenterY, 
    "Arial", 
    START_SIZE)

allDone = function()
	animatedHello.rotation = 0
	animatedHello:setFillColor(0, 1.0, 1.0)
end

rotate = function()
	transition.to(animatedHello, 
    {time = 1500, rotation = 359, onComplete = allDone})
end

transition.to(
    animatedHello, 
    {time = 1500, delay = 500, size = END_SIZE, onComplete = rotate})