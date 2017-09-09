# Interaction

## Overview

- Events and listeners
- `widget`s
- `native` library
- Audio

# Events and listeners

- User interaction in Corona uses *listeners*
- UI items can register listeners
    - ie. Button object has registered listener
    - They are notified when *events* occur
        - Dispatches listener when user taps the button

## Event listener

- Attach listener to object

``` lua
object:addEventListener(eventName, listener);
```

- `object`
    - The thing of interest
- `eventName`
    - The name of the event
- `listener`
    - The function to be dispatched when event occurs

## Table listener

- When the event occurs, the function or table is provided with a table object containing info about the event
- Listener method name should match event name

## Removing event listeners

``` lua
object:removeEventListener(eventName, listener);
```

## Runtime events

- `system`
    - Properties
        - `system.type`
- `enterFrame`
    - Called for each frame
    - 30 times per second
- `tap`
    - When user touches display
    - Properties
        - `tap.x`
        - `tap.y`
        - `tap.xStart`
        - `tap.yStart`
- `touch`
    - When user touches display
    - Properties
        - `touch.phase`
            - `began`
            - `moved`
            - `ended`
            - `cancelled`
- `accelorometer`
    - If exists on device
- `gyroscope`
    - If exists on device
- `collision`
    - Part of physics engine

``` lua
local function onSystemEvent(event)
    local eventType = event.type;
    if(eventType == "applicationStart") then
        -- do stuff when app is launched,
        -- and all code in main.lua is executed
    end
    if(eventType == "applicationExit") then
        -- do stuff when user or OS task manager quits app
    end
    if(eventType == "applicationSuspended") then
        -- do stuff when device suspends app
        -- ie. during phone call, or switch to another app
    end
    if(eventType == "applicationResume") then
        -- do stuff when app resumes from suspend
    end
    if(eventType == "applicationOpen") then
        -- do stuff when app is asked to open a url resource
        -- Android and iOS only
    end
end
Runtime:addEventListener("system", onSystemEvent);
```

- What is the object that the listener is attached to?
    - `Runtime`
- What is the event name?
    - `system`
- What is the listener? Is it a function or table?
    - `onSystemEvent`, a function

### Another `Runtime` example

``` lua
local function onTouch(event)
    print("Touch event : " .. event.phase);
end
Runtime:addEventListener("touch", onTouch);

local function onTap(event)
    print("Tap event : " .. event.x .. ", " .. event.y);
end
Runtime:addEventListener("tap", onTap);
```

## Attaching a function listener to a button

``` lua
local function myTouchListener(event)
    if(event.phase == "ended") then
        print("Touch button x pos : " .. event.x);
        print("Touch button y pos : " .. event.y);
    end
end
local myButton = display.newRect(100, 100, 200, 50);
myButton:addEventListener("touch", myTouchListener);
```

- Other display objects can have a listener attached for touch/tap events

## Attaching a table listener

``` lua
local tableListener = {};
-- method name should match event "touch"
function tableListener:touch(event)
    if(event.phase == "ended") then
        print("Touch button x pos : " .. event.x);
        print("Touch button y pos : " .. event.y);
    end
end
-- method name should match event "tap"
function tableListener:tap(event)
    print("Tap button");
end

local button = display.newRect(100, 200, 200, 50);
button:addEventListener("touch", tableListener);
button:addEventListener("tap", tableListener);
```

# Widgets

- Although you can make your own UI components using `display` objects, the `widget` library provides premade ones
    - Button
    - Picker wheel
    - Progress view
    - Segmented control
    - Slider
    - Spinner
    - Stepper
    - Switch
    - Tab bar
    - Table view

## Widget button

![widget button](https://snag.gy/sfGZiD.jpg)

``` lua
local widget = require("widget");

local function handle(event)
    if(event.phase == "ended") then
        -- do stuff
    end
end

local button = widget.newButton({
    left = 100,
    top = 200,
    id = "button",
    label = "My Button",
    onEvent = handle
    -- also has onPress/onRelease property
    -- no need to check phase
});
```

- Has fancier styles, see [docs](https://docs.coronalabs.com/api/library/widget/newButton.html)

## Widget button using a shape

![widget button using a shape](https://snag.gy/3PdZh4.jpg)

``` lua
local function handle(event)
    -- do stuff when button released
end

local button = widget.newButton({
    label = "Shape!",
    onRelease = event,
    emboss = false,
    -- rounded rectangle properties
    shape = "roundedRect",
    width = 200,
    height = 40,
    cornerRadius = 2,
    fillColor = {
        default = {1, 0, 0, 1},
        over = {1, 0.1, 0.7, 0.4}
    },
    strokeColor = {
        default = {1, 0.4, 0, 1},
        over = {0.8, 0.8, 1, 1}
    },
    strokeWidth = 4
})
```

# `native` library

- Can be used to create apps that look more like native apps for each platform
- Do not fully integrate with Corona `display` objects
    - Always appear on top of Corona objects
- Needs testing on each platform
    - Might not behave consistently
- See [docs](https://docs.coronalabs.com/native/)

## `native` example

![native example](https://snag.gy/yForGg.jpg)

``` lua
local d = display;
local cx = d.contentCenterX;
local cy = d.contentCenterY;
local cw = d.contentWidth;
local ch = d.contentHeight;
local texty = cy * 0.5;
local viewy = cy * 1.5;
local viewh = h / 2;

-- enter url here, pops up keyboard
local addressField = native.newTextField(
    cx,
    texty,
    cw,
    40
);
-- display web page here
local webView = native.newWebView(
    cx,
    viewy,
    cw,
    viewh
);
-- listener reports what happens when we try to go to page
local function urlHandler(event)
    if(event.url) then
        -- do stuff if event has url property
    end
    if(event.type) then
        -- do stuff if event has type property
    end
    if(event.errorCode) then
        -- do stuff if event has errorCode property
        native.showAlert(
            "Error!", 
            event.errorMessage, 
            {"OK"}
        );
    end
end

webView:addEventListener("urlRequest", urlHandler);
-- start page
webView:request("http://google.com");

-- listener changes url when user enters a new one
local function setAddress(event)
    if(event.phase == "ended" or event.phase == "submitted") then
        webView:request("http://" .. addressField.text);
    end
end
addressField:addEventListener("userInput", setAddress);
```

# Audio

- The Corona audio library supports sound files and streams

``` lua
audio.loadSound() -- for short, often used sounds
audio.stream() -- for longer tracks, ie. bg music
```

- Based on OpenAL
- 32 channels
- Independent volume control

## Supported audio formats

![audio formats](https://snag.gy/tMfg51.jpg)

- Suggest to use 16bit uncompressed `.wav`
    - Supported on all platforms
- Can use free tools ie. Audacity to convert formats

## Loading and playing a sound

``` lua
local soundEffect = audio.loadSound("chime.wav");
audio.play(soundEffect);
```

- Load a sound or stream
    - Returns an audio handle
- Use the handle to play
- Can specify options
    - Pass parameters to `play()`
- When called without specifying a channel
    - Channel is automatically allocated
    - Channel number returned by `play()`

## Controlling sounds

- Can control
    - All channels at once
    - Specific channel number

``` lua
audio.pause();
audio.pause(channel);
audio.resume();
audio.resume(channel);
audio.rewind();
audio.rewind(channel);
audio.setVolume();
audio.setVolume(channel);
-- etc.
```

## Audio events

- `audio.play()` has an option to provide a listener on completion of the playing of the sound
    - And other options

``` lua
audio.play(tickSound, {onComplete = explode})
-- explode is a listener
```

## Disposing audio

``` lua
audio.stop();
-- or
audio.stop(channel);
audio.dispose(handle);
```

- See [docs](https://docs.coronalabs.com/api/library/audio/index.html)