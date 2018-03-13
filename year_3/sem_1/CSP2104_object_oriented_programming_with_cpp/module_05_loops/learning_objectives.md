# Module 5 learning objectives

## Describe the different loops available

### `while` loop

- Pre test loop
- Loop iterates while condition is true

``` cpp
auto controlVar = 0;
while(controlVar < 10)
{
    // do stuff
    controlVar++;
}
```

#### Pitfalls

- Add unwanted semicolon `;`
    - Empty loop body
    - Causes infinite loop
- Failing to alter loop control variable

``` cpp
auto controlVar = 0;
while(controlVar < 10); // ends expression, stuff in block not executed in loop
{
    // do stuff
    controlVar++; // control variable not altered
}
```

- Forgetting curly braces `{}`

``` cpp
auto controlVar = 0;
while(controlVar < 10) // only cout is executed as part of loop
    cout << controlVar << endl;
    controlVar++; // control variable not altered
```

- Failing to initialize control variable

``` cpp
int controlVar; // compile error?
while(controlVar < 10)
{
    // do stuff
    controlVar++;
}
```

### `do while` loop

- Post test loop
- Will execute block at least once
- Then iterate while condition is true

``` cpp
int controlVar = 0;
do
{
    cout << controlVar << endl;
    controlVar++;
}
while(controlVar < 5)
```

### `for` loop

- Pre test loop
- `for(init; eval; alter)`
- Iterates while `eval` is true

``` cpp
auto length = word.length();
for(int i = 0; i < length; i++)
{
    // do stuff
}
```

### Range based `for` loop

- Pre test loop
- Like `for each`
- Iterates over collections
    - ie. Arrays

``` cpp
string words[5];

for(string word : words)
{
    // do stuff with each word
}
```

## Describe difference between pre vs. post test loops

- Pre test
    - Evaluates control condition before executing loop
- Post test
    - Evaluates control condition after executing loop

## Describe how loops interact when nested

- For every iteration of the outer loop
    - The inner loop executes to completion

``` cpp
// O(n^2)
for(int i = 0; i < length; i++)
{
    // for every iteration of i
    for(int j = 0; j < length; j++)
    {
        // j iterates to completion
    }
}
````