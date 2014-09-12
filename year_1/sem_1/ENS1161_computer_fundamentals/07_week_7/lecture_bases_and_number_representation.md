# Bases and Number Representation

## The decimal number system

We are familiar with the decimal number system, which is based on the number 10 (probably because we have 10 fingers).

The decimal system uses positional notation.

For example:

345 represents:  
3 * 100 + 5 * 10 + 4 * 1  
= 3 * 10<sup>2</sup> + 5 * 10 + 4 * 1

whereas

435 represents: 4 * 100 + 3 * 10 + 5 * 1

In the decimal number system we use 10 different symbols to represent numbers, which are:

0, 1, 2, 3, 4, 5, 6, 7, 8, 9.

## Use of subscripts

In the following notes, different subscripts may be used to indicate the number system and hence avoid ambiguity.

For example:

- 354<sub>10</sub> represents a decimal number
- 354<sub>8</sub> represents an octal number
- 1001010<sub>2</sub> represents a binary number
- 354<sub>16</sub> represents a hexadecimal number

## The octal number system

In the octal system, which is also positional,

- 354 means 3 * 8<sup>2</sup> + 5 * 8 + 4 * 1 which is equal to 236<sub>10</sub>
- 435 means 4 * 8<sup>2</sup> + 3 * 8 + 5 * 1 which is equal to 285<sub>10</sub>

Octal uses only 8 symbols 0, 1, 2, 3, 4, 5, 6, 7.

Here are some octal numbers and their decimal equivalents:

| Octal | Meaning                           | Decimal |
|------:|-----------------------------------|---------|
| 35    | 3 * 8 + 5 * 1                     | 29      |
| 54    | 5 * 8 + 4 * 1                     | 44      |
| 77    | 7 * 8 + 7 * 1                     | 63      |
| 261   | 2 * 8<sup>2</sup> + 6 * 8 + 1 * 1 | 177     |

### Counting in octal

| 64 | 8 | 1 | Decimal |
|:--:|:-:|:-:|:--------|
|    |   | 0 | 0       | 
|    |   | 1 | 1       |
|    |   | 2 | 2       |
|    |   | - | -       |
|    |   | 7 | 7       |
|    | 1 | 0 | 8       |
|    | 1 | 1 | 9       |
|    | - | - | -       |
|    | 1 | 7 | 15      |
|    | 2 | 0 | 16      |
|    | 2 | 1 | 17      |
|    | - | - | -       |
|    | 7 | 7 | 63      |
| 1  | 0 | 0 | 64      |
| 1  | 0 | 1 | 65      |
| -  | - | - | -       |
| 1  | 7 | 7 | 127     |
| 2  | 0 | 0 | 128     |

### Conversion from decimal to octal

The algorithm is:

>Divide by 8 until the answer is 0, then read the remainders in reverse order

#### Example 1: Convert 171<sub>10</sub> to octal

When we divide 171 repeatedly by 8, we get:

| 8 | 171        |
|:-:|------------|
| 8 | 21 + rem 3 |
| 8 | 2 + rem 5  |
| 8 | 0 + rem 2  |

The remainders in reverse order are: 2, 5 and 3  
So 171<sub>10</sub> = 253<sub>8</sub>

Why does this method work?

171 = 21 * 8 + 3 and  
21 = 2 * 8 + 5, so  
171 = ((2 * 8) + 5) * 8 + 3  
therefore 171 = 2 * 8<sup>2</sup> + 5 * 8 + 3

#### Example 2: Covert 278<sub>10</sub> to octal

| 8 | 278      |
|:-:|----------|
| 8 | 34 mod 6 |
| 8 | 4 mod 2  |
| 8 | 0 mod 4  |

So 278<sub>10</sub> = 426<sub>8</sub>

We can check this by:

426<sub>8</sub>  
= 4 * 64 + 2 * 8 + 6 * 1  
= 278<sub>10</sub>

### Conversion from octal to decimal

To convert from octal to decimal, we simply recall that each octal digit represents a particular power of 8.

#### Example 1: Convert 213<sub>8</sub> to decimal

213<sub>8</sub>  
= 2 * 8<sup>2</sup> + 1 * 8 + 3 * 1  
= 2 * 64 + 1 * 8 + 3 * 1  
= 139<sub>10</sub>

#### Example 2: Convert 467<sub>8</sub> to decimal

467<sub>8</sub>  
= 4 * 8<sup>2</sup> + 6 * 8 + 7 * 1  
= 4 * 64 + 6 * 8 + 7 * 1  
= 311<sub>10</sub>

#### Example 3: Convert 4276<sub>8</sub> to decimal

4276<sub>8</sub>  
= 4 * 8<sup>3</sup> + 2 * 8<sup>2</sup> + 7 * 8 + 6 * 1  
= 4 * 512 + 2 * 64 + 7 * 8 + 6 * 1  
= 2238<sub>10</sub>

In fact there is a more convenient way to evaluate longer expressions such as example 3, especially if you are using a calculator:

4276<sub>8</sub>  
= (((4 * 8) + 2) * 8 + 7) * 8 + 6  
= 2238<sub>10</sub>

## The binary number system

The binary number system is based on the number 2. It also uses positional notation. In this system, there are only two symbols, 0 and 1.

So for example, the binary number 101 represents:  
1 * 2<sup>2</sup> + 0 * 2 + 1 * 1  
= 5<sub>10</sub>

And the binary number 1101 represents:  
1 * 2<sup>3</sup> + 1 * 2<sup>2</sup> + 0 * 2 + 1 * 1  
= 13<sub>10</sub>

Here are some binary numbers and their decimal equivalents:

| Binary   | Meaning                 | Decimal |
|---------:|-------------------------|---------|
| 111      | 4 + 2 + 1               | 7       |
| 1001     | 8 + 0 + 0 + 1           | 9       |
| 110011   | 32 + 16 + 0 + 0 + 2 + 1 | 51      |
| 10000000 | 120 + 0 + ... + 0       | 128     |

### Counting binary

| 16 | 8 | 4 | 2 | 1 | Decimal |
|:--:|:-:|:-:|:-:|:-:|:--------|
| 0  | 0 | 0 | 0 | 0 | 0       |
| 0  | 0 | 0 | 0 | 1 | 1       |
| 0  | 0 | 0 | 1 | 0 | 2       |
| 0  | 0 | 0 | 1 | 1 | 3       |
| 0  | 0 | 1 | 0 | 0 | 4       |
| 0  | 0 | 1 | 0 | 1 | 5       |
| 0  | 0 | 1 | 1 | 0 | 6       |
| 0  | 0 | 1 | 1 | 1 | 7       |
| 0  | 1 | 0 | 0 | 0 | 8       |
| 0  | 1 | 0 | 0 | 1 | 9       |
| 0  | 1 | 0 | 1 | 0 | 10      |
| 0  | 1 | 0 | 1 | 1 | 11      |
| 0  | 1 | 1 | 0 | 0 | 12      |
| 0  | 1 | 1 | 0 | 1 | 13      |
| 0  | 1 | 1 | 1 | 0 | 14      |
| 0  | 1 | 1 | 1 | 1 | 15      |
| 1  | 0 | 0 | 0 | 0 | 16      |
| 1  | 0 | 0 | 0 | 1 | 17      |
| 1  | 0 | 0 | 1 | 0 | 18      |
| 1  | 0 | 0 | 1 | 1 | 19      |
| 1  | 0 | 1 | 0 | 0 | 20      |
| 1  | 0 | 1 | 0 | 1 | 21      |
| 1  | 0 | 1 | 1 | 0 | 22      |
| 1  | 0 | 1 | 1 | 1 | 23      |
| 1  | 1 | 0 | 0 | 0 | 24      |
| 1  | 1 | 0 | 0 | 1 | 25      |
| 1  | 1 | 0 | 1 | 0 | 26      |
| 1  | 1 | 0 | 1 | 1 | 27      |
| 1  | 1 | 1 | 0 | 0 | 28      |
| 1  | 1 | 1 | 0 | 1 | 29      |
| 1  | 1 | 1 | 1 | 0 | 30      |
| 1  | 1 | 1 | 1 | 1 | 31      |

### Conversion from decimal to binary

#### Method 1:

>Divide by 2 until the answer is 0, then read the remainders in reverse order.

##### Example 1: Convert 58<sub>10</sub> to binary

| 2 | 58       |
|:-:|----------|
| 2 | 29 rem 0 |
| 2 | 14 rem 1 |
| 2 | 7 rem 0  |
| 2 | 3 rem 1  |
| 2 | 1 rem 1  |
| 2 | 0 rem 1  |

The remainders in reverse order are 1, 1, 1, 0, 1, 0.

Therefore 58<sub>10</sub> = 111010<sub>2</sub>

We can check this by:

111010<sub>2</sub>  
= 32 + 16 + 8 + 0 + 2 + 0  
= 58<sub>10</sub>

#### Method 2:

An alternative and much quicker method is to use octal.

First you need to know the binary equivalents of the numbers 0 through 7.

| Base10 | Base2 |
|-------:|-------|
| 0      | 000   |
| 1      | 001   |
| 2      | 010   |
| 3      | 011   |
| 4      | 100   |
| 5      | 101   |
| 6      | 110   |
| 7      | 111   |

Convert the decimal number to octal, then replace each octal digit by its binary equivalent.

| 8 | 58      |
|:-:|---------|
| 8 | 7 rem 2 |
| 8 | 0 rem 7 |

Reading the remainders in reverse order we get 58<sub>10</sub> = 72<sub>8</sub>

Now replace each octal digit with the corresponding binary equivalent.

In this case, replace 7 with 111 and 2 with 010.

So 58<sub>10</sub>  
= 72<sub>8</sub>  
= 111010<sub>2</sub>

##### Example 1: Convert 370<sub>10</sub> to binary

First convert to octal:

| 8 | 370
|:-:|----------|
| 8 | 46 rem 2 |
| 8 | 5 rem 6  |
| 8 | 0 rem 5  |

Now replace each octal digit with the corresponding binary equivalent.

So 370<sub>10</sub>  
= 562<sub>8</sub>  
= 101110010<sub>2</sub>

## Converting binary to decimal

### Method 1

Add up the powers of 2.

#### Example 1: Convert 10111001<sub>2</sub> to decimal

10111001<sub>2</sub>  
= 2<sup>7</sup> + 2<sup>5</sup> + 2<sup>4</sup> + 2<sup>3</sup> + 1  
= 128 + 32 + 16 + 8 + 1  
= 185<sub>10</sub>  

#### Example 2: Convert 101111011<sub>2</sub> to decimal

101111011<sub>2</sub>  
= 2<sup>8</sup> + 2<sup>6</sup> + 2<sup>5</sup> + 2<sup>4</sup> + 2<sup>3</sup> + 2 + 1  
= 256 + 64 + 32 + 16 + 8 + 2 + 1  
= 379<sub>10</sub>  

#### Example 3: Convert 111100<sub>2</sub> to decimal

111100<sub>2</sub>  
= 2<sub>5</sub> + 2<sub>4</sub> + 2<sub>3</sub> + 2<sub>2</sub>  
= 32 + 16 + 8 + 4  
= 60<sub>10</sub>

### Method 2

Convert to octal first, then to decimal.

Separate groups of three binary digits, starting at the units digit. Then replace each group of three binary digits by its octal equivalent.

| Base10 | Base2 |
|-------:|-------|
| 0      | 000   |
| 1      | 001   |
| 2      | 010   |
| 3      | 011   |
| 4      | 100   |
| 5      | 101   |
| 6      | 110   |
| 7      | 111   |

#### Example 1: Convert 10111001<sub>2</sub> to decimal

`10` `111` `001`  
= 271<sub>8</sub>  
= 2 * 64 + 7 * 8 + 1  
= 185<sub>10</sub>  

#### Example 2: Convert 101111011<sub>2</sub> to decimal

`101` `101` `011`  
= 573<sub>8</sub>  
= 5 * 64 + 7 * 8 + 3  
= 379<sub>10</sub>

#### Example 3: Convert 111100<sub>2</sub> to decimal

`111` `100`  
= 74<sub>8</sub>  
= 7 * 8 + 4  
= 60<sub>10</sub>

## The hexadecimal number system

This system is based on the number 16. Its main purpose is to help us cope with long strings of binary digits. For example, supposed we had to remember the binary number:

00101101111100111000110001001011

We would find it much easier to work with its hex equivalent

2DF38C4B

| 16<sup>3</sup> | 16<sup>2</sup> | 16 | 1 | Base10 |
|:--------------:|:--------------:|:--:|:-:|--------|
|                |                | 1  | 5 | 21     |
|                | 1              | 0  | 3 | 259    |
|                |                | 5  | 7 | 87     |
| 1              | 0              | 0  | 0 | 4096   |
|                |                | 4  | 6 | 70     |

Hexadecimal uses 16 symbols.

- 0 to 9: same meaning
- A = 10
- B = 11
- C = 12
- D = 13
- E = 14
- F = 15

5C<sub>16</sub>  
= 5 * 16 + 12  
= 92<sub>10</sub>

1AF<sub>16</sub>  
= 1 * 16<sup>2</sup> + 10 * 16 + 15 * 1  
= 431<sub>10</sub>  

345<sub>16</sub>  
= 837<sub>10</sub>

1AF<sub>16</sub>  
= 431<sub>10</sub>

### Hexadecimal examples

Here are some more hex numbers and their base 10 equivalents.

**Note:**  
16<sup>2</sup> = 256  
16<sup>3</sup> = 4096

| Hex  | Meaning                                | Base10 |
|-----:|----------------------------------------|--------|
| 2B7  | 2 * 256 + 11 * 16 + 7 * 1              | 695    |
| 496  | 4 * 256 + 9 * 16 + 6 * 1               | 1174   |
| FE   | 15 * 16 + 14 * 1                       | 254    |
| CB4D | 12 * 4096 + 11 * 256 + 4 * 16 + 13 + 1 | 52045  |

### Counting in hexadecimal

| 16<sub>3</sub> | 16<sub>2</sub> | 16 | 1 | Base10 |
|:--------------:|:--------------:|:--:|:-:|:-------|
| 0              | 0              | 0  | 0 | 0      |
| 0              | 0              | 0  | 1 | 1      |
| 0              | 0              | 0  | 2 | 2      |
| -              | -              | -  | - | -      |
| 0              | 0              | 0  | 9 | 9      |
| 0              | 0              | 0  | A | 10     |
| -              | -              | -  | - | -      |
| 0              | 0              | 0  | F | 15     |
| 0              | 0              | 1  | 0 | 16     |
| 0              | 0              | 1  | 1 | 17     |
| -              | -              | -  | - | -      |
| 0              | 0              | 1  | D | 29     |
| 0              | 0              | 1  | E | 30     |
| 0              | 0              | 1  | F | 31     |
| 0              | 0              | 2  | 0 | 32     |
| -              | -              | -  | - | -      |
| 0              | 0              | 9  | F | 159    |
| 0              | 0              | A  | 0 | 160    |
| -              | -              | -  | - | -      |
| 0              | 0              | F  | F | 255    |
| 0              | 1              | 0  | 0 | 256    |
| -              | -              | -  | - | -      |
| F              | F              | F  | F | 65535  |

### Converting hex to binary

First we need to be familiar with the binary equivalents of the hex numbers 0 through F. These are:

| Base16 | Base2 |
|-------:|:------|
| 0      | 0000  |
| 1      | 0001  |
| 2      | 0010  |
| 3      | 0011  |
| 4      | 0100  |
| 5      | 0101  |
| 6      | 0110  |
| 7      | 0111  |
| 8      | 1000  |
| 9      | 1001  |
| A      | 1010  |
| B      | 1011  |
| C      | 1100  |
| D      | 1101  |
| E      | 1110  |
| F      | 1111  |

Then it is simply a matter of replacing each hexadecimal digit by the corresponding four binary digits.

### Converting binary to hex

To convert a binary integer to hex, separate binary digits into groups of four, starting at the units digit, and then replace each group by its hexadecimal equivalent.

#### Example 1: Convert 101111101010110011<sub>2</sub> to hex

10 1111 1010 1011 0011<sub>2</sub>  
= 2FAB2<sub>16</sub>

#### Example 2: 1111100001011101101<sub>2</sub> to hex

1111100001011101101<sub>2</sub>  
= 7C2ED<sub>16</sub>

### Converting between hex and decimal

Sometimes it is convenient to be able to convert from simpl hex numbers to decimal or vice versa.

For conversions such as these, it helps to know or at least be familiar with the multiples of 16.

#### Examples

| Base16 | Meaning     | Base10 |
|-------:|-------------|--------|
| 3C     | 3 * 16 + 12 | 60     |
| 54     | 5 * 16 + 4  | 84     |
| F6     | 15 * 16 + 6 | 246    |

To convert decimal 43 to hex:

43 / 16  
2 * 16 = 32  
43 / 16 = 2 rem 11  
So 43 = 2 * 16 + 11  
Therefore, 43 in decimal becomes 2B in hex.

To convert decimal 77 to hex:

77 / 16  
4 * 16 = 64  
77 / 16 = 4 rem 13  
So 77 = 4 * 16 + 13  
Therefore, 77 in decimal becomes 4D in hex.

## Representation of binary fractions

Now we consider fractions in binary. The concepts are analogous to those in the decimal system.

In the decimal system, the columns to the right of the decimal point represent

![binary frac ex 1](http://i.imgur.com/B2F5Y0x.png)

Here are some decimal numbers with both integer parts and fractional parts:

![binary frac ex 2](http://i.imgur.com/LoSzgzQ.png)

For example, the decimal number 0.324 means:

![binary frac ex 3](http://i.imgur.com/fQSvbwM.png)

Notice that the fraction 0.324 has 3 places, and so the last place represents:

![binary frac ex 4](http://i.imgur.com/s9b4Egu.png)

In the binary system, the columns to the right of the point represent:

![binary frac ex 5](http://i.imgur.com/uwzqZSE.png)

Here are some binary numbers with both integer parts and fractional parts:

![binary frac ex 6](http://i.imgur.com/FwRd9le.png)

In the binary system, for example:

0.1101<sub>2</sub> means:

![binary frac ex 7](http://i.imgur.com/IW3ljei.png)

or:

![binary frac ex 8](http://i.imgur.com/pu9rQq4.png)

= 0.8125<sub>10</sub>

In another example:

0.10011<sub>2</sub> means:

![binary frac ex 9](http://i.imgur.com/pZ2OLRD.png)

or:

![binary frac ex 10](http://i.imgur.com/LvJlz2J.png)

= 0.59375<sub>10</sub>

### Converting decimal fractions to binary

The usual method is:

Repeatedly multiply the digits to the right of the decimal point by 2, until only zeros remain. Then read the integer parts of the successive answers.

#### Example 1: Convert the decimal fraction 0.34375 to binary

![bin frac convert 1](http://i.imgur.com/HGFEyHq.png)

So 0.34375<sub>10</sub> = 0.01011<sub>2</sub>

#### Example 2: Convert the decimal fraction 0.453125 to binary

![bin frac convert 2](http://i.imgur.com/2PPAzZy.png)

So 0.453125<sub>10</sub> = 0.011101<sub>2</sub>

#### Example 3: Convert the decimal fraction 0.65625 to binary

![bin frac convert 2](http://i.imgur.com/qj6WD9A.png)

So 0.65625<sub>10</sub> = 0.10101<sub>2</sub>

### Simplified method

Ignore the point and convert the fractional part to decimal number. Then divide this by the appropriate power of 2 as given by the number of places in the fractional part.

#### Example 1: Convert 0.110011<sub>2</sub> to decimal

Ignoring the point, 110011<sub>2</sub> = 51<sub>10</sub>.

Now the fraction has 6 places, so we must divide by 2<sup>6</sup> = 64.

Therefore, 0.110011<sub>2</sub> = 

![simple bin frac 1](http://i.imgur.com/PjmjstP.png)

= 0.796875<sub>10</sub>

#### Example 2: Convert 0.11101<sub>2</sub> to decimal

Ignoring the point, 11101<sub>2</sub> = 29<sub>10</sub>.

Now the fraction has 5 places, so we must divide by 2<sup>5</sup> = 32.

Therefore, 0.11101<sub>2</sub> = 

![simple bin frac 2](http://i.imgur.com/kebye04.png)

= 0.90625<sub>10</sub>

#### Example 3: Convert 0.001010101<sub>2</sub> to decimal

1010101<sub>2</sub> = 85<sub>10</sub>.

The fraction has 9 places, so divide 85 by 2<sup>9</sup> = 512.

Therefore, 0.001010101<sub>2</sub> =

![simple bin frac 3](http://i.imgur.com/KDhR0QU.png)

= 0.166015625<sub>10</sub>

#### Example 4: Convert 0.00000101<sub>2</sub> to decimal

101<sub>2</sub> = 5<sub>10</sub>.

The fraction has 8 places, so we must divide 5 by 2<sup>8</sup> = 256.

Therefore, 0.00000101<sub>2</sub> =

![simple bin frac 4](http://i.imgur.com/UXtmRdA.png)

= 0.01953125<sub>10</sub>

## Summary of number conversion

![summary 1](http://i.imgur.com/s38INpJ.png)

![summary 2](http://i.imgur.com/nQGAfKk.png)

![summary 3](http://i.imgur.com/qS24JN4.png)

## Arithmetic using other number systems

We are mainly concerned with the addition of two numbers. An example in the decimal system:

![add base10](http://i.imgur.com/SD9D0am.png)

In the 1st column, 8 + 5 = 13, so put down 3 and carry the 1.  
In the 2nd column, 3 + 8 + 1 = 12, so put down 2 and carry the 1.

### Addition in octal

Remember that in octal the digits represent 1, 8, 8<sup>2</sup>, 8<sup>3</sup>, and so on.

So if the sum of the two digits in the 1's colum is 8 or more, there will be a carry of 1 into the next column, and so on.

#### Example 1:

![add octal ex 1](http://i.imgur.com/Hx4tWVA.png)

In the 1st column, 7<sub>8</sub> + 5<sub>8</sub> = 14<sub>8</sub>, so carry the 1.  
In the 2nd column, 6<sub>8</sub> + 7<sub>8</sub> + 1<sub>8</sub> = 16<sub>8</sub>, so carry the 1.


#### Example 2:

![add octal ex 2](http://i.imgur.com/6qG1fza.png)

In the 1st column, 6<sub>8</sub> + 5<sub>8</sub> = 13<sub>8</sub>, so carry the 1.  
In the 2nd column, 4<sub>8</sub> + 3<sub>8</sub> + 1<sub>8</sub> = 10<sub>8</sub>, so carry the 1.  
In the 3rd column, 2<sub>8</sub> + 5<sub>8</sub> + 1<sub>8</sub> = 8<sub>8</sub>, so carry the 1.

### Addition in binary

#### Example 1:

![add binary ex 1](http://i.imgur.com/FVnP8b0.png)

In the 1st column, 1 + 1 = 10, so carry the 1.  
In the 2nd column, 0 + 1 + 1 = 10, so carry the 1.  
In the 3rd column, 1 + 0 + 1 = 10, so carry the 1.  
In the 4th column, 1 + 1 = 10, so carry the 1.

#### Example 2:

![add binary ex 2](http://i.imgur.com/JodzenR.png)

In the 1st column, 1 + 1 = 10, so carry the 1.  
In the 2nd column, 1 + 0 + 1 = 10, so carry the 1.  
In the 3rd column, 1 + 1 + 1 = 11, so carry the 1.  
In the 4th column, 0 + 1 + 1 = 10, so carry the 1.  
In the 5th column, 1 + 1 + 1 = 11, so carry the 1.

#### Example 3:

![add binary ex 3](http://i.imgur.com/AiPcq1b.png)

### Addition in hexadecimal

In hexadecimal, the digits represent 1, 16, 16<sup>2</sup>, 16<sup>3</sup>, and so on.

So, if the sum of the two digits in the 1's column, is 16 or more, carry the 1 into the next column, and so on.

#### Examples:

![add hex](http://i.imgur.com/dPuu03n.png)

## Binary Coded Decimal code (BCD)

In BCD code, each digit of a decimal number is represented by a 4-bit binary *code group*. Compare the binary and the BCD representations of some decimal numbers.

### Example 1

For 37<sub>10</sub>,

The binary representation is 100101.

The BCD representation is: 0011 = 3, 0111 = 7.

### Example 2

For 65<sub>10</sub>,

The binary representation is 1000001.

The BCD representation is: 0110 = 6, 0101 = 5.

### Example 3

For 123<sub>10</sub>,

The binary representation is 1111011.

The BCD representation is: 0001 = 1, 0010 = 2, 0011 = 3.

### BCD Table

Since there are 10 decimal digits, the 4-bit binary numbers for 0 through 0 are used for BCD representation, as shown in the table:

| Base10 | BCD Code |
|:------:|:--------:|
| 0      | 0000     |
| 1      | 0001     |
| 2      | 0010     |
| 3      | 0011     |
| 4      | 0100     |
| 5      | 0101     |
| 6      | 0110     |
| 7      | 0111     |
| 8      | 1000     |
| 9      | 1001     |

- There are remaining 4-bit binary numbers: 
	- 1010 = A
	- 1011 = B
	- 1100 = C
	- 1101 = D
	- 1110 = E
	- 1111 = F

These are called *invalid BCD code groups* and do not correspond to any decimal digit.

So conversion from decimal to BCD, is simply a matter of replacing each decimal digit by the appropriate 4- bit binary code group. Futher examples follow.

### Example 4

478<sub>10</sub>

= 0100 0111 1000  
= 4--- 7--- 8---

### Example 5

345602<sub>10</sub>

= 0011 0100 0101 0110 0000 0010  
= 3--- 4--- 5--- 6--- 0--- 2---

Conversion from BCD code to the equivalent decimal number is simply a matter of separating the BCD number into groups of 4 bits and then replacing each group by the corresponding decimal digit.

### Example 6

Convert 0101011100000001 into its decimal equivalent.

= 0101 0111 0000 0001  
= 5--- 7--- 0--- 1---

### Example 7

The binary sequence 0100 1011 0011 is **not** a valid BCD representation, because we try to convert it into its decimal equivalent we find:

= 0100 1011 0011  
= 4--- ?--- 3---

1011 is an invalid BCD group.

## Addition of BCD

In the following discussion about addition of BCD numbers, it is much easier to use hexadecimal rather than binary representation.

So valid BCD code groups are represented by the hex numbers 0 through 9, while the hex numbers A through F represent invalid code groups.

When a microprocessor adds BCD numbers, it is really adding binary (or hex) numbers, but the final output must look like the result of decimal addition.

Binary (or hex) additions may or may not look like decimal additions.

These three hex additions can be interpreted as correct decimal additions:

![add bcd 1](http://i.imgur.com/FgAT7ag.png)

However the following three hex additions do not give correct decimal answers:

![add bcd 2](http://i.imgur.com/00dlclV.png)

When two BCD code groups are added, there are three possible types of outcomes as illustrated by following the three cases. Remember the additions are all hex:

![add bcd 3](http://i.imgur.com/ZdCl3do.png)

In case (i), if the result is interpreted as decimal, a correct answer is obtained.

In case (ii), an invalid BCD code group is produced so the result cannot be interpreted as decimal.

In case (iii), the result, if interpreted as decimal, gives a wrong answer.

Such decimal adjustments are usually not seen by the user. In the case of a calculator for example, the user sees only the two numbers that are input and the final output.

The hexadecimal addition of the inputs and the decimal adjustments occur inside the machine and are therefore hidden from the user. Although the calculations are in hex (or binary), as far as the user can see, the operation is simply decimal addition.

The steps involved in BCD addition are shown in the following box.

Notice that the first addition and then the decimal adjustment on each column are completed before moving to the next column.

## The procedure for BCD addition

- Start at the right column:
	- Add the two digits and transfer any carry to the next column
	- Make the decimal adjustment by adding 6 or 0, according to the rule:
		- If the sum of the two digits is more than 9
			- Add 6 and transfer any carry to the next column
		- Else add 0
	- Move to the next column and repeat the above operations until all columns have been processed

Note that a carry may come from the first addition or from the second addition.

### Example 1

![add bcd ex 1](http://i.imgur.com/g8wFosx.png)

### Example 2

![add bcd ex 2](http://i.imgur.com/8GIJYzg.png)

### Some more examples

![add bcd ex 3](http://i.imgur.com/sGTuJAA.png)

![add bcd ex 4](http://i.imgur.com/40m0nvn.png)