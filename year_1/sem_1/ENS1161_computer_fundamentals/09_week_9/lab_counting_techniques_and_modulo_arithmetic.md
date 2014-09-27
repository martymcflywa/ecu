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