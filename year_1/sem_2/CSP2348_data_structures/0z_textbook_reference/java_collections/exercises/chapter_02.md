# Chapter 2: Algorithms

## 1:

Hand-test the simple (2.3) and smart algorithms (2.5). Use the test case b = 2, n = 11. How many multiplications are performed by each algorithm?

### Simple

>To compute b<sup>n</sup> where n is a non-negative int.

>1. Set p to 1
2. For i = 1, ..., n, repeat:
	1. Multiply p by b
3. Terminate with answer p

``` java
static int power(int b, int n) {
	// return value of b raised to nth power
	// n is non-negative int
	int p = 1;
	for(int i = 1, i <= n; i++) {
		p *= b;
	}
	return p;
}
```

- Multiplications
	- = n multiplications
	- = O(n)
- b = 2, n = 11
	- Multiplied 11 times

### Smart

>To compute b<sup>n</sup> where n is a non-negative int.

>1. Set p to 1, set q to b, set m to n
2. While m is positive, repeat:
	1. If m is odd, multiply p by q
	2. Halve m (neglect remainder) and multiply q by itself
3. Terminate with answer p

``` java
static int power(int b, int n) {
	// return value of b raised to nth power
	// n is non-negative int
	int p = 1, q = b, m = n;
	while(m > 0) {
		if(m % 2 ! = 0) {
			p *= q;
		} else {
			m /= 2;
			q *= q;
		}
	}
	return p;
}
```

- Multiplications
	- 2 floor(log(n))
	- O(log(n))
- b = 2, n = 11
	- Multiplied 7 times

## 2:

What is the time complexity of the geometric algorithm given as Algorithm 1.1?

>To find the midpoint of a straight line segment AB:

>1. Draw intersecting circles of equal radius centered at points A and B
2. Let C and D be the two points where the circles intersect
3. Draw the straight line CD
4. Let E be the point where AB intersects CD
5. Terminate with point E as answer

- O(1)?? Doubt it

## 3:

Create a spreadsheet to reproduce the table of growth rates given in Table 2.10, and extend it to n = 100.

| n    | 1 | log(n) | n    | n * log(n) | n<sup>2</sup> | n<sup>3</sup> | n<sup>10</sup> | 2<sup>n</sup> |
|------|---|--------|------|------------|---------------|---------------|----------------|---------------|
| 1    | 1 | 0      | 1    | 0          | 1             | 1             | 1              | 2
| 2    | 1 | 1      | 2    | 2          | 4             | 8             | 1024           | 4
| 4    | 1 | 2      | 4    | 8          | 16            | 64            | 1048576        | 16
| 8    | 1 | 3      | 8    | 24         | 64            | 512           | 1073741824     | 256
| 10   | 1 | 3.32   | 10   | 33.22      | 100           | 1000          | 10000000000    | 1024
| 20   | 1 | 4.32   | 20   | 86.44      | 400           | 8000          | 1024E10        | 1048576
| 40   | 1 | 5.32   | 40   | 212.88     | 1600          | 64000         | 1048576E10     | 1099511627776
| 80   | 1 | 6.32   | 80   | 505.75     | 6400          | 512000        | 1073741824E10  | 1.2089258196146292E24
| 100  | 1 | 6.64   | 100  | 664.39     | 10000         | 1000000       | 1E20           | 1.2676506002282294E30
| 200  | 1 | 7.64   | 200  | 1528.77    | 40000         | 8000000       | 1024E20        | 1.6069380442589903E60
| 400  | 1 | 8.64   | 400  | 3457.54    | 160000        | 64000000      | 1048576E20     | 2.5822498780869086E120
| 800  | 1 | 9.64   | 800  | 7715.08    | 640000        | 512000000     | 1073741824E20  | 6.668014432879854E240
| 1000 | 1 | 9.97   | 1000 | 9965.78    | 1000000       | 1000000000    | 1E30           | 1.0715086071862673E301

## 4:

The following Java methods implement matrix addition and multiplication. Each matrix is represented by an n * n two-dimensional array of `float` numbers.

Analyse these methods in terms of the number of `float` additions and multiplications performed. What is the time complexity of each method?

``` java
static void matrixAdd(int n, float[][] a, float[][] b, float[][] sum) {
	// set sum to the sum of the n*n matrices a and b
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			sum[i][j] = a[i][j] + b[i][j];
		}
	}
}
```

- n<sup>2</sup> additions
- no multiplications
- max{O(n<sup>2</sup>), O(1)}
- = O(n<sup>2</sup>)

``` java
static void matrixMult(int n, float[][] a, float[][] b, float[][] prod) {
	// set prod to the product of n*n matrices a and b
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			float s = 0.0;
			for(int k = 0; k < n; k++) {
				s += a[i][k] * b[k][j];
			}
			prod[i][j] = s;
		}
	}
}
```

- n<sup>3</sup> additions
- n<sup>3</sup> multiplications
- = max{O(n<sup>3</sup>), O(n<sup>3</sup>)}
- = O(n<sup>3</sup>)

## 5:

Analyse the time complexity of the recursive algorithm to render a given integer i to base r. See algorithm 2.16.

>1. If i < 0:
	1. Render '-'
	2. Render (-i) to the base r
2. If O &le; i < r:
	1. Let d be the digit corresponding to i
	2. Render d
3. If i &ge; r:
	1. Let d be the digit corresponding to (i mod r)
	2. Render (i / r) to the base r
	3. Render d

``` java
static String renderBasedInt(int i, int r) {
	// render i to the base r
	// r is an int between 2 and 10
	if(i < 0) {
		s = '-' + renderBasedInt(-i, r);
	} else if(i < r) {
		char d = (char)('0' + i);
		s = "" + d;
	} else {
		char d = (char)('0' + i % r);
		s = renderBasedInt(i / r, r) + d;
	}
	return s;
}
```

- i < 0
	- log(abs(i)) + 2
- i > 0
	- log(i) + 1
- max{O(log(abs(i))), O(log(i))}
- = O(log(abs(i)))

## 6:

Devise a non-recursive algorithm to print a given integer i to base r. What is your algorithm's time complexity?

## 7:

Devise a recursive version of Euclid's algorithm to calculate the GCD of two numbers.

## 8:

The factorial of a positive integer n can be calculated using the algorithm given in Algorithm 2.21. What is the time complexity of this algorithm?

Devise a non-recursive version of this algorithm.

Implement both algorithms as Java methods.

>To calculate the factorial of n:

>1. If n = 0:
	1. Terminate with answer 1
2. If n &ne; 0:
	1. Let f be the factorial of n-1
	2. Terminate with answer (n * f)

## 9:

The Fibonacci number of a non-negative integer n can be calculated using the recursive algorithm given in Algorithm 2.22. What is the time complexity of this algorithm?

Devise a non-recursive version of this algorithm.

>To calculate the Fibonacci number of n:

>1. If n &le; 1:
	1. Terminate with answer 1
2. If n > 1:
	1. Let f1 be the Fibonacci number of n-1
	2. Let f2 be the Fibonacci number of n-2
	3. Terminate with answer (f1 + f2)

## 10:

Write a Java program to implement the Towers of Hanoi algorithm given in Algorithm 2.18. Use your program to count the number of moves required and thus verify the time complexity of the algorithm.

>To move a tower of n disks from source to dest where n is a positive integer.

>1. If n = 1:
	1. Move a single disk from source to dest
2. If n > 1:
	1. Let spare be the remaining pole, other than source and dest
	2. Move a tower of (n-1) disks from source to spare
	3. Move a single disk from source to dest
	4. Move a tower of (n-1) disks from spare to dest
3. Terminate

## 11:

Devise a recursive algorithm to find your way out of a maze from a given starting position.
