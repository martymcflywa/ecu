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

-- listen to this event
local event = "touch";
local logger = Logger("debug");

-- set up the board
local board = Board(logger);
board:setup();

-- set up the players, TODO: player char/color should be selectable
local red = {1, 0, 0};
local player = Player(logger, board, "x", red);

local green = {0, 1, 0};
local ai = Ai(logger, board, "o", green);

local function play(event)
    if(board:isGameOver()) then
        logger:log("main", "play()", string.format("Winner is %s!", board.winner));
    else
        if(player:turn(event)) then
            ai:turn(event);
        end
    end
    if(board:isGameOver()) then
        logger:log("main", "play()", string.format("Winner is %s!", board.winner));
    end
end

Runtime:addEventListener(event, play);