local Game = class("Game");

local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");

function Game:init(logger, board, playerChar)
    self.logger = logger;
    self.board = board;
    self.playerChar = self:playerSelect(playerChar);
end

function Game:playerSelect(playerChar)
    if(playerChar == _chars["x"]) then
        self.player = Player(self.logger, self.board, "x", _colors["red"]);
        self.ai = Ai(self.logger, self.board, "o", _colors["green"]);
    else
        self.player = Player(self.logger, self.board, "o", _colors["green"]);
        self.ai = Ai(self.logger, self.board, "x", _colors["red"]);
    end
    return playerChar;
end

function Game:play(event)
    -- when player goes first
    if(self.playerChar == _chars["x"]) then
        if(self.player:turn(event)) then
            if(not self:isGameOver()) then
                self.ai:turn(event);
            end
        end
    -- else ai goes first
    else
        -- ai first turn
        if(event.x == nil) then
            self.ai:turn(event);
        else
            if(not self:isGameOver()) then
                if(self.player:turn(event)) then
                    if(not self:isGameOver()) then
                        self.ai:turn(event);
                    end
                end
            end
        end
    end
    self:isGameOver();
end

function Game:aiFirst(event)
    self.ai:turn(event);
    self:isGameOver();
    if(event.x ~= nil) then
        if(self.player:turn(event)) then
            self:isGameOver();
        end
    end
end

function Game:isGameOver()
    if(self.board:isGameOver()) then
        if(self.board.winner == _chars["empty"]) then
            -- TODO: goto tie scene
            self.logger:log(Game.name, "isGameOver()", "game over, tie game!");
            return true;
        else
            -- TODO: goto winner scene
            self.logger:log(Game.name, "isGameOver()", string.format("game over, winner is %s!", self.board.winner));
            return true;
        end
    end
    return false;
end

return Game;