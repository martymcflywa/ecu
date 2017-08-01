-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- Your code here

local message1 = "helloWorld";
local x1 = 160;
local y1 = 240;
local font = "Arial";
local fontSize1 = 60;

local message2 = "from Martin Ponce";
local y2 = y1 + 120;
local fontSize2 = fontSize1 / 2;

display.newText(message1, x1, y1, font, fontSize1);
display.newText(message2, x1, y2, font, fontSize2);