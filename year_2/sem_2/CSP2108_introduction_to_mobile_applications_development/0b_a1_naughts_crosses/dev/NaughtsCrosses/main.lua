-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- append custom package path
package.path = package.path .. "./modules;";

-- import modules
require("modules.mobdebug").start(); -- enable zerobranestudio debugging
require("modules.30log.30log-global"); -- oop framework

-- import game classes
local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");
local Logger = require("Logger");

-- helpful globals
_w = display.contentWidth;
_h = display.contentHeight;

-- listen to this event
local event = "touch";
-- set up the logger
local logMode = "debug";
local logger = Logger(logMode);
-- set up the board
local board = Board(logger);
board:setup();
-- set up the players, TODO: player char/color should be selectable
local red = {1, 0, 0};
local green = {0, 1, 0};
local player = Player(logger, board, "x", red);
local ai = Ai(logger, board, "o", green);

local function play(event)
    if(player:turn(event)) then
        ai:turn(event);
    end
    if(board:isGameOver()) then
        if(board.winner == board.chars["empty"]) then
            logger:log("main", "play()", "game over, tie game!");
        else
            logger:log("main", "play()", string.format("game over, winner is %s!", board.winner));
        end
    end
end

Runtime:addEventListener(event, play);