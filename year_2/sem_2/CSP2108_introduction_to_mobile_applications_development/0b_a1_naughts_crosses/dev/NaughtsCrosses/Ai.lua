-- import the base class
local Marker = require("Marker");
-- extend Marker
local Ai = Marker:extend("Ai");

function Ai:init(board, char)
    Ai.super:init(board, char);
    self.spacesKeyset = self:getSpacesKeyset();
    return self;
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

function Ai:getSpacesKeyset()
    local index = {};
    local i = 1;
    for key, value in pairs(self.board.spaces) do
        index[i] = key;
        i = i + 1;
    end
    return index;
end

return Ai