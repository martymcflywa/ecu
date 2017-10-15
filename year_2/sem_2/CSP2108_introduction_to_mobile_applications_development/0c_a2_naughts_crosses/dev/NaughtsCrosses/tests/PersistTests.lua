require "busted.runner"();
require("tests.TestGlobals");

mock = require("mocks.mockagne");
when = mock.when;
any = mock.any;
verify = mock.verify;
verifyNoCall = mock.verify_no_call

local documentsDirectory = "/mock/path";
local filename = "score.json";

describe("PersistTests.", function()
    local logger;
    local persist;

    before_each(function()
        -- global mocks
        _G.io = mock.getMock();
        _G.system = mock.getMock();
        _G._json = mock.getMock();
        _G.system.DocumentsDirectory = documentsDirectory;
        when(_G.system.pathForFile(filename, _G.system.DocumentsDirectory))
            .thenAnswer(system.DocumentsDirectory .. "/" .. filename);
        -- reset logger and persist for every test
        logger = Logger(_logMode);
        persist = Persist(logger);
    end)

    describe("Loading scores.", function()
        it("Expects Persist.scores to be deserialized with expected score values scores.json exists.", function()
            -- setup expected
            local expectedJson = '{"win":1,"loss":1,"draw":1}';
            local expectedScores = {
                win = 1,
                loss = 1,
                draw = 1
            };
            -- setup mock responses
            when(_G.io.open(_G.system.pathForFile(filename, _G.system.DocumentsDirectory), "r")).thenAnswer(_G.io);
            when(_G.io.read(_G.io, "*a")).thenAnswer(expectedJson);
            when(_G._json.decode(expectedJson)).thenAnswer(expectedScores);
            -- assert
            local actualScores = persist:loadScores();
            assert.same(expectedScores, actualScores);
        end)

        it("Expects Persist.scores to be initialized with zeros when scores.json doesn't exist.", function()
            -- setup expected
            local expectedJson = '{"win":0,"loss":0,"draw":0}';
            local expectedScores = {
                win = 0,
                loss = 0,
                draw = 0
            };
            -- setup mock responses
            when(_G.io.open(_G.system.pathForFile(filename, _G.system.DocumentsDirectory), "r")).thenAnswer(_G.io);
            when(_G.io.read(_G.io, "*a")).thenAnswer(expectedJson);
            when(_G._json.decode(expectedJson)).thenAnswer(expectedScores);
            -- assert
            local actualScores = persist:loadScores();
            assert.same(expectedScores, actualScores);
        end)
    end)

    describe("Saving scores.", function()
        it("Expects scores.json to contain expected score values when scores.json is saved.", function()
            -- add test here
        end)

        it("Expects scores.json to be initialized with zeros when scores.json is not saved.", function()
            -- add test here
        end)
    end)

    describe("Resetting scores.", function()
        it("When scores are reset, scores.json exists and contains zero for all values.", function()
            -- add test here
        end)
    end)
end)