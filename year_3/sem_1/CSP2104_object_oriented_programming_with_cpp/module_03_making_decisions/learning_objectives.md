# Module 3 learning objectives

## Explain the use of `if` and `if-else` statements
- Single alternative `if`
    - If the declared boolean expression is true, then the code within the `if` block will be executed
        - Otherwise it will be skipped and code below the `if` block will be executed (if any)
- Double alternative `if-else`
    - If the declared boolean expression is true, then the code within the `if` block will be executed
    - Else if the boolean expression is false, the code within the `else` statement will be executed

## Understand what nesting is
- `if` statements can be nested within a parent `if` or `else` block

``` cpp
if(foo.isTrue)
    // do stuff
else
    if(bar.isTrue) // this is nested inside parent else
        // do other stuff
    else
        // do some other thing
```

## Explain use of switch statement
- Used as a shortcut alternative for deep `if-else-if-else` statements

``` cpp
switch(some.value)
{
    // cases are expected values of some.value
    case 1:
        // do something if value is 1
        break; // don't need break if return
    case 2:
        // do something else if value is 2
        break;
    default:
        // do something if value isn't either 1 or 2.
}
```