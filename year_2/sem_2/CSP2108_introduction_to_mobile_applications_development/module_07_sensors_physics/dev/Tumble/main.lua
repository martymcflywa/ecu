--
-- Simple demo combining physics with accelerometer events
--

require("mobdebug").start();
local physics = require("physics")

-- physics parameters
local gravity = 3.5*9.8
local roomFriction = 0.2
local roomBounce = 0.6
local gemFriction = 0.2
local gemBounce = 0.8
local gemDensity = 1.0

-- numbers
local numberOfGems = 25

-- layout
local roomSize = (math.min(display.contentHeight, display.contentWidth))*0.7
local roomLocation = {x = (display.contentWidth - roomSize)/2, y = (display.contentHeight - roomSize)/2}

-- sizes
local gemSize = 20

local drawMode = "normal";
local soundFx;

local function onTap(event)
	if(event.numTaps == 2) then
		local newDrawMode;
		if(drawMode == "normal") then
			newDrawMode = "debug";
		else
			newDrawMode = "normal";
		end
		drawMode = newDrawMode;
		physics.setDrawMode(drawMode);
	end
end

local function onPostCollision(event)
	if(event.force > 10) then
		if(event.object1.type == "gem" and event.object2.type == "gem") then
			local channel = audio.findFreeChannel();
			if(channel ~= 0) then
				local volume = event.force / 100;
				audio.setVolume(volume, {channel = channel});
				audio.play(soundFx, {channel = channel});
			end
			print(string.format("Event %s", event.name));
		end
	end
end

local function setupSound()
	soundFx = audio.loadSound("sounds/glass-clink-4.wav", system.ResourceDirectory);
end

-- Called when a new accelerometer measurement has been received.
local function onAccelerometerDataReceived( event )
	
	physics.setGravity(gravity*event.xGravity, -gravity*event.yGravity)
	
	--print( "Accelerometer name: " .. event.name .. " " .. event.xGravity)
		
end 

local function setupEvents()
	
	if system.hasEventSource( "accelerometer" ) then
		Runtime:addEventListener( "accelerometer", onAccelerometerDataReceived )
	end
	Runtime:addEventListener("tap", onTap);
	Runtime:addEventListener("postCollision", onPostCollision);
end

local function setupPhysics()

	physics.start()
	physics.setGravity(0, gravity)
	physics.setAverageCollisionPositions(true);
end


local function createTumbler()

	tumbler = display.newGroup()
	tumbler.x = (display.contentWidth - roomSize)/2
	tumbler.y = (display.contentHeight - roomSize)/2

	local wallThickness = 10
	
	--left wall
	local wall = display.newRect(0, 0, wallThickness, roomSize)
	wall.anchorX = 0
	wall.anchorY = 0
	wall.type = "wall"
	tumbler:insert(wall)
	physics.addBody(wall, "static", {friction = roomFriction, bounce = roomBounce})
	
	--right wall
	wall = display.newRect(roomSize-wallThickness, 0, wallThickness, roomSize)
	wall.anchorX = 0
	wall.anchorY = 0
	wall.type = "wall"
	tumbler:insert(wall)
	physics.addBody(wall, "static", {friction = roomFriction, bounce = roomBounce})
	
	--top wall
	wall = display.newRect(0, 0, roomSize, wallThickness)
	wall.anchorX = 0
	wall.anchorY = 0
	wall.type = "wall"
	tumbler:insert(wall)
	physics.addBody(wall, "static", {friction = roomFriction, bounce = roomBounce})
	
	--bottom wall
	wall = display.newRect(0, roomSize-wallThickness, roomSize, wallThickness)
	wall.anchorX = 0
	wall.anchorY = 0
	wall.type = "wall"
	tumbler:insert(wall)
	physics.addBody(wall, "static", {friction = roomFriction, bounce = roomBounce})
	
end

local function createGems()
	
	for gemCount = 1, numberOfGems do
		local gem = display.newCircle(roomSize*(0.1+0.8*math.random()), roomSize*(0.1+0.8*math.random()), gemSize)
		gem.isSleepingAllowed = false
		gem:setFillColor(0, 255, 0, 255)
		gem.type = "gem"
		tumbler:insert(gem)
		physics.addBody(gem, "dynamic", {density = gemDensity, friction = gemFriction, bounce = gemBounce, radius = gemSize})
	end
	
end

local function main()

	setupEvents()		
	setupPhysics()	
	createTumbler()
	createGems()
	setupSound();
end

main()