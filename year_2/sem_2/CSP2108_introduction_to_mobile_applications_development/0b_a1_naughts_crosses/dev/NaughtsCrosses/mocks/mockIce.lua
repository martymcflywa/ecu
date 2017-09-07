-- (C) Copyright 2013 Cluain Krystian Szczęsny (http://it.cluain.pl) and others.
--
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the GNU Lesser General Public License
-- (LGPL) version 2.1 which accompanies this distribution, and is available at
-- http://www.gnu.org/licenses/lgpl-2.1.html
--
-- This library is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
-- Lesser General Public License for more details.
--
-- User: Krystian Szczęsny
-- Date: 10/15/13
-- Time: 9:02 AM
--

local ice = {}

local boxes = {}

local function createBox()
    local box = {
        stuff = {}
    }

    box.retrieve = function(self, name)
        return box.stuff[name]
    end

    box.save = function()
    -- it's already in memory
    end
    box.store = function(self, name, value)
        box.stuff[name] = value
    end

    return box
end

ice.loadBox = function(self, name)
    if not boxes[name] then
        boxes[name] = createBox()
    end

    return boxes[name]
end

return ice