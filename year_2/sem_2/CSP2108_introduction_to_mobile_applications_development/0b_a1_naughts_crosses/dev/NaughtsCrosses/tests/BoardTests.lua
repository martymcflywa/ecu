require "busted.runner"();
require("tests.TestGlobals");

describe("BoardTests.", function()
    local logger;
    local board;

    setup(function()
        logger = Logger(_logMode);
        board = Board(logger, _d.newGroup());
    end)

    after_each(function()
        board:setup();
        board.winner = _chars["empty"];
    end)

    describe("Detect win for x.", function()
        
        local expectedWinner = 1;
        
        it("Expects win for top horizontal.", function()
            board.scores = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for mid horizontal.", function()
            board.scores = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for bottom horizontal.", function()
            board.scores = {
                {0, 0, 0},
                {0, 0, 0},
                {1, 1, 1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left vertical.", function()
            board.scores = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for mid vertical.", function()
            board.scores = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for right vertical.", function()
            board.scores = {
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left-right-down diagonal.", function()
            board.scores = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left-right-up diagonal.", function()
            board.scores = {
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)
    end)

    describe("Detect win for o.", function()
        
        local expectedWinner = -1;
        
        it("Expects win for top horizontal.", function()
            board.scores = {
                {-1, -1, -1},
                { 0,  0,  0},
                { 0,  0,  0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for mid horizontal.", function()
            board.scores = {
                { 0,  0,  0},
                {-1, -1, -1},
                { 0,  0,  0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for bottom horizontal.", function()
            board.scores = {
                { 0,  0,  0},
                { 0,  0,  0},
                {-1, -1, -1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left vertical.", function()
            board.scores = {
                {-1,  0,  0},
                {-1,  0,  0},
                {-1,  0,  0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for mid vertical.", function()
            board.scores = {
                { 0, -1,  0},
                { 0, -1,  0},
                { 0, -1,  0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for right vertical.", function()
            board.scores = {
                { 0,  0, -1},
                { 0,  0, -1},
                { 0,  0, -1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left-right-down diagonal.", function()
            board.scores = {
                {-1,  0,  0},
                { 0, -1,  0},
                { 0,  0, -1}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)

        it("Expects win for left-right-up diagonal.", function()
            board.scores = {
                { 0,  0, -1},
                { 0, -1,  0},
                {-1,  0,  0}
            };
            assert.is_true(board:isWin());
            assert.same(expectedWinner, board.winner);
        end)
    end)

    describe("Detect tie game.", function()
        
        local expectedWinner = 0;

        it("Expects tie game.", function()
            board.scores = {
                { 1,  1, -1},
                {-1, -1,  1},
                { 1,  1, -1}
            };
            assert.is_true(board:isGameOver());
            assert.same(expectedWinner, board.winner);
        end)
    end)

    --[[
        NOTE: The test x,y coordinates used here are different to in-game,
        as the stub display object defines a different resolution.
    --]]
    describe("Convert touch coords to Board row,col.", function()
        local event = {};
        setup(function()
            board:setup();
            event.x = 0;
            event.y = 0;
        end)

        it("Expects touch at row=1, col=1.", function()
            local expectedRow = 1;
            local expectedCol = 1;
            event.x = 129;
            event.y = 129;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=1, col=2.", function()
            local expectedRow = 1;
            local expectedCol = 2;
            event.x = 257;
            event.y = 129;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=1, col=3.", function()
            local expectedRow = 1;
            local expectedCol = 3;
            event.x = 385;
            event.y = 129;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=2, col=1.", function()
            local expectedRow = 2;
            local expectedCol = 1;
            event.x = 129;
            event.y = 384;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=2, col=2.", function()
            local expectedRow = 2;
            local expectedCol = 2;
            event.x = 257;
            event.y = 384;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=2, col=3.", function()
            local expectedRow = 2;
            local expectedCol = 3;
            event.x = 385;
            event.y = 384;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=3, col=1.", function()
            local expectedRow = 3;
            local expectedCol = 1;
            event.x = 129;
            event.y = 639;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=3, col=2.", function()
            local expectedRow = 3;
            local expectedCol = 2;
            event.x = 257;
            event.y = 639;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)

        it("Expects touch at row=3, col=3.", function()
            local expectedRow = 3;
            local expectedCol = 3;
            event.x = 385;
            event.y = 639;
            local actualRow, actualCol = board:getGridFromTouch(event);
            assert.same(expectedRow, actualRow);
            assert.same(expectedCol, actualCol);
        end)
    end)
end)