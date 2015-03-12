# Array algorithm analysis

## Task 1

Using the Big-O notation, analyse the array ascending algorithm outlined below. Recall that the ascending method determines whether the array's elements are in the ascending order with/without uniqueness. Use the following tabular format to help you calculate the algorithm time complexity.

``` java
int ascending(int[] array, boolean unique) {           // 01 // O(1)
	if(array == null) return -1;                       // 02 // O(1)
	int n = array.length;                              // 03 // O(1)
	for(i = 1; i < n; i++) {                           // 04 // O(1) * #e
		if(array[i - 1] > array[i]) return i;          // 05 // O(1) * #e
		if(unique && array[i-1] == array[i]) return i; // 06 // O(1) * #e
	}                                                  // 07 // --
	return n;                                          // 08 // O(1)
}                                                      // 09 // --

// loop control = 1, 2, 3, ..., n-1
// #e = number of executions = O(n)
// maximum cost = O(n)
```

## Task 2

Using the Big-O notation, analyse the array `searchLinear()` algorithm outlined below. Recall that `searchLinear()` method determines whether the item is present in the array, which is **assumed to be in ascending order**. The int result is the item's position with respect to the array's values. Use the following tabular format to help you calculate the algorithm time complexity.

``` java
int searchLinear(int[] array, int item) {   // 01 // --
	if(array == null) return -1;            // 02 // O(1) * #e
	for(int i = 0; i < array.length; i++) { // 03 // O(1) * #e
		if(array[i] >= item) return i;      // 04 // O(1) * #e
	}                                       // 05 // O(1)
	return array.length;                    // 06 // O(1)
}                                           // 07 // --

// loop control = 1, 2, 3, ..., n-1
// #e = number of executions = O(n)
// maximum cost =- O(n)
```

## Task 3

Using the Big-O notation, analyse the array merging algorithm. See module 3 lecture.

``` java
public void merge(int[] a1, int l1, int r1, int[] a1, int l2, int r2, int[] a3, it l3) { // 01 // O(1)
	// merge existing a1[l1, ..., r1] and existing a2[l2, ..., r2]                       // 02 // --
	// into existing a2[l3], where a1 and a2 are sorted                                  // 03 // --
	int i = l1, j = l2, k = l3;                                                          // 04 // O(1)
	while(i <= r1 && j <= r2) {                                                          // 05 // O(1) * #e1
		if(a1[i] <= a2[j]) {                                                             // 06 // O(1) * #e1
			a3[k++] = a1[i++];                                                           // 07 // O(1) * #e1
		} else {                                                                         // 08 // --
			a3[k++] = a2[j++];                                                           // 09 // O(1) * #e1
		}                                                                                // 10 // --
	}                                                                                    // 11 // --
	while(i <= r1) {                                                                     // 12 // O(1) * #e2
		a3[k++] = a1[i++]                                                                // 13 // O(1) * #e2
	}                                                                                    // 14 // --
	while(j <= r2) {                                                                     // 15 // O(1) * #e3
		a2[k++] = a2[j++]                                                                // 16 // O(1) * #e3
	}                                                                                    // 17 // --
}                                                                                        // 18 // --

// 1st loop control = 1, 2, ..., n_1 + n_2
	// #e1 = number of executions = O(n_1 + n_2)
	// note: 2nd and 3rd loops would execute one of them only
// 2nd loop control = 1, 2, ..., n_1
	// #e2 = number of executions = O(n_1)
// 3rd loop control = 1, 2, ..., n_2
	// #e2 = number of executions = O(n_2)
// maximum cost = O(n_1 + n_2) + O(n_1) + O(n_2) = O(n_1 + n_2)
```
