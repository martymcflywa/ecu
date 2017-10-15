require("modules.30log.30log-global");

-- mocked corona sdk objects
display = require("mocks.mockDisplay");
system = require("mocks.mockSystem");
io = require("mocks.mockIo");

Logger = require("Logger");
Board = require("Board");
Game = require("Game");
Ai = require("Ai");
Persist = require("Persist");
event = {
    phase = "ended"
};

-- setup globals, see main.lua
_d = display;
_w = _d.contentWidth;
_h = _d.contentHeight;
_cx = _d.contentCenterX;
_cy = _d.contentCenterY;
_colors = {
    black = {0, 0, 0},
    white = {1, 1, 1},
    red = {1, 0, 0},
    green = {0, 1, 0},
    orange = {1, 0.5, 0, 1}
};
_chars = {
    empty = 0,
    x = 1,
    o = -1
};
_difficulty = {
    e = "easy",
    m = "medium",
    h = "hard"
};
_x = "x";
_o = "o";
_event = "touch";
_logMode = "info";
logger = Logger(_logMode);