-- import the base class
local Marker = require("Marker");
-- extend Marker
local Player = Marker:extend("Player");

function Player:init(board, char, color)
    Player.super.init(self, board, char, color);
end

function Player:turn(event)
    if(event.phase == self.phase) then
        local row, col = self.board.getGridFromTouch(self.board, event);
        if(row ~= nil and col ~= nil) then
            Player.super.mark(self, row, col);
        else
            print("INFO: Touch at x=" .. event.x .. " y=" .. event.y .. " is the outside board.");
        end
    end
end

return Player;