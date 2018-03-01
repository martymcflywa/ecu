# Making decisions

## Outline

- `if` and `if-else` statements
- Nested `if` statements
- Common pitfalls
- `switch` statements
- Conditional operator `?`
- Logical `AND`/`OR`
- Decisions with `struct` fields

# `if` and `if-else` statements

- C++ supports all standard control structures
    - `if`
    - `if-else`
    - `switch`
    - Conditional operators
- Can combine decisions using logical `AND`/`OR`

## Single alternative `if`

- `if` primary C++ selection structure statement used to perform a single alternative selection

``` cpp
if(boolean expression)
{
    // will perform action in this block if true..
}
// otherwise will skip block and continue here.
```

### Using the `if` statement

``` cpp
if(driverAge < 26)
    premiumDue += 100;
if(driverAge > 50)
    premiumDue -= 50;
if(numTickets == 2)
    premiumDue += 60.25;
```

## Dual alternative `if-else`

``` cpp
if(boolean expression)
{
    // code in this block executed if true
}
else
{
    // code in this block executed if false
}
```

### Using the `if-else` statement

``` cpp
if(genderCode == 'F')
    cout << "Female" << endl;
else
    cout << "Male" << endl;
```

# Nested `if` statements

- `if` structure that rests entirely within another `if` structure
- Can reside within `if` or `else` blocks

``` cpp
if(genderCode == 'F')
    cout << "Female" << endl;
else
    if(genderCode == 'M')
        cout << "Male" << endl;
    else
        cout << "Invalid code" << endl;
```

# Common pitfalls

- Forgetting C++ comparisons are case sensitive
- Assuming that indentation has a logical purpose
- Adding unwanted semicolon `;`
- Using `=` instead of `==`
- Making unecessary comparisons
- Creating unreachable code

# `switch` statements

- Alternative to using deep `if-else` expressions
- Less chance of having dead paths

``` cpp
switch(department)
{
    case 1:
        employee.department = "Human Resources":
        break;
    case 2:
        employee.department = "Sales";
        break;
    case 3:
        employee.department = "Information Systems";
        break;
    default:
        throw std::invalid_argument("Invalid department " + std::to_string(department));
}
```

# Conditonal operator `?`

- Represented by `?`
- Concise way to express two conditional statements

``` cpp
if(driverAge < 26)
    premium = 250;
else
    premium = 185;
```

- Above could be shortened by conditional below

``` cpp
driverAge < 26 ? premium = 250 : premium 185;
```

- More complex example

``` cpp
cout << (a < b ? a : b) << " is greater" << endl;
```

# Logical `AND`/`OR`

- Convenient shortcut for testing multiple conditions
- Join two conditions with `&&` (AND)
    - Both statements must be `true` to execute block
- Join two condtitions with `||` (OR)
    - One of two statements must be `true` to execute block
- `&&` takes precedence over `||`
- Use `()` to remove ambiguity in result of mixed logical expressions

``` cpp
if((student.quizOne == pass || student.quizTwo == pass)
    && student.finalExam == pass)
{
    // student must pass at least one quiz
    // AND final exam to execute code here
}
```

# Making decisions with `struct` fields

``` cpp
struct BaseballPlayer
{
    int jerseyNumber;
    int numberOfHits;
}

int main()
{
    BaseballPlayer shortStop;
    const int LOW_HITS = 5;
    const int HIGH_HITS = 20;

    if(shortStop.numberOfHits <= LOW_HITS)
        cout << "Player " << shortStop.jerseyNumber << " is performing poorly." << endl;
    else
        if(shortStop.numberOfHits <= HIGH_HITS)
            cout << "Player " << shortStop.jerseyNumber << " is doing well." << endl;
        else
            cout << "So WOW!" << endl;
    
    return 0;
}
```