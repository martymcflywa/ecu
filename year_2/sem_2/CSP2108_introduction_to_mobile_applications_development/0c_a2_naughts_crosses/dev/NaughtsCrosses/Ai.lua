-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(board, char, color)
    Ai.super.init(self, board, char, color, false);
end

function Ai:dispose()
    Ai.super.dispose(self);
end

function Ai:turn(event)
    if(event.phase == self.phase) then
        if(self:goForWin()) then
            return;
        elseif(self:goForBlock()) then
            return;
        elseif(self:goForCenter()) then
            return;
        elseif(self:goForCorner()) then
            return;
        else
            self:lastResort();
        end
    end
end

function Ai:goForWin()
    local me = _chars[self.char];
    local winHere = (self.board.rowsCols - 1) * me; -- maintain ai's sign, ai can win here
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        if(scoreHere == winHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    self:logTurn("goForWin()", row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:goForBlock()
    local me = _chars[self.char];
    local blockHere =  (self.board.rowsCols - 1) * (me * -1); -- reverse ai's sign, ai will lose here
    for index in pairs(self.board.winCombos) do
        local scoreHere = self.board.checkWinInCombo(self.board, index);
        if(scoreHere == blockHere) then
            for key, value in pairs(self.board.getWinCombo(self.board, index)) do
                row = value["x"];
                col = value["y"];
                if(self.board.isEmpty(self.board, row, col)) then
                    Ai.super.mark(self, row, col);
                    self:logTurn("goForBlock()", row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:goForCenter()
    local row = math.ceil(self.board.rowsCols * 0.5);
    local col = row;
    if(self.board.isEmpty(self.board, row, col)) then
        Ai.super.mark(self, row, col);
        self:logTurn("goForCenter()", row, col);
        return true;
    end
    return false;
end

function Ai:goForCorner()
    local corners = {
        {x = 1, y = 1},
        {x = 3, y = 1},
        {x = 1, y = 3},
        {x = 3, y = 3}
    };
    for index in pairs(corners) do
        local col = corners[index]["x"];
        local row = corners[index]["y"];
        if(self.board.isEmpty(self.board, col, row)) then
            Ai.super.mark(self, col, row);
            self:logTurn("goForCorner()", row, col);
            return true;
        end
    end
    return false;
end

function Ai:lastResort()
    for row = 1, self.board.rowsCols, 1 do
        for col = 1, self.board.rowsCols, 1 do
            if(Ai.super.mark(self, row, col)) then
                self:logTurn("lastResort()", row, col);
                return;
            end
        end
    end
end

function Ai:logTurn(strategy, row, col)
    logger:debug(Ai.name, strategy, string.format("put '%s' at row=%d, col=%d", self.char, row, col));
end

return Ai