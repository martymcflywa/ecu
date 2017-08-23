# Corona images and groups

## Overview

- Images
- Content scaling
- Configuration files
- Image sheets
- See [Corona API](https://docs.coronalabs.com/api/index.html)
    - `graphics.*`
    - `display.*`

# Images

- Loaded as `display` objects
- `display.newImage`
    - Used to load an image from file
    - Shows image on screen
    - Creates display object
- `display.newImageRect`
    - Similar to `newImage`
    - Different scaling
- Images can be used to fill shapes
- Image sheets can be used to load images for animation

## `display.newImage` vs. `display.newImageRect`

- Both loads images
- `display.newImageRect` works best when using **content scaling**
- Content scaling
    - Way of dealing with different size displays for different devices
    - Easier

# Content scaling

- Corona figures out how to map images to actual device display
    - May be different size and aspect ratio between different devices
- Default Corona Simulator resolution
    - 320 x 480 (iPhone 4 aspect ratio)
- Can be changed by editing `config.lua`

## Setting content area in Corona Simulator

![screen size](https://snag.gy/i6olGX.jpg)

## `config.lua`

``` lua
application =
{
    content =
    {
        width = 320,
        height = 480,
        scale = "letterBox",
        fps = 30,
        -- other settings
    },
    notifications =
    {
        -- other settings
        -- etc.
    }
}
```

- Format
    - Lua tables, ie. `application`
    - Nested
- Has other tables that control behaviour of the app

## `display.newImage*` syntax

``` lua
display.newImage(filename [, x, y]);
display.newImageRect(filename, width, height);
```

- `display.newImage()` parameters
    - `filename`
        - The image file
        - Needs to be in the same folder as `main.lua`
            - Or include relative path to file
    - `[, x, y]`
        - Optional `x, y` coordinates where anchor is placed
        - Default `0, 0`, middle of the image
    - Default size is actual pixel size
- `display.newImageRect()` parameters
    - `filename`
        - Same as above
    - `width, height`
        - Size of the image

## Example

``` lua
local WIDTH = 50;
local HEIGHT = 50;

local small = display.newImage("relative/path/pathSmall.png");
small.width = WIDTH;
small.height = HEIGHT;
small.anchorX = 0;
small.anchorY = 0;
small.x = 10;
small.y = 10;

local smallRect = display.newImageRect("relative/path/Small.png", WIDTH, HEIGHT);
smallRect.anchorX = 0;
smallRect.anchorY = 0;
smallRect.x = 110;
smallRect.y = 210;
```

### Result on different devices

![result](https://snag.gy/vwQmoW.jpg)

## Changing the scaling method

- Mapping to the display depends on
    - Width/height of content area
    - Scaling method
        - See `scale` in `config.lua`
- `letterBox`
    - Default
    - Maintains aspect ratio
    - Fits display
- `zoomEven`
    - Similar but may not fit all on display
- `adaptive`
    - Width/height dynamically determined
    - Not supported on all devices
- `zoomStretch`
    - Content fits whole display screen
    - Aspect ratio not preserved

### `letterBox` vs. `zoomEven`

![letterBox vs. zoomEven](https://snag.gy/8MLEIb.jpg)

### `zoomStretch`

![zoomStretch](https://snag.gy/CoQJYu.jpg)

## Dynamic resolution

- Only used by `display.newImageRect()`
- Can provide multiple versions of image
    - To improve appearance of images on displays with different resolutions
    - Example `small.png`
        - Also has 200x200 version
        - `small@2x.png`
- `config.lua` configured to use both versions

``` lua
application =
{
    content =
    {
        width = 320,
        height = 480,
        scale = "letterBox",
        fps = 30,
        -- other settings
        imageSuffix =
        {
            ["@2x"] = 2,
            -- other suffixes with scales
        },
    }
}
```

- Can provide multiple resolutions
- Specifies naming convention
    - The **suffix**
- Multiplies size of original image
    - In example above, any image files with suffix `@2x` in filename
- Corona finds best match

### Dynamic resolution result

![dynamic resolution](https://snag.gy/PwlvHd.jpg)

# Image sheets

- Handy to have multiple images in one file
    - ie. Multiple frames in an animation
- Read one file
    - Pick parts of image for different images

## Image sheet example

![image sheet](https://snag.gy/uxJQAC.jpg)

- 14 frames
- 110 x 100 px
- Order of frames
    - Starts at top left
    - Left to right and down

## Using image sheets

``` lua
local options =
{
    width = 110,
    height = 100,
    frameCount = 14
}

local sequenceData =
{
    name = "fly",
    start = 1,
    count = 14,
    time = 200,
    loopCount = 0
}

local sheet = graphics.newImageSheet("sprite1.png", options);
local character = display.newSprite(sheet, sequenceData);
character.x = display.contentWidth / 2;
character.y = display.contentHeight / 2;

character:play();
```

### `sequenceData` properties

- `name`
    - Used to identify different sequences
- `start`
    - The frame to start on
- `count`
    - How many frames to use
- `time`
    - Delay between frames
- `loopCount`
    - How many times to repeat the sequence
    - `0` = infinite
- `loopDirection`
    - `forward`
    - `bounce`
- Can contain more than one sequence with different names
- Can be non-consecutive frames

### Complex `sequenceData` example

``` lua
local multiSequenceData =
{
    {
        name = "fly",
        start = 1,
        count = 14,
        time = 200,
        loopCount = 0
    },
    {
        name = "flyFaster",
        frames = { 1, 3, 5, 7, 9, 11, 13 },
        time = 100,
        loopCount = 0
    }
}

local sheet = graphics.newImageSheet("sprite1.png", options);
local character = display.newSprite(sheet, multiSequenceData);
character:setSequence("flyFaster");
character.x = display.contentWidth / 2;
character.y = display.contentHeight / 2;

character:play();
```

# More info

- See Corona API
- [Sprite animation](https://docs.coronalabs.com/guide/media/spriteAnimation/index.html)
- [Image sheets](https://docs.coronalabs.com/guide/media/imageSheets/index.html)