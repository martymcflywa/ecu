# Location

## Overview

- Location awareness
- Location handlers
- Map views
- Networking

# Location awareness

- Refers to devices that can passively or actively determine its location
- A special feature of mobile devices
    - They're mobile
    - Can move place to place
- Would not be significant unless they were aware of their location and use that info

## Examples of mobile apps with location awareness

- Pokemon go
- Tourist guides
- Who's here apps
- Navigation apps

# Location handlers

- One way to make corona apps location aware
- Uses GPS/Wifi, 3G/4G tower locations to estimate location

## Adding a location handler

``` lua
if(system.hasEventSource("location")) then
    Runtime:addEventListener("location", locationHandler);
else
    print("Location events not supported on this platform");
end
```

## Android build settings for location events

``` lua
settings =
{
    android =
    {
        userPermissions =
        {
            -- use GPS
            "android.permission.ACCESS_FINE_LOCATION",
            -- use wifi/cell tower
            "android.permission.ACCESS_COARSE_LOCATION"
        }
    }
};
```

## Example handler

``` lua
local locationHandler = function(event)
    -- check for error (location services turned off)
    if(event.errorCode) then
        native.showAlert("GPS Location Error", event.errorMessage, {"OK"});
        print("Location error: " .. tostring(event.errorMessage));
    else
        local latitudeText = string.format("%.4f", event.latitude);
        currentLatitude = latitudeText;
        latitude.text = latitudeText;

        local longitudeText = string.format("%.4f", event.longitude);
        currentLongitude = longitudeText;
        longitude.text = longitudeText;

        local altitudeText = string.format("%.4f", event.altitude);
        currentAltitude = altitudeText;
        altitude.text = altitudeText;

        local speedText = string.format("%.4f", event.speed);
        speed.text = speedText;

        local directionText = string.format("%.4f", event.direction);
        direction.text = directionText;

        -- time == unix time
        local timeText = string.format("%.0f", event.time);
        time.text = timeText;
    end
end
```

# `mapView`

``` lua
-- needs to be run on a device
local myMap = native.newMapView(20, 20, 280, 360);
myMap.x = display.contentCenterX;
myMap.y = display.contentCenterY;

-- display map as vector streets, can also use satellite, hybrid
myMap.mapType = "standard";

-- init map to location
myMap:setCenter(-31.752946, 155.773322);
```

## Android build settings for `mapView`

``` lua
settings =
{
    android =
    {
        userPermissions =
        {
            -- use GPS
            "android.permission.ACCESS_FINE_LOCATION",
            -- use wifi/cell tower
            "android.permission.ACCESS_COARSE_LOCATION"
        },
        usesFeatures =
        {
            -- If you set permissions ACCESS_FINE/COURSE_LOCATION,
            -- you may want to set up your app to not require location services as follows.
            -- Otherwise, devices that do not have loc services will be unable to purchase
            -- this app
            {name = "android.hardware.location", required = false},
            {name = "android.hardware.location.gps", required = false},
            {name = "android.hardware.location.network", required = false}
        }
    }
};
```

## `mapView` events/listeners

- `marker` listener
    - Place markers, listens for user tapping on them
- `mapAddress` listener
    - Convert location description to lat/long
    - Convert lat/long to description
- `location` listener
    - Listen for user touches
- Can also get current estimated location

### `markerListener`

``` lua
local function markerListener(event)
    -- event has fields:
        -- markerID
        -- latitude
        -- longitude
end

local markerOptions = {
    title = "Name of marker",
    subtitle = "Longer description",
    listener = markerListener,
    imageFile = "someImage.png"
};

myMap:addMarker(-33.33333, 555.55555, markerOptions);
```

### `locationHandler`

``` lua
local function locationHandler(event)
    if(event.isError) then
        print("Map error: " .. event.errorMessage);
    else
        print("The specified string is at: " .. event.latitude .. "," .. event.longitude);
    end
end

myMap:requestLocation("ECU Joondalup", locationHandler);
```

### `mapAddressHandler`

``` lua
local function mapAddressHandler(event)
    if(event.isError) then
        -- handle error, print message
    else
        print("Nearest location: " .. event.city .. ", " .. event.country);
    end
end

myMap:nearestAddress(-31.744790, 115.767446, mapAddressHandler);
```

### `mapLocationListener`

``` lua
local function mapLocationListener(event)
    print("The tapped location is in: " .. event.latitude .. ", " .. event.longitude);
end

myMap:addEventListener("mapLocation", mapLocationListener);
```

### `userLocationListener`

``` lua
local attempts = 0;

local function userLocationListener(event)
    local currentLocation = myMap:getUserLocation();

    if(currentLocation.errorCode or (currentLocation.latitude == 0 and currentLocation.longitude == 0)) then
        print(currentLocation.errorMessage);
        attempts = attempts + 1;
        if(attempts > 10) then
            native.showAlert("No GPS signal", "Can't sync with GPS.", {"OK"});
        else
            timer.performWithDelay(1000, userLocationListener);
        end
    else
        print("Current location: " .. currentLocation.latitude .. currentLocation.longitude);
    end
end

attempts = 0;
userLocationListener();
attempts = 0;
timer.performWithDelay(5000, userLocationListener);
```