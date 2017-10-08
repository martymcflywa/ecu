local composer = require("composer");
require("mobdebug").start();

_d = display;
_cw = _d.contentWidth;
_ch = _d.contentHeight;
_cx = _cw * 0.5;
_cy = _ch * 0.5;

_colors = {
    blue = {0, 0, 1},
    red = {1, 0, 0}
};
_effectTime = 500;

-- button grid
_bRows = 5;
_bCols = 4;

_marginX = _cw * 0.05; 
_gutterX = _marginX * 0.5;
_bContainerW = _cw - (_marginX * 2);
_buttonW = (_bContainerW - (_gutterX * (_bCols - 1))) / _bCols;

_marginY = _ch * 0.05;
_gutterY = _marginY * 0.5;
_bContainerY = _ch - (_marginY * 2);
_buttonH = (_bContainerY - (_gutterY * (_bRows - 1))) / _bRows;

_buttons = {};
_effects = {
    {
        "fade", 
        "crossFade", 
        "zoomOutIn", 
        "zoomOutInFade"
    },
    {
        "zoomInOut",
        "zoomInOutFade",
        "flip",
        "flipFadeOutIn"
    },
    {
        "zoomOutInRotate",
        "zoomOutInFadeRotate",
        "zoomInOutRotate",
        "zoomInOutFadeRotate"
    },
    {
        "fromRight",
        "fromLeft",
        "fromTop",
        "fromBottom"
    },
    {
        "slideLeft",
        "slideRight",
        "slideDown",
        "slideUp"
    }
};

local xOffset = _marginX;
local yOffset = _marginY;

for row = 1, _bRows, 1 do
    _buttons[row] = {};
    for col = 1, _bCols, 1 do
        _buttons[row][col] = {};
        _buttons[row][col]["xL"] = xOffset;
        _buttons[row][col]["xR"] = xOffset + _buttonW;
        _buttons[row][col]["yT"] = yOffset;
        _buttons[row][col]["yB"] = yOffset + _buttonH;
        _buttons[row][col]["x"] = xOffset + (_buttonW * 0.5);
        _buttons[row][col]["y"] = yOffset + (_buttonH * 0.5);
        _buttons[row][col]["effect"] = _effects[row][col];
        xOffset = xOffset + _buttonW + _gutterX;
        print(_effects[row][col] .. " x=" .. _buttons[row][col]["x"] .. " y=" .. _buttons[row][col]["y"]);
    end
    xOffset = _marginX;
    yOffset = yOffset + _buttonH + _gutterY;
end

composer.gotoScene("demoScene1");