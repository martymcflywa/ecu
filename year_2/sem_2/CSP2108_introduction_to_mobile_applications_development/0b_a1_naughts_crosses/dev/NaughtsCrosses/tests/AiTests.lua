require "busted.runner"();
require("tests.TestGlobals");

describe("AiTests.", function()
    local logger;
    local board;
    local ai;

    setup(function()
        logger = Logger(_logMode);
        board = Board(logger, _d.newGroup());
    end)

    after_each(function()
        -- reset board tables
        board:setup();
    end)

    describe("When Ai is x.", function()
        setup(function()
            ai = Ai(logger, board, _x, _colors["red"]);
        end)

        describe("Ai goes for win.", function()
            it("Expects Ai puts x where it can win.", function()
                board.scores = {
                    {1, 1, 0},
                    {0, 0, 0},
                    {0, 0, 0},
                };
                expected = {
                    {1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for block.", function()
            it("Expects Ai puts x where it needs to block.", function()
                board.scores = {
                    {-1, -1,  0},
                    { 0,  0,  0},
                    { 0,  0,  0}
                };
                expected = {
                    {-1, -1,  1},
                    { 0,  0,  0},
                    { 0,  0,  0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for center.", function()
            it("Expects Ai puts x in center first when can't win or block.", function()
                board.scores = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
                };
                expected = {
                    {0, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for corner.", function()
            it("Expects Ai puts x in corner when can't win, block or put in center.", function()
                board.scores = {
                    {-1,  0,  0},
                    { 0, -1,  0},
                    { 0,  0,  0}
                };
                expected = {
                    {-1,  0,  0},
                    { 0, -1,  0},
                    { 0,  0,  1}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)
    end)

    describe("When Ai is o.", function()
        setup(function()
            ai = Ai(logger, board, _o, _colors["green"]);
        end)

        describe("Ai goes for win.", function()
            it("Expects Ai puts o where it can win.", function()
                board.scores = {
                    {-1, -1,  0},
                    { 0,  0,  0},
                    { 0,  0,  0},
                };
                expected = {
                    {-1, -1, -1},
                    { 0,  0,  0},
                    { 0,  0,  0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for block.", function()
            it("Expects Ai puts o where it needs to block.", function()
                board.scores = {
                    { 1,  1,  0},
                    { 0,  0,  0},
                    { 0,  0,  0}
                };
                expected = {
                    { 1,  1, -1},
                    { 0,  0,  0},
                    { 0,  0,  0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for center.", function()
            it("Expects Ai puts o in center first when can't win or block.", function()
                board.scores = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
                };
                expected = {
                    { 0,  0,  0},
                    { 0, -1,  0},
                    { 0,  0,  0}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)

        describe("Ai goes for corner.", function()
            it("Expects Ai puts o in corner when can't win, block or put in center.", function()
                board.scores = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 0}
                };
                expected = {
                    { 1,  0,  0},
                    { 0,  1,  0},
                    { 0,  0, -1}
                };
                ai:turn(event);
                assert.same(expected, board.scores);
            end)
        end)
    end)
end)