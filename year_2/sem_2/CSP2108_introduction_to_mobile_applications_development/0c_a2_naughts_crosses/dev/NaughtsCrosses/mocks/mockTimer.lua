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
-- User: Maciej Staroń
-- Date: 16.10.2013
-- Time: 13:12
--

local ev = require("ev")
local timer = {}

timer.performWithDelay = function(time, callback)
    assert(time, "No time provided")
    assert(callback, "No callback provided")

    ev.Timer.new(function()
        callback({})

    end, time/1000):start(ev.Loop.default)

end

return timer