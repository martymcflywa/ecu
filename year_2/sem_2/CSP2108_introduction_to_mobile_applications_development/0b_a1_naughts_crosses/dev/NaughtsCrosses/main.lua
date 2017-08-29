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

-- set up the board
local board = Board();
board:draw();

-- set up the players, TODO: player char should be selectable
local player = Player(board, "X");
local ai = Ai(board, "O");

local playerMarks = 0;

-- start checking score when we have at least 3 marks 
local function checkScore()
    if(playerMarks >= 3) then
        -- if isGameOver, do something to stop program
        if(board:isGameOver()) then
            print("Winner is " .. board.winner .. "!");
        else
            print("No winner yet.");
        end
    end
end

local function play(event)
    if(player:turn(event)) then
        ai:turn(event);
        playerMarks = playerMarks + 1;
    end
    checkScore();
end

Runtime:addEventListener("touch", play)