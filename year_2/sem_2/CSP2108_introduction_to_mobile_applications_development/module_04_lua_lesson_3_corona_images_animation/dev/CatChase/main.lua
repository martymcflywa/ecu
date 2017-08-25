-- 
-- Abstract: JungleScene sample project
-- Demonstrates sprite sheet animations, with different frame rates
-- 
-- Version: 1.0
-- 
-- Sample code is MIT licensed, see https://www.coronalabs.com/links/code/license
-- Copyright (C) 2010 Corona Labs Inc. All Rights Reserved.

-- Plants are from http://blender-archi.tuxfamily.org/Greenhouse
-- and are subject to creative commons license, http://creativecommons.org/licenses/by/3.0/
--
--	Supports Graphics 2.0
---------------------------------------------------------------------------------------

-- add custom package path
package.path = package.path .. "./modules";

-- global imports
class = require "modules.30log.30log-global";
-- local imports
local TreeFactory = require "modules.treefactory.Factory";

local centerX = display.contentCenterX;
local centerY = display.contentCenterY;
local _W = display.contentWidth;
local _H = display.contentHeight;

-- Define reference points locations anchor ponts
local TOP_REF = 0;
local BOTTOM_REF = 1;
local LEFT_REF = 0;
local RIGHT_REF = 1;
local CENTER_REF = 0.5;

display.setStatusBar(display.HiddenStatusBar);

-- The sky as background
local sky = display.newImage("sky.jpg", centerX, centerY);
-- ground
local baseline = 280;

local trees = TreeFactory.get(BOTTOM_REF, baseline);

-- an image sheet with a cat
local catSheet = graphics.newImageSheet(
	"runningcat.png",
	{
		width = 512,
		height = 256,
		numFrames=8
	});

-- play 8 frames every 1000 ms
local catActor = display.newSprite(
	catSheet, 
	{
		name = "cat",
		start = 1,
		count = 8,
		time = 1000
	});
catActor.x = display.contentWidth / 4 + 40;
catActor.y = baseline - 75;
catActor.xScale = 0.5;
catActor.yScale = 0.5;
catActor:play();

-- A sprite sheet with a green dude
local manSheet = graphics.newImageSheet(
	"greenman.png",
	{
		width = 128,
		height = 128,
		numFrames = 15
	});

-- play 15 frames every 500 ms
local manActor = display.newSprite(
	manSheet,
	-- has to be an array here
	{
		{
			name = "slow", 
			start = 1,
			count = 15,
			time = 500			
		},
		{
			name = "fast",
			start = 1,
			count = 15,
			time = 250		
		}
	});

manActor.x = 3 * display.contentWidth / 4 + 30;
manActor.y = baseline - 55;
manActor:play();

-- Grass
-- This is doubled so we can slide it
-- When one of the grass images slides offscreen, we move it all the way to the right of the next one.
local grass = display.newImage("grass.png");
grass.anchorX = LEFT_REF;
grass.x = 0;
grass.y = baseline - 20;

local grass2 = display.newImage("grass.png");
grass2.anchorX = LEFT_REF;
grass2.x = 480;
grass2.y = baseline - 20;

-- solid ground, doesn't need to move
local ground = display.newRect(0, baseline, 480, 90);
ground:setFillColor(0x31 / 255, 0x5a / 255, 0x18 / 255);
ground.anchorX = LEFT_REF;
ground.anchorY = TOP_REF;

-- A per-frame event to move the elements
local tPrevious = system.getTimer();

local function move(event)
	local tDelta = event.time - tPrevious;
	tPrevious = event.time;

	local xOffset = 0.2 * tDelta;

	grass.x = grass.x - xOffset;
	grass2.x = grass2.x - xOffset;
	
	if (grass.x + grass.contentWidth) < 0 then
		grass:translate(480 * 2, 0);
	end
	if (grass2.x + grass2.contentWidth) < 0 then
		grass2:translate(480 * 2, 0);
	end
	
	for i = 1, #trees, 1 do
		trees[i].x = trees[i].x - trees[i].dx * tDelta * 0.2;
		if ((trees[i].x + trees[i].contentWidth) < 0) then
			trees[i]:translate(480 + trees[i].contentWidth * 2, 0);
		end
	end

	-- drama integrated here
	if (manActor.sequence == "slow") then
		manActor:translate(xOffset / -10, 0);
	end
	if (manActor.sequence == "fast") then
		manActor:translate(xOffset / 10, 0);
	end
	if (manActor.x - catActor.x > 250) then
		manActor:setSequence("slow");
	end
	if (manActor.x - catActor.x < 150) then
		manActor:setSequence("fast");
	end
	manActor:play();
end

-- Start everything moving
Runtime:addEventListener("enterFrame", move);