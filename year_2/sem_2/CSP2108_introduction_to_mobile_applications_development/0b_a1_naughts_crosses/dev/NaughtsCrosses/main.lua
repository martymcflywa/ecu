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
-- local Ai = require("Ai");
-- listen to this events
local event = "touch";

-- set up the board
local board = Board();
board:setup();

-- set up the players, TODO: player char/color should be selectable
local red = {1, 0, 0};
local player = Player(board, "x", red);
-- local ai = Ai(board, "o");

local playerTurns = 0;

local function printWinner(winner)
    local options = {
        text = winner .. " has won!\nGAME OVER!",
        x = board.d.contentWidth * 0.5,
        y = board.d.contentHeight * 0.5,
        font = "Arial",
        fontSize = 25,
        align = "center"
    };
    local gameOver = display.newText(options);
    gameOver.anchorX = 0;
    gameOver.anchorY = 0;
end

-- start checking score when we have at least 3 marks 
local function checkScore()
    if(playerTurns >= 3) then
        -- if isGameOver, do something to stop program
        if(board:isGameOver()) then
            printWinner(board.winner);
            -- kill touch
            Runtime:removeEventListener(event, play);
        else
            print("No winner yet.");
        end
    end
end

local function play(event)
    if(player:turn(event)) then
        -- TODO: check score before ai turn
        ai:turn(event);
        playerTurns = playerTurns + 1;
    end
end

Runtime:addEventListener(event, play)