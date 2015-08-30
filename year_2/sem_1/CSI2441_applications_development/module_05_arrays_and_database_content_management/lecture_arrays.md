# Arrays

## Objectives

- Understand how arrays are used
- Understand how arrays occupy computer memory
- Manipulate an array to replace nested decisions
- Declare and initialize an array
- Declare and initialize constant arrays
- Load array values from a file
- Search an array for an exact match
- Use parallel arrays
- Force subscripts to remain within array bounds
- Improve search efficiency by using an earlier exit
- Search an array for a range match

## Understanding arrays

- Array
	- Series or list of variables in computer memory
	- All share the same name
	- Each has a different subscript
- Subscript / index
	- Position number of an item in an array
	- Subscripts are always a sequence of integers

### How arrays occupy computer memory

- Each item has same name and data type
- Element
	- An item in the array
- Array elements are contiguous in memory
- Size of the array
	- Number of elements in can hold

![figure 8.1](http://i.imgur.com/3opERYD.png)

- Subscript is placed in parenthesis or square brackets following the array name
	- Language dependent
- Zero based array
	- First subscript is 0
	- Highest subscript value is `arraySize` - 1
- Arrays make programs more efficient and professional

## Manipulating an array to replace nested decisions

- The input file:

![figure 8.2](http://i.imgur.com/sJ8ROGk.png)

- The desired output:

![figure 8.3](http://i.imgur.com/RHCJvyc.png)

- Report could be created in several ways
	- If data is sorted
		- A control break program could be created
	- If unsorted
		- Multiple counters could be used to accumulate the grouping totals
	- Report could be created using arrays to accumulate the grouping totals

![figure 8.4](http://i.imgur.com/ukezwRy.png)

![figure 8.5](http://i.imgur.com/CXfZkjm.png)

![figure 8.6](http://i.imgur.com/bZgMPE0.png)

![figure 8.7](http://i.imgur.com/QuMoGXT.png)

- Using an array
	- Simplifies the program logic
	- Reduces the number of statements
- Each element is referenced by name and subscript
	- `count[0]`

![figure 8.8](http://i.imgur.com/o0Cuqy5.png)

![figure 8.9](http://i.imgur.com/My4vVLm.png)

- Benefit
	- Can use a variable as the subscript
- Look for relationships between the array subscript value and the data or processing required
- Application:
	- Number of bedrooms matches the array subscript

![figure 8.10](http://i.imgur.com/7PsGuUt.png)

- If the action is the same for all values of the subscript
	- There is no need to test the value of the subscript

![figure 8.11](http://i.imgur.com/n60Rauw.png)

- Use the subscript to control an array printing loop
- Any variable can be used as a subscript for controlling a loop using the array, as long as it is
	- Integer
	- Initialised to some value
	- Greater than 0
	- Incremented during every iteration

![figure 8.12](http://i.imgur.com/PZtPSIo.png)

## Array declaration and initialization

- Array elements do not have to be declared individually
- Put the array size in square brackets in the declaration

![figure 8.13](http://i.imgur.com/YfHGGAD.png)

- Array elements should be initialized
- Initialization loop
	- Loop structure that provides initial values to an array
- Use the loop control variable as the array subscript

![figure 8.14](http://i.imgur.com/pdpfAU5.png)

### Declaring and initializing constant arrays

- The input file
- Floor and apartment letter will not change

![figure 8.15](http://i.imgur.com/31ZYH9i.png)

- Need to print rent bills based on the floor of the building

![figure 8.16](http://i.imgur.com/DW2kKQK.png)

- Use an array to hold the floor and corresponding rent figures
- These array values will be constant
- Hardcoded values
	- Values assigned directly in program statements

![figure 8.17](http://i.imgur.com/ahDrSTt.png)

![figure 8.18](http://i.imgur.com/xcWHjaM.png)

- Choose a variable to be the subscript
	- Determine which variable the correct selection depends on
- Rent depends on the floor
	- Select `tenFloor` variable as the subscript in the `figureRent()` module

![figure 8.19](http://i.imgur.com/KyKxSqZ.png)

## Loading an array from file

- If there are many rent values, or they change frequently
	- Initialize the `rent` array from a file
- Allows values to change without changing the program
- In this file, the rent records are stored in order by floor

![figure 8.21](http://i.imgur.com/F2luwQz.png)

## Searching for an exact match in an array

- The input file
	- Customer orders
- Item numbers are not consecutive
	- With large gaps

![figure 8.22](http://i.imgur.com/4MwSEPN.png)

- Create an array with valid item numbers
- Use a loop to search the array for valid item numbers

![figure 8.23 8.24](http://i.imgur.com/L8EKTOm.png)

- Flag
	- Variable that indicates whether an event occurred
	- Boolean
- Technique for searching an array
	- Set subscript to 0
		- To start at the first element
	- Init flag to `false`
		- To indicate the desired value has not been found
	- Examine each element in the array
	- If value matches
		- Set flag to `true`
	- If value does not match
		- Increment subscript
		- Examine next array

![figure 8.25](http://i.imgur.com/Tgaj9EO.png)

## Using parallel arrays

- Two arrays in which each element of one array is associated with the element in the same relative position in the other array
- Use one array for item numbers
- Use a second array for item prices
- When correct item is found
	- Price is in the same position in the other array

![figure 8.26](http://i.imgur.com/Ds2AQIK.png)

![figure 8.27](http://i.imgur.com/S1iBxKN.png)

![figure 8.28](http://i.imgur.com/t5cQOj0.png)

![figure 8.29](http://i.imgur.com/yJz7jLr.png)

## Remaining within array bounds

- Out of bounds
	- Using a subscript that is not within the acceptable range of the array
- Some languages give an error
	- Others just search through memory beyond the end of the array
- Programs should prevent bounds errors
- Subscript should not go beyond 5 because there are only 6 array elements
	- Subscript 0 to 5

![figure 8.30](http://i.imgur.com/V2SmvDA.png)

## Improving search efficiency using early exit

- To improve efficiency, program should stop searching when match is found
- Forcing a variable
	- Setting a variable specific to a specific value instead of letting normal processing set it
- Early exit
	- Leaving a loop as soon as a match is found
- The larger the array, the better the improvement by doing an early exit

![figure 8.31](http://i.imgur.com/r1NaJqP.png)

## Searching an array for a range match

- Range values
	- Any set of contiguous values
- The input file

![figure 8.32](http://i.imgur.com/r2cIZ84.png)

- Need to apply a discount for ranges of quantity ordered

![figure 8.33](http://i.imgur.com/V3a8F8r.png)

![figure 8.34](http://i.imgur.com/AJnrgBe.png)

- Drawbacks
	- Very large array
		- Uses a lot of memory
	- Must store the same values repeatedly
	- What upper limit should be used for array elements?
- A better approach

![figure 8.35](http://i.imgur.com/1aGPNk0.png)

- This approach requires a parrallel array to find the appropriate discount level
- Array will hold the low end value of each range
- Start comparing with the last discount array value
	- If quantity is at least as high as the array element value, apply the discount

![figure 8.36](http://i.imgur.com/J7fk2tp.png)

![figure 8.37](http://i.imgur.com/ySeQSud.png)

## Summary

- Array
	- Series or list of variables in memory
	- Same name and type but different subscript
- Can use a variable as a subscript to the array to replace multiple nested decisions
- Can declare and init all elements in an array with a single statement
- Use a constant array when the array element values are fixed at the beginning of the program
- Can load an array from a file
- To search an array
	- Init the subscript
	- Loop to test each array element value
- Set a flag when the desired value is found while searching an array
- Parallel arrays
	- Each element in one array is associated with the element in the same relative position in the other array
- Ensure that subscript does not go out of bounds
- For range comparisons
	- Store either low or high end values of each range
