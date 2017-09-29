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
-- Date: 10/15/13
-- Time: 9:02 AM
--

local ev = require("ev")
local transition = {}

transition.to = function(target, options)
    assert(options.time, "No time provided")
    ev.Timer.new(function()

        --set required properties on target
        if options.x then
            target.x = options.x
        end
        if options.y then
            target.y = options.y
        end
        if options.xScale then
            target.xScale = options.xScale
        end
        if options.yScale then
            target.yScale = options.yScale
        end
        if options.alpha then
            target.alpha = options.alpha
        end
        
        if options.onComplete then options.onComplete() end

    end, options.time/1000):start(ev.Loop.default)
end

return transition