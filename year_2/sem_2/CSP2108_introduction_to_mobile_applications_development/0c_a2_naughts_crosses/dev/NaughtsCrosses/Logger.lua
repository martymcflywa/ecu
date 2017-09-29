Logger = class("Logger");

function Logger:init(level)
    self.levels = {
        info = 1,
        debug = 2
    };
    self.level = self.levels[level];
end

function Logger:info(class, method, message)
    if(self.level >= self.levels["info"]) then
        print(string.format("[INFO] %s#%s: %s", class, method, message));
    end
end

function Logger:debug(class, method, message)
    if(self.level >= self.levels["debug"]) then
        print(string.format("[DEBUG] %s#%s: %s", class, method, message));
    end
end

-- ignore logging level, just print it
function Logger:log(class, method, message)
    print(string.format("[LOG] %s#%s: %s", class, method, message));
end

return Logger;