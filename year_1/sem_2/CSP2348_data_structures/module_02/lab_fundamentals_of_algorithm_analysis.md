# Fundamentals of algorithm analysis

## Task 1

Create a spreadsheet to show the growth rates given in the following table.

Observe the differences among these growth rates.

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

## Task 2

Suppose that the following expressions are the sum of characteristic operations of some algorithms. Determine the time complexity of each of these expressions by means of the Big-O notation.

### n<sup>10</sup> + 9 * n<sup>9</sup> + 20 * n<sup>8</sup>

>max{O(n<sup>10</sup>), O(9 * n<sup>9</sup>), O(20 * n<sup>8</sup>)}  

Normalise constant factor.

>&rArr; max{O(n<sup>10</sup>), O(n<sup>9</sup>), O(n<sup>8</sup>)}  
&rArr; O(n<sup>10</sup>)

### (n + 1)<sup>4</sup>

>O((n + 1)<sup>4</sup>)  
= O((n + 1) \* (n + 1) \* (n + 1) \* (n + 1))  
= O(n + 1) \* O(n + 1) \* O(n + 1) \* O(n + 1)  

Normalise constant factor.

>= O(n) \* O(n) \* O(n) \* O(n)  
= O(n \* n \* n \* n)  
= O(n<sup>4</sup>)

### (n<sup>2</sup> + n)<sup>2</sup>

>O((n<sup>2</sup> + n)<sup>2</sup>)  
= O((n<sup>2</sup> + n) \* (n<sup>2</sup> + n))  
= O(n<sup>2</sup> + n) \* O(n<sup>2</sup> + n)

Normalise constant factor.

>= O(n<sup>2</sup>) \* O(n<sup>2</sup>)  
= O(n<sup>2</sup> * n<sup>2</sup>)  
= O(n<sup>4</sup>)

### n + 0.001 * n<sup>3</sup>

>&rArr; max{O(n), O(0.001 * n<sup>3</sup>)}  
&rArr; max{O(n), O(n<sup>3</sup>)}  
&rArr; O(n<sup>3</sup>)

### n<sup>3</sup> - 1000 * n<sup>2</sup>

>&rArr; max{O(n<sup>3</sup>), O(1000 * n<sup>2</sup>)}  
&rArr; max{O(n<sup>3</sup>), O(n<sup>2</sup>)}  
&rArr; O(n<sup>3</sup>)

### n + log<sub>2</sub>(n)

>&rArr; max{O(n), O(log<sub>2</sub>(n))}  
>&rArr; O(n)

### n<sup>2</sup> + n * log<sub>2</sub>(n)

>&rArr; max{O(n<sup>2</sup>), O(n * log<sub>2</sub>(n))}  
&rArr; max{O(n<sup>2</sup>), O(log<sub>2</sub>(n))}  
&rArr; O(n<sup>2</sup>)

### 2<sup>n</sup> + n<sup>2</sup>

>&rArr; max{O(2<sup>n</sup>), O(n<sup>2</sup>)}  
&rArr; O(2<sup>n</sup>)

### (n<sup>3</sup> + 2 * n) / (n + 5)

>O((n<sup>3</sup> + 2 * n) / (n + 5))  
= O(n<sup>3</sup> + 2 * n) / O(n + 5)  
= O(n<sup>3</sup>) / O(n)  
= O(n<sup>3</sup> / n)  
= O(n<sup>2</sup>)

## Task 3

Analyse the time complexity of the following methods / algorithms.

Source: Excercise 2.4 or page 31 of reference textbook - Java Collections (2001)

The following Java methods implement matrix addition and multiplication. Each matrix is represented by an n * n two-dimensional array of float numbers.

``` java
static void matrixAdd (int n, float[][] a, float[][] b, float[][] sum) {

	// Set sum to the sum of the n*n matrices a and b
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			sum[i][j] = a[i][j] + b[i][j];
		}
	}
}

static void matrixMult(int n, float[][] a, float[][] b, float[][] prod) {

	// Set prod to the sum of the n*n matrices a and b
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

### `matrixAdd()`

- Number of additions: n * n = n<sup>2</sup>
	- In the new matrix, there are n*n elements
	- Each element is the result of **ONE** addition from matrix A and matrix B
- Number of multiplications: 0
	- There is no multiplication involved in constructing any new element
- Time complexity:

>max{O(additions), O(multiplications)}  
= max{O(n<sup>2</sup>, O(1))}  
= O(n<sup>2</sup>)

### `matrixMult()`

- Number of additions: n \* n \* n = n<sup>3</sup>
	- In each new matrix, there are n*n elements
	- Each element is the result of n additions from matrix A and matrix B
- Number of multiplications: n \* n \* n = n<sup>3</sup>
	- Each element is the result of n multiplications from matrix A and matrix B
- Time complexity:

>max{O(additions), O(multiplications)}  
= max{O(n<sup>3</sup>), O(n<sup>3</sup>)}  
= O(n<sup>3</sup>)
