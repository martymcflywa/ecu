local Game = class("Game");

local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");
local Persist = require("Persist");

function Game:init(logger, playerChar, sceneGroup)
    self.logger = logger;
    self.board = Board(logger, sceneGroup);
    self.persist = Persist(logger);
    self.scores = self.persist:loadScores();
    self.playerChar = self:playerSelect(playerChar);
end

function Game:dispose()
    if(self.player ~= nil) then
        self.player:dispose();
        self.player = nil;
    end
    if(self.ai ~= nil) then
        self.ai:dispose();
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