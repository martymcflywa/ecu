require "busted.runner"();
require("tests.TestGlobals");

describe("PersistTests.", function()
    local logger;
    local persist;

    before_each(function()
        logger = Logger(_logMode);
        persist = Persist(logger);

        system.ResourceDirectory = "/mocked/path";
        when(system.fileForPath(persist.filename, system.ResourceDirectory))
            .thenAnswer(system.ResourceDirectory .. "/" .. persist.filename);
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
                when(io.open(system.ResourceDirectory, "r")).thenAnswer(io);
                when(io.read("*a")).thenAnswer(expectedJson);
                
                persist:loadScores();
                assert.same("/mocked/path/scores.json", persist.filepath);
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