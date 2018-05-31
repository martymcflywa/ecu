# Evaluating C++ expressions

## 1:

1.	Assume a, b and c are integers and that a = 0, b = 1 and c = 5. Evaluate each of the following expressions. (Do not assume the answers are cumulative; evaluate each expression using the original values for a, b and c.)
    1.	a + b
        - = 0 + 1
        - = 1 
    2.	a > b
        - false
    3.	3 + b * c
        - = 3 + 1 * 5
        - = 3 + 5
        - = 8
    4.	++b
        - 2
    5.	b++
        - 2
    6.	b <= c
        - true
    7.	a > 5
        - false
    8.	++a == b
        - true
    9.	b != c
        - true
    10.	b == c
        - false
    11.	b = c
        - b = 5
    12.	b / c
        - Depends on return type or variable storing result
        - int = 0
        - double = 0.2
    13.	b % c
        - 1
    14.	b + c * 4 / 3
        - 1 + 5 * 4 / 3
        - 1 + ((5 * 4) / 3)
        - 1 + (20 / 3)
        - 1 + 6.6
        - int = 7
        - double = 7.6
    15.	22 / (c + 3)
        - 22 / (5 + 3)
        - 22 / 8
        - int = 2
        - double 2.75

