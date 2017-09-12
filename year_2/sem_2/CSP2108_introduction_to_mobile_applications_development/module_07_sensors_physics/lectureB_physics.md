# Physics

## Physics engines

- Is a library that carries out the calculations needed to simulate movement and interaction of objects according to physics laws
- Handles things like
    - Rigid and soft body dynamics
    - Collisions
- See [Physics Setup](https://docs.coronalabs.com/guide/physics/physicsSetup/index.html)

# Box2D

- Physics engine used by Corona
- An open source library often used for games
- Calculates rigid body dynamics
    - Bodies composed of
        - Polygons
        - Circles
    - Joined by joints
    - Includes
        - Gravity
        - Frictions
        - Restitution
            - Bouncing

## Box2D in Corona

- `display` objects in Corona can have physics added
- All objects made physical can then automatically interact / move / collide / bounce off each other
- Uses a coordinate system with
    - `0,0` in top left
    - 1 pixel = 1/30 meter
    - angles in degrees

## Starting and stopping `physics`

``` lua
local physics = require("physics");

-- setup objects and physical properties

-- starts physics system
physics.start();

-- do other things, calls to physics functions

-- suspends physics calculations
physics.pause();
-- resumes physics calculations
physics.start();
-- when done with physics
physics.stop();
```

## `physics` options

### Sleeping

- `physics.start(true)`
    - Prevents objects from "sleeping" when inactive
- Saves CPU
    - But objects don't respond to gravity without collision
- Default
    - `false`
- `object.isSleepingAllowed = false`
    - Prevents object from sleeping

### Gravity

- `x` and `y` components of gravity can be set
- Default
    - (0, 9.8) ms^-2
- `physics.setGravity(x, y)`

### Scale

- `physics.setScale(s)`
- Default
    - 30 : 30 pixels
    - About 1 meter

### Draw mode

- Useful for debugging
- `physics.setDrawMode(m)`
    - `normal`
        - Objects displayed as normal
    - `debug`
        - Object outlines used for collisions are shown instead
    - `hybrid`
        - Both are shown

# Tumble

- See `Tumble.zip`
- Suggest to test on Android device
    - Uses accelerometer

## Features

![tumble](https://snag.gy/MWIX20.jpg)

- There's a square room containing a number of green gems
- At the start they are at the top of the screen and fall under gravity towards the bottom
- They bounce off each other and the walls
- After awhile they stop moving and look like image above
- On a real device you can tilt device to change direction of gravity
    - Makes the gems fall and bounce again

## `main()`

``` lua
function main()
    setupEvents()
    setupPhysics()
    createTumbler()
    createGems()
end
```

- Runs when the app starts
- It sets up
    - Accelerometer listener
    - Inits physics engine
    - Create/insert room walls
    - Create/insert gems

## `setupEvents()`

``` lua
function setupEvents()
    if system.hasEventSource("accelerometer") then
        Runtime:addEventListener("accelerometer", onAccelerometerDataReceived);
    end
end

function onAccelerometerDataReceived(event)
    physics.setGravity(gravity * event.xGravity, -gravity * event.yGravity);
end
```

- Sets up gravity to match up-down orientation of device
    - Relative to portrait layout

## `setupPhysics()`

``` lua
function setupPhysics()
    physics.start()
    physics.setGravity(0, gravity)
end
```

- The physics engine is set up here
- `gravity` is a constant defined earlier
    - More than default
    - Makes things fall faster than normal

## `createTumbler()`

``` lua
function createTumbler()
    tumbler = display.newGroup()
    tumbler.x = (display.contentWidth - roomSize) / 2
    tumbler.y = (display.contentHeight - roomSize) / 2
    local wallThickness = 10

    -- left wall
    local wall = display.newRect(0, 0, wallThickness, roomSize)
    wall.anchorX = 0
    wall.anchorY = 0
    wall.type = "wall"
    tumbler:insert(wall)

    -- each wall is created as a display object
    physics.addBody(
        -- then added to physics with addBody
        wall,
        -- as static body type
        "static",
        -- and has own friction and elasticity properties
        {
            friction = roomFriction,
            bounce = roomBounce
        }
    )
    -- ...
end
```

## Making objects physical with `properties`

### `addBody` properties

- `physics.addBody(object, {properties})`
- `density`
    - Water = `1.0`
    - Mass = `area` * `density`
- `friction`
    - `0` = none
    - `1` = lots
- `bounce`
    - How much energy is retained after collision
    - `1.0` = no loss
    - `>0.3` = bouncy

### `bodyType`s

- `"dynamic"`
    - Full physics
    - Includes gravity, collisions
- `"static"`
    - No velocity
- `"kinematic"`
    - Has velocity but no gravity

### Bounding box

- Using `physics.addBody()` adds a rectangle bounding box around the object used for collisions
- This can be changed by
    - `radius` property
        - Creates a circular body
    - Defining a polygon and using it as the `shape` property
        - Can define convex polygon bodies
    - See [docs](https://docs.coronalabs.com/guide/physics/physicsBodies/index.html)

## `createGems()`

``` lua
function createGems()
    for gemCount = 1, numberOfGems do
        local gem = display.newCircle(
            roomSize / 2 + math.random(-1, 1),
            roomSize / 2,
            gemSize
        )
        -- stop gems from falling asleep
        gem.isSleepingAllowed = false
        gem:setFillColor(0, 255, 0, 255)
        gem.type = "gem"
        tumbler.insert(gem)
        physics.addBody(
            gem,
            "dynamic",
            {
                density = gemDensity,
                friction = gemFriction,
                bounce = gemBounce,
                -- make body circle
                radius = gemSize
            }
        )
    end
end
```

## Collisions

### Simple local

``` lua
-- has self param, table listener
local function onLocalCollision(self, event)
    if(event.phase == "began") then
        print(self.type .. ": collision began with " .. event.other.type)
    elseif(event.phase == "ended") then
        print(self.type .. ": collision ended with " .. event.other.type)
    end
end

-- adding to objects

-- some function body
wall.collision = onLocalCollision
wall:addEventListener("collision")
tumber:insert(wall)
```

### Simple global

``` lua
-- create global event listener,
-- no self param
-- object1 and object2 can be in any order
local function onGlobalCollision(event)
    if(event.phase == "began") then
        print("began: " .. event.object1.type .. " and " .. event.object2.type)
    elseif(event.phase == "ended") then
        print("ended: " .. event.object1.type .. " and " .. event.object2.type)
    end
end

local function setupEvents()
    if system.hasEventSource("accelerometer") then
        Runtime:addEventListener("accelerometer", onAccelerometerDataReceived)
    end
    Runtime:addEventListener("collision", onGlobalCollision)
end
```

### Collisions can be complicated

- See docs re [physics](https://docs.coronalabs.com/api/library/physics/index.html), [collision detection](https://docs.coronalabs.com/guide/physics/collisionDetection/index.html)
- Pre/post collision events can be used to
    - Control collisions
    - Get more info
        - Forces
- Filtering can be done to control which collisions are reported

## Sensors

- Objects can be set up as **sensors**
    - So they don't interact with other objects
    - Collision events are generated when other objects pass through them

``` lua
physics.addBody(object, "static", {isSensor = true});
```

## Controlling bodies

- Some methods to manipulate bodies
- Don't use these in a collision listener
    - Or use a timer delay

``` lua
-- x,y pixels per second
object.setLinearVelocity(2, 4);
-- push the object, if applied off center, object will rotate
object.applyForce(500, 2000, object.x, object.y);
-- similar but gives a one off shove
object.applyLinearImpulse(60, 20, object.x, object.y);
-- applies a rotational force
object.applyTorque(2);
```

## More

- Jointed objects etc.
- See docs