local Marker = class("Marker");

function Marker:init(logger, board, char, color)
    self.logger = logger;
    self.board = board;
    self.char = char;
    self.phase = "ended"; -- ended triggers listener only once
    self.color = color;
    self.textOptions = {
        text = self.char,
        font = "Arial",
        fontSize = 70,
        align = "center"
    };
end

function Marker:dispose()
    if(self.logger ~= nil) then
        logger = nil;
    end
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
    return self.board.putMark(self.board, row, col, self.char, self.color, self.textOptions);
end

return Marker;