-- import the base class
local Marker = require("Marker");

-- Player extends Marker, TODO: Rename Marker.
local Player = Marker:extend("Player");

function Player:init(board, char)
    Player.super:init(board, char);
    return self;
end

function Player:fill(event)
    if event.phase == self.phase then
        tap = 0;
        for key, value in pairs(self.board.compartments) do
            if (event.x > value[2] and event.x < value[4]) then
                if (event.y < value[3] and event.y > value[5]) then
                    local x = value[2] + (self.board.w20 / 2) - self.shiftX;
                    local y = value[3] - (self.board.h20 / 2) - self.shiftY;
                    Player.super:mark(self.char, x, y);
                    -- TODO: add hit tracking here
                end
            end
        end
    end
end

return Player;