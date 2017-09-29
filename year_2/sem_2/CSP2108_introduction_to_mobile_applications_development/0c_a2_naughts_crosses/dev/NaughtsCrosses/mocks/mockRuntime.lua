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

local Runtime = {
    eventListeners = {}
}

Runtime.addEventListener = function(self, name, callback)
    if not Runtime.eventListeners[name] then Runtime.eventListeners[name] = {} end
    table.insert(Runtime.eventListeners[name], callback)
end

Runtime.removeEventListener = function(self, name, callback)
    assert(Runtime.eventListeners[name], "no such event name: " .. tostring(name))
    for i = #Runtime.eventListeners[name], 1, -1 do
        if Runtime.eventListeners[name][i] == callback then
            table.remove(Runtime.eventListeners[name], i)
        end
    end
end

Runtime.dispatchEvent = function(self, event)
    assert(event.name, "event name not provided")

    if not Runtime.eventListeners[event.name] or #Runtime.eventListeners[event.name] == 0 then return end

    for i = 1, #Runtime.eventListeners[event.name] do
        Runtime.eventListeners[event.name][i](event)
    end
end

return Runtime