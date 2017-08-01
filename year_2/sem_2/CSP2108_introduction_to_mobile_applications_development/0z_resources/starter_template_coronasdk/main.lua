-- Project: Corona SDK Reference Project Template
--
-- Date: March 23, 2015
--
-- Version: 0.1
--
-- Author: Serkan Aksit -> https://github.com/sekodev -> https://twitter.com/sekodev
-- Sleepy Bug Studios -> http://sleepybugstudios.com -> https://www.facebook.com/sleepybugstudios
--
-- Tools: Sublime Text 3 with Corona Editor 1.5.1
--
-- Update History:
-- 0.1 - Initial release
--
-- Please refer to sources below for more and up-to-date information
-- Corona SDK Docs: http://docs.coronalabs.com
-- Lua docs: http://www.lua.org/docs.html


-- main
-- Origin. The starting point of your project.
-- This is the only file Corona SDK will require to work. If it doesn't exist, you'll see an error.


local composer = require ("composer")		-- Include the Composer library
-- You can refer to this document for more information about Composer -> http://docs.coronalabs.com/api/library/composer/index.html

-- You can make Composer store your variables by this method. 
-- Consider these, global variables that Composer stores for you. 
-- Later in the project, you can call use/change this variables.
-- It doesn't matter if it's a string or a number in Lua. I just named them like this for easier understanding.
composer.setVariable("variableString", "Game Level")
composer.setVariable("fontSize", 64)

-- Go to the "logo" scene that's inside "screens" folder in 1000 ms with the "crossFade" effect
-- Refer to the Composer API for more transition options.
composer.gotoScene("screens.logo", "crossFade", 1000)