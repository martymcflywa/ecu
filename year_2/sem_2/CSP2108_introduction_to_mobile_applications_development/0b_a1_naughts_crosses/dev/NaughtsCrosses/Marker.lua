local Marker = class("Marker");

function Marker:init(board, char)
    self.board = board;
    self.char = char;
    self.font = "Arial";
    self.fontSize = 70;
    self.phase = "began";
    self.centerX = self.board.w20 / 2;
    self.centerY = self.board.h20 / 2;
    return self;
end

function Marker:mark(key, char)
    if(self.board:isSpaceEmpty(key)) then
        local x = self.board.spaces[key][2] + self.centerX;
        local y = self.board.spaces[key][3] - self.centerY;
        self:markCenter(char, x, y);
        return true;
    else
        print("INFO: space " .. key .. " already marked.");
        return false;
    end
end

function Marker:markCenter(char, xPos, yPos)
    local options = {
        text = char,
        x = xPos - (self.fontSize / 2),
        y = yPos - (self.fontSize / 2),
        font = self.font,
        fontSize = self.fontSize,
        align = "center"
    };
    local mark = display.newText(options);
    mark.anchorX = 0;
    mark.anchorY = 0;
    if(char == "X") then
        mark.x = mark.x + (mark.contentWidth / 4);
        mark.y = mark.y - (mark.contentHeight / 16);
        mark:setFillColor(1, 0, 0);
    else
        mark.x = mark.x + (mark.contentWidth / 7.3);
        mark.y = mark.y - (mark.contentHeight / 13);
        mark:setFillColor(0, 1, 0);
    end
end

function Marker:updateSpace(key, char)
    self.board.spaces[key][6] = self:charToInt(char);
end

function Marker:charToInt(char)
    if(char == "X") then
        return self.board.chars["cross"];
    elseif(char == "O") then
        return self.board.chars["naught"];
    end
end

return Marker;