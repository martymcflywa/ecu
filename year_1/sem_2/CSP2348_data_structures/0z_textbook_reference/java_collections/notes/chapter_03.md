# 3: The array data structure

## Arrays

Arrays are directly supported by nearly all major programming languages, and are familiar to every programmer. Nevertheless, a brief review of arrays will be useful here, and will serve as an opportunity to disentangle the general properties of arrays from their properties in specific programming languages such as Java. The array algorithms discussed in this chapter are expressed entirely in terms of the general properties of arrays.

An array is a sequence of indexed components, with the following properties:

- The length of the array (number of components) is fixed when the array is constructed
- Each component of the array has a fixed and unique index
	- The indices range from a lower index bound, through to a higher index bound
- Any component of the array can be accessed (inspected or updated) using its index
	- This is an efficient operation, having time complexity O(1)

In strongly typed languages, an array must be homogeneous, ie. all its components must have the same type; in weakly typed languages, an array may be heterogeneous. In different object-oriented langauges, arrays are objects (as in Java) or not (as in C++). Java arrays have the following specific properties:

- For an array of length n, the index bounds are 0 and n - 1
- Every array is homogeneous, the type of its components being stated in the program
	- The components may be values of some stated primitive type, or object of some stated class
		- Java actually allows a measure of heterogeneity
			- An array type of C[], where C is an object class, may contain objects of any subclass of C
- An array itself is an object
	- Consequently, an array is allocated dynamically (by means of `new`), is manipulated by reference, and is automatically deallocated when no longer referred to
- The notation for accessing the component with index i in array a is `a[i]`, and the notation for inspecting the length of array a is `a.length`

## Java arrays

The following Java code allocates and initializes an array of six integers, named `primes`:

``` java
int[] primes = {2, 3, 5, 7, 11, 13};
```

The following code prints all the components of `primes`:

``` java
for(int i = 0; i < primes.length; i++) {
	System.out.println(primes[i]);
}
```

Now assume that a class `Date` has been declared, such that each `Date` object has fields `y`, `m`, and `d`, and is equipped with a method `advance`. The following code allocates (but does not initialize) an array of three `Date` objects, named `holidays[]`:

``` java
Date[] holidays = new Date[3];
```

The following code assigns a `Date` object to each component of `holidays[]`

``` java
int thisYear = 2000;
//...
holidays[0] = new Date(thisYear + 1, 1, 1);
holidays[1] = new Date(thisYear + 1, 5, 1);
holidays[2] = new Date(thisYear + 1, 12, 25);
//...
holidays[0].advance(365);\
```

## Subarrays

A subarray is a sequence of consecutive components forming a part of a larger array. Throughout this book we shall see the notation:

>a[l...r]

to denote a subarray of a, consisting of the components a[l] through a[r]. The length of a subarray is the number of components in the subarray. The length of subarray a[l...r] is r - l + 1.

All of the algorithms discussed in this chapter work not only for whole arrays, but also for subarrays. We shall generally state the problem to be solved in terms of a (sub)array a[left...right].

Java, like most programming languages, has no special notation for subarrays. This causes no difficulties in practice; a method that must process subarray a[left...right] can be coded with `a, left, right` as separate paramters.

## Sorted arrays

An array or subarray is sorted if the values of its components are in ascending order, ie. The value of each component of the sub/array is less than or equal to the value of that component's right neighbour. Many of the algorithms discussed in this chapter assume that a sub/array is sorted.

The meaning of "x is less than y" / "y is greater than x" must be defined separately for each data type. For numbers it means that x is a smaller number than y. For strings, it conventionally means that x lexicographically precedes y. For dates, it naturally means that x is earlier than y.

The meanings of least and greatest are derived in the obvious way from the meanings of less and greater. In a sorted array, the leftmost component contains the least value, and the rightmost component the greatest value.

Java 2's `java.lang.Comparable` interface captures the notions of less and greater. This interface requires a `compareTo()` method to compare two objects, such that `x.compareTo(y)` returns a negative integer if x is less than y, zero of x is equal to y, or a positive integer if x is greater than y. `Comparable` is implemented by several Java 2 library classes including `Integer` and `String`. Other classes such as `Date` may be declared to implement `Comparable`, in which case they must implement the method `compareTo()` appropraitely.

``` java
public interface Comparable {
	public int compareTo(Object that) {
		// return a negative int if this object is less than that
		// or zero if this object is equal to that
		// or a positive int if this object is greater than that
	}
}
```

## Insertion

Suppose that we are required to insert a new value at a given position in an array. For instance, given the array a[0...8], we might be required to insert val at index 3. This can be done only by copying the values in components a[3...7] into their respective right neighbours a[4...8], and then copying val into a[3]. The value originally at a[8] will be lost. These effects are consequences of the rigid structure of an array: it has a fixed number of components, and these components have fixed and consecutive indices.

The algorithm below inserts val at position ins in the sub/array a[left...right]. The algorithm works correctly even in the boundary cases ins = left or ins = right. Note that Step 1 does nothing when ins = right.

>To insert val at position ins in a[left...right], where left &le; ins &le; right:

>1. Copy a[ins...right-1] into a[ins+1...right]
2. Copy val into a[ins]
3. Terminate

``` java
static void insert(Object val, int ins, Object[] a, int left, int right) {
	// insert val at position ins in a[left...right]
	// where left ≤ ins ≤ right
	for(int i = right; i > ins; i--) {
		a[i] = a[i - 1];
	}
	a[ins] = val;
}
```

Analysing the insert algorithm's time efficiency: The characteristic operations are copies. Let n = right - left + 1 be the length of a[left...right]. Step 1 could copy any number from 0 through n - 1 components (depending on the value of ins). On average, Step 1 performs (n - 1) / 2 copies. Step 2 performs one further copy. In total:

>Average no. of copies = (n - 1) / 2 + 1 = (n + 1) / 2

The fastest-growing term is n / 2, so the insert algorithm has time complexity O(n).

## Deletion
