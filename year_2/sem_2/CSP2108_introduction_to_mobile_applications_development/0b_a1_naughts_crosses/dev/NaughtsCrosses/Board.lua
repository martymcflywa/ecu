local Board = class("Board");

-- defines dimensions of play area
function Board:init(playerChar, aiChar)
    self.rank = 3;

    self.players = {
        player = playerChar,
        ai = aiChar
    };

    self.chars = {
        empty = 0,
        X = 1,
        O = 2
    };

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

    self.scoreboard = self.newScoreBoard(self);
    self.winCombos = self.newWinCombos(self);

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

    self.winner = nil;
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

-- this table keeps track of chars put on board
-- when player/ai puts piece on board, this table gets updated too
-- empty = 0, player = increment, ai = decrement
-- when checking for winner, iterate winCombos to find result
-- if player has three in a row, expected return = 3
-- if ai has three in a row, expected return = -3
function Board:newScoreBoard()
    local scoreboard = {};
    for row = 1, self.rank, 1 do
        scoreboard[row] = {};
        for col = 1, self.rank, 1 do
            scoreboard[row][col] = self.chars["empty"];
        end
    end
    return scoreboard;
end

-- gets score at row, col
function Board:getMarkAt(row, col)
    return self.scoreboard[row][col];
end

-- check if score at row, col is empty
function Board:isEmpty(row, col)
    if(self.getMarkAt(self, row, col) == self.chars["empty"]) then
        return true;
    end
    return false;
end

-- puts score at row, col
function Board:putScore(score, row, col)
    if(self.isEmpty(self, row, col) == true) then
        self.scoreboard[row][col] = score;
        return true;
    end
    return false;
end

function Board:isGameOver()
    if(not isWin()) then
        for row = 1, self.rank, 1 do
            for col = 1, self.rank, 1 do
                if(self.isEmpty(self, row, col)) then
                    return false;
                end
            end
        end
        -- end on draw
        return true;
    end
    -- end on win
    return true;
end

function Board:newWinCombos()
    local winCombos = {};
    comboCount = 1;

    -- define vertical combos
    for i = 1, self.rank, 1 do
        winCombos[comboCount] = {};
        for j = 1, self.rank, 1 do
            winCombos[comboCount][j] = {};
            winCombos[comboCount][j]["x"] = i;
            winCombos[comboCount][j]["y"] = j;
        end
        comboCount = comboCount + 1;
    end

    -- define horizontal combos
    for i = 1, self.rank, 1 do
        winCombos[comboCount] = {};
        for j = 1, self.rank, 1 do
            winCombos[comboCount][j] = {};
            winCombos[comboCount][j]["x"] = j;
            winCombos[comboCount][j]["y"] = i;
        end
        comboCount = comboCount + 1;
    end

    -- define diagonal combos
    -- left-right-up
    winCombos[comboCount] = {};
    for i = 0, self.rank, 1 do
        winCombos[comboCount][i] = {};
        winCombos[comboCount][i]["x"] = i;
        winCombos[comboCount][i]["y"] = i;
    end
    comboCount = comboCount + 1;

    -- left-right-down
    winCombos[comboCount] = {};
    for i = self.rank, 1, -1 do
        winCombos[comboCount][i] = {};
        winCombos[comboCount][i]["x"] = self.rank - i - 1;
        winCombos[comboCount][i]["y"] = i;
    end
    return winCombos;
end

function Board:getWinCombo(id)
    return self.winCombos[id];
end

function Board:checkWinInCombo(id)
    local output = 0;
    for index, value in pairs(self.getWinCombo(self, id)) do
        local mark = self.getMarkAt(self, value["x"], value["y"]);
        if mark = self.players["player"] then
            output = output + 1;
        end
        if mark = self.players["ai"] then
            output = output - 1;
        end
    end
    return output;
end

function Board:isWin()
    for index in pairs(self.winCombos) down
        local score = self.checkWinInCombo(self, index);
        if(math.abs(score)) == self.rank then
            if(score == math.abs(score)) then 
                return self.players["player"];
            else
                return self.players["ai"]
            end
        end
    end
    return false;
end

-- check if space is empty
function Board:isSpaceEmpty(key)
    return self.spaces[key][6] == self.chars["empty"];
end

-- detect if game is over
-- function Board:isGameOver()
--     for key, value in pairs(self.chars) do
--         -- ignore empty
--         if(key ~= "empty") then
--             if(self.checkForWinner(self, value)) then
--                 self.winner = key;
--                 return true;
--             end
--         end
--     end
--     return false;
-- end

-- look up winning combinations for winner
function Board:checkForWinner(charInt)
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
    return isWinner;
end

function Board:charToInt(char)
    if(char == "X") then
        return self.chars["X"];
    elseif(char == "O") then
        return self.chars["O"];
    end
end

return Board;