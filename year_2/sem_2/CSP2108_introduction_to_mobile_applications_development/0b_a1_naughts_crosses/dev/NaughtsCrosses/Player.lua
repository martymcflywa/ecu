-- import the base class
local Filler = require("Filler");

-- Player extends Filler, TODO: Rename Filler.
local Player = Filler:extend("Player");

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
                    local x = (value[4] - value[2]) / 2;
                    local y = (value[3] - value[5]) / 2;
                    -- TODO: Fix x, y coordinates, calcs above are broken.
                    print(x);
                    print(y);
                    Player.super:mark(self.char, x, y);
                end
            end
        end
    end
end

return Player;