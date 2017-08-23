# Lab: Animation with image sheets

- See [JungleScene](dev/JungleScene)

## Quiz

1. What does `display.setStatusBar(display.HiddenStatusBar)` do?
    - Hides the device status bar
2. What is the size of this image and where is it positioned on screen?
    - `local sky = display.newImage("sky.jpg", centerX, centerY);`
        - Size: original image size
        - Position: center of content window
3. See [code 1:](#code-1)
    - What does the following lines do?
        - Sets `x` and `y` to 70%
        - Sets `y` anchor to `1`, bottom of image
            - `y` position relative to bottom of tree
        - Sets `x` position to `20`, sets `y` position to `280`
            - `y` positioned to ground
        - Sets **speed**, how many pixels to move each frame on `x` axis
            - `0.1` px per frame
4. See [code 2:](#code-2)
    - What will be the size in pixels of the cat?
        - Depends on device resolution and scaling method
        - If device is 480 x 320
            - Size will be 50% of original image size
    - What is the name of the sequence that will play when `play()` is called?
        - `cat`
5. `ground:setFillColor(0x31 / 255, 0x5a / 255, 0x18 / 255);`
    - What are the rgb values above?
        - R = 49 / 255 = 0.19215686274
        - G = 90 / 255 = 0.35294117647
        - B = 24 / 255 = 0.09411764705
6. `local tPrevious = system.getTimer();`
    - What does `system.getTimer()` return?
        - [`system.getTimer()`](https://docs.coronalabs.com/api/library/system/getTimer.html)
        - Returns time in ms since app launch
        - May return microseconds if supported by hardware
7. See [code 3:](#code-3) `function move()`
    - After the function, `Runtime:addEventListener("enterFrame", move)`
    - `move` is called at every `"enterFrame"` event
        - Timing is defined by timing of the sequences of the two sprites
            - `cat` = `instance1`
            - `man` = `instance2`
8. See `line 120` and `line 121`
    - `local tDelta = event.time - tPrevious`
    - `tPrevious = event.time`
        - Figures out how much time in ms have passed since last frame was drawn
        - This will then be used to work out how far everything should have movied
        - `event.time` is the current time
        - `tPrevious` stores the previous time
9. See [code 4:](#code-4)
    - `if` statements determine whether the grass images need to be rearranged
    - At any time, one of the grass images will be on the left of the screen
        - The other will be on the right
        - Gives the impression of a single image continuously moving right to left
            - And trees moving with them
    - How does the `if` statements move the grass?
        - When the right edge position of each image is less than zero
            - The image is moved on x axis by 480 * 2
10. See [code 5:](#code-5)
    - `for` loop does a similar thing to all trees
    - Moves them right to left
    - Shifts from left edge to right edge to keep cycling forever
    - How many times will the loop execute for each frame?
        - Length of `tree` array

### code 1

``` lua
tree[1] = display.newImage("Palm-arecaceae.png");
tree[1].xScale = 0.7;
tree[1].yScale = 0.7;
tree[1].anchorY = BOTTOM_REF;
tree[1].x = 20;
tree[1].y = baseline;
tree[1].dx = 0.1;
```

### code 2

``` lua
-- an image sheet with a cat
local sheet1 = graphics.newImageSheet(
    "runningcat.png",
    {
        width = 512, 
        height = 256,
        numFrames = 8
    });

-- play 8 frames every 1000 ms
local instance1 = display.newSprite(
    sheet1, 
    {
        name = "cat",
        start = 1,
        count = 8,
        time = 1000
    });
instance1.x = display.contentWidth / 4 + 40;
instance1.y = baseline - 75;
instance1.xScale = 0.5;
instance1.yScale = 0.5;
instance1:play();
```

### code 3

``` lua
local function move(event)
	local tDelta = event.time - tPrevious;
	tPrevious = event.time;

	local xOffset = 0.2 * tDelta;

	grass.x = grass.x - xOffset;
	grass2.x = grass2.x - xOffset;
	
	if (grass.x + grass.contentWidth) < 0 then
		grass:translate(480 * 2, 0);
	end
	if (grass2.x + grass2.contentWidth) < 0 then
		grass2:translate(480 * 2, 0);
	end
	
	local i
	for i = 1, #tree, 1 do
		tree[i].x = tree[i].x - tree[i].dx * tDelta * 0.2;
		if (tree[i].x + tree[i].contentWidth) < 0 then
			tree[i]:translate(480 + tree[i].contentWidth * 2, 0);
		end
	end
end
```

### code 4

``` lua
if (grass.x + grass.contentWidth) < 0 then
    grass:translate(480 * 2, 0);
end
if (grass2.x + grass2.contentWidth) < 0 then
    grass2:translate(480 * 2, 0);
end
```

### code 5

``` lua
local i
for i = 1, #tree, 1 do
    tree[i].x = tree[i].x - tree[i].dx * tDelta * 0.2;
    if (tree[i].x + tree[i].contentWidth) < 0 then
        tree[i]:translate(480 + tree[i].contentWidth * 2, 0);
    end
end
```