# CSG2341

## Workshop 7: GA case studies

#### Martin Ponce 10371381

## Initial results

![initial results](http://snag.gy/W3jUO.jpg)

<div class="page-break"></div>

## Step 6

- Remove `LLL` genes

### Code

``` java
public void develop() {
	if(Math.random() < CLEANUP_PROB) {

		// store previous genes
		char prev = '?';
		char prev2 = '?';

		// iterate each gene
		for(int i = 0; i < moves.length(); i++) {
			// if we have 3 L genes in a row, prev2, prev and current
			if(prev2 == 'L' && prev == 'L' && moves.charAt(i) == 'L') {
				// change LLL genes to RFF
				moves = moves.substring(0, i - 2)
						+ "R"
						+ moves.substring(i + 1)
						+ "FF";
				i -= 2;
			}

			// setting prev2
			if(i > 0) {
				prev2 = moves.charAt(i - 1);
			} else {
				prev2 = '?';
			}

			// setting prev
			if(i > -1) {
				prev = moves.charAt(i);
			} else {
				prev = '?';
			}
		}
	}
}
```

### Results

![step 6 results](http://snag.gy/WYoQ0.jpg)

<div class="page-break"></div>

## Step 7

- Remove `RRR` genes

### Code

``` java
public void develop() {
	if(Math.random() < CLEANUP_PROB) {

	// Step 6...

		for(int i = 0; i < moves.length(); i++) {

			// Step 6 ...

			// if we have 3 R genes in a row, prev2, prev and current
			if(prev2 == 'R' && prev == 'R' && moves.charAt(i) == 'R') {

				// change RRR genes to LFF
				moves = moves.substring(0, i - 2)
						+ "L"
						+ moves.substring(i + 1)
						+ "FF";
				i -= 2;
			}
			// Step 6 ...
		}
	}
}
```

### Results

![step 7 results](http://snag.gy/uqgvs.jpg)

<div class="page-break"></div>

## Step 8

- Remove genes
	- `RLF`, `LRF`, `FRL`, `FLR`

### Code

``` java
// RLF to FFF
if(prev2 == 'R' && prev == 'L' && moves.charAt(i) == 'F') {
	moves = moves.substring(0, i - 2)
			+ "F"
			+ moves.substring(i + 1)
			+ "FF";
	i -= 2;
}

// RLF to FFF
if(prev2 == 'L' && prev == 'R' && moves.charAt(i) == 'F') {
	moves = moves.substring(0, i - 2)
			+ "F"
			+ moves.substring(i + 1)
			+ "FF";
	i -= 2;
}

// FRL to FFF
if(prev2 == 'F' && prev == 'R' && moves.charAt(i) ==  'L') {
	moves = moves.substring(0, i - 1)
			+ "F"
			+ moves.substring(i + 1)
			+ "F";
	i -= 1;
}

// FLR to FFF
if(prev2 == 'F' && prev == 'L' && moves.charAt(i) == 'R') {
	moves = moves.substring(0, i - 1)
			+ "F"
			+ moves.substring(i + 1)
			+ "F";
	i -= 1;
}
```

### Results

![step 8 results](http://snag.gy/l0RoR.jpg)

## Step 9

- Ideas for other ways to improve
	- `RRL` to `RFF`
	- `LLR` to `LFF`
- Attempted to implement below
	- Worse performance
- Wrapped in `if(i > 1)` causes `RRR`
	- Without `if` causes `StringIndexOutOfBounds` error

### Code

``` java
if(i > 1) {
	// RRL to RFF
	if(prev2 == 'R' && prev == 'R' && moves.charAt(i) == 'L') {
		moves = moves.substring(0, i - 2)
				+ "R"
				+ moves.substring(i + 1)
				+ "FF";
		i -= 2;
	}

	// LLR to LFF
	if(prev2 == 'L' && prev == 'L' && moves.charAt(i) == 'R') {
		moves = moves.substring(0, i - 2)
				+ "L"
				+ moves.substring(i + 1)
				+ "FF";
		i -= 2;
	}
}
```
