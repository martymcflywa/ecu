# Exercises set 8

## Question 1

Find the 2's complement form of each of the following decimal numbers.

1. -27
	- Convert 27 to binary
		- 27 / 2 = 13 rem 1
		- 13 / 2 = 6 rem 1
		- 6 / 2 = 3 rem 0
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
		- 27 = 11011
	- Find 1's complement
		- 00100
	- Add 1
		- 00100 + 1 = 00101
	- Negative number, add leading 1's
	- -27 = 1110 0101
2. -73
	- Convert 73 to binary
		- 73 / 2 = 36 rem 1
		- 36 / 2 = 18 rem 0
		- 18 / 2 = 9 rem 0
		- 9 / 2 = 4 rem 1
		- 4 / 2 = 2 rem 0
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
		- 73 = 1001001
	- Find 1's complement
		- 0110110
	- Add 1
		- 0110110 + 1 = 0110111
	- Negative number, add leading 1's
	- -73 = 1011 0111
3. 49
	- Convert 49 to binary
		- 49 / 2 = 24 rem 1
		- 24 / 2 = 12 rem 0
		- 12 / 6 = 6 rem 0
		- 6 / 2 = 3 rem 0
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
		- 49 = 110001
	- Positive number, just add leading 0's
	- 49 = 0011 0001
4. -123
	- Convert 123 to binary
		- 123 / 2 = 61 rem 1
		- 61 / 2 = 30 rem 1
		- 30 / 2 = 15 rem 0
		- 15 / 2 = 7 rem 1
		- 7 / 2 = 3 rem 1
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
		- 123 = 1111011
	- Find 1's complement
		- 0000100
	- Add 1
		- 0000100 + 1 = 0000101
	- Negative number, add leading 1's
	- -123 = 1000 0101
5. -56
	- Convert 56 to binary
		- 56 / 2 = 28 rem 0
		- 28 / 2 = 14 rem 0
		- 14 / 2 = 7 rem 0
		- 7 / 2 = 3 rem 1
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
		- 56 = 111000
	- Find 1's complement
		- 000111
	- Add 1
		- 000111 + 1 = 001000
	- Negative number, add leading 1's
	- -56 = 1100 1000

## Question 2

Convert each of the following 2's complement numbers to decimal

1. 1010 1010
	- Leading 1, negative number
		- Find 1's complement
			- 0101 0101
		- Add 1
			- 0101 0101 + 1 = 0101 0110
		- Convert to binary
			- 0101 0110 = 56<sub>16</sub> = 86<sub>10</sub>
		- Add minus sign
	- 1010 1010 = -86
2. 1000 0001
	- Leading 1, negative number
		- Find 1's complement
			- 0111 1110
		- Add 1
			- 0111 1110 + 1 = 0111 1111
		- Convert to binary
			- 0111 1111 = 7F<sub>16</sub> = 127<sub>10</sub>
		- Add minus sign
	- 1000 0001 = -127
3. 1111 0011
	- Leading 1, negative number
		- Find 1's complement
			- 0000 1100
		- Add 1
			- 0000 1100 + 1 = 0000 1101
		- Convert to binary
			- 0000 1100 = 0C<sub>16</sub> = 12<sub>10</sub>
		- Add minus sign
	- 1111 0011 = -13
4. 0111 0000
	- Leading 0, Positive number
		- Convert to decimal
			- 0111 0000 = 70<sub>16</sub> = 112<sub>10</sub>
5. 1100 1111
	- Leading 1, negative number
		- Find 1's complement
			- 0011 0000
		- Add 1
			- 0011 0000 + 1 = 0011 0001
		- Convert to binary
			- 0011 0001 = 31<sub>16</sub> = 49<sub>10</sub>
		- Add minus sign
	- 1100 1111 = -49

## Question 3

For each of the following exercises, find the output and the status of the C, N and V flags when the two given 8-bit binary numbers are added.

### 1: 0010 1110 + 0110 0100

```
V
C  01101 0000 // carry
-------------
  	0010 1110 +
	0110 0100
=============
N 	1001 0010
```

- Answer:
	- 1001 0010
	- C = 0
	- N = 1
	- V = 1

### 2: 0100 0100 + 1000 0111

```
V
C  00000 1000 // carry
-------------
	0100 0100
	1000 0111
=============
N   1100 1011
```

- Answer
	- 1100 1011
	- C = 0
	- N = 1
	- V = 0

### 3: 1100 1010 + 0110 1111

```
V
C  11001 1100 // carry
-------------
	1100 1010
	0110 1111
=============
N   0011 1001
```

- Answer
	- 0011 1001
	- C = 1
	- N = 0
	- V = 0

### 4: 1110 0001 + 1010 1001

```
V
C  11100 0010 // carry
-------------
	1110 0001
	1010 1001
=============
N   1000 1010
```

- Answer
	- 1000 1001
	- C = 1
	- N = 1
	- V = 0

### 5: 1001 0100 + 1011 0101

```
V
C  10110 1000 // carry
-------------
	1001 0100
	1011 0101
=============
N   0100 1001
```

- Answer
	- 0100 1001
	- C = 1
	- N = 0
	- V = 1

## Question 4

For each of the parts in Question 3, interpret the given 8-bit numbers as **unsigned** integers and:

1. Find the decimal equivalents of the integers and their sum
2. State whether the sum of the two integers will fit into 8-bits
3. If not, state the 16-bit binary number that represents them

### 1: 0010 1110 + 0110 0100 = 1001 0010

1. Convert to decimal
	- 0010 1110 = 2E<sub>16</sub> = 46<sub>10</sub>
	- 0110 0100 = 64<sub>16</sub> = 100<sub>10</sub>
		- 46 + 100 = 146
	- 1001 0010 = 92<sub>16</sub> = 146<sub>10</sub>
2. Does output fit in 8-bits (0 - 255<sub>10</sub>)
	- Yes 146 fits 
3. N/A

### 2: 0100 0100 + 1000 0111 = 1100 1011

1. Convert to decimal
	- 0100 0100 = 44<sub>16</sub> = 68<sub>10</sub>
	- 1000 0111 = 87<sub>16</sub> = 135<sub>10</sub>
	 - 68 + 135 = 203
	- 1100 1011 = CB<sub>16</sub> = 203<sub>10</sub>
2. Does output fit in 8-bits (0 - 255<sub>10</sub>)
	- 203 fits
3. N/A

### 3: 1100 1010 + 0110 1111 = 0011 1001

1. Convert to decimal
	- 1100 1010 = CA<sub>16</sub> = 202<sub>10</sub>
	- 0110 1111 = 6F<sub>16</sub> = 111<sub>10</sub>
		- 202 + 111 = 313
2. Does output fit in 8-bits (0 - 255<sub>10</sub>)
	- No, 313 does not fit
3. What is the 16-bit binary number
	- 0000 0001 0011 1001

### 4: 1110 0001 + 1010 1001 = 1000 1010

1. Convert to decimal
	- 1110 0001 = E1<sub>16</sub> = 225<sub>10</sub>
	- 1010 1001 = A9<sub>16</sub> = 169<sub>10</sub>
		- 225 + 169 = 394
2. Does output fit in 8-bits (0 - 255<sub>10</sub>)
	- No, 394 does not fit
3. What is the 16-bit binary number
	- 0000 0001 1000 1010

### 5: 1001 0100 + 1011 0101 = 0100 1001

1. Convert to decimal
	- 1001 0100 = 94<sub>16</sub> = 148<sub>10</sub>
	- 1011 0101 = B5<sub>16</sub> = 181<sub>10</sub>
		- 148 + 181 = 329
2. Does output fit in 8-bits (0 - 255<sub>10</sub>)
	- No, 329 does not fit
3. What is the 16-bit binary number
	- 0000 0001 0100 1001

## Question 5

For each of the parts in Question 3, interpret the given 8-bit numbers as **signed** integers in 2's complement form, and:

1. State whether the 8-bit output represents a positive or negative integer, and whether it needs to be extended to 16 bits
2. Find the decimals represented by the two given numbers and their sum

### 1: 0010 1110 + 0110 0100 = 1001 0010

- C = 0
- N = 1
- V = 1

1. Output is positive
	- V = 1, output is 16-bit.
	- 0000 0000 1001 0010
2. Find decimals
	- 0010 1110 = 2E<sub>16</sub> = 46<sub>10</sub>
	- 0110 0100 = 64<sub>16</sub> = 100<sub>10</sub>
	- 1001 0010 = 92<sub>16</sub> = 146<sub>10</sub>

### 2: 0100 0100 + 1000 0111 = 1100 1011

- C = 0
- N = 1
- V = 0

1. Output is negative
	- V = 0, output is 8-bit
	- 1100 1011 = -53
2. Find decimals
	- 0100 0100 = 44><sub>16</sub> = 68<sub>10</sub>
	- 1000 0111 = negative
		- Find 1's complement
			- 0111 1000
		- Add 1
			- 0111 1000 + 1 = 0111 1001
			- 0111 1001 = 78<sub>16</sub> = 121<sub>10</sub>
	- 68 + -121 = -53
	- 1100 1011
		- Find 1's complement
			- 0011 0100
		- Add 1
			- 0011 0100 + 1 = 0011 0101
			- 0011 0101 = 35<sub>16</sub> = 53<sub>10</sub>
	- 1100 1011 = -53

### 3: 1100 1010 + 0110 1111 = 0011 1001

- C = 1
- N = 0
- V = 0

1. Output is positive
	- V = 0, output is 8-bit
2. Find decimals
	- 1100 1010 = negative
		- Find 1's complement
			- 0011 0101
		- Add 1
			- 0011 0101 + 1 = 0011 0110
		- Find decimal
			- 0011 0110 = 36<sub>16</sub> = 54
		- 1100 1010 = -54
	- 0110 1111 = positive
		- Find decimal
			- 0110 1111 = 6F<sub>16</sub> = 111
	- 0011 1001
		- Find decimal
			- 0011 1001 = 39<sub>16</sub> = 57
	- -54 + 111 = 57

### 4: 1110 0001 + 1010 1001 = 1000 1010

- C = 1
- N = 1
- V = 0

1. Output is negative
	- V = 0, output is 8-bit
2. Find decimals
	- 1110 0001 = negative
		- Find 1's complement
			- 0001 1110
		- Add 1
			- 0001 1110 + 1 = 0001 1111
		- Find decimal
			- 0001 1111 = 1F<sub>16</sub> = 31<sub>10</sub>
	- 1010 1001 = negative
		- Find 1's complement
			- 0101 0110
		- Add 1
			- 0101 0110 + 1 = 0101 0111
		- Find decimal
			- 0101 0111 = 57<sub>16</sub> = 87<sub>10</sub>
	- 1000 1010 =  negative
		- Find 1's complement
			- 0111 0101
		- Add 1
			- 0111 0101 + 1 = 0111 0110
		- Find decimal
			- 0111 0110 = 76<sub>16</sub> = 118<sub>10</sub>
	- 1000 1010 = -118

### 5: 1001 0100 + 1011 0101 = 0100 1001

- C = 1
- N = 0
- V = 1

1. Output is negative
	- V = 1, output is 16-bit
	- 1111 1111 0100 1001 = -183
2. Find decimals
	- 1001 0100 = negative
		- Find 1's complement
			- 0110 1011
		- Add 1
			- 0110 1011 + 1 = 0110 1100
		- Find decimal
			- 0110 1100 = 6C<sub>16</sub> = 108<sub>10</sub>
	- 1011 0101 = negative
		- Find 1's complement
			- 0100 1010
		- Add 1
			- 0100 1010 + 1 = 0100 1011
		- Find decimal
			- 0100 1011 = 4B<sub>16</sub> = 75<sub>10</sub>
	- -108 + -75 = -183
	- 0100 1001 = negative
		- Find 1's complement
			- 1011 0110
		- Add 1
			- 1011 0110 + 1 = 1011 0111
		- Find decimal
			- 1011 0111 = B7<sub>16</sub> = 183<sub>10</sub>
		- 0100 1001 = -183

## Question 6

Add the 8-bit binary numbers 1000 1001 and 1011 1001, and find the values of the C, N and V flags. Then:

1. Interpret the adddition as **unsigned** integers, extending to 16-bits if required. Convert the output to decimal number. Then check the answer by carrying out the same operation using the decimal equivalents.

2. Repeat Step 1, but for **signed** integers.

```
V
C  10111 0010 // carry
-------------
	1000 1001
	1011 1001
=============
N   0100 0010
```

| C | N | V |
|:-:|:-:|:-:|
| 1 | 0 | 1 |

### 1: Unsigned 1000 1001 + 1011 1001

- Output: 16-bit
	- 0000 0001 0100 0010 = 322<sub>10</sub>
- Find decimals
	- 1000 1001 = 89<sub>16</sub> = 137<sub>10</sub>
	- 1011 1001 = B9<sub>16</sub> = 185<sub>10</sub>
		- 137 + 185 = 322
	- 0000 0001 0100 0010 = 142<sub>16</sub> = 322<sub>10</sub>

### 2: Signed 1000 1001 + 1011 1001

- Output: Negative 16-bit
	- 1111 1111 0100 0010 = -190<sub>10</sub>
- Find decimals
	- 1000 1001 = negative
		- Find 1's complement
			- 0111 0110
		- Add 1
			- 0111 0110 + 1 = 0111 0111
		- Find decimal
			- 0111 0111 = 77<sub>16</sub> = 119
		- 1000 1001 = -119
	- 1011 1001 = negative
		- Find 1's complement
			- 0100 0110
		- Add 1
			- 0100 0110 + 1 = 0100 0111
		- Find decimal
			- 0100 0111 = 47<sub>16</sub> = 71
		1011 1001 = -71
	- -119 + (-71) = -190

## Question 7

Repeat steps in Question 6 for numbers 0101 1010 and 1011 1001.

```
V
C  11111 0000
-------------
	0101 1010
	1011 1001
=============
N   0001 0011
```

| C | N | V |
|:-:|:-:|:-:|
| 1 | 0 | 0 |

### 1: Unsigned 0101 1010 + 1011 1001

- Output: 16-bit
	- 0000 0001 0001 0011 = 275<sub>10</sub>
- Find decimals
	- 0101 1010 = 5A<sub>16</sub> = 90
	- 1011 1001 = B9<sub>16</sub> = 185
		- 90 + 185 = 275
	- 0000 0001 0001 0011 = 113<sub>16</sub> = 275<sub>10</sub>

### 2: Signed 0101 1010 + 1011 1001

- Output: Positive 8-bit
	- 0001 0011 = 19<sub>10</sub>
- Find decimals
	- 0101 1010 = 5A<sub>16</sub> = 90
	- 1011 1001 = negative
		- Find 1's complement
			- 0100 0110
		- Add 1
			- 0100 0110 + 1 = 0100 0111
		- Find decimal
			- 0100 0111 = 47<sub>16</sub> = 71
	- 90 + (-71) = 19
	- 0001 0011 = 13<sub>16</sub> = 19<sub>10</sub>

## Question 8

Repeat steps in Question 6 for numbers 0111 1010 and 0011 0001.

```
V
C  01110 0000
-------------
	0111 1010
	0011 0001
=============
N   1010 1011
```

| C | N | V |
|:-:|:-:|:-:|
| 0 | 1 | 1 |

### 1: Unsigned 0111 1010 + 0011 0001

- Output: 8-bit
	- 1010 1011 = 171<sub>10</sub>
- Find decimals
	- 0111 1010 = 79<sub>16</sub> = 122<sub>10</sub>
	- 0011 0001 = 31<sub>16</sub> = 49<sub>10</sub>
		- 122 + 49 = 171
	- 1010 1011 = AB<sub>16</sub> = 171

### 2: Signed 0111 1010 + 0011 0001

- Output: Positive 16-bit
	- 0000 0000 1010 1011 = 171<sub>10</sub>
- Find decimals
	- 0111 1010 = positive
		- 0111 1010 = 79<sub>16</sub> = 122<sub>10</sub>
	- 0011 0001 = positive
		- 0011 0001 = 31<sub>16</sub> = 49<sub>10</sub>
	- 1010 1011 = AB<sub>16</sub> = 171

## Question 10

Suppose that two 8-bit binary numbers have been added and the 8-bit output and the CCR flags are as shown:

0101 1010

| C | N | V |
|:-:|:-:|:-:|
| 1 | 0 | 1 |

### 1: Unsigned output 0101 1010

Interpret the result as an **unsigned** integer and give the correct answer as a decimal

- Output 16-bit
	- 0000 0001 0101 1010
	- = 15A<sub>16</sub>
	- = 346<sub>10</sub>

### 2: Signed output 0101 1010

Interpret the result as a **signed** integer and give the correct answer as a decimal

- Output negative 16-bit
	- 1111 1111 0101 1010
	- Find 1's complement
		- 1010 0101
	- Add 1
		- 1010 0101 + 1 = 1010 0110
	- Find decimal
		- 1010 0110 
		- = A6<sub>16</sub>
		- = -166<sub>10</sub>

## Question 11

Add the **unsigned** integers 143 and 179 using the following steps:

1. Convert both integers to 8-bit binary
	- 143<sub>10</sub> = 1000 1111
		- 143 / 2 = 71 rem 1
		- 71 / 2 = 35 rem 1
		- 35 / 2 = 17 rem 1
		- 17 / 2 = 8 rem 1
		- 8 / 2 = 4 rem 0
		- 4 / 2 = 2 rem 0
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
	- 179<sub>10</sub> = 1011 0011
		- 179 / 2 = 89 rem 1
		- 89 / 2 = 44 rem 1
		- 44 / 2 = 22 rem 0
		- 22 / 2 = 11 rem 0
		- 11 / 2 = 5 rem 1
		- 5 / 2 = 2 rem 1
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
2. Add the two 8-bit binary numbers and calculate C flag
	- 1000 1111 + 1011 0011 = 0000 0001 0100 0010
3. Use C flag to determine whether output needs to be extended to 16-bit
	- C = 1
4. Convert all binary numbers to decimal
	- 0000 0001 0100 0010 = 142<sub>16</sub> = 322<sub>10</sub>
5. Check result is correct by comparing decimal operation with binary operation
	- 143 + 179 = 322
	- 0000 0001 0100 0010 = 322<sub>10</sub>

## Question 12

Add the **unsigned** integers 81 and 123 using the following steps:

1. Convert both integers to 8-bit binary
	- 81<sub>10</sub> = 0101 0001 
		- 81 / 2 = 40 rem 1
		- 40 / 2 = 20 rem 0
		- 20 / 2 = 10 rem 0
		- 10 / 2 = 5 rem 0
		- 5 / 2 = 2 rem 1
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
	- 123<sub>10</sub> = 0111 1011
		- 123 / 2 = 61 rem 1
		- 61 / 2 = 30 rem 1
		- 30 / 2 = 15 rem 0
		- 15 / 2 = 7 rem 1
		- 7 / 2 = 3 rem 1
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
2. Add the two 8-bit binary numbers and calculate C flag
	- 0101 0001 + 0111 1011 = 1100 1100
3. Use the C flag to determine whether output needs to be extended to 16-bit
	- C = 0
4. Convert all binary numbers to decimal
	- 1100 1100 = CC<sub>16</sub> = 204<sub>10</sub>
5. Check result is correct by comparing decimal operation with binary operation
	- 81 + 123 = 204
	- 1100 1100 = 204<sub>10</sub>

## Question 13

Add the **signed** integers -93 and 44 using the following steps:

1. Convert both integers to 8-bit 2's complement form
	- -93 = 1010 0011
		- 92 / 2 = 46 rem 1
		- 46 / 2 = 23 rem 0
		- 23 / 2 = 11 rem 1
		- 11 / 2 = 5 rem 1
		- 5 / 2 = 2 rem 1
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
		- 1's complement
			- 0101 1101 = 1010 0010
		- Add 1
			- 1010 0010 + 1 = 1010 0011
	- 44 = 0010 1100
		- 44 / 2 = 22 rem 0
		- 22 / 2 = 11 rem 0
		- 11 / 2 = 5 rem 1
		- 5 / 2 = 2 rem 1
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
2. Add the two 8-bit 2's complement representations and calculate the N and V flags
	- 1010 0011 + 0010 1100
	- = 1100 1111
		- C = 0
		- N = 1
		- V = 0
3. Use the binary output and the flags to determine whether output needs to be extended to 16-bit
	- Negative 8-bit output
4. Convert the 2's complement representation to a decimal output
	- 1100 1111 = negative
		- Find 1's complement
			- 0011 0000
		- Add 1
			- 0011 0000 + 1 = 0011 0001
		- Find demical
			- 0011 0001
			- = 31<sub>16</sub>
			- = 49<sub>10</sub>
5. Check the binary output matches the decimal output
	- -93 + 44 = -49

## Question 14

Add the **signed** integers -52 and 71 using the following steps:

1. Convert both integers to 8-bit 2's complement form
	- -52 = 1100 1100
		- 52 / 2 = 26 rem 0
		- 26 / 2 = 13 rem 0
		- 13 / 2 = 6 rem 1
		- 6 / 2 = 3 rem 0
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
			- 0011 0100
		- 1's complement
			- 1100 1011
		- Add 1
			- 1100 1011 + 1 = 1100 1100
	- 71 = 0100 0111
		- 71 / 2 = 35 rem 1
		- 35 / 2 = 17 rem 1
		- 17 / 2 = 8 rem 1
		- 8 / 2 = 4 rem 0
		- 4 / 2 = 2 rem 0
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
2. Add the two 8-bit 2's complement representations and calculate the N and V flags
	- 1100 1100 + 0100 0111
	- = 0001 0011
		- C = 1
		- N = 0
		- V = 0
3. Use the binary output and the flags to determine whether output needs to be extended to 16-bit
	- Positive 8-bit output
4. Convert the 2's complement representation to a decimal output
	- 0001 0011
	- = 13<sub>16</sub>
	- = 19<sub>10</sub>
5. Check the binary output matches the decimal output
	- -52 + 71 = 19

## Question 15

Add the **signed** integers -89 and -103 using the following steps:

1. Convert both integers to 8-bit 2's complement form
	- -89 = 1010 0111
		- 89 / 2 = 44 rem 1
		- 44 / 2 = 22 rem 0
		- 22 / 2 = 11 rem 0
		- 11 / 2 = 5 rem 1
		- 5 / 2 = 2 rem 1
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
		- = 0101 1001
		- 1's complement
			- 1010 0110
		- Add 1
			- 1010 0110 + 1 = 1010 0111
	- -103 = 1001 1001
		- 103 / 2 = 51 rem 1
		- 51 / 2 = 25 rem 1
		- 25 / 2 = 12 rem 1
		- 12 / 2 = 6 rem 0
		- 6 / 2 = 3 rem 0
		- 3 / 2 = 1 rem 1
		- 1 / 2 = 0 rem 1
		- = 0110 0111
		- 1's complement
			- 1001 1000
		- Add 1
			- 1001 1000 + 1 = 1001 1001
2. Add the two 8-bit 2's complement representations and calculate the N and V flags
	- 1010 0111 + 1001 1001
	- = 0100 0000
	- C = 1
	- N = 0
	- V = 1
3. Use the binary output and the flags to determine whether output needs to be extended to 16-bit
	- Negative 16-bit output
4. Convert the 2's complement representation to a decimal output
	- 1111 1111 0100 0000
		- 1's complement
			- 0000 0000 1011 1111
		- Add 1
			- 1011 1111 + 1 = 1100 0000
		- Find decimal
			- 1100 0000 = C0<sub>16</sub>
			- = 192
		- 1100 0000 = -192
5. Check the binary output matches the decimal output
	- -89 + -103 = -192

## Question 16

Add the **signed** integers 78 and 69 using the following steps:

1. Convert both integers to 8-bit 2's complement form
	- 78 = 0100 1110
		- 78 / 2 = 39 rem 0
		- 39 / 2 = 19 rem 1
		- 19 / 2 = 9 rem 1
		- 9 / 2 = 4 rem 1
		- 4 / 2 = 2 rem 0
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
	- 69 = 0100 0101
		- 69 / 2 = 34 rem 1
		- 34 / 2 = 17 rem 0
		- 17 / 2 = 8 rem 1
		- 8 / 2 = 4 rem 0
		- 4 / 2 = 2 rem 0
		- 2 / 2 = 1 rem 0
		- 1 / 2 = 0 rem 1
2. Add the two 8-bit 2's complement representations and calculate the N and V flags
	- 0100 1110 + 0100 0101
	- = 1001 0011
		- C = 0
		- N = 1
		- V = 1
3. Use the binary output and the flags to determine whether output needs to be extended to 16-bit
	- Positive 16-bit output
4. Convert the 2's complement representation to a decimal output
	- 0000 0000 1001 0011
	- = 93<sub>16</sub>
	- = 147<sub>16</sub>
5. Check the binary output matches the decimal output
	- 78 + 69 = 147