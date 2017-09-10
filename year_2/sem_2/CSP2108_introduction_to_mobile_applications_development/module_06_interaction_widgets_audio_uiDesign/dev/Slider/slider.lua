-----------------------------------------------------------------------------------------
--
-- slider.lua
--
-- game logic for a slider game
--
-----------------------------------------------------------------------------------------

local slider = {}

-- this will be a 5x5 slider
slider.SIZE = 3;

-- keeps track of which tiles are where
local tiles = {}
-- where is the hole
local hole

-- sets up in standard positions
function slider:reset()
	tiles = {}
	for i = 1, self.SIZE do
		tiles[i] = {}
		for j = 1, self.SIZE do
			tiles[i][j] = (i-1)*self.SIZE + j -- "tile numbers"
		end
	end
	tiles[self.SIZE][self.SIZE] = 0 -- the hole
	
	hole = {row = self.SIZE, column = self.SIZE}
end

-- which "tile number" is currently in this row and column
function slider:getTile( row, column )
	return tiles[row][column]
end

-- to do a move, the caller calls getMoves(), which returns info about which tiles move to where
-- then calls doMoves() to update the puzzle data

-- buffer info for next move
local moves
local nextHole

-- returns sequence of tile movements
-- sets moves and nextHole
function slider:getMoves( row, column )
	if row ~= hole.row and column ~= hole.column then
		return nil
	end
	
	if row == hole.row and column == hole.column then
		return nil
	end
	
	moves = {}
	nextHole = {row = row, column = column}
	
	-- move tiles to right
	if row == hole.row and column < hole.column then
		for c = hole.column-1, column, -1 do
			moves[#moves+1] = {
				from = {index = self:getTile(row, c), row = row, column = c},
				to = {index = self:getTile(row, c+1), row = row, column = c+1}
				}
		end
	end
	
	-- move tiles to left
	if row == hole.row and column > hole.column then
		for c = hole.column+1, column do
			moves[#moves+1] = {
				from = {index = self:getTile(row, c), row = row, column = c},
				to = {index = self:getTile(row, c-1), row = row, column = c-1}
				}
		end
	end
	
	-- move tiles down
	if row < hole.row and column == hole.column then
		for r = hole.row-1, row, -1 do
			moves[#moves+1] = {
				from = {index = self:getTile(r, column), row = r, column = column},
				to = {index = self:getTile(r+1, column), row = r+1, column = column}
				}
		end
	end
	
	-- move tiles up
	if row > hole.row and column == hole.column then
		for r = hole.row+1, row do
			moves[#moves+1] = {
				from = {index = self:getTile(r, column), row = r, column = column},
				to = {index = self:getTile(r-1, column), row = r-1, column = column}
				}
		end
	end
	
	return moves
end

-- carry out sequence using moves and nextHole
function slider:doMoves()
	for i = 1, #moves do
		tiles[moves[i].to.row][moves[i].to.column] = tiles[moves[i].from.row][moves[i].from.column]
	end
	
	tiles[nextHole.row][nextHole.column] = 0
	hole = nextHole
end

-- check whether the puzzle is completely solved
function slider:isSolved()
	local count = 1
	for row = 1, SIZE do
		for column = 1, SIZE do
			if row == SIZE and column == SIZE then
				return true
			end 
			if tiles[row][column] ~= count then
				return false
			end
			count = count + 1
		end
	end
end

-- start in default configuration
slider:reset()

return slider
