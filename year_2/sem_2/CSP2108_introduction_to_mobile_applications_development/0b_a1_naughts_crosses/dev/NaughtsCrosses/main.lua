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

-- listen to this event
local event = "touch";

-- set up the board
local board = Board();
board:setup();

-- set up the players, TODO: player char/color should be selectable
local red = {1, 0, 0};
local player = Player(board, "x", red);

local green = {0, 1, 0};
local ai = Ai(board, "o", green);

local function play(event)
    player:turn(event);
    if(board:isGameOver()) then
        print("WINNER IS " .. board.winner .. "!");
    else
        ai:turn(event);
    end
end

Runtime:addEventListener(event, play);