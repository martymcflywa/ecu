# Module 4 learning objectives

## What is an array

- Data structure of constant length
- Contains elements of a single type
- Memory is allocated to hold elements in array
- Index starts at 0

## Declaring / initialising an array

- Requires
    - Type specifier
    - Identifier
    - Dimension (subscript)

``` cpp
// Declaring array
double moneyCollected[5];
// Type == double
// Identifier == moneyCollected
// Dimension == [5]

// Initialising array
int rent[] = {250, 375, 460, 600};
// array is initialised with values contained within '{}'
int rent[4] = {250, 375} // rent[2] and rent[3] are null
```

## Common issues with arrays

- Forgetting arrays are zero based
- Exceeding array bounds

## How is `string` superior to `char[]`

- Can use standard compare operators like `==`, `>` etc.
    - Would otherwise have to use `strcmp()`
- Can use assignment operator `=`
    - Would otherwise have to use `strcpy()`
- Don't need to worry about out of bounds errors
- Has class methods
    - `find(string pattern, int index)`
    - `rfind(string pattern, int index)`
    - `substr(int start, int end)`
    - `erase(int start, int end)`
    - `insert(int index, string word)`