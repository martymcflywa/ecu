# Data Dictionary

- The data dictionary is where all definitions of data will be recorded
- It is a section in the requirements specification
- Systems analysts define all the data being used in the system so that others, such as programmers, can later on read these definitions and can then develop the system accordingly

## Types of Definition

- There are two types of definition to be stored:
	- Elementary
	- Composite
- Elementary is data which for our purposes need not be split down any further
	- Customer number
	- Part number
- Composite definitions are composed of elementary definitions
	- A document which contains many elementary data items

# Elementary Data Sub-Section

- Each elementary data item appears **only once** in this sub-section even though the data item appears in many pages and documents throughout the system
- The data items are sorted into alphabetical order so that they can be easily found by others
- We need to create a list of all the data items to be used in the system and start to populate this sub-section

## Elementary Definitions

- Each data item contains:
	- Name
		- Account number
	- Type
		- Character
	- Size 
		- 8
	- Format
	- Constraint
	- Legend

### Type

- Type can be *character*
	- Alphabetic, numeric or other keyboard character
- Type can be *date*
	- 12/12/2014
- Type can be *alphabetic*
	- Any stream of alphabetic characters
- Type can be *alphanumeric*
	- Any stream of alphabetic and numeric characters

#### Website Types

- Type can be *link*
	- The icon is a link to another part of the website, or another website
- Type can be *button*
	- Some executable program is initiated on pressing the button

### Format

- Format provides a statement of the structure of the elementary data item
- Sometimes it is not used depending on the type
- Examples:
	- `dd/mm/yyyy` to show the structure of a data type
	- `$` to indicate dollar format, `12345.67`
	- `ZZZ9` indicates leading spaces for a 4 digit number
		- `___76`
	- Pulldown indicates that a pull-down menu is being used
	- Radio indicates that radio buttons are employed

### Constraint

- A constraint is any restriction placed on the range of values that may be assumed by a data item
- A constraint may be
	- A member of a set, or one of a list of possible values
		- Amex, Visa or MasterCard
	- Limited to a range of numeric values
		- 100 - 500
	- A limitation in the characters that may be used within a data item
		- Car registration number must always begin with `1`, `6`, `7`, `8` or `9`

### Legend

- This is positioned at the end of the elementary data dictionary sub-section
- Here a reader is informed of the coding system used by the writer
- Mostly the legend defines the codes used in the type column, such as `N` or `D`
- Sometimes codes are used in the format or constraint column too
	- `$` for dollar format
	- `Z` for leading spaces
	- `$ZZZ9.99`

## Elementary Data Quiz 1

- What's the elementary data dictionary for
	- `employee-no` ie. `1235`
	- `employee-name`

| Name            | Type   | Size | Format | Constraint |
|-----------------|:------:|:----:|:------:|------------|
| `employee-name` | `x`    | 35   |        |            |
| `employee-no`   | `x`    | 5    | 99999  |            |

**Legend:**  
`x` = any character  
`9` = any digit

### Answer Notes

- Since there will be no actual calculation performed on `employee-no`, `x` (any character) is chosen and the format limits it to any digit
	- Marks will be lost in assignments and exams if you do not follow this rule
- Since people's names may contain spaces, hyphens or apostrophes, use `x`
	- Marks will be lost in assignments and exams if you do not follow this rule

## Elementary Data Quiz 2

![bank statement](http://i.imgur.com/ZJtMwXU.png)

- Create elementary dictionary items for each data item on the bank statement
- There will be a problem defining trans-no since the size varies depending on whether it is a deposit or withdrawal
- We will deal with this later in the lecture
- For the moment, define two elementary items
	- `deposit-no`
	- `withdrawal-no`

| Name             | Type | Size | Format     | Constraint                  |
|------------------|:----:|:----:|------------|-----------------------------|
| `account-name`   | `x`  | 15   |            |                             |
| `account-no`     | `x`  | 8    | 9(8)       |                             |
| `amount`         | `N`  | 8    | $          |                             |
| `balance`        | `N`  | 8    | -$         |                             |
| `deposit-no`     | `x`  | 7    |            | `D` + 999999                |
| `statement-date` | `D`  | 10   | dd/mm/yyyy | last day of the month       |
| `status`         | `x`  | 1    |            | must be `*` for -ve balance |
| `trans-type`     | `A`  | 1    |            | either `D` or `W`           |
| `withdrawal-no`  | `x`  | 8    |            | 999999 + `/W`               |

**Legend:**  
`A`: alphabetic  
`N`: numeric  
`D`: date format  
`x`: any character  
`9`: any digit  
`$`: leading spaces but ends in `.99`  
`-`: leading negative sign possible

# Composite Data

- In organisations, data usually occurs in groups
	- Web pages
	- Documents
	- Files
- This is composite because it is structured out of elementary items
- Note that we are only interested in capturing the *dyamic* data into the data dictionary
	- Things that change
- Note that most web-based systems designed today, which include headings, titles, pictures etc are defined in the composite data dictionary since they can be changed on the web page layout via middleware

## Composite Data Dictionary Sub-Section

- The requirements specification contains a composite data dictionary sub-section
- Within this sub-section there are a number of further sub-sections
	- One for each type of composite ie:
		- Web pages
		- Documents
- Within these, the definitions are defined alphabetically for easy access

## Composite Definitions

- The same notation is used to describe any type of composite data
- There are four concepts involved (otherwise known as constructs)
	- Sequence
	- Repetition
	- Selection (and case)
	- Optionality

### Sequence

- The top lne of the bank statement shows three data items occurring serially
	- `statement` = `account-no` + `account-name` + `statement-date`
- Write the composite definitions for your student card or driver's licence

### Repetition

- Wrapped inside `{}`
- The bottom part of the bank statement shows a series of lines which are repeated:

`statement` = `account-no` + `account-name` + `statement-date` + `{trans-no + trans-type + amount + balance + status}`

- The curly brackets indicate that a series of lines exist
- The above is not equivalent to:

`{trans-no}` + `{trans-type}` + ...

Which would be shown as:

D10756 + D10159 + 700557/W + D + D + W + ...

- Upper and lower limits, if known are shown as follows:
	- `2{item}` lower limit only known
	- `{item}5` upper limit only known
	- `2{item}5` both upper and lower limits known

### Selection

- The `trans-no` field actually contains two different forms of transaction:
	- One to describe a deposit
	- One to describe a withdrawal
- This is selection
	- For example, either one type or the other must appear (but not both)
- Wrapped inside `[]` and separated by `|`
- Selection is shown as:

`statement` = `account-no` + `account-name` + `statement-date` + `{[widthrawal-no | deposit-no] + trans-type + amount + balance + status}`

### Case

- The concept of selection can be extended to describe a more general situation - CASE
- Case is where two *or more* alternatives exist and one has to be chosen
- Wrapped inside `()` separated by `|`

`main-course` = `[meat | fish | vegetarian]`

### Optionality

- When an account goes into the *red*, an asterisk is shown in the status column
- This is known as optionality, because it may or may not appear
- Note that optionality is different from selection
	- With selection, something must appear
- With optionality, it may or may not appear
	- Like includes/extends

`statement` = `account-no` + `account-name` + `statement-date` + `{[withdrawal-no | deposit-no] + trans-type + amount + balance + (status)}

### Nesting

- It is possible to *nest* composite definitions
- Nesting means to embed one definition within another

`statement` = `account-no` + `account-name` + `statement-date` + `{line}`  
`line` = `[withdrawal-no | deposit-no]` + `trans-type` + `amount` + `balance` + `(status)`

- As well as being easier to read and understand, `line` can be reused in other definitions thus simplifying the definition there as well
- Going back to the earlier problem with `deposit-no` and `withdrawal-no`, we can now define `trans-no` as a nested composite data item

`trans-no` = `[deposit-no | withdrawal-no]`

- And define `deposit-no` and `withdrawal-no` as elementary items

## Standard Naming

- If we adopt standard ways of naming data items, then a lot of confusion can be avoided
	- Always use lower case names
		- Easy to cut and paste
	- Always hyphenate
		- Rather than use combination of approaches
	- Always qualify a name
		- If we just say date, is it today's date or `report-date`?
		- This is why we used `statement-date` in the data dictionary so it is much clearer
- A standard approach to naming composite items also makes sens
- It means all developers have a shorthand to describe common structures
	- For example, on a web page, typically there are many blocks or divisions
		- We will use the word *para*
		- `web-page` = `header-para` + `detail-para`
	- Similarly in reports we can use the suffix *-line*

## Buttons, Pulldowns and Rollovers

- With online systems and the internet, significant use is made of
	- Buttons to execute functions
	- Pulldown menus to provide the use with a range of choices
	- Rollover menus, similar function to pulldown menus
- Use the type or format columns to deal with these

## Exercise

Create elementary and composite data dictionary definitions for the following web page

![data dictionary exercise](http://i.imgur.com/srWZb4k.png)

### Elementary Data Dictionary

| Name              | Type | Size | Format | Constraint                             |
|-------------------|:----:|:----:|--------|----------------------------------------|
| `clear-button`    | `B`  | 10   |        | `name` = Clear Form                    |
| `comments-para`   | `X`  | 256  |        |                                        |
| `first-name`      | `X`  | 20   |        |                                        |
| `last-name`       | `X`  | 20   |        |                                        |
| `learning-choice` | `X`  | 1    | `CB`   | one of Word, Excel or PowerPoint       |
| `payment-para`    | `X`  | 1    | `R`    | one of cash, eftpos, cheque or credit  |
| `post-code`       | `X`  | 4    | `9999` |                                        |
| `street-name`     | `X`  | 30   |        |                                        |
| `street-no`       | `X`  | 4    | `ZZZ9` |                                        |
| `street-type`     | `X`  | 10   | `P`    | one of a set: `\std\street-types.doc`  | 
| `state`           | `X`  | 3    | `P`    | States                                 |
| `submit-button`   | `B`  | 18   |        | `name` = Submit Information            |
| `suburb`          | `X`  | 30   |        |                                        |

**Legend:**  
`X`: any character  
`B`: button  
`P`: pulldown menu  
`Z`: leading spaces  
`R`: radio button  
`CB`: checkbox

### Composite Data Dictionary

`details-para` = `first-name` + `last-name` + `street-no` + `street-name` + `street-type` + `suburb` + `state` + `post-code`

`learning-para` = `1{learning-choice}3`

`States` = `[WA, SA, VIC, NSW, QLD, TAS, NT, ACT]`

`web-page` = `details-para` + `learning-para` + `payment-para` + `comments-para` + `submit-button` + `clear-button`

# Review

- Define the following:
	- Elementary data item
		- Single piece of data at the lowest level of abstraction
			- Customer number
			- Part code
			- Invoice date
		- Elementary data items contain
			- Name
			- Type
			- Size
			- Format
			- Constraint
	- Composite data item
		- A group of elementary data items that relate to each other during use of system
		- Involves four concepts
			- Sequence
			- Repetition
			- Selection
			- Optionality
	- Constraint
		- Any restriction placed on the range of values that may be assumed by elementary data item
			- Possible values
				- Amex or Visa or MasterCard
			- Limited to range of numeric values
				- 100 - 500
			- Limitation in characters that may be used within data item
				- Must begin with `1`
	- Sequence
		- The order in which elementary data items appear
		- The sequence must be displayed in composite data items
	- Repetition
		- Where composite data items are repeated (see bank statement)
		- Expressed by:
			- `{trans-no + trans-type + amount + balance + status}`
		- To express known upper and lower limits of repetition
			- `2{item}` lower limit only known
			- `{item}5` upper limit only known
			- `2{item}5` upper and lower limits known
	- Selection
		- Expresses where one of two or more elemetary data items could be shown in place of each other
		- For example, either show `deposit-no` or `withdrawal-no`
		- Expressed by: 
			- `{[deposit-no | withdrawal-no]}`
	- Case
		- Where two or more alternatives exist and one has to be chosen
		- Like *switch statements* in programming, where each `case` is a possible input
		- Expressed by:
			- `main-course` = `[meat | fish | vegetarian]`
	- Optionality
		- Where an elementary data item may or may not appear
		- `status` is optionally expressed by:
			- `statement` = `amount` + `balance` + `(status)`
	- Nesting
		- To embed one definition within another
		- Allows the embedded composite data definition to be reused elsewhere
		- `line` is a nested composite definition expressed by:
			- `statement` = `account-no` + `account-name` + `{line}`
			- `line` = `[withdrawal-no | deposit-no]` + `trans-type` + `amount`