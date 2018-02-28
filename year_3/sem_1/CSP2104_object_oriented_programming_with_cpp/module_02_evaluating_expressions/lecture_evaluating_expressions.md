# Evaluating C++ expressions

## Outline

- C++ binary arithmetic operators
- Precedence and associativity of arithmetic operations
- Shortcut arithmetic operators
- Unary operators
- Boolean expressions
- Operations on struct fields

# C++ binary arithmetic operators

- Five binary arithmetic operators
    1. `+` addition
    2. `-` subtraction
    3. `*` multiplication
    4. `/` division
    5. `%` modulo

``` cpp
#include <iostream>
using namespace std;

int main()
{
    cout << 12 + 9 << endl; // 21
    int sum = 12 + 9; // 21
    cout << sum << endl; // value of sum
    return 0;
}
```

## Operands and binary arithmetic operators

- Using binary arithmetic operators on two `int` results in `int`
    - Example
        - `7 / 2 = 2`
        - Truncates float values
- When evaluating expression with operands of varying data types, C++ uses the unifying data type principle
    - `3.2 * 2`
    - Converts all types in expression to type that occupies most memory

### Precedence order

- `long double`, `double`
- `float`, `unsigned long`, `long`
- `unsigned int`
- `int`
- `short`
- `char`

### Example

``` cpp
#include <iostream>
using namespace std;

int main()
{
    int a = 2, b = 4, c = 10, intResult;
    float g = 2.0f, h = 4.4f, i = 12.8f, floatResult;
    double d = 2.0, e = 4.4, f = 12.8, doubleResult;

    intResult = a + b; // == int 6, both operands are int
    intResult = a * b; // == int 8, both operands are int
    intResult = c / a; // == int 5, both operands are int

    floatResult = g / a; // == float 1.0, both operands are float
    floatResult = h / g; // == float 2.2, both operands are float

    doubleResult = a * d; // == double 4.0, operands are int and double, but without redundant decimal
    doubleResult = f / a; // == double 6.4, operands are int and double
    doubleResult = e + h; // == double 8.8, operands are float and double
}
```

## Casting

- Type casting transforms a given data type to another

### Implicit cast

- Auto casting that occurs when you assign a value of one type to another with higher precedence
    - `int answer = 2.0 * 7;`

### Explicit cast

- Deliberately casting one type to another
    - `int answer = static_cast<int>(doubleVar);`
    - `int answer = (int) doubleVar;`

## Modulo

- `%` gives the remainder of `int` division
    - `7 % 3 = 1`
    - `-10 % 8 = -2`
    - `-10 % -8 = -2`
- Only used on `int`
- Can be used to extract digits from numbers
    - `6543 % 10 = 3`
    - `6789 % 10 = 9`

# Precedence and associativity of arithmetic operations

- `*`, `/`, `%` have higher precedence
- `+`, `-` follow
- Just like maths

## Associativity

- Most operators have left to right associativity rule
- Leftmost operation with highest precedence first
    - Apply unifiying type principle if required
- Each subsequent `*`, `/` or `%` operation is evaluated in same manner from left to right
- Leftmost operation with lowest precedence (`+` or `-`) evaluated second
- Then each subsequent `+` or `-` operation is evaluated in the same manner from left to right

``` cpp
2 + 3 * 4.0 = 14.0;
// 3 * 4.0 = 12.0;
// 2 + 12.0 = 14.0;

3 / 4 + 2.2 = 2.2;
// 3 / 4 = (int) 0;
// 0 + 2.2 = 2.2;

3.0 / 4 + 2.2 = 2.95;
// 3.0f / 4 = 0.75;
// 0.75 + 2.2 = 2.95;

3.0 * 1.1 / 2 = 1.65
// 3.0 * 1.1 = 3.3;
// 3.3 / 2 = 1.65;

3 / 2 * 5 / 2 = 2;
// 3 / 2 = (int) 1;
// 1 * 5 = 5;
// 5 / 2 = (int) 2;
```

# Shortcut arithmetic operators

## Compound assignment operators

- `+=` add and assign
- `-=` subtract and assign
- `*=` multiply and assign
- `/=` divide and assign
- `%=` mod and assign

## Increment/decrement operators

### Prefix operator

- `++count` increment
- `--count` decrement

### Postfix operator

- `count++` increment
- `count--` decrement

## Shortcut examples

``` cpp
#include <iostream>
using namespace std;

int main()
{
    int count = 0;
    count = count + 1; // == 1
    count += 1 // == 2;
    ++count; // == 3;
    count++; // == 4;
    return 0; 
}
```

# Unary operators

- `+` positive value operator
    - `+5`
- `-` negative value operator
    - `-8`
- `&` address operator
    - `&count`

``` cpp
#include <iostream>
using namespace std;

int main()
{
    int x = 5;
    int y = 775;

    cout << "The value of x is " << x << " and the value of y is " << y endl;
    cout << "The address of x is " << &x << " and the address of y is " << &y << endl;
    return 0;
}
```

# Boolean expressions

- Relational operators evaluate relationship between operands
- Used to evaluate boolean expressions
    - `true` or `false`
- `==` equal to
- `!=` not equal to
- `>` greater than
- `>=` greater than or equal to
- `<` less than
- `<=` less than or equal 
- `!` not operator
    - Reverses boolean value of expression
        - `cout << (9 > 2);`
            - Displays `1` `true`
        - `cout << !(9 > 2);`
            - Displays `0` `false`

# Operations on struct fields

``` cpp
#include <iostream>
using namespace std;

struct Employee
{
    int id;
    double hourlyRate;
}

int main()
{
    const double RAISE = 2.77;
    const double AVERAGE_PAY = 13.0;

    Employee employee;

    employee.hourlyRate = 10.00;
    employee.hourlyRate += RAISE;

    cout << "Salary is " << employee.hourlyRate << endl;
    cout << "Is the employee's salary above average? " << (employee.hourlyRate > AVERAGE_PAY) << endl;
    
    return 0;
}
```