-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- append custom package path
package.path = package.path .. "./modules;" .. "./scenes;";

-- import modules
require("modules.mobdebug").start(); -- enable zerobranestudio debugging
require("modules.30log.30log-global"); -- oop framework

-- import game classes
local composer = require("composer");
local Logger = require("Logger");

-- helpful globals, TODO: maybe move these to a constants class
_d = display;
_w = _d.contentWidth;
_h = _d.contentHeight;
_cx = _d.contentCenterX;
_cy = _d.contentCenterY;
_colors = {
    black = {0, 0, 0},
    white = {1, 1, 1},
    red = {1, 0, 0},
    green = {0, 1, 0},
    transparent = {0, 0, 0, 0}
};
_chars = {
    empty = 0,
    x = 1,
    o = -1
};
_x = "x";
_o = "o";
_event = "touch";
_logMode = "debug";

--[[
    It all starts at MainMenu.
--]]
composer.gotoScene("scenes.MainMenu", {effect = "fade", time = 500});