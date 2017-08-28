-- import the base class
local Marker = require("Marker");

-- Player extends Marker, TODO: Rename Marker.
local Player = Marker:extend("Player");

function Player:init(board, char)
    Player.super:init(board, char);
    return self;
end

function Player:fill(event)
    if(event.phase == self.phase) then
        for key, value in pairs(self.board.spaces) do
            if(event.x > value[2] and event.x < value[4]) then
                if(event.y < value[3] and event.y > value[5]) then
                    Player.super:mark(key, self.char);
                    Player.super:updateSpace(key, self.char);
                end
            end
        end
    end
end

return Player;