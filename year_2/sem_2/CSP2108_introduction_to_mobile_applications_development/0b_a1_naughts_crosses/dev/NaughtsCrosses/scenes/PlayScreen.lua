-- Scene template from: https://docs.coronalabs.com/guide/system/composer/index.html#template

local composer = require("composer");
local scene = composer.newScene();
local Logger = require("Logger");
local Board = require("Board");
local Game = require("Game");

--[[
    Code outside scene event functions are only executed once,
    unless the scene is removed by composer.RemoveScene().
--]]

local bg;
local logger;
local board;
local game;
local playerChar;
local gameOverScreenOptions = {
    effect = "flip",
    time = 300,
    params = {}
};

--[[
    Defining initializers first.
--]]
local function initBg(sceneGroup)
    local bg = _d.newRect(_cx, _cy, _w, _h);
    bg:setFillColor(unpack(_colors["white"]));
    sceneGroup:insert(bg);
    return bg;
end

local function handleTie()
    gameOverScreenOptions.params.message = "tie game\nyou both lose";
    timer.performWithDelay(500, function() composer.gotoScene("scenes.GameOver", gameOverScreenOptions); end);
end

local function handleWin()
    local message;
    local winChar;
    local isPlayerWinner = false;
    if(game.board.winner == _chars[_x]) then
        winChar = _x;
    else
        winChar = _o;
    end
    if(playerChar == _chars[winChar]) then
        message = string.format("you won with '%s'\nwell done", winChar);
    else
        message = string.format("you lose\nai beat you with '%s'", winChar);
    end
    gameOverScreenOptions.params.message = message;
    timer.performWithDelay(500, function() composer.gotoScene("scenes.GameOver", gameOverScreenOptions); end);
end

--[[
    Checks if game is over. If so, goto appropriate scene.
--]]
local function isGameOver()
    if(game.board:isGameOver()) then
        if(game.board.winner == _chars["empty"]) then
            game.logger:log("PlayScreen", "isGameOver()", "game over, tie game!");
            handleTie();
            return true;
        else
            game.logger:log("PlayScreen", "isGameOver()", string.format("game over, winner is %s!", game.board.winner));
            handleWin();
            return true;
        end
    end
    return false;
end

--[[
    Listen for "touch" events here. 
--]]
local function play(event)
    -- ai first turn, proxy event.x will be nil
    if(event.x == nil) then
        game.ai:turn(event);
    else
        if(not isGameOver()) then
            if(game.player:turn(event)) then
                if(not isGameOver()) then
                    game.ai:turn(event);
                    -- do one last check if game over, ai might take a winning turn
                    isGameOver();
                end
            end
        end
    end
end

local function dispose(sceneGroup)
    -- if(bg ~= nil) then
    --     -- bg:removeEventListener(_event, play);
    --     _d.remove(bg);
    --     bg = nil;
    -- end
    if(board ~= nil) then
        board:dispose();
        board = nil;
    end
    if(game ~= nil) then
        game:dispose();
        game = nil;
    end
    if(playerChar ~= nil) then
        playerChar = nil;
    end
    if(logger ~= nil) then
        logger = nil;
    end
    -- if(sceneGroup.numChildren > 0) then
    --     sceneGroup:removeSelf();
    -- end
end

local function setupGame(sceneGroup, playerChar)
    playerChar = playerChar;
    bg = initBg(sceneGroup);
    logger = Logger(_logMode);
    board = Board(logger, sceneGroup);
    game = Game(logger, board, playerChar);
    board:draw();
    bg:addEventListener(_event, play);

    -- if ai goes first, dispatch a proxy event to trigger gameplay
    if(playerChar == _chars[_o]) then
        local proxyEvent = {
            name = "touch",
            phase = "ended",
            target = bg
        };
        bg:dispatchEvent(proxyEvent);
    end
end

--[[
    Code in create() runs when the scene is first created,
    before appearing on the screen.
    Create ui/display objects here, ie. buttons, text, graphics etc
    so it's ready when show() is dispatched.
--]]
function scene:create(event)
    local sceneGroup = self.view;
    -- clear everything when restarting scene
    dispose(sceneGroup);
end

function scene:show(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    --[[
        "will" code executed when scene is still off screen, but about to be shown.
        Reset variable values or reposition objects to start points,
        ie. restarting the level etc.
    --]]
    if(phase == "will") then
        -- do stuff just before shown
        setupGame(sceneGroup, event.params.char);
    --[[
        "did" code executed when scene is completely on screen. Has become the active screen.
        Start transitions, timers, start music for the scene or physics etc.
    --]]
    elseif(phase == "did") then
        -- do stuff when shown
    end
end

function scene:hide(event)
    local sceneGroup = self.view;
    local phase = event.phase;

    --[[
        "will" code executed when scene is still on screen, but about to be hidden.
        Pause/stop physics, cancel timers/transitions, stop music etc.
    --]]
    if(phase == "will") then
        -- do stuff just before hidden

    --[[
        "did" code executed when scene is completely hidden.
        Scene view remains initialized and stays in memory,
        could be reused without initializing.
    --]]
    elseif(phase == "did") then
        -- do stuff when hidden
        -- clear the board
        -- dispose(sceneGroup);
    end
end

--[[
    Code executed before removing scene's view.
    Undo stuff from when create() was called, ie. dispose.

    To remove a scene, call composer.removeScene(name);
    Can also pass shouldRecycle bool: composer.removeScene(name, true);
    Recycled scenes stay in mem.
--]]
function scene:destroy(event)
    local sceneGroup = self.view;
    -- dispose(sceneGroup);
end

--[[
    These events will be dispatched when transitioning to the scene.
--]]
scene:addEventListener("create", scene);
scene:addEventListener("show", scene);
scene:addEventListener("hide", scene);
scene:addEventListener("destroy", scene);

--[[
    When done with a scene, remember to:
        - Remove runtime listeners
        - Cancel transitions/timers
        - Dispose audio
        - Close IO (files/db etc.)
--]]

return scene;