# Data management

## Overview

- Ways to persist data
- Json
- Sqlite

# Json

- JavaScript Object Notation
- Good for small, simple data storage
- Human readable
- Easy to parse
- Text based
- Similar to lua tables
- Easy to convert between
    - Serialize
    - Deserialize

## Json basics

- Two structures
    - Object
        - Unordered set of key/value pairs
    - Array
        - Ordered collection of values
- Values
    - Strings
        - In double quotes `" "`
    - Numbers
    - Objects
    - Arrays
    - Boolean
    - Null
- Can be nested

## Serialize lua table to json

``` lua
local json = require("json");
local summerOlympics = {
    {year = 1896, city = "Athens", country = "Greece"},
    {year = 1900, city = "Paris", country = "France"},
    {year = 1904, city = "St Louis", country = "USA"}
}
-- converts table to json string
local summerOlympicString = json.encode(summerOlympics);
-- string can then be written to file or sent over network
print(summerOlympicString);
```

## Deserialize json to lua table

``` lua
local path = system.pathForFile("olympicData.json", system.ResourceDirectory);
local file, e = io.open(path, "r");
if(not file) then
    -- print file error
else
    local contents = file:read("*a");
    io.close(file);
    local summerOlympcs, pos, msg = json.decode(contents)
    if(not summerOlympics) then
        -- exception handling
        print("Deserialize failed at " .. tostring(pos) .. ": " .. tostring(msg))
    else
        print_r(summerOlympics);
    end
end
```

# Sqlite

- Good for larger, more complicated data
- Relational database
    - Multiple tables
- CRUD

## What is sql

- Database language for relational databases

## What is relational database

- Consists of number of tables
    - Has rows/columns
- Each row (tuple) contains data about some entity
- Each column (attribute) corresponds to one specific piece of data
- Related data from different tables can be picked out and combined to answer questions of interest

## Creating a database

``` lua
local sqlite3 = require("sqlite3");
local path = system.pathForFile("data.db", system.DocumentsDirectory);
local db, dbErrorCode, dbError = sqlite.open(path);
```

## Creating a table

``` lua
-- sql command as a string
local tableSetup = [[
    CREATE TABLE IF NOT EXISTS test
        id INTEGER PRIMARY KEY AUTOINCREMENT
        ,name
        ,description
        ,website
    GO
]]
```

## Inserting row

``` lua
local insertQuery = [[
    INSERT INTO test
    VALUES
        NULL
        ,'John Doe'
        ,'This is an unknown person'
        ,'http://www.somewebsite.com'
]]
```

## Deserialize sqlite to lua table

``` lua
local people = {
    {
        name = "John Doe",
        description = "Some description",
        website = "http://somewebsite.com"
    }
    -- more table entries
}

for i = 1, #people, 1 do
    local q = string.format("INSERT INTO test VALUES(NULL, %s, %s, %s", people[i].name, people.[i].description, people[i].website);
    dbErrorCode = db:exec(q);
end
```

## Update tuple

``` lua
local q = "UPDATE test SET name='Grouch' WHERE id=3;"
dbErrorCode = db:exec(q);
```

## Closing db

``` lua
local function onSystemEvent(event)
    if(event.type == "applicationExit") then
        if(db and db:isopen()) then
            db:close();
        end
    end
end
Runtime:addEventListener("system", onSystemEvent);
```