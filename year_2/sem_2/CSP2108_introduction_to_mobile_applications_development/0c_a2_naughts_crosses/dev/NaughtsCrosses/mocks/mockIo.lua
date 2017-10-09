local io = {};

io.open = function(filepath, mode)
    return self;
end

io.close = function(file)

end

io.read = function(self, mode)
    return "mock file content";
end

return io;