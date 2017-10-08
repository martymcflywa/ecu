local Persist = class("Persist");

local filename = "scores.json";
local path = system.ResourceDirectory;

function Persist:init(logger)
    self.logger = logger;
    self.filepath = system.pathForFile(filename, path);
end

function Persist:loadScores()
    local scores = self:read(self.filepath);
    if(scores) then
        self.scores = scores;
    else
        self:resetScores();
    end
end

function Persist:saveScores(win, loss, draw)
    self.scores.win = self.scores.win + win;
    self.scores.loss = self.scores.loss + loss;
    self.scores.draw = self.scores.draw + draw;
    self.write(self.filepath, self.scores);
end

function Persist:resetScores()
    self.scores = {
        win = 0;
        loss = 0;
        draw = 0;
    };
    self:write(self.filepath, self.scores);
end

function Persist:read(filepath)
    local file, error = io.open(filepath, "r");
    local object = nil;
    if(file) then
        self.logger:debug(self.name, "read()", string.format("Reading file %s", filepath));
        local deserialized = file.read("*a");
        object = _json.decode(deserialized);
    else
        self.logger:debug(self.name, "read()", string.format("Error reading file %s: %s", filepath, error));
    end
    io.close(file);
    return object;
end

function Persist:write(filepath, object)
    local file, error = io.open(filepath, "w");
    local isWrite = false;
    if(file) then
        local serialized = _json.encode(object);
        file:write(serialized);
        isWrite = true;
    else
        self.logger:debug(self.name, "write()", string.format("Error writing file %s: %s", filepath, error));
        -- TODO: figure out a way to handle this case gracefully, will need to write file at some point
    end
    io.close(file);
    return isWrite;
end

return Persist;