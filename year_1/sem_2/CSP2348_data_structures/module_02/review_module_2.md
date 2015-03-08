# Review questions

## Algorithim analysis

### 1:

- An algorithm that takes a certain number of steps to complete any given tasks has a time complexity of:
	- O(1)

### 2:

- The notation O(n<sup>2</sup>) means that the algorithm's time (or space) growth rate is proportional to:
	- n<sup>2</sup>

### 3:

Determine the time complexity of the following expression:

>(3 \* n<sup>4</sup> + 2 \* n<sup>3</sup> + 2) / (5 \* n)

#### Answer

>= max{O(3 / 5 \* n<sup>3</sup>), O(2 / 5 \* n<sup>2</sup>), O(2 / 5 \* n<sup>-1</sup>)}  
= max{O(n<sup>3</sup>), O(n<sup>2</sup>), O(n<sup>-1</sup>)}  
= O(n<sup>3</sup>)

### 4:

What is the growth rate of the following method?

``` java
int count (int[] a, int c) { // O(1)
	int i; // O(1)
	count = 0; // O(1)
	for(i = 0; i < a.length; i++) { // control = max{O(1), O(1), O(1)}
	// body = O(a.length)
		if(a[i] == c) {
			count++; // max{O(1), O(1)}
		}
	}
	return count; // O(1)
}
```

#### Answer

Maximum growth rate:

>O(a.length)  
= O(n)
