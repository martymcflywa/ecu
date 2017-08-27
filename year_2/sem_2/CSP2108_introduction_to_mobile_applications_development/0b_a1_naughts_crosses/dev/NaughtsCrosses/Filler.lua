local Filler = class("Filler");

function Filler:init(board, char)
    self.board = board;
    self.char = char;
    self.phase = "began";
    return self;
end

function Filler:mark(char, x, y)
    local mark = display.newText(char, x, y);
    mark.anchorX = 0;
    mark.anchorY = 0;
end

return Filler;