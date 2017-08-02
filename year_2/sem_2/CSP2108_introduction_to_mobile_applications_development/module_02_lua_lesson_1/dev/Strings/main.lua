-----------------------------------------------------------------------------------------
--
-- main.lua
--
-- Displays info about mobile device
-- CSP2308 Workshop 2
-- Author: Martin Ponce
-- Version: 20170802
-----------------------------------------------------------------------------------------

FONT = "Arial";
FONT_SIZE = 20;
MARK_X = "x";
MARK_PLUS = "+";
MARGIN = 10;

-- mark middle of the screen
display.newText(
    MARK_X, 
    display.contentCenterX, 
    display.contentCenterY, 
    FONT, 
    FONT_SIZE
);

-- mark top left corner
display.newText(
    MARK_PLUS,
    MARGIN,
    MARGIN,
    FONT,
    FONT_SIZE
);
-- mark top right corner
display.newText(
    MARK_PLUS,
    display.contentWidth - MARGIN,
    MARGIN,
    FONT,
    FONT_SIZE
);
-- mark bottom left corner
display.newText(
    MARK_PLUS,
    MARGIN,
    display.contentHeight - MARGIN,
    FONT,
    FONT_SIZE
);
-- mark bottom right corner
display.newText(
    MARK_PLUS,
    display.contentWidth - MARGIN,
    display.contentHeight - MARGIN,
    FONT,
    FONT_SIZE
);

-- show display coordinates
yPos = 20; -- y coord for next text object

-- title
display.newText(
    "Display:",
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
-- increment y
yPos = yPos + FONT_SIZE;

-- get width/height, set in config.lua
dimensionsMessage = "W * H = " .. display.contentWidth .. " * " .. display.contentHeight;

display.newText(
    dimensionsMessage,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;

-- get actual width/height, number formatted to 1 decimal point
actualWidth = string.format("%.1f", display.actualContentWidth);
actualHeight = string.format("%.1f", display.actualContentHeight);
actualDimensionsMessage = "Actual W * H = " .. actualWidth .. " * " .. actualHeight;

display.newText(
    actualDimensionsMessage,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;

-- get aspect ratio, number formatted to 2 decimal points
aspectRatio = display.pixelHeight / display.pixelWidth;
aspectRatioMessage = string.format("%.2f", aspectRatio);

display.newText(
    "Aspect Ratio = " .. aspectRatioMessage,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE * 2;

-- get system info
display.newText(
    "System:",
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;

-- get app name
appName = system.getInfo("appName");
display.newText(
    "appName = " .. appName,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;

-- get architecture info
archInfo = system.getInfo("architectureInfo");
display.newText(
    "architectureInfo = " .. archInfo,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;

-- get model
model = system.getInfo("model");
display.newText(
    "model = " .. model,
    display.contentCenterX,
    yPos,
    FONT,
    FONT_SIZE
);
yPos = yPos + FONT_SIZE;