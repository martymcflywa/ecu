-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(board, char, color)
    Ai.super.init(self, board, char, color);
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
    print("DEBUG: entering tryToWin()");
    local me = self.board.chars[self.char];
    local winHere = (self.board.rowsCols - 1) * me;
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        print("DEBUG: " .. scoreHere .. " vs " .. winHere);
        if(scoreHere == winHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    print("DEBUG: executed tryToWin() strategy");
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:tryToBlock()
    print("DEBUG: entering tryToBlock()");
    local me = self.board.chars[self.char];
    local blockHere = (self.board.rowsCols * (me * -1)) - 1;
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        print("DEBUG: " .. scoreHere .. " vs " .. blockHere);
        if(scoreHere == blockHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    print("DEBUG: executed tryToBlock() strategy");
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:lastResort()
    print("DEBUG: entering lastResort()");
    -- go for center first
    local cRow = 2;
    local cCol = 2;
    if(self.board.isEmpty(self.board, cRow, cCol)) then
        Ai.super.mark(self, cRow, cCol);
        return;
    end

    for row = 1, self.board.rowsCols, 1 do
        for col = 1, self.board.rowsCols, 1 do
            if(Ai.super.mark(self, row, col)) then
                print("DEBUG: executed lastResort() strategy");
                return;
            end
        end
    end
end

return Ai