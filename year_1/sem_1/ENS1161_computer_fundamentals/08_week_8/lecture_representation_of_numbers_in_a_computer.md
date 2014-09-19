# Representation of numbers in a computer

In this section we are concerned with integers, how they are represented in a computer and how they are added.

In a computer, numbers are usuall represented as sequences of binary digits or **bits** of fixed length.

For example, an integer may be stored in **1 byte (8 bits)** or sometimes might require **2 bytes (16 bits)**.

When talking about 8-bit binary numbers, for example, the **rightmost** bit is called **bit 0** and the **leftmost** bit is **bit 7**.

Bit 0 is also called the **least significant bit (LSB)** because it represents 1, and bit 7 is called the **most significant bit (MSB)** because it represents 128.

![cpu](http://i.imgur.com/zgLMv8n.png)

## Signed and unsigned integers

The set of integers consists of zero and the positive and negative *whole numbers*, such as 37, 1496, -28, -355 etc, that is numbers that have no fractional part.

Computer science uses the concepts of signed integers and unsigned integers.

### Unsigned integers

Unsigned integers are non-negative integers beginning with 0. Some applications involve positive whole numbers only.

### Signed integers are all integers, including positive, negative and zero. A **sign** is required to distinguish between positive and negative numbers.

Some applications require the use of both positive and negative whole numbers.

## Representation of unsigned integers

Representation of unsigned integers is no different from that of ordinary binary numbers, except that there may be leading zeros infront to pad out the number to 8 or 16 bits.

The binary representation of 55 is 110111. The 8-bit representation would be 0011 0111.

The 8-bit range of values for unsigned integers is:

`0000 0000` to `1111 1111`

Or 0<sub>10</sub> to 255<sub>10</sub>

The 16-bit range of values for unsigned integers is:

`0000 0000 0000 0000` to `1111 1111 1111 1111`

Or 0<sub>10</sub> to 65535<sub>10</sub>

## Representation of signed integers

In our work with signed integers, we will use the method called **2's complement** representation.

Mostly we will be concerned with 8-bit 2's complement representation, but sometimes we will use 16-bit 2's complement representation.

To represent signed integers we separate the possible 8-bit numbers into two groups:

`0000 0000` to `0111 1111` represent positive integers (or zero).  
`1000 0000` to `1111 1111` represent negative integers.

With this arrangement we can represent signed integers from -128 to 127:

`0000 0000` to `0111 1111` represent numbers 0<sub>10</sub> to 127<sub>10</sub>  
`1000 0000` to `1111 1111` represent the numbers from -128<sub>10</sub> to -1<sub>10</sub>

- Notice that **bit 7** indicates the sign:
	- If **bit 7** is 0, the number is positive (or zero)
	- If **bit 7** is 1, the number is negative
- Remember, when dealing with signed integers:
	- If a number starts with 0, it is positive (or zero)
	- If a number starts with 1, it is negative

## Definition of 8-bit 2's complement representation

1. For an integer from 0 to 127, the 2's complement representation is the same as its usual binary representation
2. For an integer -m from 128 to -1, the 2's complement representation is the binary representation of 256 - m.

In practice, we use 1, but in place of 2, we use an algorithm based on the so-called *1's complement* of the number.

## Finding the 1's complement of a number

The procedure to find the 1's complement of a number is very easy.

Simply replace each 1 by a 0 and vice versa.

### Example

The 1's complement of `1111 1110` is `0000 0001`.  
The 1's complement of `0001 1001` is `1110 0110`.  
The 1's complement of `1001 1001` is `0110 0110`.

## Converting an integer -m to 2's complement form

To find the 2's complement representation of a negative integer -m, the algorithm is:

- Drop the minus sign
- Convert the decimal number *m* to 8-bit binary
- Find the 1's complement and add 1

### Example 1

Find the 2's complement representation of -95.

The binary representation of 95 is `0101 1111`.  
The 1's complement is `1010 0000`.  
Add 1 = `1010 0001`.  

-95 = `1010 0001`

### Example 2

Find the 2's complement representation of -46.

The binary representation of 46 is `0010 1110`.  
The 1's complement is `1101 0001`.  
Add 1 = `1101 0010`.

-46 is `1101 0010`

### Example 3

Find the 2's complement representation of -68.

The binary representation of 68 is `0100 0100`.  
The 1's complement is: `1011 1011`.  
Add 1 = `1011 1100`.

## Converting a 2's complement form to an integer.

To convert a positive number to decimal, we may use any methods of conversion from an ordinary binary number.

To convert a negative number in 2's complement form to decimal, we use the fact that the process of finding the 2's complement is its own inverse.

Starting with `1010 0011`.  
Its 1's complement is `0101 1100`.  
Add 1.  
The result is `0101 1101`.  
Now starting with `0101 1101`.  
Its 1's complement is `1010 0010`.  
Add 1.  

The result is `1010 0011` - original number.

- So we can
	- Find the 1's complement and add 1
	- Convert the binary number to decimal
	- Attach a minus sign

### Example 1

Convert the 2's complement number `1011 1001` to base<sub>10</sub>

The number is negative.  
The 2's complement number is `1011 1001`.  
It's 1's complement is `0100 0110`.  
Add 1.  
The result is `0100 0111`.

`0100 0111`<sub>2</sub> = 71<sub>10</sub>

`1011 1001`<sub>2</sub> = -71<sub>10</sub>

### Example 2

Convert the 2's complement number `1101 0111` to base<sub>10</sub>

The number is negative.  
The 2's complement number is `1101 0111`  
It's 1's complement is `0010 1000`  
Add 1.  
The result is `0010 1001`

`0010 1001`<sub>2</sub> = 41<sub>10</sub>

`1101 0111`<sub>2</sub> = -41<sub>10</sub>

### Example 3

Convert the 2's complement number 0010 0101 to base<sub>10</sub>

The number is positive.  
So it's 2's complement representation is just its ordinary binary representation.

`0010 0101`<sub>2</sub> = 25<sub>16</sub> = 37<sub>10</sub>

`0010 0101`<sub>2</sub> = 37<sub>10</sub>

## A hexadecimal version of the 1's complement method

To convert negative integer to 8-bit 2's complement:

- Using binary
	- Drop the minus sign
	- Convert the decimal number to binary
	- Find the 1's complement and add 1
- Using hexadecimal
	- Drop the minus sign
	- Convert the decimal number to hex
	- Subtract from `FF` and add 1
	- Convert to binary

To convert the 8-bit 2's complement of a negative integer to decimal:

- Using binary
	- Find the 1's complement and add 1
	- Convert the binary number to decimal
	- Attach a minus sign
- Using hexadecimal
	- Convert from binary to hex
	- Subtract from `FF` and add 1
	- Convert the hex number to decimal
	- Attach a minus sign

## Addition of two bytes and the `C`, `N` and `V` flags

When the microprocessor adds two 8-bit binary numbers, it simply processes two bytes of binary data.

The operation is performed by the *Arithmetic and Logic Unit* ALU in the heart of the microprocessor. The ALU is given two 8-bit binary numbers with the instruction to *add*.

When the ALU carries out the addition, it also assigns values to various flags, in particular the `N`, `V` and `C` flags.

It is the programmer task to interpret the instruction result depending on the type integer being processes - either signed or unsigned.

The unsigned integers requires to use the `C` flag to determine whether the 8-bit output needs to be extended to 16-bits in order to give a correct answer.

The signed integers are required to use the `V` and `N` flags to determine the sign of the answer, and also to determine whether the 8-bit output needs to be extended to 16 bits in order to give a correct answer.

Each flag is given the value 1 or 0 during the addition operation as follows.

- `C` is equali to the carry out of bit 7
	- `C` is called the *carry flag*
- `N` is equal to the MSB (bit 7) of the 8-bit output
	- `N` is sometimes called the *negative flag* or the *sign bit*
- `V` is calculated from the carry bit into bit 7 and the carry bit out of bit 7.
	- `V` is sometimes called the *sign bit error* flag

When the result of the addition is to be interpreted as a signed integer, `V` is used:

- Together with `N`, to determine the sign of the answer, and
- To determine whether the 8-bit output represents the correct answer or whether it needs to be extended to 16 bits

We calculate `V` using:

`V` = (carry into bit 7) ⊕ (carry out of bit 7)

The truth table for exclusive or is as shown.

| `p` | `q` | `p` ⊕ `q` |
|:---:|:---:|:---------:|
| 0   | 0   | 0         |
| 0   | 1   | 1         |
| 1   | 0   | 1         |
| 1   | 1   | 0         |

## ALU structure

![ALU strcuture](http://i.imgur.com/kAQT36v.png)

## Examples of additions and flags

### Example 1

When the two 8-bit binary numbers `00110101` and `10100100` are added the result is an 8-bit output and the `N`, `V` and `C` flags are given values of 0 or 1:

![nvc example 1](http://i.imgur.com/J6nbLqA.png)

### Example 2

![nvc example 2](http://i.imgur.com/W87cdzg.png)

### Example 3

![nvc example 3](http://i.imgur.com/HjYN6ic.png)

### Example 4

![nvc example 4](http://i.imgur.com/29jYleO.png)

## Overflow

Sometimes the correct answer is bigger than 8 bits, and the program must detect this and extend the answer to 16 bits.

- This is indicated by the flags:
	- If the output is to be interpreted as an unsigned integer, the `C` flag is used
	- If the output ist be interpreted as a signed integer, the `V` and `N` flags are used

## Interpreting the output as an unsigned integer

- If `C` = 0, the correct answer fits into 8 bits
- If `C` = 1, the correct answer does not fit into 8 bits
	- The output must be extended to 16 bits

## Interpreting the output as an unsigned integer

### Example 1

Consider the result of adding 168<sub>10</sub> and 137<sub>10</sub>. The correct answer is 305<sub>10</sub> which does not fit in 8 bits.

But how does the microprocessor tell us this?

If we add the binary representations of 168 and 137 by hand, we get:

```
160 = 	1010 1000 +
137 = 	1000 1001
	   10011 0001
```

However, the output from the microprocessor would be just 8-bits and the flags:

- 8-bit output: `00110001`
- `CNV` = `101`

And this is what we must interpret.

Since `C` = 1, the correct answer does not fit into 8 bits.

To extend the answer to 16 bits, we take the 8-bit output, put the value of `C` infront of it, then add leading zeros in front to pad the answer out to 16 bits.

`0000 0001 0011 0001` 8-bit output + C + leading zeros

The correct answer is:

`0000 0001 0011 0001`<sub>2</sub> = 01311<sub>16</sub> = 305<sub>10</sub>

### Example 2

Consider the result of adding 98<sub>10</sub> and 114<sub>10</sub>. The correct answer is 212<sub>10</sub> which is inside the range for 8-bit unsigned integers. But how does the microprocessor tell us this?

If we add the binary representations of 98 and 114 by hand, we get:

```
 98 =	0110 0010 +
114 =	0111 0010
	   01101 0110
```

The output from the microprocessor would be just 8-bits and the flags:

- 8-bit output: `11010100`
- `CNV` = `011`

And this is what we must interpret.

Since `C` = 0, the correct answer fits into 8-bits, and so the correct answer is:

`1101 0100`<sub>2</sub> = D4<sub>16</sub> = 212<sub>10</sub>

### Example 3

How should we interpret the following output from the microprocessor as an unsigned integer?

- 8-bit output: `01100000`
- `CNV` = `101`

Since `C` = 1, the correct answer does not fit into 8 bits. So the correct answer is:

`0000 0001 0110 0000`<sub>2</sub> = 160<sub>16</sub> = 352<sub>10</sub>

### Example 4

How should we interpret the following output from the microprocessor as an unsigned integer?

- 8-bit output: `00110110`
- `CNV` = `101`

Since `C` = 1, the correct answer does not fit into 8-bits, so the correct answer is:

`0000 0001 0011 0110`<sub>2</sub> = 136<sub>16</sub> = 310<sub>10</sub>

## Interpreting the output as a signed integer

When interpreting the addition of two 8-bit binary integers as a signed integer, we must decide:

1. The sign of the answer
	- Positive or negative
2. Whether the 8-bit output needs to be extended to 16 bits

For these tasks, we need the `N` and `V` flags

- The `N` flag is bit 7 (MSB) of the 8-bit output
- The `V` flag is equal to (carry into bit 7) ⊕ (carry out of bit 7)

### Part 1

**The sign of the answer**

`N` is often called the *sign* bit because `N` = 1 indicates that the number is negaive and `N` = 0 indicates the number is non-negative.

In the present context the sign depends on both `N` and `V`.

Put in very simple terms, sometimes `N` tells us the wrong answer, that is `N` may be *telling lies* and `V` is the *lie-detector*.

`V` = 1 means `N` is telling lies. `V` = 0 means `N` is not telling lies. This is why `V` is sometimes called the *sign bit error* flag.

In summary:

- If `V` = 0
	- `N` = 1 means the answer is negative
	- `N` = 0 means the answer is positive
- If `V` = 1
	- `N` = 1 means answer is positive
	- `N` = 0 means answer is negative

### Part 2

**Possible extension of 8-bit output**

With 8 bits we can represent signed integers between -128 and +127.

Sometimes the correct answer lies beyond the ends of this range, and we need to use a 16-bit 2's complement number to represent the correct answer.

This can happen when we add two positive numbers or two negative numbers, but not when we add a positive and negative number.

The `V` flag indicates whether the 8-bit output needs to be extended to 16 bits:

- If `V` = 0
	- The current 8-bit output as a 2's complement number gives the correct answer
	- Not necessary to extend the 8-bit output to 16 bits
- If `V` = 1
	- The current 8-bit output as a 2's complement number does not give the correct answer
	- The 8-bit output needs to be extended to 16 bits

This is why `V` is sometimes called the *2's complement overflow* flag.

## Questions that the flags are asking

It may help to think of flags `N` and `V` as replying to certain questions

- `N` is asking "Is the answer negative?"
	- `N` = 1 is replying "Yes, the answer is negative"
	- `N` = 0 is replying "No, the answer is not negative"
- `V` is asking "Is `N` telling lies?" **AND** "does the output need to be extended?"
	- `V` = 1 is replying "Yes, `N` is telling lies" **AND**
		- `V` = 1 is replying "Yes, the answer needs to be extended"
	- `V` = 0 is replying "No, `N` is not telling lies" **AND**
		- `V` = 0 is replying "No, the answer does not need to be extended"

## How to extend to 16 bits

There is one more rule that needs to be used.

When the 8-bit output needs to be extended to 16 bits, eight extra digits are placed at the front.

But it depends on whether the answer is positive or negative as to whether we use leading 0's or leading 1's to pad out the extra digits.

- The rule is:
	- If the answer is positive, and the 8-bit output needs to be extended to 16 bits
		- Add leading 0's
	- If the answer is negative, and the 8-bit output needs to be extended to 16 bits
		- Add leading 1's

## Summarising the `N` and `V` flags

### Two big positive numbers

![nv flag 1](http://i.imgur.com/Fz6aemB.png)

### Two big negative numbers

![nvflag 2](http://i.imgur.com/4LQyapI.png)

### Big positive number and small negative number

![nvflag 3](http://i.imgur.com/l5uZD7l.png)

### Big negative number and small positive number

![nvflag 4](http://i.imgur.com/JbMWPqv.png)

### Interpretations

There are four different types of interpretations:

![nv interpretation](http://i.imgur.com/GA3eAvI.png)

### Example 1

When two signed integers are added, the 8-bit output and the `N` and `V` flags are as shown. Interpret the result as a signed integer.

`1110 1101` | `N` = 1, `V` = 0

- Solution:
	- `N` = 1: the answer is negative
	- `V` = 0: `N` is not telling lies
	- The output **IS** negative
	- The 8-bit output does not need to be extended.

Converting to base<sub>10</sub>

```
1110 1101 		// 2's complement
0001 0010 +		// 1's complement
        1
---------
0001 0011
```

`0001 0011`<sub>2</sub> = 13<sub>16</sub> = 19<sub>10</sub>

The answer is -19.

### Example 2

When two signed integers are added, the 8-bit output and the `N` and `V` flags are as shown. Interpret the result as a signed integer.

`0011 0101` | `N` = 0, `V` = 0

- Solution:
	- `N` = 0: the answer is positive
	- `V` = 0: `N` is not telling lies
	- The output is positive
	- The 8-bit output does not need to be extended

Since the answer is positive, the 2's complement representation is just its ordinary binary representation.

`0011 0101`<sub>2</sub> = 35<sub>16</sub> = 53<sub>10</sub>

The answer is 53<sub>10</sub>

### Example 3

When two signed integers are added, the 8-bit output and the `N` and `V` flags are shown. Interpret the result as a signed integer.

`1010 1101` | `N` = 1, `V` = 1

- Solution:
	- `N` = 1: the answer is negative
	- `V` = 1: `N` is telling a lie
	- The output is positive
	- The output needs to be extended to 16 bits, which gives

`0000 0000 1010 1101`

Since the answer is positive, its 16-bit 2's complement representation is just its ordinary binary representation.

`0000 0000 1010 1101`<sub>2</sub> = AD<sub>16</sub> = 173<sub>10</sub>

The answer is 173<sub>10</sub>

### Example 4

When two signed integers are added, the 8-bit output and the `N` and `V` flags are as shown. Interpret the result as a signed integer.

`0110 0010` | `N` = 0, `V` = 1

- Solution
	- `N` = 0: the answer is not negative
	- `V` = 1: `N` is telling a lie
	- The output is negative
	- The output needs to be extended to 16 bits, which gives

`1111 1111 0110 0010`

Converting to base<sub>10</sub>

```
1111 1111 0110 0010 	// 2's complement
0000 0000 1001 1101 +	// 1's complement
				  1
0000 0000 1001 1110
```

`0000 0000 1001 1110`<sub>2</sub> = 9E<sub>16</sub> = 158<sub>10</sub>

The answer is -158<sub>10</sub>

## Looking at both interpretations

In the following examples, we look at the result of the addition of two bit binary numbers. We are not told whether these two numbers were unsigned or signed integers.

Our task is to interpret the result:

1. In terms of unsigned integers, and
2. In terms of signed integers

### Example 1A - Unsigned

Sum of `1001 1111` and `0111 1011`

The output from the microprocessor would be just 8-bits and the flags:

```
0001 1010

C N V
1 0 0
```

Interpreting in terms of **unsigned** integers, we notice that `C` = 1, so the correct answer **does not** fit into 8-bits. So, extending to 16 bits, the correct answer is:

`0000 0001 0001 1010`<sub>2</sub> = 011A<sub>16</sub> = 282<sub>10</sub>

Checking: When interpreting as unsigned integers, the numbers being added are 159 and 123, whose sum is 282, which lies outside the range of 8-bits.

### Example 1B - Signed

Sum of `1001 1111` and `0111 1011`

The output from the microprocessor would be just 8-bits and the flags:

```
0001 1010

C N V
1 0 0
```

Interpreting in terms of **signed** integers, we notice that `N` = 0 and `V` = 0, so the correct answer is **positive** and **fits** into 8 bits. So the correct answer is:

`0001 1010`<sub>2</sub> = 1A<sub>16</sub> = 26<sub>10</sub>

Checking: When interpreting as signed integers, the numbers added are -97 and 123, whose some is 26, which lies within the range for 8-bits.

### Example 2A - Unsigned

Sum of `1000 1111` and `1001 1011`

The output from the microprocessor would be just 8-bits and the flags:

```
0010 1010

C N V
1 0 1
```

Interpreting in terms of **unsigned** integers, we notice that `C` = 1, so the correct answer **does not** fit into 8 bits. So, extending to 16 bits, the correct answer is:

`0000 0001 0010 1010`<sub>2</sub> = 012A<sub>16</sub> = 298<sub>10</sub>

Checking: When interpreting as unsigned integers, the numbers being added are 143 and 155, whose sum is 298, which lies outside the range of 8-bits.

### Example 2B - Signed

The output from the microprocessor would be just 8-bits and the flags:

```
0010 1010

C N V
1 0 1
```

Interpreting in terms of signed integers, we notice that `N` = 0 and `V` = 1, so the correct answer **is** negative and **does not** fit into 8 bits. Therefore we must extend to 16 bits by adding leading 1's. So the correct answer is:

`1111 1111 0010 1010`<sub>2</sub> = FF2A<sub>16</sub> = -214<sub>10</sub>

Checking: While interpreting as signed integers, the numbers being added are -113 and -101, whose sum is -214, which lies outside the range for 8-bits.

### Example 3A - Unsigned

The sum of `0101 0101` and `0011 1001`

The output from the microprocessor would be just 8-bits and the flags:

```
1000 1110

C N V
0 1 1
```

Interpreting in terms of unsigned, we notice that `C` = 0, and the correct answer **fits** into 8 bits. So the correct answer is:

`1000 1110`<sub>2</sub> = 8E<sub>16</sub> = 142<sub>10</sub>

Checking: While interpreting as unsigned integers, the numbers being added are 85 and 57, whose sum is 142, which lies inside the range of 8-bits.

### Example 3B - Signed

The sum of `0101 0101` and `0011 1001`

The output from the microprocessor would be just 8-bits and the flags:

```
1000 1110

C N V
0 1 1
```

Interpreting in terms of signed integers, we notice that `N` = 1 and `V` = 1, so the correct answer is positive, and **does not** fit into 8 bits. Therefore we must extend to 16 bits by adding leading 0's. So the correct answer is:

`0000 0000 1000 1110`<sub>2</sub> = 008E<sub>16</sub> = 142<sub>10</sub>

Checking: While interpreting as signed integers, the numbers being added are 85 and 57, whose sum is 142, which lies inside the range for 8-bits.

### Example 4A - Unsigned

The sum of `1010 0100` and `0100 1001`

The output from the microprocessor would be just 8-bits and the flags:

```
1110 1101

C N V
0 1 0
```

Interpreting in terms of unsigned integers, we notice that `C` = 0, so the correct answer fits into 8 bits. So the correct answer is:

`1110 1101`<sub>2</sub> = ED<sub>16</sub> = 237<sub>10</sub>

Checking: While interpreting as unsigned integers, the numbers being added are 164 and 73, whose sum is 237, which lies inside the range of 8-bits.

### Example 4B - Signed

The sum of `1010 0100` and `0100 1001`

The output from the microprocessor would be just 8-bits and the flags:

```
1110 1101

C N V
0 1 0
```

Interpreting in terms of signed integers, we notice that `N` = 1 and `V` = 0, so the correct answer is negative and fits into 8 bits. So the correct answer is:

`1110 1101`<sub>2</sub> = ED<sub>16</sub> = -19<sub>10</sub>

Checking: While interpreting as signed integers, the numbers being added are -92 and 73, whose sum is -19, which lies inside the range for 8-bits.