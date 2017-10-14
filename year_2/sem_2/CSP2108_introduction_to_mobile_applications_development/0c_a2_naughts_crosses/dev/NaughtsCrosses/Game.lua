local Game = class("Game");

local Board = require("Board");
local Player = require("Player");
local Ai = require("Ai");

function Game:init(playerChar, sceneGroup)
    self.board = Board(sceneGroup);
    self.playerChar = self:playerSelect(playerChar);
end

function Game:playerSelect(playerChar)
    if(playerChar == _chars[_x]) then
        self.player = Player(self.board, _x, _colors["red"]);
        self.ai = Ai(self.board, _o, _colors["green"]);
    else
        self.player = Player(self.board, _o, _colors["green"]);
        self.ai = Ai(self.board, _x, _colors["red"]);
    end
    return playerChar;
end

return Game;