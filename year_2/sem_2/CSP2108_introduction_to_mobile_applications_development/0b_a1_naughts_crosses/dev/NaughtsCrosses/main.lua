-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- add custom package path
package.path = package.path .. "./modules;";

-- imports
require("modules.mobdebug").start(); -- enables zerobranestudio debugging
require("modules.30log.30log-global"); -- oop framework

local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");

-- set up the board
local board = Board();
board:draw();

-- set up the player, TODO: player char should be selectable
local player = Player(board, "X");
local ai = Ai(board, "O");

local playerMarks = 0;

local function fill(event)
    if(player:fill(event)) then
        ai:fill(event);
        playerMarks = playerMarks + 1;
    end
    -- start checking score when we have at least 3 marks 
    if(playerMarks >= 3)

    end
end

--FILL COMPARTMENT W/ COLOUR WHEN TOUCHED
-- local function fill(event)
--     if event.phase == "began" then
--         tap = 0;
--         for t = 1, 9 do
--             if event.x > board.compartments[t][3] and event.x < board.compartments[t][5] then
--                 if event.y < board.compartments[t][4] and event.y > board.compartments[t][6] then
--                     r = board.d.newRect(board.compartments[t][3], board.compartments[t][6], board.w20, board.h20);
--                     r:setFillColor(1, 1, 0);
--                     r.anchorX = 0;
--                     r.anchorY = 0;
--                     -- if board[t][7] == EMPTY then
--                     --     board[t][7] = whichTurn;
--                     --     whichTurn = whichTurn == X and O or X;
--                     -- end
--                 end
--             end
--         end
--     end
-- end

Runtime:addEventListener("touch", fill)