-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(board, char, color, difficulty)
    Ai.super.init(self, board, char, color, false);
    self.difficulty = difficulty;
    self.turns = 0;
    self.corners = {
        {row = 1, col = 1, oppRow = 3, oppCol = 3},
        {row = 3, col = 1, oppRow = 1, oppCol = 3},
        {row = 1, col = 3, oppRow = 3, oppCol = 1},
        {row = 3, col = 3, oppRow = 1, oppCol = 1}
    };
end

function Ai:dispose()
    Ai.super.dispose(self);
end

function Ai:turn(event)
    if(event.phase == self.phase) then
        if(self.difficulty == _difficulty["e"]) then
            self:easy();
        elseif(self.difficulty == _difficulty["m"]) then
            self:medium();
        elseif(self.difficulty == _difficulty["h"]) then
            self:hard();
        end
        self.turns = self.turns + 1;
    end
end

function Ai:easy()
    self:goForRandom();
end

function Ai:medium()
    if(self.turns % 2 == 0) then
        self:hard();
    else
        self:goForRandom();
    end
end

function Ai:hard()
    if(self:goForWin()) then
        return;
    elseif(self:goForBlock()) then
        return;
    elseif(self:goForCenter()) then
        return;
    elseif(self:goForOppCorner()) then
        return;
    elseif(self:goForCorner()) then
        return;
    else
        self:lastResort();
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

function Ai:goForOppCorner()
    local me = _chars[self.char];
    local player = me * -1;
    for index in pairs(self.corners) do
        local row = self.corners[index]["row"];
        local col = self.corners[index]["col"];
        if(self.board:getScoreAt(row, col) == player) then
            local oppRow = self.corners[index]["oppRow"];
            local oppCol = self.corners[index]["oppCol"];
            if(self.board:isEmpty(oppRow, oppCol)) then
                Ai.super.mark(self, oppRow, oppCol);
                self:logTurn("goForOppCorner()", oppRow, oppCol);
                return true;
            end
        end
    end
    return false;
end

function Ai:goForCorner()
    for index in pairs(self.corners) do
        local row = self.corners[index]["row"];
        local col = self.corners[index]["col"];
        if(self.board.isEmpty(self.board, row, col)) then
            Ai.super.mark(self, row, col);
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

function Ai:goForRandom()
    local empty = self.board:getEmpty();
    local random = math.random(1, #empty);
    local row = empty[random]["row"];
    local col = empty[random]["col"];
    Ai.super.mark(self, row, col);
    self:logTurn("goForRandom()", row, col);
    return true;
end

function Ai:logTurn(strategy, row, col)
    logger:debug(Ai.name, strategy, string.format("put '%s' at row=%d, col=%d", self.char, row, col));
end

return Ai;