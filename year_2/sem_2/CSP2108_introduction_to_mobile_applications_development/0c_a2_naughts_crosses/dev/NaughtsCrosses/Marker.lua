local Marker = class("Marker");

function Marker:init(board, char, color, isPlayer)
    self.board = board;
    self.char = char;
    self.phase = "ended"; -- ended triggers listener only once
    self.color = color;
    self.isPlayer = isPlayer;
    self.textOptions = {
        text = self.char,
        font = "Arial",
        fontSize = 70,
        align = "center"
    };
end

function Marker:dispose()
    if(self.char ~= nil) then
        self.char = nil;
    end
    if(self.color ~= nil) then
        self.color = nil;
    end
    if(self.board ~= nil) then
        self.board:dispose();
        self.board = nil;
    end
end

function Marker:mark(row, col)
    local isMarked = self.board:putMark(row, col, self.char, self.color, self.textOptions);
    if(isMarked) then
        self.board:pushTurn(row, col, self.char, self.color, self.textOptions, self.isPlayer);
        return true;
    end
end

return Marker;