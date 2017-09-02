-- import the base class
local Marker = require("Marker");
-- extend Marker
local Player = Marker:extend("Player");

function Player:init(logger, board, char, color)
    Player.super.init(self, logger, board, char, color);
end

function Player:turn(event)
    if(event.phase == self.phase) then
        local row, col = self.board.getGridFromTouch(self.board, event);
        if(row ~= nil and col ~= nil) then
            Player.super.mark(self, row, col);
            return true;
        else
            self.logger:info(Player.name, "turn()", string.formamt("Touch at x=%d, y=%d is outside the board.", event.x, event.y));
            return false;
        end
    end
end

return Player;