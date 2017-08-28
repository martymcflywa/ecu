local Board = class("Board");

-- defines dimensions of play area
function Board:init()
    self.chars = {
        empty = 0,
        cross = 1,
        naught = 2
    }

    self.d = display;

    self.w20 = self.d.contentWidth * 0.2;
    self.h20 = self.d.contentHeight * 0.2;
    self.w40 = self.d.contentWidth * 0.4;
    self.h40 = self.d.contentHeight * 0.4;
    self.w60 = self.d.contentWidth * 0.6;
    self.h60 = self.d.contentHeight * 0.6;
    self.w80 = self.d.contentWidth * 0.8;
    self.h80 = self.d.contentHeight * 0.8;

    self.spaces = {
        tl = {1, self.w20, self.h40, self.w40, self.h20, 0},
        tm = {2, self.w40, self.h40, self.w60, self.h20, 0},
        tr = {3, self.w60, self.h40, self.w80, self.h20, 0},
        ml = {4, self.w20, self.h60, self.w40, self.h40, 0},
        mm = {5, self.w40, self.h60, self.w60, self.h40, 0},
        mr = {6, self.w60, self.h60, self.w80, self.h40, 0},
        bl = {7, self.w20, self.h80, self.w40, self.h60, 0},
        bm = {8, self.w40, self.h80, self.w60, self.h60, 0},
        br = {9, self.w60, self.h80, self.w80, self.h60, 0}
    }

    self.threeInARow = {
        horizontals = {
            top = {"tl", "tm", "tr"},
            middle = {"ml", "mm", "mr"},
            bottom = {"bl", "bm", "br"}
        },
        verticals = {
            left = {"tl", "ml", "bl"},
            middle = {"tm", "mm", "bm"},
            right = {"tr", "mr", "br"}
        },
        diagonals = {
            leftRightUp = {"bl", "mm", "tr"},
            leftRightDown = {"tl", "mm", "br"}
        }
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

-- check if space is empty
function Board:isSpaceEmpty(key)
    return self.spaces[key][6] == self.chars["empty"];
end

-- check for winner
function Board:isGameOver()
    for key, value in pairs(self.chars) do
        if(checkForWinner(value)) then
            return key
        end
    end
end

local function checkForWinner(charInt)
    local maxMatch = 3;
    local isWinner = false;

    -- iterate each k,v in threeInARow
    for oKey, oValue in pairs(self.threeInARow) do
        local matchTally = 0;
        -- iterate over each k,v in threeInARow value
        for iKey, iValue in pairs(oValue) do
            matchTally = 0;
            -- iterate each element in threeInARow value, value
            for i = 1, #iValue, 1 do
                -- look up spaces using iValue[i] as key 
                if(self.spaces[iValue[i]][6] == charInt) then
                    matchTally = matchTally + 1;
                end
            end
            if(matchTally >= maxMatch) then
                isWinner = true;
            end
            -- exit nested loop if we found a winner
            if(isWinner) then
                break;
            end
        end
        -- exit nested loop if we found a winner
        if(isWinner) then
            break;
        end
    end
end

return Board;