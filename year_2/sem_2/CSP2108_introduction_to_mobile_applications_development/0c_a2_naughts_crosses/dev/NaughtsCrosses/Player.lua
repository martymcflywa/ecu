-- import the base class
local Marker = require("Marker");
-- extend Marker
local Player = Marker:extend("Player");

function Player:init(board, char, color)
    Player.super.init(self, board, char, color, true);
end

function Player:dispose()
    Player.super.dispose(self);
end

function Player:turn(event)
    if(event.phase == self.phase) then
        local row, col = self.board.getGridFromTouch(self.board, event);
        if(row ~= nil and col ~= nil) then
            if(Player.super.mark(self, row, col)) then
                logger:debug(Player.name, "turn()", string.format("char=%s row=%d col=%d", self.char, row, col));
                return true;
            end
        end
        return false;
    end
end

function Player:undo(event)
    if(event.phase == self.phase) then
        local turn = self.board:popTurn();
        if(turn) then
            logger:debug(Player.name, "undo()", string.format("char=%s row=% col=%", turn.char, turn.row, turn.col));
        end
    end
end

return Player;