# Display groups, scenes and composer

## Overview

- Display groups
- Group transforms
- Scenes
- Composer

# Display groups

- Display objects drawn onto the *stage*
    - Like a large sheet of paper
    - x,y coordinate system
- Can also be drawn as part of a `displayGroup`
    - Like transparent sheets
    - Can be laid on top of the stage
- Each `displayGroup` has own x,y coordinate system
- Whole coordinate system can be moved around within stage coordinate system
- `displayGroup`s can contain other `displayGroups` in a hierarchy
    - Like folders > subfolders
- Can have properties applied to children

# Group transforms

- `displayGroup`s can be transformed
    - Moved
    - Rotated
    - Scaled
- All objects within a `displayGroup` are transformed hierarchically
- Does not play well with physics
    - **Don't mix them!**

## Group transform example 1

``` lua
local myGroup = display.newGroup();
local myBox = display.newRect(100, 100, 80, 80);
myBox:setFillColor(1, 0, 0, 0.8);
myGroup:insert(myBox); -- myBox is now child of myGroup
```

![myGroup on phone](https://snag.gy/sVWxYI.jpg)

![myGroup anchor](https://snag.gy/ulig1m.jpg)

## Group transform example 2

``` lua
myGroup.x = 50;
myGroup.y = 50;

local actualBoxX, actualBoxY = myBox:localToContent(0, 0); -- = 150
print(actualBoxX, actualBoxY); -- = 150
```

![myGroup2 on phone](https://snag.gy/SyxTah.jpg)

![myGroup2 new anchor](https://snag.gy/qSDC87.jpg)

- `myGroup`s `(0, 0)` point has now been moved to `(50, 50)` in content coordinates
- So the red square is now at `(150, 150)` in content coordinates
- But still at `(100, 100)` within `myGroup` coordinates

# Scenes and composer

- `displayGroup`s allow `displayObject`s to be treated en-mass
    - The key mechanism used in `composer` library
- This library allows an app to have different `scene`s for different tasks
    - Using their own `displayObject`s
    - Able to move them on/off the display easily and conveniently

## Using the `composer` library

- Divide app into `scene`s
    - Like screens/windows in desktop app
- Each scene has own `.lua` file
    - Has to have certain structure
- `main.lua` does global init then uses `composer` to *load in* the first scene when the app starts
    - Call `composer.gotoScene()`
    - First scene then takes control
        - Entry point
- Handing control from one scene to another or to switch scenes
    - Call `composer.goToScene()`

## Scene structure

- See [Corona SDK docs template](https://docs.coronalabs.com/api/library/composer/index.html#template)

## Scene lifecycle

![scene lifecycle](https://snag.gy/JpuTZw.jpg)

## Composer variables

- Allows variables to be shared between scenes

``` lua
local backgrounds = {
    -- some collection of bg images
};

-- share collection between scenes, kv pair
composer.setVariable("backgrounds", backgrounds);

-- in next scene
local function makeBackground(group, sceneNumber)
    local backgrounds = composer.getVariable("backgrounds"); -- refer to key
    -- do stuff with backgrounds from previous scene
end
```

## Scene parameters

``` lua
-- main.lua
local options = {
    -- some collection of options
};
composer.gotoScene("gameScene", options);

-- gameScene.lua
function scene:show(event)
    -- references 'options' as .params
    local params = event.params;
end
```