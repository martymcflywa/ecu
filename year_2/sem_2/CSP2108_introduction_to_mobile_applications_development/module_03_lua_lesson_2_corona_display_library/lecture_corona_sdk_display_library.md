# Corona SDK display library

## Overview

- Display objects
- Lines
- Shapes
- Polygons
- See https://docs.coronalabs.com/api/index.html

# Display objects

- `display` is one of Corona SDK's libraries
- `display.newText()` creates a display object and returns its reference to the caller
    - The object can then be manipulated
        - ie. Change colour
- Other kinds of display objects can be created/manipulated

## Creating `display` objects

``` lua
-- shape object, appears as a circle
display.newCircle()
-- line object
display.newLine()
-- shape object based on x,y coordinates
display.newPolygon()
-- shape objects, rectangle or rounded rectangle
display.newRect()
display.newRoundedRect()
-- loads image from file as display object
display.newImage()
-- similar to newImage(), handles image scaling differently
display.newImageRect()
```

## `display` object properties

``` lua
alpha -- transparency
anchorX, anchorY -- used for alignment
x, y -- location of anchor point on screen
isVisible -- un/hides object
```

- Many of these can be changed by assigning a new value

## `display` object methods

``` lua
rotate() -- rotates by a number of degrees
scale() -- makes larger or smaller
translate() -- move object around
toFront(), toBack() -- controls z-order, else drawn in creation order
```

## Removing `display` objects

- To preserve memory, remove objects when not needed

``` lua
display.remove(theObject);
theObject = nil;

-- or

theObject:removeSelf();
theObject = nil;
```

## Additional properties and methods

- Specific kinds of `DisplayObject` have extra properties and methods
    - See docs for full list
- `TextObject` have 
    - `text`
    - `setFillColor()`
- `ShapeObject` have 
    - `fill`
    - `stroke`
    - `setStrokeColor`

# Classes and objects

- Lua can simulate object oriented programming
- `DisplayObject` is a Lua class with subclasses
    - `ShapeObject`
    - `TextObject`
    - `EmitterObject`
    - `GroupObject`
    - `LineObject`
    - `SpriteObject`
    - `SnapshotObject`
- All **inherit** properties and methods from `DisplayObject` and add their own

# Quick quiz

``` lua
local halfW = display.contentCenterX;
local halfH = display.contentCenterY;

local vertices = { 
    0, -110, 27, -35, 105, -35, 43, 16, 65, 90, 
    0, 45, -65, 90, -43, 15, -105, -35 -27, -35};

local star = display.newPolygon(
    halfW,
    halfH,
    vertices)

star.fill = { type="image", filename="mountains.png" }
star.strokeWidth = 10
star:setStrokeColor(1, 0, 0)

transition.to(star, {time = 2000, delay = 1000, xScale = 2, yScale = 2})
```

1. What is the `DisplayObject`
    - `star`
    - Also a `ShapeObject`
2. Which of its properties are changed by assignment
    - `star.fill`
    - `star.strokeWidth`
    - `xScale` and `yScale` also modified but within `transition.to()`
3. Which method is called
    - `star:setStrokeColor()`