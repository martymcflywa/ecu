local Board = class("Board");

-- defines dimensions of play area
function Board:init()
    self.d = display;
    self.w20 = self.d.contentWidth * 0.2;
    self.h20 = self.d.contentHeight * 0.2;
    self.w40 = self.d.contentWidth * 0.4;
    self.h40 = self.d.contentHeight * 0.4;
    self.w60 = self.d.contentWidth * 0.6;
    self.h60 = self.d.contentHeight * 0.6;
    self.w80 = self.d.contentWidth * 0.8;
    self.h80 = self.d.contentHeight * 0.8;

    self.compartments = {
        {"tl", 1, self.w20, self.h40, self.w40, self.h20, 0},
        {"tm", 2, self.w40, self.h40, self.w60, self.h20, 0},
        {"tr", 3, self.w60, self.h40, self.w80, self.h20, 0},
        {"ml", 4, self.w20, self.h60, self.w40, self.h40, 0},
        {"mm", 5, self.w40, self.h60, self.w60, self.h40, 0},
        {"mr", 6, self.w60, self.h60, self.w80, self.h40, 0},
        {"bl", 7, self.w20, self.h80, self.w40, self.h60, 0},
        {"bm", 8, self.w40, self.h80, self.w60, self.h60, 0},
        {"br", 9, self.w60, self.h80, self.w80, self.h60, 0}
    }
    return self;
end

-- draws naughts and crosses board
function Board:draw()
    local vertLeft = self.d.newLine(self.w40, self.h20, self.w40, self.h80);
    vertLeft.strokeWidth = 5;
    local vertRight = self.d.newLine(self.w60, self.h20, self.w60, self.h80);
    vertRight.strokeWidth = 5;
    local horTop = self.d.newLine(self.w20, self.h60, self.w80, self.h60);
    horTop.strokeWidth = 5;
    local horBottom = self.d.newLine(self.w20, self.h40, self.w80, self.h40);
    horBottom.strokeWidth = 5;
end

return Board;