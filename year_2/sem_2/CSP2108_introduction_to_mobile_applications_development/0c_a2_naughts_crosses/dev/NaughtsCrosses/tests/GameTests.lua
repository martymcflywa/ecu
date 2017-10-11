require "busted.runner"();
require("tests.TestGlobals");

describe("GameTests.", function()

    local sceneGroup;

    setup(function()
        sceneGroup = _d.newGroup();
    end)

    describe("When Player is x.", function()
        local expectedPlayerChar = _x;
        it("Expects Game will select Player as x.", function()
            local game = Game(expectedPlayerChar, sceneGroup);
            assert.same(expectedPlayerChar, game.playerChar);
        end)
    end)

    describe("When Player is o.", function()
        local expectedPlayerChar = _x;
        it("Expects Game will select Player as o.", function()
            local game = Game(expectedPlayerChar, sceneGroup);
            assert.same(expectedPlayerChar, game.playerChar);
        end)
    end)
end)