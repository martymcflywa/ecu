require "busted.runner"();
require("tests.TestGlobals");

mock = require("mocks.mockagne");
when = mock.when;
any = mock.any;
verify = mock.verify;

local resourceDirectory = "/mock/path";
local filename = "scores.json";

describe("PersistTests.", function()
    local logger;
    local persist;

    before_each(function()
        -- setup mocks
        io = mock.getMock();
        system = mock.getMock();
        system.ResourceDirectory = resourceDirectory;
        when(system.pathForFile(filename, system.ResourceDirectory))
            .thenAnswer(system.ResourceDirectory .. "/" .. filename);
        
        logger = Logger(_logMode);
        persist = Persist(logger);
    end)

    describe("Loading scores.", function()
        describe("When scores.json exists.", function()
            it("Expects Persist.scores to be deserialized with expected score values.", function()
                
                local expectedJson = '{"win" : 1, "loss" : 1, "draw" : 1}';
                local expectedScores = {
                    win = 1,
                    loss = 1,
                    draw = 1
                };
                
                -- setup mocks
                when(io.open(resourceDirectory, "r")).thenAnswer(io);
                when(io.read(io, "*a")).thenAnswer(expectedJson);

                persist:loadScores();

                assert.same("/mock/path/scores.json", persist.filepath);
                local actualScores = persist.scores;
                assert.same(expectedScores, actualScores);
            end)
        end)

        describe("When scores.json does not exist.", function()
            it("Expects Persist.scores to be initialized with zeros.", function()
                -- add test here
            end)
        end)
    end)

    describe("Saving scores.", function()
        describe("When scores.json is saved successfully.", function()
            it("Expects scores.json to contain expected score values.", function()
                -- add test here
            end)
        end)

        describe("When scores.json is not saved successfully.", function()
            it("Expects scores.json to not exist.", function()
                -- add test here
            end)
        end)
    end)

    describe("Resetting scores.", function()
        it("When scores are reset, scores.json exists and contains zero for all values.", function()
            -- add test here
        end)
    end)
end)