-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(board, char)
    Ai.super.init(self, board, char);
    self.spacesKeyset = self:getKeyset(self.board.spaces);
end

function Ai:fill(event)
    if(event.phase == self.phase) then
        -- TODO: try to implement a smarter ai...
        -- in the meantime, just find a random empty space
        local key;
        repeat
            key = self.spacesKeyset[math.random(#self.spacesKeyset)];
        until(self.board:isSpaceEmpty(key))

        if(Ai.super.mark(self, key, self.char)) then
            Ai.super.updateSpace(self, key, self.char);
            return true;
        end
        return false;
    end
end

function Ai:getKeyset(table)
    local keys = {};
    local i = 1;
    for key, value in pairs(table) do
        keys[i] = key;
        i = i + 1;
    end
    return keys;
end

return Ai