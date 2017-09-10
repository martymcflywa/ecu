-----------------------------------------------------------------------------------------
--
-- main.lua
--
-- main for Slider example
--
-----------------------------------------------------------------------------------------

-- even though we only have one scene, we will use the composer library

local composer = require( "composer" )
require("mobdebug").start();

-- Code to initialize the app can go here

-- Now load the opening scene

-- Assumes that "questionScene.lua" exists and is configured as a Composer scene
composer.gotoScene( "sliderScene" )