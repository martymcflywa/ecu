-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(logger, board, char, color)
    Ai.super.init(self, logger, board, char, color);
end

function Ai:dispose()
    Ai.super.dispose(self);
end

function Ai:turn(event)
    if(event.phase == self.phase) then
        if(self:tryToWin()) then
            return;
        elseif(self:tryToBlock()) then
            return;
        else
            self:lastResort();
        end
    end
end

function Ai:tryToWin()
    local me = _chars[self.char];
    local winHere = (self.board.rowsCols - 1) * me; -- maintain ai's sign, ai about to win here
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        if(scoreHere == winHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    self.logger:debug(Ai.name, "tryToWin()", string.format("put '%s' at row=%d, col=%d", self.char, row, col))
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:tryToBlock()
    local me = _chars[self.char];
    local blockHere =  (self.board.rowsCols - 1) * (me * -1); -- reverse ai's sign, ai about to lose here
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        if(scoreHere == blockHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    self.logger:debug(Ai.name, "tryToBlock()", string.format("put '%s' at row=%d, col=%d", self.char, row, col))
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:lastResort()
    -- go for center first
    local cRow = 2;
    local cCol = 2;
    if(self.board.isEmpty(self.board, cRow, cCol)) then
        Ai.super.mark(self, cRow, cCol);
        self.logger:debug(Ai.name, "lastResort()", string.format("put '%s' at row=%d, col=%d", self.char, cRow, cCol))
        return;
    end

    for row = 1, self.board.rowsCols, 1 do
        for col = 1, self.board.rowsCols, 1 do
            if(Ai.super.mark(self, row, col)) then
                self.logger:debug(Ai.name, "lastResort()", string.format("put '%s' at row=%d, col=%d", self.char, row, col))
                return;
            end
        end
    end
end

return Ai