local Game = class("Game");

local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");

function Game:init(logger, board, playerChar)
    self.logger = logger;
    self.board = board;
    self.playerChar = self:playerSelect(playerChar);
end

function Game:dispose()
    if(self.player ~= nil) then
        self.player:dispose();
        self.player = nil;
    end
    if(self.ai ~= nil) then
        self.player:dispose();
        self.ai = nil;
    end
    if(self.playerChar ~= nil) then
        self.playerChar = nil;
    end
    if(self.board ~= nil) then
        self.board:dispose();
        self.board = nil;
    end
    if(self.logger ~= nil) then
        self.logger = nil;
    end
end

function Game:playerSelect(playerChar)
    if(playerChar == _chars[_x]) then
        self.player = Player(self.logger, self.board, _x, _colors["red"]);
        self.ai = Ai(self.logger, self.board, _o, _colors["green"]);
    else
        self.player = Player(self.logger, self.board, _o, _colors["green"]);
        self.ai = Ai(self.logger, self.board, _x, _colors["red"]);
    end
    return playerChar;
end

return Game;