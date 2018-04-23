# Multithreading

## Overview

- Introduction
- Advantages
- Disadvantages
- Data level parallelism
- Task level parallelism
- `std::thread`
- Race conditions
- Preventing race conditions
- `mutex` examples
- `join` vs. `detach`
- Putting threads to sleep

# Introduction

- C++ supports multithreading
- Multiple sequences of instructions (threads) are run at the same time (in parallel)
- OS manages how threads are distributed across CPU resources
    - Within and across CPU cores

# Advantages

- Allows program to be split into functions that run in parallel
    - Accept realtime input
    - Communicate over network
    - Run simulation updates
- Get more performance

# Disadvantages

- Code becomes hard to design/debug
    - Multiple things hapenning at same time

## Major problems

- Race conditions
    - When multiple threads try to modify same variable simultaneously
- Deadlock
    - Thread A waits for Thread B to release a resource
    - While Thread B waits for Thread A to release another resource

# Data level parallelism

- Run multiple instances of the same action on different data

## Colin McRae Rally 04

- Exploiting data level parallelism in particle system simulating weather allowed
    - Increased performance
    - Higher detail visual effects

![data level parallelism](https://snag.gy/5XK3mP.jpg)

# Task level parallelism

- Run different tasks in parallel

## Black & White 2

- Original single thread design
    - Major events (ie. avalanches) occupy the physics system slowing down rendering
- Overcome by using two separate threads
    - One performs rendering
    - Other performs physics calculations

![task level parallelism](https://snag.gy/wtV93G.jpg)

# `std::thread`

- Class that lets us run threads
- `thread::join()`
    - Wait for thread to finish before proceeding
- `thread::detatch()`
    - Lets thread run freely and unchecked
    - Used when we don't need to wait for thread to finish

## Function without parameters

``` cpp
void someFunction()
{
    cout << "Doing stuff" << endl;
}

void main()
{
    thread t(someFunction); // calls someFunction in another thread
    t.join(); // wait for thread t to finish
}
```

## Function with parameters

``` cpp
void someFunction(int x, int& y)
{
    cout << "This is doing stuff with " << x << " and " << y '\n';
}

void main()
{
    int x = 5;
    int y = 2;

    thread t(someFunction, x, ref(y)); // passing by ref()
    t.join();
}
```

# Race conditions

``` cpp
void increment(int& total, int id)
{
    for (int i = 0; i < 1000000; i++)
        total++;

    cout << "Id " << id << ": increment done!\n";
}

void main()
{
    int total = 0;

    // without thread
    increment(total, 1);
    increment(total, 2);
    cout << "total: " << total << endl;
    // result = 2000000

    // with thread
    thread a(increment, ref(total), 1);
    thread b(increment, ref(total), 2);
    a.join();
    b.join();
    cout << "total: " << total << endl;
    // result = 1297884, WRONG!
}
```

## Update variable procedure

- Load data from memory address of variable to CPU register
- Put a 1 into another register
- Set arithmetic logic unit (ALU) to addition
- Run ALU, storing result in a register
    - Accumulator
- Write value of accumulator back to variable's memory address

## Race condition reason

- These steps take time so there's a chance that between thread reading old value and writing new value the other thread has read the old value
- The second thread will then overwrite what the first thread has written
- Its called race condition because the result depends on which thread gets to the variable first
- Can be hard to debug because the problems they cause are intermittent

# Preventing race conditions

- Let only one thread access common data at a time
    - If one thread is already accessing it, let other threads wait
- In C++ we can define a `mutex` section
    - Mutually exclusive

# `mutex` examples

## Example 1

- Code below behaves like single thread
- Only one thread allowed in loop at a time

``` cpp
static mutex barrier;

void increment(int& total, int id)
{
    lock_guard<mutex> block(barrier);
    for(int i = 0; i < 1000; i++)
    {
        total++;
    }
}
```

## Example 2

- Uses temporary non shared variable
- Multiple threads can access loop
- But blocks on update at the end

``` cpp
static mutex barrier;

void increment(int& total, int id)
{
    int incrementTotal = 0;
    for(int i = 0; i < 1000; i++)
    {
        incrementTotal++;
    }
    lock_guard<mutex> block(barrier);
    total += incrementTotal;
}
```

# `join` vs. `detach`

## `join`

![join](https://snag.gy/0NhzSB.jpg)

- We want to run the two particle update threads after the world update
- Wait for them to finish with `join` before rendering the world

## `detatch`

![detach](https://snag.gy/5v74a3.jpg)

- We want to perform some independant activity
    - Load next level
- Since this is not needed to run the game update loop we can detatch it

## Detatching a needed thread

- If we detatch a thread that we actually need to finish before proceeding, errors occur

# Putting threads to sleep

- You may split your software into many threads
- But usually some are more important than others
- Simple jobs in a loop can flood a CPU core with activity

``` cpp
void simpleJob()
{
    while(1)
    {
        if (year == 2018)
            armaggedon = true;
            this_thread::sleep_for(chrono::seconds(5));
    }
}
```

- For more complex jobs, time how long it takes and take that into account when working out the sleep time
    - For example if you want to run something 60 times per second