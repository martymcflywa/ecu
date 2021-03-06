-- import the base class
local Marker = require("Marker");
-- extend Marker
local Player = Marker:extend("Player");

function Player:init(logger, board, char, color)
    Player.super.init(self, logger, board, char, color);
end

function Player:dispose()
    Player.super.dispose(self);
end

function Player:turn(event)
    if(event.phase == self.phase) then
        local row, col = self.board.getGridFromTouch(self.board, event);
        if(row ~= nil and col ~= nil) then
            if(Player.super.mark(self, row, col)) then
                self.logger:debug(Player.name, "turn()", string.format("put '%s' at row=%d, col=%d", self.char, row, col))
                return true;
            end
        else
            self.logger:info(Player.name, "turn()", string.format("Touch at x=%d, y=%d is outside the board.", event.x, event.y));
        end
        return false;
    end
end

return Player;