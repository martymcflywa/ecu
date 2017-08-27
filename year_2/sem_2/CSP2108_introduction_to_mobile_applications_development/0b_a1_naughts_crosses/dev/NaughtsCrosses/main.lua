-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- Your code here
d = display;
w20 = d.contentWidth * 0.2;
h20 = d.contentHeight * 0.2;
w40 = d.contentWidth * 0.4;
h40 = d.contentHeight * 0.4;
w60 = d.contentWidth * 0.6;
h60 = d.contentHeight * 0.6;
w80 = d.contentWidth * 0.8;
h80 = d.contentHeight * 0.8;

----DRAW LINES FOR BOARD
local lline = d.newLine(w40, h20, w40, h80);
lline.strokeWidth = 5;
local rline = d.newLine(w60, h20, w60, h80);
rline.strokeWidth = 5;
local bline = d.newLine(w20, h40, w80, h40);
bline.strokeWidth = 5;
local tline = d.newLine(w20, h60, w80, h60);
tline.strokeWidth = 5;

--PLACE BOARD COMPARTMENT DIMENSIONS IN TABLE
board = {
    {"tl", 1, w20, h40, w40, h20, 0},
    {"tm", 2, w40, h40, w60, h20, 0},
    {"tr", 3, w60, h40, w80, h20, 0},
    {"ml", 4, w20, h60, w40, h40, 0},
    {"mm", 5, w40, h60, w60, h40, 0},
    {"mr", 6, w60, h60, w80, h40, 0},
    {"bl", 7, w20, h80, w40, h60, 0},
    {"bm", 8, w40, h80, w60, h60, 0},
    {"br", 9, w60, h80, w80, h60, 0}
}

--FILL COMPARTMENT W/ COLOUR WHEN TOUCHED
local function fill (event)
    if event.phase == "began" then
        tap = 0;
        for t = 1, 9 do
            if event.x > board[t][3] and event.x < board [t][5] then
                if event.y < board[t][4] and event.y > board[t][6] then
                    r = d.newRect(board[t][3], board[t][6], w20, h20);
                    r:setFillColor(1, 1, 0);
                    r.anchorX = 0;
                    r.anchorY = 0;
                end
            end
        end
    end
end

Runtime:addEventListener("touch", fill)