# Understanding program structure

## Objectives

- Describe the features of unstructured spaghetti code
- Describe three basic structures
	1. Sequence
	2. Selection
	3. Loop
- Use a priming read
- Appreciate the need for structure
- Recognize structure
- Describe three special structures
	1. `case`
	2. `do-while`
	3. `do-until`

## Spaghetti code

- Spaghetti code
	- Logically snarled program statements
- Can be the result of poor program design
	- Example: College admissions criteria

![college admission requirements](http://i.imgur.com/IfaEE0j.png)

![college admission logic model](http://i.imgur.com/9ndOQqn.png)

- Spaghetti code programs often work
	- But are difficult to read and maintain
- Usually quicker to write
	- ie. Code as you go
- Convoluted logic usually requires more code
- Developers often think:
	- "Just testing the concept, will fix it later"
	- Rarely, if ever happens to be fixed
- Nightmare to fix and unravel later
- Correctly analysing and structuring a program before you start coding takes a little extra time
- Correctly re-structuring a program after it has been coded can take far longer and may never be fully successful

## Structures

- Structure
	- A basic unit of programming logic
- Any program can be constructed from only three basic types of structures
	- Sequence
	- Selection
	- Loop

### Sequence

- Sequence
	- A set of instructions performed sequentially with no branching

![sequence model](http://i.imgur.com/bcdH19g.png)

### Selection

- Selection
	- Asks a question
		- Then takes one of two possible courses of action based on the answer
	- Also called a **decision structure**
	- Or an `if-then-else`

#### Selection: dual alternative `if`

![selection dual alternative if model](http://i.imgur.com/OgwPwr4.png)

- Contains two alternatives

```
if hoursWorked > 40 then
	calculate regularPay and overtimePay
else
	calculate regularPay
```

#### Selection: single alternative `if`

![selection single alternative if model](http://i.imgur.com/sr6kbbW.png)

- Contains one alternative
	- Or a one-sided condition

```
if employee belongs to dentalPlan then
	deduct 40 from employeeGrossPay
```

- `else` clause not required
- `null` case
	- Situation where nothing is done
- Some novice developers sometimes write long series of single alternative `if` statements to avoid complex `if-then-else` structures

```
if varGender == "F" then
	showWomensClothing
end if
```

```
if varGender == "M" then
	showMensClothing
end if
```

- The two statements above could be combined into one `if-then-else` statement

```
if varGender == "F" then
	showWomensClothing
else
	showMensClothing
end if
```

### Loop

```
while testCondition continues to be true
	do someProcess
```

```
while isHungry
	take anotherBiteOfFood
```

### Structures in use

- All logic problems can be solved using only these three structures
- Structures can be combined in an infinite number of ways
- **Stacking**
	- Attaching structures end to end
- End-structure statements
	- Indicate the end of a structure
	- `endif` ends and `if-then-else` structure
	- `endwhile` ends an loop structure

```
if varGender == "F" then
	showWomensClothing
else
	showMensClothing
end if
```

```
varCounter = 0

while varCounter <= 20 do
	print varCounter
	varCounter = varCounter + 1
endwhile
```

#### Stacked structure model

![stacked structure model](http://i.imgur.com/wonPigi.png)

### Nesting and blocks

- Any individual task or step in a structure can be replaced by a structure
- **Nesting**
	- Placing one structure within another
- **Block**
	- Group of statements that execute as a single unit

#### Block structure model

![Block structure model](http://i.imgur.com/gBtvtJj.png)

### Gluing the structures together

![gluing structures together model](http://i.imgur.com/qMkxyU8.png)

- Each structure has one entry and one exit point
- Structures attach to others only at entry or exit points
- Most initial coding issues arise from these entry and exit points:
	- Not being correctly defined
	- Receiving incorrect (unexpected) input

#### Structure entry / exit points

![structure entry / exit points](http://i.imgur.com/CF5WAGg.png)

## Using the priming read

- **Priming read** or **priming input**
	- Reads the first input data record
	- Outside the loop that reads the rest of the records
	- Helps keep the program structured
- Analyze a program flow for structure one step at a time
- Never try and code two sequential structures at once
	- Finding points of error becomes exponentially more difficult
- Watch for unstructured loops that **do not** follow this order
	1. Ask question
	2. Take action based on answer
	3. Return to ask the question again

### Unstructured loop

```
// bad: no priming read
while varCounter <= 20 do
	print varCounter
	varCounter = varCounter + 1
endwhile
```

### Structured loop

```
// good: priming read
varCounter = 0

while varCounter <= 20 do
	print varCounter
	varCounter = varCounter + 1
endwhile
```

### Strucuted but non functional loop

```
// good: priming read
varCounter = 0

while varCounter <= 20 do
	print varCounter
endwhile

// bad: increment outside loop
varCounter = varCounter + 1
```

### Structured, functional but non useful loop

```
// good: priming read
varCounter = 0


while varCounter <= 20 do
	varCounter = varCounter + 1
endwhile

// bad: action outside loop
print varCounter
```

## Reasons for structure

- Advantages
	- Provides clarity
	- Professionalism
	- Efficiency
	- Ease of maintenance
	- Supports modularity

### College admission refactored correctly

![college admission refactored correctly 1](http://i.imgur.com/MJJr5Bn.png)

![college admission refactored correctly 2](http://i.imgur.com/8WVCQbl.png)

## Special structures: `case`, `do-while`, `do-until`

- Many languages allow three additional structures
	- `case`
	- `do-while`
	- `do-until`

### `case`

- Decisions with more than two alternatives
- Tests a variable against a series of values
	- Takes action based on match
- Nested `if-then-else` statements will do what a `case` structure does

#### Nested `if-then-else`

- Using nested `if-then-else` for multiple alternatives

![nested if-then-else multiple alternatives](http://i.imgur.com/jz4vrS4.png)

#### `case` instead of nested `if-then-else`

- Using `case` for multiple alternatives

![case multiple alternatives](http://i.imgur.com/sepN7Lh.png)

### `do-while` and `do-until`

- Question is asked at the end of the loop structure
- Ensures that the loop statements are always used at least once
- Especially common in **database recordset loops** where you `do-until` there are no more records in the result set

![do-until model](http://i.imgur.com/RH4T5My.png)

#### `do-while`

- `do-while`
	- Executes as long as the condition is `true`

```
varCounter = 0

while varCounter <= 20 do
	print varCounter
	varCounter = varCounter + 1
endwhile
```

- Is `varCounter <= 20`?
	- Yes
	- OK, keep going

#### `do-until`

- `do-until`
	- Executes as long as the condition is `false`
		- Until it becomes `true`

```
varCounter = 0

do until varCounter = 20
	print varCounter
	varCounter = varCounter + 1
endwhile
```

- Is `varCounter == 20`?
	- No
	- OK, keep going

## Selection of coding structures

- In the end, as a developer you select the structures that you feel best suite coding tasks at hand
- Be consistent at all times
- Predictable and consistent coding structures are easier to
	- Find
	- Debug
	- Enhance
- As stated, in a branching conditional structure, always try to code the `if` side first, using **known inputs**
	- Then code the `else` side

## Setting up priming reads

- In some applications, when you commence a loop structure, you will know a certain value
- For example, you might write a program that summarises yearly sales figures for a shop that is open 24/7

```
varYearlyTotal = 0
varDailyTake = 0

for i = 1 to 365 do
	varYearlyTake = varYearlyTake + varDailyTake(i)
end
```

- In such a case you know the number of days in a year so it can be hardcoded into the loop
- In many applications you will need to set up looping structures based on highly variable types of input
	- Where you cannot hardcode a value with certainty
- In the example of the form shown below, we might end up with any number of fields to process in the unit details section of the form
	- Assuming the user can add new rows as they go
- In this case, we need to
	- Read in the submitted form
	- Analyse its contents
	- Set up the loop

![priming read form](http://i.imgur.com/AICiA8e.png)

### Analysing input for priming reads

- One possible approach for the previous example might be to use a `for-each` structure first

```
varFieldCount = 0

for each item in form
	varFieldCount = varFieldCount + 1
next

// now to process the form

for i = 1 to varFieldCount do
	// read and process input
end
```

- Now, that will get the entire form and not just the unit details, so we have to go abit further
	- ie. Eliminate the following fields
		- `firstName`
		- `surName`
		- `studentID`
		- `courseType`

```
varFieldCount = 0

for each item in form
	if item.name <> "firstName" OR item.name <> "surName"
		OR item.name <> "studentID" OR item.name <> "courseType" then
			varFieldCount = varFieldCount + 1
	end if
next

// now to process the form, taking into account four fields per row
varTotalRows = varFieldCount / 4

for i = 1 to varTotalRows do
	// read and process input
end
```

- Now, this example is broken into rows as we would probably want to do both row and field based input processing and validation
- What would the first thing we would check for at the row level before processing any further input?
