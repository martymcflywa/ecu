# Exercises set 9

## Question 1

State whether the following are true or false:

### A: 22 ≡ 40 (mod 9)

```
40 - 22 = 18
18 mod 9 = 0
True
```

### B: 35 ≡ 67 (mod 8)

```
67 - 35 = 32
32 mod 8 = 0
True
```

### C: 34 ≡ 44 (mod 6)

```
44 - 34 = 10
10 mod 6 = 4
False
```

### D: 15 ≡ 29 (mod 4)

```
29 - 15 = 14
14 mod 4 = 2
False
```

### E: 12 ≡ 60 (mod 3)

```
60 - 12 = 48
48 mod 3 = 0
True
```

### F: 13 ≡ 83 (mod 7)

```
83 - 13 = 70
70 mod 7 = 0
True
```

### G: -6 ≡ 2 (mod 8)

```
2 - (-6) = 8
8 mod 8 = 0
True
```

### H: -3 ≡ 11 (mod 7)

```
11 - (-3) = 14
14 mod 7 = 0
True
```

## Question 2

Find the least residues of the following:

### A: 73 (mod 7)

```
73 / 7 = 10 + remainder
73 - 7 * 10 = 3
```

### B: 28 (mod 3)

```
28 / 3 = 9 + remainder
28 - 3 * 9 = 1
```

### C: -17 (mod 6)

```
-17 / 6 = -2 + remainder
-17 - 6 * -2 = -5
-5 + 6 = 1
```

### D: 39 (mod 5)

```
39 / 5 = 7 + remainder
39 - 5 * 7 = 4
```

### E: -49 (mod 8)

```
-49 / 8 = -6 + remainder
-49 - 8 * -6 = -1
-1 + 8 = 7
```

### F: 74 (mod 4)

```
74 / 4 = 18 + remainder
74 - 4 * 18 = 2
```

## Question 3

Find the least residues of the following:

### A: 503175 (mod 11)

```
503175 / 11 = 45743 + remainder
503175 - 11 * 45743 = 2
```

### B: 673528 (mod 17)

```
673528 / 17 = 33736 + remainder
673528 - 17 * 33736 = 5
```

### C: 498236 (mod 13)

11

### D: 45210739 (mod 23)

7

### E: 664195 (mod 19)

12

### F: 7499051 (mod 29)

28

## Question 4

Find the least residues of the following:

Hint: Replace numbers by their least residues during the calculation

### A: 5342987 * 4420931 (mod 17)

10 (mod 17)

```
5342987 / 17 = 314293 + remainder
5342987 - 17 * 314293 = 6

4420931 / 17 = 260054 + remainder
4420931 - 17 * 260054 = 13

= 6 * 13 (mod 17)
= 78 (mod 17)

78 / 17 = 4 + remainder
78 - 17 * 4 = 10
```

### B: 6634826<sup>5</sup> (mod 19)

11 (mod 19)

```
6634826 / 19 = 349201 + remainder
6634826 - 19 * 349201 = 7

7^5 (mod 19)
= 16807 (mod 19)

16807 / 19 = 884 + remainder
16807 - 19 * 884 = 11
```

### C: (4399862 * 3398106)<sup>6</sup> (mod 29)

25 (mod 29)

```
4399862 / 29 = 151719 + remainder
4399862 - 29 * 151719 = 11

3398106 / 29 = 117176 + remainder
3398106 - 29 * 117176 = 2

(11 * 2)^6 (mod 29)
= 22^6 (mod 29)
= 113379904 (mod 29)

113379904 / 29 = 3909651 + remainder
113379904 - 29 * 3909651 = 25
```

## Question 5

Solve the following congruences (by trial and error, if necessary)

Formula I found, only works when there is addition at *x*:

>x + a ≡  b (mod c)  
(c + b - a) (mod c)  
= x

### A: x + 7 ≡ 4 (mod 9)

```
9 + 4 - 7 = 6
6 (mod 6) = 6

x = 6
```

### B: w + 3 ≡ 5 (mod 11)

```
11 + 5 - 3 = 13
13 (mod 11) = 2

w = 2
```

### C: y + 8 ≡ 3 (mod 13)

```
13 + 3 - 8 = 8
8 (mod 13) = 8

y = 8
```

### D: z + 6 ≡ 1 (mod 8)

```
8 + 1 - 6 = 3
3 (mod 8) = 3

z = 3
```

### E: x + 4 ≡ 3 (mod 5)

```
5 + 3 - 4 = 4
4 (mod 5) = 4

x = 4
```

### F: y + 7 ≡ 2 (mod 10)

```
10 + 2 - 7 = 5
5 (mod 10) = 5

y = 5
```

## Question 6

Solve the following congruences (by trial and error, if necessary)

### A: 5x ≡ 3 (mod 11)

```
x = 0: 0 mod 11 = 0
x = 1: 5 mod 11 = 5
x = 2: 10 mod 11 = 10
x = 3: 15 mod 11 = 4
x = 4: 20 mod 11 = 9
x = 5: 25 mod 11 = 3 ** answer
x = 6: 30 mod 11 = 8
x = 7: 35 mod 11 = 2
x = 8: 40 mod 11 = 7
x = 9: 45 mod 11 = 1
x = 10: 50 mod 11 = 6

x = 5
```

### B: 7w ≡ 5 (mod 9)

```
w = 0: 0 mod 9 = 0
w = 1: 7 mod 9 = 7
w = 2: 14 mod 9 = 5 ** answer
w = 3: 21 mod 9 = 3
w = 4: 28 mod 9 = 1
w = 5: 35 mod 9 = 8
w = 6: 42 mod 9 = 6
w = 7: 49 mod 9 = 4
w = 8: 56 mod 9 = 2

w = 2
```

### C: 9y ≡ 5 (mod 12)

```
y = 0: 0 mod 12 = 0
y = 1: 9 mod 12 = 9
y = 2: 18 mod 12 = 6
y = 3: 27 mod 12 = 3
y = 4: 36 mod 12 = 0
y = 5: 45 mod 12 = 9
y = 6: 54 mod 12 = 6
y = 7: 63 mod 12 = 3
y = 8: 72 mod 12 = 0
y = 9: 81 mod 12 = 9
y = 10: 90 mod 12 = 6
y = 11: 99 mod 12 = 3

y = no answer
```

### D: 4z ≡ 1 (mod 7)

```
z = 0: 0 mod 7 = 0
z = 1: 4 mod 7 = 4
z = 2: 8 mod 7 = 1 ** answer
z = 3: 12 mod 7 = 5
z = 4: 16 mod 7 = 2
z = 5: 20 mod 7 = 6
z = 6: 24 mod 7 = 3

z = 2
```

### E: 2x ≡ 3 (mod 5)

```
x = 0: 0 mod 5 = 0
x = 1: 2 mod 5 = 2
x = 2: 4 mod 5 = 4
x = 3: 6 mod 5 = 1
x = 4: 8 mod 5 = 3 ** answer

x = 4
```

### F: 3y ≡ 1 (mod 10)

```
y = 0: 0 mod 10 = 0
y = 1: 3 mod 10 = 3
y = 2: 6 mod 10 = 6
y = 3: 9 mod 10 = 9
y = 4: 12 mod 10 = 3
y = 5: 15 mod 10 = 5
y = 6: 18 mod 10 = 8
y = 7: 21 mod 10 = 1 ** answer
y = 8: 24 mod 10 = 4
y = 9: 27 mod 10 = 7

y = 7
```

## Question 7

Solve the following congruences.

### A: x<sup>2</sup> ≡ 5 (mod 11)

```
x = 0: 0 mod 11 = 0
x = 1: 1 mod 11 = 1
x = 2: 4 mod 11 = 4
x = 3: 9 mod 11 = 9
x = 4: 16 mod 11 = 5 ** answer
x = 5: 25 mod 11 = 3
x = 6: 36 mod 11 = 3
x = 7: 49 mod 11 = 5 ** answer
x = 8: 64 mod 11 = 9
x = 9: 81 mod 11 = 4
x = 10: 100 mod 11 = 1

x = 4 and 7
```

### B: y<sup>2</sup> ≡ 2 (mod 7)

```
y = 0: 0 mod 7 = 0
y = 1: 1 mod 7 = 1
y = 2: 4 mod 7 = 4
y = 3: 9 mod 7 = 2 ** answer
y = 4: 16 mod 7 = 2 ** answer
y = 5: 25 mod 7 = 4
y = 6: 36 mod 7 = 1

y = 3 and 4
```

### C: w<sup>2</sup> ≡ 4 (mod 12)

```
w = 0: 0 mod 12 = 0
w = 1: 1 mod 12 = 1
w = 2: 4 mod 12 = 4 ** answer
w = 3: 9 mod 12 = 9
w = 4: 16 mod 12 = 4 ** answer
w = 5: 25 mod 12 = 1
w = 6: 36 mod 12 = 0
w = 7: 49 mod 12 = 0
w = 8: 64 mod 12 = 4 ** answer
w = 9: 81 mod 12 = 9
w = 10: 100 mod 12 = 4 ** answer
w = 11: 121 mod 12 = 1

w = 2, 4, 8 and 10
```

### D: z<sup>2</sup> ≡ 3 (mod 12)

```
z = 0: 0 mod 12 = 0
z = 1: 1 mod 12 = 1
z = 2: 4 mod 12 = 4
z = 3: 9 mod 12 = 9
z = 4: 16 mod 12 = 4
z = 5: 25 mod 12 = 1
z = 6: 36 mod 12 = 0
z = 7: 49 mod 12 = 0
z = 8: 64 mod 12 = 4
z = 9: 81 mod 12 = 9
z = 10: 100 mod 12 = 4
z = 11: 121 mod 12 = 1

z = no answer
```

### E: x<sup>2</sup> ≡ 5 (mod 8)

```
x = 0: 0 mod 8 = 0
x = 1: 1 mod 8 = 1
x = 2: 4 mod 8 = 4
x = 3: 9 mod 8 = 1
x = 4: 16 mod 8 = 0
x = 5: 25 mod 8 = 1
x = 6: 36 mod 8 = 4
x = 7: 49 mod 8 = 1

x = no answer
```

### F: w<sup>2</sup> ≡ 10 (mod 13)

```
w = 0: 0 mod 13 = 0
w = 1: 1 mod 13 = 1
w = 2: 4 mod 13 = 4
w = 3: 9 mod 13 = 9
w = 4: 16 mod 13 = 3
w = 5: 25 mod 13 = 12
w = 6: 36 mod 13 = 10 ** answer
w = 7: 49 mod 13 = 10 ** answer
w = 8: 64 mod 13 = 12
w = 9: 81 mod 13 = 3
w = 10: 100 mod 13 = 9
w = 11: 121 mod 13 = 4
w = 12: 144 mod 13 = 1

w = 6 and 7
```

### G: y<sup>2</sup> ≡ 3 (mod 6)

```
y = 0: 0 mod 6 = 0
y = 1: 1 mod 6 = 1
y = 2: 4 mod 6 = 4
y = 3: 9 mod 6 = 3 ** answer
y = 4: 16 mod 6 = 4
y = 5: 25 mod 6 = 1

y = 3
```

### H: z<sup>2</sup> ≡ 5 (mod 6)

```
z = 0: 0 mod 6 = 0
z = 1: 1 mod 6 = 1
z = 2: 4 mod 6 = 4
z = 3: 9 mod 6 = 3
z = 4: 16 mod 6 = 4
z = 5: 25 mod 6 = 1

z = no answer
```

## Question 8

Start with the seed x<sub>0</sub> = 47 and generate 10 pseudo-random numbers using the formula

>x<sub>n</sub> = 47 x<sub>n-1</sub> (mod 100)

```
 x_1 ≡ 47 x_0 ≡ 47 * 47 ≡ 2209 ≡ 9 (mod 100)
 x_2 ≡ 47 x_1 ≡ 47 * 2209 ≡ 103823 ≡ 23 (mod 100)
 x_3 ≡ 47 x_2 ≡ 47 * 103823 ≡ 4879681 ≡ 81 (mod 100)
 x_4 ≡ 47 x_3 ≡ 47 * 4879681 ≡ 229345007 ≡ 7 (mod 100)
 x_5 ≡ 47 x_4 ≡ 47 * 229345007 ≡ 10779215329 ≡ 29 (mod 100)
 x_6 ≡ 47 x_5 ≡ 47 * 10779215329 ≡ 506623120463 ≡ 63 (mod 100)
 x_7 ≡ 47 x_6 ≡ 47 * 506623120463 ≡ 23811286661761 ≡ 61 (mod 100)
 x_8 ≡ 47 x_7 ≡ 47 * 23811286661761 ≡ 1119130473102767 ≡ 67 (mod 100)
 x_9 ≡ 47 x_8 ≡ 47 * 1119130473102767 ≡ 52599132235830049 ≡ 49 (mod 100)
x_10 ≡ 47 x_9 ≡ 47 * 52599132235830049 ≡ 2472159215084012303 ≡ 3 (mod 100)
```

## Question 9

Start with the seed x<sub>0</sub> = 19 and generate 10 pseudo-random number using the formula

>x<sub>n</sub> = 19 x<sub>n-1</sub> (mod 100)

```
 x_1 ≡ 19 x_0 ≡ 19 * 19 ≡ 361 ≡ 61 (mod 100)
 x_2 ≡ 19 x_1 ≡ 19 * 361 ≡ 6859 ≡ 59 (mod 100)
 x_3 ≡ 19 x_2 ≡ 19 * 6859 ≡ 130321 ≡ 21 (mod 100)
 x_4 ≡ 19 x_3 ≡ 19 * 130321 ≡ 2476099 ≡ 99 (mod 100)
 x_5 ≡ 19 x_4 ≡ 19 * 2476099 ≡ 47045881 ≡ 81 (mod 100)
 x_6 ≡ 19 x_5 ≡ 19 * 47045881 ≡ 893871739 ≡ 39 (mod 100)
 x_7 ≡ 19 x_6 ≡ 19 * 893871739 ≡ 16983563041 ≡ 41 (mod 100)
 x_8 ≡ 19 x_7 ≡ 19 * 16983563041 ≡ 322687697779 ≡ 79 (mod 100)
 x_9 ≡ 19 x_8 ≡ 19 * 322687697779 ≡ 6131066257801 ≡ 1 (mod 100)
x_10 ≡ 19 x_9 ≡ 19 * 6131066257801 ≡ 116490258898219 ≡ 19 (mod 100)
```

## Question 10

Start with the seed x<sub>0</sub> = 2345 and generate 6 pseudo-random numbers using the formula

>x<sub>n</sub> = 2345 x<sub>n-1</sub> (mod 65536)

```
x_1 ≡ 2345 x_0 ≡ 2345 * 2345 ≡ 5499025 ≡ 59537 (mod 65536)
x_2 ≡ 2345 x_1 ≡ 2345 * 5499025 ≡ 12895213625 ≡ 22585 (mod 65536)
x_3 ≡ 2345 x_2 ≡ 2345 * 12895213625 ≡ 30239275950625 ≡ 8737 (mod 65536)
x_4 ≡ 2345 x_3 ≡ 2345 * 30239275950625 ≡ 70911102104215625 ≡ 41033 (mod 65536)
x_5 ≡ 2345 x_4 ≡ 2345 * 70911102104215625 ≡ 166286534434385640625 ≡ 15537 (mod 65536)
x_6 ≡ 2345 x_5 ≡ 2345 * 166286534434385640625 ≡ 389941923248634327265625 ≡ 61785 (mod 65536)
```

## Question 11

Calculate 7<sup>134</sup> (mod 23)

```
// convert 134 to binary
134 / 8 = 16 rem 6
16 / 8 = 2 rem 0
2 / 8 = 0 rem 2

134_10 = 206_8 = 10000110_2

134 = 128 + 4 + 2

// find least residual for each applicable power
7^128 ≡ 18 (mod 23)
7^4 ≡ 9 (mod 23)
7^2 ≡ 3 (mod 23)
```

>7<sup>134</sup> ≡ 7<sup>128</sup> * 7<sup>4</sup> * 7<sup>2</sup> ≡ 18 * 9 * 3 ≡ 486 ≡ 3 (mod 23)  
7<sup>134</sup> ≡ 3 (mod 23)

## Question 12

Calculate 13<sup>77</sup> (mod 19)

```
// convert 77 to binary
77 / 8 = 9 rem 5
9 / 8 = 1 rem 1
1 / 8 = 0 rem 1

77_10 = 115_8 = 1001101_2

77 = 64 + 8 + 4 + 1

// find least residual for each applicable power
13^64 ≡ 6 (mod 19)
13^8 ≡ 16 (mod 19)
13^4 ≡ 4 (mod 19)
13^1 ≡ 13 (mod 19)
```

>13<sup>77</sup> ≡ 13<sup>64</sup> * 13<sup>8</sup> * 13<sup>4</sup> * 13<sup>1</sup> ≡ 6 * 16 * 4 * 13 ≡ 4992 ≡ 14 (mod 19)  
7<sup>134</sup> ≡ 14 (mod 23)

## Question 13

Consider the set of 4-digit numbers from 1000 to 9999

- T denotes the set of elements that begin with 34
- F denotes the set of elements that begin with 56

### 1: How many of the numbers begin with the digits 34?

>n(T) = 100

### 2: How many of the numbers end with the digits 56?

>n(F) = 90

### 3: How many of the numbers begin with 34 and end with 56?

>n(T ∩ F) = 1

### 4: How many of the numbers begin with 34 or end with 56, or both?

>n(T ∪ F) = n(T) + n(F) - n(T ∩ F) = 100 + 90 - 1 = 189

### 5: How many of the numbers begin with 34 or end with 56, but not both?

>n(T ∪ F) - n(T ∩ F) = 189 - 1 = 188

### 6: How many of the numbers neither begin with 34 nor end with 56?

>n(T' ∪ F') = 9000 - 189 = 8811

## Question 14

Consider the set of whole numbers from 1 - 100

- F denotes the set of elements that are multiples of 5
- E denotes the set of elements that are multiples of 8

### 1: How many of the numbers are multiples of 5?

>n(F) = 100 / 5 = 20

### 2: How many of the numbers are multiples of 8?

>n(E) = 100 / 8 = 12 **ignored remainder

### 3: How many of the numbers are multiples of 5 and multiples of 8?

>n(F ∩ E) = 2 (40 and 80)

### 4: How many of the numbers are either multiples of 5 or else multiples of 8?

>n(F ∩ E') + n(F' ∩ E) - n(F ∩ E) = 20 + 12 - 2 = 30

### 5: How many of the numbers are neither multiples of 5 nor multiples of 8?

>n(F' ∪ E') = S - (n(F ∩ E') + n(F' ∩ E)) = 100 - 30 = 70

## Question 15

Consider a 100-page book with pages numbered from 1 to 100

- Z denotes the set of pages that contain a 0
- E denotes the set of pages that contain an 8

### 1: On how many pages would the page number contain a 0?

>n(Z) = 10

### 2: How many times would the digit 0 be printed?

11

### 3: On how many pages would the page number contain an 8?

>n(E) = 19

### 4: How many times would the digit 8 be printed?

20

## Question 16

How many 8-bit binary numbers are there? From 0000 0000 to 1111 1111

8 sequences of 2 objects.

```
2^8 = 256
```

## Question 17

Suppose an assembly langauge uses o-codes with 3 letters such as LDA, ADA, DEB, INX etc. If all 26 letters of the alphabet are used, how many different op-codes can be represented.

3 sequences of 26 objects.

```
26^3 = 17576
```

## Question 18

A salesperson has to visit 8 different towns exactly once. In how many ways can this be done? Assume that each town is connected directly to every other town.

```
Because there is only one permutation of 8 objects...
8! = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
= 40320
```

## Question 19

Numbers are to be formed from the digits 1, 2, 3 and 4, and repititions are not permitted.

### 1: How many possible 3-digit numbers are there?

4 permutations of 3 objects.

```
4! = 4 * 3 * 2 * 1
= 24
```

### 2: How many possible even 3-digit numbers are there?

Only numbers ending with 2 or 4 are even.  
The first 2 digits can be permutations, the last digit is fixed.

```
4 objects minus 1 because the last digit is fixed

Numbers ending with 2
3! = 3 * 2 * 1
= 6

Numbers ending with 4
3! = 3 * 2 * 1
= 6

6 + 6
= 12
```

### 3: How many possible 3-digit numbers are there that are not greater than 200?

First digit has to be 1 to be less than 200.  
The first digit is fixed, the last two digits can be permutations.

```
4 objects minus 1 because the first digit is fixed

Numbers under 200
3! = 3 * 2 * 1
= 6
```

### 4: How many possible 3-digit numbers are there that are not greater than 400?

The first digit can only either 1, 2 or 3

```
1 as first digit
3! = 3 * 2 * 1
= 6

2 as first digit
3! = 3 * 2 * 1
= 6

3 as first digit
3! = 3 * 2 * 1
= 6

6 + 6 + 6 = 18
```

## Question 20

Repeat Question 19 assuming repetitions are permitted.

### 1: How many possible 3-digit numbers are there?

3 digit number, 4 possible numbers for each digit.

```
4^3 = 64
```

### 2: How many possible even 3-digit numbers are there?

Only numbers ending with 2 or 4 are even.

```
Numbers ending with 2
4^2 = 16

Numbers ending with 4
4^2 = 16

16 + 16 = 32
```

### 3: How many possible 3-digit numbers are there that are not greater than 200?

Only numbers beginning with 1 are less than 200.

```
Numbers beginning with 1
4^2 = 16
```

### 4: How many possible 3-digit numbers are there that are not greater than 400?

Only numbers beginning with 1, 2 or 3 are less than 400.

```
Numbers beginning with 1
4^2 = 16

Numbers beginning with 2
4^2 = 16

Numbers beginning with 3
4^2 = 16

16 + 16 + 16 = 48
```

## Question 21

How many permutations are there of the letters DYNAMO?

```
P(6, 4) 
= 6! / (6 - 4)! 
= 6! / 2! 
= 720 / 2
= 360
```

## Question 22

There are 16 teams in a competition. At the end of the season, how many different arrangements could there be for the top 6?

```
P(16, 4)
= 16! / (16 - 6)!
= 16! / 10!
= 20922789888000 / 3628800
= 5765760
```

## Question 23

How many permutations are there of the letters in the word ORANGE?

```
6! = 720
```

## Question 24

How many 5-subsets are there of {a, b, c, d, e, f}?

```
P(6, 5)
= 6! / 5! * (6 - 5)!
= 6! / 5!
= 720 / 120
= 6
```

## Question 25

In a lottery, a player must select 6 numbers from 36. The winning draw is made by a mechanical selection of 6 marbles from a barrel of 36 marbles, numbered 1 to 36. If the player's selection matches the draw in any order, s/he wins. How many possible selections can a player make?

```
P(36, 6)
= 36! / 6! * (36 - 6)!
= 36! / 6! * 30!

In calculator:
36! / (6! * 30!) = 1947792

Do the factorials as they come, not after any operations,
otherwise answer will be wrong.
```

## Question 26

A and B are points on opposite corners of the grid as shown:

![grid q26](http://i.imgur.com/hs4QQCO.png)

How many shortest paths aret here from A to B?

Hint: For the shortest path you can only travel North or East. So there must be 6 steps to the East and 4 steps to the North. If you choose which four steps will be to the North, there will be no choice for the 6 steps to the East.

Problem is permutation.

Total squares to travel is 10 = objects 
Steps North dictates steps East = 4 permutations

```
P(10, 4)
= 10! / 4! * (10 - 4)!
= 10! / 4! * 6!
= 3628800 / (24 * 720)
= 21
```

## Question 27

In a certain programming language, variable names must start with a letter and the subsequent characters may be upper case letters or decimal digits.

Problem is sequence.

### 1: Find the number of possible 2-character variable names

```
1st character = 26
2nd character = 36

26 * 36 = 936
```

### 2: Find the number of possible 3-character variable names

```
1st character = 26
2nd character = 36
3rd character = 36

26 * 36^2 = 33696
```

## Question 28

A student must answer 3 out of 5 questions in a test.

Problem is subset.

### 1: How many choices does she have?

```
P(5, 3)
= 5! / 3! * (5 - 3)!
= 5! / 3! * 2!
= 120 / 6 * 2
= 120 / 12
= 10
```

### 2: How many choices does she have if she must answer the first question and two of the remaining questions?

```
P(4, 2)
= 4! / 2! * (4 - 2)!
= 4! / 2! * 2!
= 24 / 2 * 2
= 24 / 4
= 6
```

### 3: How many choices does she have if she must answer one of the first two questions and two of the remaining questions?

```
2 choices * 3 choices
= 6
```

## Question 29

Passwords for a certain computer system are of two types, restricted and unrestricted. The first character of a restricted password is R, and the first character of an unrestricted password is U. If restricted, the password has 3 more characters, all alphabetic. If unrestricted, the password has 4 more characters, which are decimal digits. How many possible passwords are there?

Problem is subset.

```
// restricted passwords
26^3 = 17576

// unrestricted
10^4 = 10000

17576 + 10000 = 27576
```

## Question 30

How many 8-bit binary numbers begin with 001

Problem is sequence.

```
2 objects, 5 sequences
2^5 = 32
```

## Question 31

How many 4-digit numbers from 1000 to 4999 are multiples of 5? Multiples of 5 end in 5 or 0.

Problem is sequence.

```
1st digit = 4 choices
2nd digit = 10 choices
3rd digit = 10 choices
4th digit = 2

4 * 10 * 10 * 2 = 800
```

## Question 32

Find the number of 7-permutations of HEXAGON that start with A, or end with NX, or start with A and end with NX.

Problem is permutation.

7 objects.

```
// starting with A
6! = 720

// ending with NX
5! = 120

// start with A and end with NX
!4 = 24

720 + 120 - 24 = 816
Minus 24 else counting them twice!
```

## Question 33

Find the number of 16-bit binary strings that start with 0101, or end with 001110, or start with 0101 and end with 001110.

```
// start with 0101
16 - 4 = 12
2^12 = 4096

// end with 001110
16 - 6 = 10
2^10 = 1024

// start with 0101 and end with 001110
16 - 10 = 6
2^6 = 64

4096 + 1024 - 64 = 5056
Minus 64 else counting them twice!
```