local Marker = class("Marker");

function Marker:init(board, char)
    self.board = board;
    self.char = char;
    self.phase = "began";
    self.shiftX = 5;
    self.shiftY = 15;
    return self;
end

function Marker:mark(char, x, y)
    local mark = display.newText(char, x, y);
    mark.anchorX = 0;
    mark.anchorY = 0;
end

return Marker;