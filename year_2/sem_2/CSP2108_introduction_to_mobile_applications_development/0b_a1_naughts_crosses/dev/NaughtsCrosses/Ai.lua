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
    local me = self.board.chars[self.char];
    for index in pairs(self.board.winCombos) do
        local meWinning = self.board.checkWinInCombo(self.board, index);
        if(meWinning < (self.board.rowsCols - 1) * me) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:tryToBlock()
    local me = self.board.chars[self.char];
    for index in pairs(self.board.winCombos) do
        local playerWinning = self.board.checkWinInCombo(self.board, index);
        if(playerWinning > (self.board.rowsCols * me) - 1) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:lastResort()
    for row = 1, self.board.rowsCols, 1 do
        for col = 1, self.board.rowsCols, 1 do
            if(Ai.super.mark(self, row, col)) then
                return;
            end
        end
    end
end

return Ai