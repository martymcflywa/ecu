# Review questions

## Introduction to data structures and remedial mathematics

### 1:

What are the differences between an algorithm and a program?

#### Answer

- An algorithm is a procedure that
	- Can be performed by humans or machines
	- Can be expressed in any suitable language
	- May be as abstract as we like
- A program is an algorithm that
	- Must be performed by machines
	- Must be expressed in a programming language
	- Must be detailed and specific

### 2:

What are the features of a concrete data type?

#### Answer

Concrete data types are strictly defined to contain specified data type values.

- Defined for specific inputs
- Rarely reusable
- Examples of concrete data types
	- Boolean
	- Integer
	- Float

### 3:

Calculate 2<sup>8</sup> by hand in as many was as you can find, then compare their efficiency in terms of multiplications.

#### Answer

>1. 2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 = 2<sup>8</sup>
	- 7 multiplications
	- 0 variables
2. 4 = 2 \* 2; 4 \* 4 \* 4 \* 4 = 2<sup>8</sup>
	- 4 multiplications
	- 1 variable
3. 4 = 2 \* 2; 8 = 4 \* 2, 4 \* 8 \* 8 = 2<sup>8</sup>
	- 4 multiplications
	- 2 variables
4. 4 = 2 \* 2; 16 = 4 \* 4; 16 \* 16 = 2<sup>8</sup>
	- 3 multiplications
	- 2 variables

### 4:

Given 2<sup>10</sup> &asymp; 10<sup>3</sup>, use power laws to prove that 2<sup>20</sup> &asymp; 10<sup>6</sup> and 2<sup>30</sup> &asymp; 10<sup>9</sup>.

#### 2<sup>20</sup> &asymp; 10<sup>6</sup>

>1. Since 10<sup>3</sup> &asymp; 2<sup>10</sup>  
2. 10<sup>3</sup> \* 10<sup>3</sup> &asymp; 2<sup>10</sup> \* 2<sup>10</sup>
3. Then 10<sup>3+3</sup> &asymp; 2<sup>10+10</sup>
4. Therefore 10<sup>6</sup> &asymp; 2<sup>20</sup>

#### 2<sup>30</sup> &asymp; 10<sup>9</sup>

>1. Since 10<sup>3</sup> \* 10<sup>6</sup> &asymp; 2<sup>10</sup> \* 2<sup>20</sup>
2. 10<sup>3+6</sup> &asymp; 2<sup>10+20</sup>
3. Therefore 10<sup>9</sup> &asymp; 2<sup>30</sup>

### 5:

Apply floor() and ceiling() functions to log<sub>2</sub>(70).

>1. Find the closest power<sup>2</sup> &le; 70
	- 64
2. Find the closest power<sup>2</sup> > 70
	- 128
3. log<sub>2</sub>(64) &le; log<sub>2</sub>(70) < log<sub>2</sub>(128)
4. log<sub>2</sub>(64) = 6 &le; log<sub>2</sub>(70) < log<sub>2</sub>(128) = 7
5. Therefore
	- floor(log<sub>2</sub>(70)) = 6
	- ceiling(log<sub>2</sub>(70)) = 7

### 6:

If 2<sup>p</sup> < n < 2<sup>p+1</sup>, what should be the values of floor(log<sub>2</sub>(n)) and ceiling(log<sub>2</sub>(n))?

>1. Since 2<sup>p</sup> < n < 2<sup>p+1</sup>
2. Then log<sub>2</sub>(2<sup>p</sup>) < log<sub>2</sub>(n) < log<sub>2</sub>(2<sup>p+1</sup>)
3. Then p < log<sub>2</sub>(n) < p+1
4. Therefore
	- floor(log<sub>2</sub>(n)) = p
	- ceiling(log<sub>2</sub>(n)) = p+1
