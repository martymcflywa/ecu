-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- constants define sizes/locations of face parts
local X = display.contentCenterX;
local Y = display.contentCenterY;

local HEAD_SIZE = display.contentWidth * 0.35;
local EYE_OFFSET_X = HEAD_SIZE / 5;
local EYE_OFFSET_Y = HEAD_SIZE / 5;
local MOUTH_OFFSET = HEAD_SIZE / 4;

-- functions to draw face parts

local function drawHead()
    local head = display.newCircle(X, Y, HEAD_SIZE);
    head:setFillColor(1, 0.5, 0.5);
    head:setStrokeColor(0.2, 0.2, 0);
    head.strokeWidth = 3;
    return head;
end

local function drawLeftEye()
    return display.newText(
        "O", 
        X - EYE_OFFSET_X, 
        Y - EYE_OFFSET_Y,
        "Arial",
        20
    );
end

local function drawLeftEyePupil()
    return display.newText(
        "X",
        X - EYE_OFFSET_X,
        Y - EYE_OFFSET_Y,
        "Arial",
        20
    );
end

local function drawRightEye()
    return display.newText(
        "o",
        X + EYE_OFFSET_X,
        Y - EYE_OFFSET_Y,
        "Arial",
        20
    );
end

local function drawRightEyePupil()
    return display.newText(
        "x",
        X + EYE_OFFSET_X,
        Y - EYE_OFFSET_Y,
        "Arial",
        20
    );
end

local function drawNose()
    return display.newText(
        ">",
        X,
        Y,
        "Arial",
        20
    );
end

local function drawMouth()
    return display.newText(
        "~~~",
        X,
        Y + MOUTH_OFFSET,
        "Arial",
        20
    );
end

local function drawFace()
    drawHead();
    leftEye = drawLeftEye();
    leftEyePupil = drawLeftEyePupil();
    rightEye = drawRightEye();
    rightEyePupil = drawRightEyePupil();
    drawNose();
    mouth = drawMouth();
end

drawFace()

local function poke()
    leftEye.text = "X";
    leftEyePupil:removeSelf();
    rightEye.text = "x";
    rightEyePupil:removeSelf();
    display.newText(
        "U",
        X,
        mouth.y + mouth.height,
        "Arial",
        30
    )
end

transition.to(
    leftEye,
    {
        delay = 500,
        time = 1000,
        size = 40
    }
);

transition.to(
    leftEyePupil,
    {
        delay = 500,
        time = 1000,
        size = 40
    }
);

transition.to(
    rightEyePupil,
    {
        delay = 500,
        time = 1000,
        size = 40
    }
);

transition.to(
    rightEye,
    {
        delay = 500,
        time = 1000,
        size = 40,
        onComplete = poke
    }
);