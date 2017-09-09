# Lua lesson 4

## Overview

- Iterators
- Generic `for`
- Files and lua filesystem
- Data structures

# Iterators

- Is something that lets you iterate over a collection of elements
- One way to do this is use a function that returns another element each time it is called

## `ipairs`

- `pairs()` is a lua iterator that can be used to iterate over an array
- If `a` is an array, then `pairs(a)` returns
    - A function
    - A state variable
    - A control variable
- Each time the function is called passing the state and control variable
    - It returns the next key and value
- The key is then used as the next control variable value

### `pairs()` examples

``` lua
local a = {10, 20, 30};
local iter, s, y = pairs(a);
local x1, y1;

x1, y1 = iter(s, x);
print(x1, y1) -- 1, 10
x = x1; -- x becomes current index

x1, y1 = iter(s, x);
print(x1, y1) -- 2, 20
x = x1;

x1, y1 = iter(s, x);
print(x1, y1) -- 3, 30
x = x1;

x1, y1 = iter(s, x);
print(x1, y1) -- nil, nil reached end of aray
x = x1;
```

``` lua
-- code above could be written like this
do
    local iter, s, x = pairs(a);
    while true do
        local x1, y1 = iter(s, x);
        x = x1;
        if(x == nil) then
            break;
        end
        print(x1, y1);
    end
end
```

``` lua
-- or the shortcut, less verbose method
for x, y in pairs(a) do
    print(x, y);
end
```

## Corona library and iterators

- Iterators are used in Corona libraries
    - Files `io`
    - Filesystem `lfs`
    - Database `sqlite`
    - `string`s

# Files and lua filesystem

## `io` library

- Often want to read/write info to/from files
    - Save game data
    - Save user settings
- Filesystems for mobile os often have limited access from apps
- Corona `io` provides a consistent view
- See https://docs.coronalabs.com/guide/data/readWriteFiles/

## System directories

- `system.ResourceDirectory`
    - Project directory where `main.lua` lives
- `system.DocumentsDirectory`
    - App specific storage that persists between sessions
- `system.TemporaryDirectory`
    - Single session storage
    - Only persists while app is running
- `system.CachesDirectory`
    - Unreliable
    - May survive between sessions

## Locating files

``` lua
system.pathForFile(filename, [,baseDir]);
```

- Returns a path to the file that can be used with `io` functions
- Default dir is `system.ResourcesDirectory`

## Writing to files

``` lua
-- string to write to file
local saveData = "my app state data";
-- path for file to write
local path = system.pathForFile("myFile.txt", system.DocumentsDirectory);

--[[
    io.open() returns a file object and a return string.
    The file will be nil if there is an error.
    "w" is for writing.
--]]

-- open the file handle
local file, errorString = io.open(path, "w");

if(not file) then
    -- error occurred, output the cause
    print("File error: " .. errorString);
else
    -- write to file
    file:write(saveData);
    -- close file handle
    io.close(file);
end
file = nil;

--[[
    Remember to close with io.close() and set file to nil when done.
    Otherwise will cause memory leaks.
--]]
```

## Reading from files

``` lua
-- path for file to read
local path = system.pathForFile("myFile.txt", system.DocumentsDirectory);
-- open file handle
local file, errorString = io.open(path, "r");

if(not file) then
    -- error occurred, output the cause
    print("File error: " .. errorString);
else
    -- read data from file
    -- *a means to read entire file in one go, includes \n
    local contents = file:read("*a");
    print("Contents of " .. path .. "\n" .. contents);
    -- close file handle
    io.close(file);
end
file = nil;
```

## `io` iterators

### Reading a file

``` lua
local path = system.pathForFile("myFile.txt", system.DocumentsDirectory);
-- writing to this file
local file, error = io.open(path, "w");

if(file) then
    -- write to file
    file:write("line1\n");
    file:write("line2");
    io.close(file);
    file = nil;

    -- read it back
    for line in io.lines(path) do -- io.lines() is the iterator
        print(line);
    end
else
    print("File error: " .. error);
end
```

### Traversing a directory

``` lua
local lfs = require("lfs");
-- empty string points to dir
local docPath = system.pathForFile("", system.DocumentsDirectory);
print(docPath);

for file in lfs.dir(docPath) do
    print("Found file: " .. file);
end
```

### Android gotcha

- No physical `system.ResourceDirectory` on Android
- Everything resides in a compressed `.apk`
- Some file types cannot be read directly from it
    - `html`/`htm`
    - `3pg`
    - `m4v`
    - `mp4`
    - `png`
    - `jpg`
    - `ttf`
- See [workaround]
(https://docs.coronalabs.com/guide/data/readWriteFiles/index.html)
- If the file types above need to be copied from core directory to another
    - Must change filename so it can be accessed by file IO API
    - Example
        - To move `cat.png` from resource directory to documents directory
        - Rename `cat.png.txt` then copy
        - Sounds very hacky
    
# Data structures

- Used to perform standard programming tasks
- ie. Stack has operations
    - `push(x)`
        - Put object on top of the stack
    - `pop()`
        - Remove the top object from the stack
- Some programming languages support various data structures
    - Or can be implemented by using pointers/object references etc.
- Lua only has one data structure
    - Tables
- They can be used to simulate other data structures

## Lua array

- Use integers as keys in table
- 2d array is implemented as table of tables

``` lua
-- 2d array
local MAX = 5;
local matrix = {};

for i = 1, MAX do
    matrix[i] = {};
    for j = 1, MAX do
        matrix[i][j] = i * j;
    end
end

for i = 1, MAX do
    local row = "";
    for j = 1, MAX do
        row = row .. matrix[i][j] .. "\t";
    end
    print(row);
end
```

## Lua linked list

``` lua
local list = nil;

list = {
    next = list, 
    value = "milk"
};
list = {
    next = list, 
    value = "rice"
};
list = {
    next = list, 
    value = "carrots"
};

local l = list;
while l do
    print(l.value);
    l = l.next;
end
```

## Lua set

- Set operations
    - `create`
    - `add(x)`
    - `remove(x)`
    - `isMember(x)`
- Use a table
    - Use elements as indices

``` lua
-- create
local set = {};

-- add
set.milk = true;
set.rice = true;
set.carrots = true;

-- remove
set.milk = nil;

-- test
if set.rice then
    print("We have rice");
end
if set.milk then
    print("We have milk");
end

-- use iterator
for x, _ in pairs(set) do
    print("We have " .. x);
end
```