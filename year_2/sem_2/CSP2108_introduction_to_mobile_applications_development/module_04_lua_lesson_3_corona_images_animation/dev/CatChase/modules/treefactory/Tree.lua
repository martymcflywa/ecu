local Tree = class();
Tree.__name = "Tree";

function Tree:__init(filename, scale, anchorY, x, y, dx)
    self = display.newImage(filename);
    self.xScale = scale;
    self.yScale = scale;
    self.anchorY = anchorY;
    self.x = x;
    self.y = y;
    self.dx = dx;
    return self;
end

function Tree:translate(x, y)
    self:translate(x, y)
end

return Tree;