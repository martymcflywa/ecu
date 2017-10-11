local Persist = class("Persist");

function Persist:init()
    self.filename = "scores.json";
    self.path = system.ResourceDirectory;
    self.filepath = system.pathForFile(self.filename, self.path);

    if(not self.filepath) then
        self:newFile(self.filepath);
        self.filepath = system.pathForFile(self.filename, self.path);
    end
end

function Persist:loadScores()
    local scores = self:read(self.filepath);
    if(scores) then
        return scores;
    else
        return self:resetScores();
    end
end

function Persist:saveScores(scores)
    self:write(self.filepath, scores);
end

function Persist:resetScores()
    local scores = {
        win = 0;
        loss = 0;
        draw = 0;
    };
    self:write(self.filepath, scores);
    return scores;
end

function Persist:read(filepath)
    local file, errorMessage = io.open(filepath, "r");
    local object = nil;
    if(file) then
        logger:debug(self.name, "read()", string.format("Reading file %s", filepath));
        local deserialized = file:read("*a");
        object = _json.decode(deserialized);
    else
        logger:debug(self.name, "read()", string.format("Error reading file %s: %s", filepath, errorMessage));
    end
    io.close(file);
    file = nil;
    return object;
end

function Persist:newFile(filepath)
    local file, errorMessage = io.open(filepath, "w");
    if(file) then
        logger:debug(self.name, "newFile()", string.format("Creating new file %s", filepath));
        file:write("");
    else
        logger:debug(self.name, "newFile()", string.format("Error creating new file %s: %s", filepath, errorMessage));
    end
    io.close(file);
    file = nil;
end

function Persist:write(filepath, object)
    local file, errorMessage = io.open(filepath, "w");
    local isWrite = false;
    if(file) then
        local serialized = _json.encode(object);
        file:write(serialized);
        isWrite = true;
    else
        logger:debug(self.name, "write()", string.format("Error writing file %s: %s", filepath, errorMessage));
        -- TODO: figure out a way to handle this case gracefully, will need to write file at some point
    end
    io.close(file);
    file = nil;
    return isWrite;
end

return Persist;