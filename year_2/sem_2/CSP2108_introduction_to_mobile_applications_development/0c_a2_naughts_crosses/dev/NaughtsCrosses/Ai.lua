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
    self:random();
end

function Ai:medium()
    if(self.turns % 2 == 0) then
        self:hard();
    else
        self:random();
    end
end

function Ai:hard()
    if(self:win()) then
        return;
    elseif(self:block()) then
        return;
    elseif(self:center()) then
        return;
    elseif(self:oppositeCorner()) then
        return;
    elseif(self:emptyCorner()) then
        return;
    else
        self:lastResort();
    end
end

function Ai:win()
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
                    self:logTurn("win()", row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:block()
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
                    self:logTurn("block()", row, col);
                    return true;
                end
            end
        end
    end
    return false;
end

function Ai:center()
    local row = math.ceil(self.board.rowsCols * 0.5);
    local col = row;
    if(self.board.isEmpty(self.board, row, col)) then
        Ai.super.mark(self, row, col);
        self:logTurn("center()", row, col);
        return true;
    end
    return false;
end

function Ai:oppositeCorner()
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
                self:logTurn("oppositeCorner()", oppRow, oppCol);
                return true;
            end
        end
    end
    return false;
end

function Ai:emptyCorner()
    for index in pairs(self.corners) do
        local row = self.corners[index]["row"];
        local col = self.corners[index]["col"];
        if(self.board.isEmpty(self.board, row, col)) then
            Ai.super.mark(self, row, col);
            self:logTurn("emptyCorner()", row, col);
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

function Ai:random()
    local empty = self.board:getEmpty();
    local random = math.random(1, #empty);
    local row = empty[random]["row"];
    local col = empty[random]["col"];
    Ai.super.mark(self, row, col);
    self:logTurn("random()", row, col);
    return true;
end

function Ai:logTurn(strategy, row, col)
    logger:debug(self.name, "turn()", string.format("char=%s row=%d col=%d strategy=%s", self.char, row, col, strategy));
end

return Ai;