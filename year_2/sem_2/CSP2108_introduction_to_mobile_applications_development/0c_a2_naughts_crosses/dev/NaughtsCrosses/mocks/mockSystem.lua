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

-- local socket = require("socket")

local system = {}

system.DocumentsDirectory = "/mock/path";

system.pathForFile = function(filename, path)
    return path .. "/" .. filename;
end

system.getInfo = function(name)
    if name == "platformName" then
        return "simulator"
    elseif name == "model" then
        return "simulator"
    end
end

system.getTimer = function() return socket.gettime()*1000 end

return system