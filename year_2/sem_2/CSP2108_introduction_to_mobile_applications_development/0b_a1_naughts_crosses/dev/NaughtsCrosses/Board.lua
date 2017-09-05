--[[

    Representation of the board as tables:

     1,1 | 1,2 | 1,3
    -----|-----|-----
     2,1 | 2,2 | 2,3
    -----|-----|-----
     3,1 | 3,2 | 3,3

    Each space is referenced by its column and row number, ie. 1,1 = top left.
    See https://coronalabs.com/blog/2015/04/07/tutorial-working-with-a-grid-layout/

    Three tables represent the board: centers, scores and grid.

    centers:
    Converts col,row to pixel coordinate, where marker is placed.

    scores:
    col,row holds value for marker placed. If "x" is placed, col,row's value = 1.
    If "o" is placed, col,row's value = -1. scores table is summed by winCombos table. 
    "x" wins if sum == 3. "o" wins if sum == -3. Tie if scores full but no winning sum.

    grid:
    Converts touch event pixel coordinates to col,row.

    @author Martin Ponce, 10371381 for CSP2108
    @version 20170901

--]]

local Board = class("Board");

-- defines dimensions of play area
function Board:init(logger, sceneGroup)
    self.logger = logger;
    -- injecting scenegroup here so board and chars are added to it
    -- TODO: would prefer to keep this responsibility to scene but running out of time
    self.sceneGroup = sceneGroup;
    self.rowsCols = 3;
    self.w20 = _w * 0.2;
    self.h20 = _h * 0.2;
    self.w40 = _w * 0.4;
    self.h40 = _h * 0.4;
    self.w60 = _w * 0.6;
    self.h60 = _h * 0.6;
    self.w80 = _w * 0.8;
    self.h80 = _h * 0.8;
    self.centers = {};
    self.scores = {};
    self.grid = {};
    self.winCombos = {};
    self.winner = _chars["empty"];
    self:setup();
end

function Board:setup()
    self:newBoard();
    self:newWinCombos();
end

function Board:dispose()
    if(self.sceneGroup ~= nil) then
        self.sceneGroup:removeSelf();
        self.sceneGroup = nil;
    end
    if(self.winner ~= _chars["empty"]) then
        self.winner = _chars["empty"];
    end
    if(self.centers ~= nil) then
        self.centers = nil;
    end
    if(self.scores ~= nil) then
        self.scores = nil;
    end
    if(self.grid ~= nil) then
        self.grid = nil;
    end
    if(self.winCombos ~= nil) then
        self.winCombos = nil;
    end
    if(self.logger ~= nil) then
        self.logger = nil;
    end
end

-- draws naughts and crosses board
function Board:draw()
    local boardGroup = _d.newGroup();
    local vertLeft = _d.newLine(boardGroup, self.w40, self.h20, self.w40, self.h80);
    vertLeft.strokeWidth = 5;
    vertLeft:setStrokeColor(unpack(_colors["black"]));
    local vertRight = _d.newLine(boardGroup, self.w60, self.h20, self.w60, self.h80);
    vertRight.strokeWidth = 5;
    vertRight:setStrokeColor(unpack(_colors["black"]));
    local horTop = _d.newLine(boardGroup, self.w20, self.h60, self.w80, self.h60);
    horTop.strokeWidth = 5;
    horTop:setStrokeColor(unpack(_colors["black"]));
    local horBottom = _d.newLine(boardGroup, self.w20, self.h40, self.w80, self.h40);
    horBottom.strokeWidth = 5;
    horBottom:setStrokeColor(unpack(_colors["black"]));
    self.sceneGroup:insert(boardGroup);
end

-- void, sets up three tables in single On^2 loop:
-- scores: tracks marked grids,
-- centers: contains x,y coord for mark placement
-- grid: detects touch, returns col,row of board
function Board:newBoard()
    local xPc = 0.2;
    local yPc = 0.2;
    local xLeftPc = 0.2;
    local xRightPc = 0.4;
    local yTopPc = 0.2;
    local yBottomPc = 0.4;
    for row = 1, self.rowsCols, 1 do
        self.scores[row] = {};
        self.centers[row] = {};
        self.grid[row] = {};
        for col = 1, self.rowsCols, 1 do
            self.scores[row][col] = _chars["empty"];
            self.centers[row][col] = {};
            self.centers[row][col]["x"] = self:xCenter(xPc * _w);
            self.centers[row][col]["y"] = self:yCenter(yPc * _h);
            xPc = xPc + 0.2;
            self.grid[row][col] = {};
            self.grid[row][col]["xLeft"] = _w * xLeftPc;
            self.grid[row][col]["xRight"] = _w * xRightPc;
            self.grid[row][col]["yTop"] = _w * yTopPc;
            self.grid[row][col]["yBottom"] = _h * yBottomPc;
            xLeftPc = xLeftPc + 0.2;
            xRightPc = xRightPc + 0.2;
        end
        xPc = 0.2;
        yPc = yPc + 0.2;
        xLeftPc = 0.2;
        xRightPc = 0.4;
        yTopPc = yTopPc + 0.2;
        yBottomPc = yBottomPc + 0.2;
    end
end

function Board:xCenter(left)
    local xShift = self.w20 / 2;
    return left + xShift;
end

function Board:yCenter(top)
    local yShift = self.h20 / 2;
    return top + yShift;
end

function Board:getCenter(row, col)
    local x = self.centers[row][col]["x"];
    local y = self.centers[row][col]["y"];
    return x, y;
end

-- gets score at row, col
function Board:getScoreAt(row, col)
    return self.scores[row][col];
end

-- check if score at row, col is empty
function Board:isEmpty(row, col)
    if(self:getScoreAt(row, col) == _chars["empty"]) then
        return true;
    end
    return false;
end

-- put marker on board, update scores
function Board:putMark(row, col, char, color, textOptions)
    local score = _chars[char];
    local x, y = self:getCenter(row, col);
    if(self:isEmpty(row, col)) then
        self.scores[row][col] = score;
        textOptions.x = x;
        textOptions.y = y;
        local mark = _d.newText(textOptions);
        mark:setFillColor(unpack(color));
        self.sceneGroup:insert(mark);
        return true;
    else
        self.logger:debug(self.name, "putMark()", string.format("row=%d, col=%d, x=%03d, y=%03d already occupied.", row, col, x, y));
        return false
    end
end

function Board:isGameOver()
    if(self:isWin()) then
        return true;
    else
        -- check if board fully populated
        for row = 1, self.rowsCols, 1 do
            for col = 1, self.rowsCols, 1 do
                if(self:isEmpty(row, col)) then
                    return false;
                end
            end
        end
        -- gameover on draw
        return true;
    end
end

function Board:newWinCombos()
    comboCount = 1;
    -- define vertical combos
    for i = 1, self.rowsCols, 1 do
        self.winCombos[comboCount] = {};
        for j = 1, self.rowsCols, 1 do
            self.winCombos[comboCount][j] = {};
            self.winCombos[comboCount][j]["x"] = i;
            self.winCombos[comboCount][j]["y"] = j;
        end
        comboCount = comboCount + 1;
    end

    -- define horizontal combos
    for i = 1, self.rowsCols, 1 do
        self.winCombos[comboCount] = {};
        for j = 1, self.rowsCols, 1 do
            self.winCombos[comboCount][j] = {};
            self.winCombos[comboCount][j]["x"] = j;
            self.winCombos[comboCount][j]["y"] = i;
        end
        comboCount = comboCount + 1;
    end

    -- define diagonal combos
    -- left-right-down
    self.winCombos[comboCount] = {};
    for i = 1, self.rowsCols, 1 do
        self.winCombos[comboCount][i] = {};
        self.winCombos[comboCount][i]["x"] = i;
        self.winCombos[comboCount][i]["y"] = i;
    end
    comboCount = comboCount + 1;
    -- right-left-down
    self.winCombos[comboCount] = {};
    for i = self.rowsCols, 1, -1 do
        self.winCombos[comboCount][i] = {};
        self.winCombos[comboCount][i]["x"] = self.rowsCols - i + 1;
        self.winCombos[comboCount][i]["y"] = i;
    end
end

function Board:getWinCombo(id)
    return self.winCombos[id];
end

function Board:checkWinInCombo(id)
    local score = 0;
    for index, value in pairs(self:getWinCombo(id)) do
        score = score + self:getScoreAt(value["x"], value["y"]);
    end
    return score;
end

function Board:isWin()
    for index in pairs(self.winCombos) do
        local score = self:checkWinInCombo(index);
        if(math.abs(score)) == self.rowsCols then
            if(score == math.abs(score)) then 
                self.winner = _chars[_x];
                return true;
            else
                self.winner = _chars[_o];
                return true;
            end
        end
    end
    return false;
end

function Board:getGridFromTouch(event)
    for row = 1, self.rowsCols, 1 do
        for col = 1, self.rowsCols, 1 do
            -- if touch coord is between xleft and xright
            if(event.x > self.grid[row][col]["xLeft"] and event.x < self.grid[row][col]["xRight"]) then
                -- if touch coord is between ytop and ybottom
                if(event.y > self.grid[row][col]["yTop"] and event.y < self.grid[row][col]["yBottom"]) then
                    return row, col;
                end
            end
        end
    end
end

return Board;