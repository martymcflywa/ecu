# Module 2 learning objectives

## List binary arithmetic operators
- `+`
- `-`
- `*`
- `/`
- `%`

## Explain precedence of arithmetic operators
- `*`, `/`, `%` have higher precedence
-  `+`, `-` follow
- Leftmost operation with highest precedence first
    - Unifying type principle applied if required
- Then each subsequent `*`, `/` or `%` is evaluated left to right
- Then leftmost operation with lowest precedence `+`, `-` evaluated second
- Then each subsequent `+` or `-` is evaluated left to right

## Explain shortcut arithmetic operators
- Compound assignment
    - `+=` add and assign
    - `-=` subtract and assign
    - `*=` multiply and assign
    - `/=` divide and assign
    - `%=` mod and assign
- Inc/decrement
    - Prefix
        - Inc/decrement takes place before evaluation
        - `++count;`
        - `--count;`
    - Postfix
        - Inc/decrement takes place after evaluation
        - `count++;`
        - `count--;`

## List unary operators
- `+` positive value
    - `+5`
- `-` negative value
    - `-5`
- `&` address operator
    - `&count`

## Explain how boolean expressions are handled
- Evaluate relationship between operands
- Result is `true` or `false`
- `==` equal to
- `!=` not equal to
- `<` less than
- `<=` less than or equal to
- `>` greater than
- `>=` greater than or equal to
- `!` not operator
    - Reverses boolean value of expression
    - `auto isLessThan = 9 < 2` == false
    - `auto isLessThan = !(9 < 2)` == true

## Understand how to make use of operators with structs
- Reference struct variable with `.`

``` cpp
struct Person
{
    int age;
}

int main()
{
    const auto MIN_AGE = 18;
    Person person;

    cout << "Person can buy beer: " << (person.age >= MIN_AGE) << endl; 
}
```