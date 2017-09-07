require "busted.runner"();
require("tests.TestGlobals");

describe("GameTests.", function()
    local logger;
    local board;

    setup(function()
        logger = Logger(_logMode);
        board = Board(logger, _d.newGroup());
    end)

    describe("When Player is x.", function()
        local expectedPlayerChar = _x;
        it("Expects Game will select Player as x.", function()
            local game = Game(logger, board, expectedPlayerChar);
            assert.same(expectedPlayerChar, game.playerChar);
        end)
    end)

    describe("When Player is o.", function()
        local expectedPlayerChar = _x;
        it("Expects Game will select Player as o.", function()
            local game = Game(logger, board, expectedPlayerChar);
            assert.same(expectedPlayerChar, game.playerChar);
        end)
    end)
end)