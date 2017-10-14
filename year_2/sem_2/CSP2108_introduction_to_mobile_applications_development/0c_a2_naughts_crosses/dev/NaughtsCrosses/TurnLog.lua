--[[
    TurnLog uses doubly linked list structure to record turns.
    It has stack style push/pop methods so that the last turn can be undone,
    and uses the previous pointer to achieve this.
    It also has a forward iterator to replay turns.
]]

local TurnLog = class("TurnLog");

function TurnLog:init()
    self.head = nil;
    self.tail = nil;
    self.length = 0;
end

function TurnLog:push(turn)
    if(self.tail) then
        self.tail._next = turn;
        turn._prev = self.tail;
        self.tail = turn;
    else
        self.head = turn;
        self.tail = turn;
    end
    self.length = self.length + 1;
end

function TurnLog:pop()
    if(not self.tail) then
        return;
    end
    local turn = self.tail;
    if(turn._prev) then
        turn._prev._next = nil;
        self.tail = turn._prev;
        turn._prev = nil;
    else
        self.head = nil;
        self.tail = nil;
    end
    self.length = self.length - 1;
    return turn;
end

function TurnLog:peek()
    if(not self.tail) then
        return;
    end
    return self.tail;
end

local function replay(self, current)
    if(not current) then
        current = self.head;
    elseif(current) then
        current = current._next;
    end
    return current;
end

function TurnLog:replay()
    return replay, self, nil;
end

local function rewind(self, current)
    if(not current) then
        current = self.tail;
    elseif(current) then
        current = current._prev;
    end
    return current;
end

function TurnLog:rewind()
    return rewind, self, nil;
end

return TurnLog;