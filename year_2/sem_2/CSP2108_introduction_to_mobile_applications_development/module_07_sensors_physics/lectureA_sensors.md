# Sensors

## Mobile device sensors

- Sensors in bold supported by Corona
    - Provided device has them
- **Camera**
    - Captures still/video images
- **Microphone**
    - Records sound
- **GPS**
    - Location
- **Touch screen**
    - Can be pressure sensitive
- **Accelerometer**
    - Gravity and motion
- Proximity
    - Detects nearby objects
- **Magnetometer / compass**
    - Measures magnetic fields
- Light
    - Detects level of ambient lighting
- Fingerprint
- Barometer
- Thermometer
- Pedometer
- Heart rate
- **Gyroscope**
    - Measures rotation

## Camera permissions in `build.settings`

``` lua
settings =
{
    android =
    {
        userPermissions =
        {
            "android.permission.CAMERA", -- access to camera
            "android.permission.WRITE_EXTERNAL_STORAGE", -- access to storage
            "android.permission.RECORD_AUDIO" -- access to mic
        },
    },
}
```

## Camera

``` lua
local function onComplete(event)
    local photo = event.target;
    if(photo) then
        -- do stuff if target is photo
    end
end

if(media.hasSource(media.Camera)) then
    media.capturePhoto(
        {listener = onComplete}
    );
else
    native.showAlert("Corona", "This device does not have a camera.", {"OK"});
end
```

- The screenshot below is what happens when code above runs in the simulator
    - The image is added to the display
- Alternatively you can save to file

![camera](https://snag.gy/hLNqG2.jpg)

## Video

- Corona simulator does not support video
- Must test directly on device

``` lua
local onVideoComplete = function(event)
    print("Video session ended.");
end

local function onComplete(event)
    if(event.completed) then
        media.playVideo(
            event.url,
            media.RemoteSource,
            true,
            onVideoComplete
        );
        print(event.duration);
        print(event.fileSize);
    end
end

if(media.hasSource(media.Camera)) then
    media.captureVideo(
        {listener = onComplete}
    );
else
    native.showAlert(
        "Corona", 
        "This device does not have a camera.",
        {"OK"}
    );
end
```

## Audio

``` lua
local filePath = system.pathForFile("recording.aif", system.DocumentsDirectory);
local r = media.newRecording(filePath);
r:startRecording();

local callback = function()
    r:stopRecording();
    print("done.");
end

timer.performWithDelay(3000, callback, 1);
```

## Accelerometer

- Works with `Runtime` object
- Does not work in the simulator
    - Test on device

``` lua
local count = 0;

local function reportAcceleration(event)
    count = count + 1;
    if(count == 100) then
        print(
            event.name,
            event.xGravity,
            event.yGravity,
            event.zGravity
        );
        count = 0;
    end
end

Runtime:addEventListener("accelerometer", reportAcceleration);
```

## Gyroscope

- Does not work in the simulator
    - Test on device

``` lua
-- called when a new gyro measurement is received
local function onGyroDataReceived(event)
    -- calc approx rotation traveled via delta time
    -- rotation rate is in radians per second
    local deltaRadians = event.zRotation * event.deltaTime;
    local deltaDegrees = deltaRadians * (180 / math.pi);
    print("Gyro: deltaZ=" .. deltaDegrees .. " degrees");
end

if(system.hasEventSource("gyroscope")) then
    Runtime:addEventListener("gyroscope", onGyroDataReceived);
else
    native.showAlert("Corona", "This device does not have a gyro.", {"OK"});
end
```

## Orientation

- When user changes between landscape/portrait etc.
- Useful when using accelerometer/gyro
    - Relative to portrait orientation
- Android
    - `left` <--> `right`
    - `portrait` <--> `portraitUpsideDown`
- iOS
    - `faceUp` <--> `faceDown`
- If `build.settings` have only one orientation
    - All changes reported
- Otherwise only for supported orientations

``` lua
local function onOrientationChange(event)
    local currentOrientation = event.type;
    print("Current orientation: " .. currentOrientation);
end

Runtime:addEventListener("orientation", onOrientationChange);
```
    