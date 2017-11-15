print("hello world");

-- numeric for loop
for a = 1, 10, 1 do
    print(string.format("for loop: %d", a));
end

-- repeat until (do while)
local repeatArray = {7, 3, 6, 3, 8, 9};
local repeatIndex = 1;
repeat
    print(string.format("repeatUntil: %d", repeatArray[repeatIndex]));
    repeatIndex = repeatIndex + 1;
until not repeatArray[repeatIndex];

-- while
local whileArray = {6, 9, 6, 9, 7};
local whileIndex = 1;
while whileArray[whileIndex] do
    print(string.format("while: %d", whileArray[whileIndex]));
    whileIndex = whileIndex + 1;
end

-- pairs
local countryCities = {
    Australia = "Sydney",
    Philippines = "Manila",
    UnitedStates = "NewYork"
}
for k, v in pairs(countryCities) do
    print(string.format("%s is in %s", v, k));
end

-- ipairs
local ipairArray = {1, 2, 3, 4, 5, 6};
for i, v in ipairs(ipairArray) do
    print(string.format("index=%d value=%d", i, v));
end