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
        -- rather than iterate for touch x/y, select random key from board.spaces
        -- local space = nil;
        -- repeat
        local random = math.random(9);
        print(random);
        local space = self.board.spaces[1];
        -- while
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