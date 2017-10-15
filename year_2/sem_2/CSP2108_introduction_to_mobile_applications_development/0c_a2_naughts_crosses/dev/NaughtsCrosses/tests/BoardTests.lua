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

    describe("Turn log.", function()
        it("Expects turn to be pushed to TurnLog.", function()
            local expected = {
                row = 1,
                col = 1,
                char = _x,
                color = _colors["red"],
                textOptions = {},
                isPlayer = true
            };
            board:pushTurn(
                expected.row,
                expected.col,
                expected.char,
                expected.color,
                expected.textOptions,
                expected.isPlayer);
            local actual = board.turnLog:peek();
            assert.same(expected, actual);
        end)

        it("Expects last player turn to be popped from TurnLog.", function()
            local expectedRemainingTurns = 2;
            local playerTurn1 = {
                row = 1,
                col = 1,
                char = _x,
                color = _colors["red"],
                textOptions = {},
                isPlayer = true   
            };
            local aiTurn1 = {
                row = 1,
                col = 2,
                char = _o,
                color = _colors["green"],
                textOptions = {},
                isPlayer = false
            };
            local playerTurn2 = {
                row = 1,
                col = 3,
                char = _x,
                color = _colors["red"],
                textOptions = {},
                isPlayer = true   
            };
            board:pushTurn(
                playerTurn1.row,
                playerTurn1.col,
                playerTurn1.char,
                playerTurn1.color,
                playerTurn1.textOptions,
                playerTurn1.isPlayer);
            board:pushTurn(
                aiTurn1.row,
                aiTurn1.col,
                aiTurn1.char,
                aiTurn1.color,
                aiTurn1.textOptions,
                aiTurn1.isPlayer);
            board:pushTurn(
                playerTurn2.row,
                playerTurn2.col,
                playerTurn2.char,
                playerTurn2.color,
                playerTurn2.textOptions,
                playerTurn2.isPlayer);
            board:popTurn();
            local aiTurnActual = {
                row = board.turnLog:peek().row,
                col = board.turnLog:peek().col,
                char = board.turnLog:peek().char,
                color = board.turnLog:peek().color,
                textOptions = board.turnLog:peek().textOptions,
                isPlayer = board.turnLog:peek().isPlayer
            };
            assert.same(aiTurn1, aiTurnActual);
        end)

        it("Expects last ai and player turn to be popped from TurnLog.", function()
            local expectedRemainingTurns = 1;
            local aiTurn1 = {
                row = 1,
                col = 1,
                char = _x,
                color = _colors["red"],
                textOptions = {},
                isPlayer = false   
            };
            local playerTurn1 = {
                row = 1,
                col = 2,
                char = _o,
                color = _colors["green"],
                textOptions = {},
                isPlayer = true
            };
            local aiTurn2 = {
                row = 1,
                col = 3,
                char = _x,
                color = _colors["red"],
                textOptions = {},
                isPlayer = false   
            };
            board:pushTurn(
                aiTurn1.row,
                aiTurn1.col,
                aiTurn1.char,
                aiTurn1.color,
                aiTurn1.textOptions,
                aiTurn1.isPlayer);
            board:pushTurn(
                playerTurn1.row,
                playerTurn1.col,
                playerTurn1.char,
                playerTurn1.color,
                playerTurn1.textOptions,
                playerTurn1.isPlayer);
            board:pushTurn(
                aiTurn2.row,
                aiTurn2.col,
                aiTurn2.char,
                aiTurn2.color,
                aiTurn2.textOptions,
                aiTurn2.isPlayer);
            board:popTurn();
            local actual = board.turnLog:peek();
            local aiTurnActual = {
                row = actual.row,
                col = actual.col,
                char = actual.char,
                color = actual.color,
                textOptions = actual.textOptions,
                isPlayer = actual.isPlayer
            };
            assert.same(aiTurn1, aiTurnActual);
        end)
    end)

    describe("Player undo.", function()
        
    end)
end)