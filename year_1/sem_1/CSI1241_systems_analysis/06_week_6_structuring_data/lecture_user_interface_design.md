# User Interface Design

## Introduction

- How a user is able to interact with a computer system can make the difference between a system being accepted or rejected by users
- Reflect on the computer systems you have used
	- What was your experience like?
	- Were they all equally easy to use?
	- Were some frustrating?
		- In what ways?
- Clearly by putting some time and thought into this, you are more likely to provide an acceptable system to the majority of your users

### Questions to Ask

- How pleasant is the user interface?
	- Do you enjoy working with the system?
- Does it contribute to the user obtaining their goal in using the system?
- Does it assist in accurate and complete input?
	- A poorly designed interface may actually increase the number of input errors
- How long does it take to learn the system?
	- The easier the system is to learn the more users will be encouraged to cooperate with it
- Does the system have an adequate response time?
	- Too long response times create user frustration and can lead to input errors

### Scope of User Interface

- The scope of user interface design covers all aspects of what the users see and how they are able to interact with the computer system
- While this unit focuses on web based systems, this lecture will cover the range of issues with respect to all user interface design
	- Reports
	- Screens etc.
- Also, the word *design* is used here when describing for example the layout of a web page
- Some would call this design rather than analysis
- However the view taken here is that the definition of the layout of reports, screens, web pages and input forms is still the provice of the systems analyst and in any case it is part of the requirement specification

## Human Factors Principles

- Keep it simple
- Be consistent
- Reduce complexity
- Cohesion
- Provide user shortcuts
- Allow easy reversal of actions
- Handle errors consistently and correctly

### Keep it Simple

- Use terminology appropriate to your audience
- Use mnemonic coding (ie. M for male) only where blatantly obvious
- Simple screen displays, web pages and reports
- Use new pages sparingly in web based systems
	- There is a balance between too much information inside one page and calling up others

### Be Consistent

- Be consistent with
	- Terminology
	- Screens
	- Menus
	- Buttons
	- Standard escape sequences
	- Error messages
	- Help dialogs
- A consistent system is one that users feel comfortable with and can master quickly

### Reduce Complexity

- Human memory issues
	- "Seven plus or minus two" (Miller, 1956)
	- Whenever feasible, let the user recognise rather than having to recall
	- This reduces memory load, recognition reduces typing errors
- Don't overdo augmentation 
	- For example, blinking lights
	- Minimise highlighting
	- Limit flashing or auditory messages
- Don't get the user lost
	- Site maps
	- Graphic reminder of menu paths in help function
	- Menus restricted to three levels
	- Similarly restrict web page depth

### Cohesion

- Screens, webpages, forms and reports should be cohesive
- Sections within them should be cohesive
- Neighbouring data items should be related in some way such as
	- Logically
	- Temporally
	- By task etc.

### Provide User Shortcuts

- Since not all users will be equally competent, provide for range of skill
	- Direct page or screen access to reduce clicks and shorten time
	- Use of function keys for power users
- This means provide different ways of doing the same task

### Allow Easy Reversal of Actions

- Erase commands
- Undo commands
- Escape menus
- Allow for reversal of a single action, data entry or even a complete group of transactions
- Paging back

### Handle Errors Consistently and Correctly

- Specific messages suggesting cause of errors
- Help functions providing detailed assistance
- Diplomatic error messages
- Always try to include instructions on what to do next to correct the problem
- Use specific, constructive terms in error messages
- When users make errors, they often need "how to move on" information

#### Examples of Poor Error Messages

- Error 57
- Data entry error
- Array overflow
- Error!

#### Examples of Improved Error Messages

- The file name you have typed was not found, press F2 to list valid file names
- Please choose an option from the menu
- You have typed a value outside the range of accepted values, press F9 for a list of acceptable values
- The file name you entered already exists, press F2 if you want to save it to a new name

## Web Page and Screen Design Issues

- To a large extent, many of the issues affecting web page design apply to screen design as well
- Try to prevent user errors
	- Anticipate potential problem areas and help the user avoid making mistakes by forcing the choice upon the user and avoiding typing by the user
		- Use pulldown menus, rollovers or radio buttons
		- Pulldown menus etc. reduce typing which is the biggest source of mistake
		- Speeds up the task as well
		- Gray out menu choices or buttons when they are not available

### Formatting

- Use a light pastel colour as background with dark colour as foreground
- Use no more than four colours on a single page
- Use no more than seven colours on a single system
- Use no more than 3 different fonts on a single screen or page
- Use bold, italic, underline format sparingly but consistent
- Use upper and lowercase letters, not all uppercase
- Use banners and coloured headings
- Some graphics are good but not too many
- Use page tracker to show position inside website
- Make buttons visually distinctive and highlight the instruction such as **submit** or **cancel**

### Display Issues

- Status messages
	- Usually a single line appearing near the bottom of the screen
	- Similarly a consistent style of pop-up message should appear on a web-based system
	- Users may not be aware of this so use attention-getting techniques to shift the user's focus
- Static objects (buttons, icons etc.)
	- Should appear in exactly the same location on all screens

## Report Design Issues

- We should not forget the important role that reports play in most information systems
- Many of the concepts previously discussed apply to reports too
	- Use of capitals
	- Bold, underlining
	- Complexity etc.

### Example of Reports

- External outputs
 	- Invoices
 	- Pay cheques
 	- Airline tickets
 	- Travel itineraries
 	- Telephone bills
 	- Electricity bills
- Internal outputs
 	- Detailed reports
 	- Summary reports
 	- Exception reports
 	- Decision support enquiries
 	- Graphs, charts
- Turnaround outputs
	- Forms that are printed out and after further details are added and form becomes a source document to input data
- Internal controls for outputs
	- Timing and volume
	- Distribution
	- Control totals
	- Access controls

### Report Design Issues

#### Outputs

- Should be easy to read and interpret
- Every report should have a title
- Use section headings to segment blocks of data
- Legends should be used to formally define all fields on a report
- Timing of reports is important
- Ensure correct distribution
- Outputs must be acceptable to the users who receive them
	- For example, at the right level of detail

#### Input Options

- Online keyboards
- Mouse or other pointing devices
- Touch screens
- Light pens
- Barcode readers
- OCR
- MICR
- Voice
- Push button telephone
- Special purpose terminals

#### Forms

- Use consistent field labels and abbreviations
- Movement from field to field (tab order)
- Provide default value in fields whenever possible to minimise data entry
- Provide explanatory messages for expected field inputs or data entry error
- Required vs. optional values
- Dependent values
	- Need to be filled in only if another field has a particular value entered

#### Input Design Issues

- Minimise the amount of typing or handwriting
- Enter only variable data
- Use codes where feasible
- Develop a standard for input forms
- Standardise all responses
- Provide instructions for completing forms
- Design mail documents to fit envelopes
- Use of mouse vs. function keys
- Consider light pens and barcodes as an alternative

#### Usage Issues

- Throughput
- Backlog
- Internal controls
- Accuracy
- Boredom
- Learning rates
- Environmental considerations

#### Checks to ensure data is valid

- Completeness checks
- Limit and range checks
- Combination checks
- Self-checking digits
- Date validation
- Password and other security checks

# Review

- List human factor principles
	- Keep it simple
	- Be consistent
	- Reduce complexity
	- Cohesion
	- Provide user shortcuts
	- Allow easy reversal of actions
	- Handle errors consistently and correctly
- What is the maximum desirable number of colours on a web page?
	- Four colours
- What is the maximum desirable number of fonts on a web page?
	- Three fonts
- What is a turnaround document?
	- Forms that are printed out and further details are added to the form by the client
	- Form then becomes a source document to input data
- Give examples of:
	- External outputs
		- Invoices
		- Pay cheques
		- Airline tickets
		- Travel itineraries
		- Telephone bills
		- Electricity bills
	- Internal outputs
		- Detailed reports
		- Summary reports
		- Exception reports
		- Decision support enquiries
		- Graphs, charts
	- Input options
		- Online keyboards
		- Mouse and other pointing devices
		- Light pens
		- Barcode readers
		- OCR
		- MICR
		- Voice
		- Push button telephone
		- Special purpose terminals
- List five input design issues
	- Minimise the amount of typing or handwriting
	- Enter only variable data
	- Use codes where feasible
	- Develop a standard for input forms
	- Standardise all responses
	- Provide instructions for completing forms
	- Design mail documents to fit envelopes
	- Use of mouse vs. function keys
	- Consider light pens and barcodes as an alternative
- List four checks to ensure data is valid
	- Completeness checks
	- Limit and range checks
	- Combination checks
	- Self-checking digits
	- Date validation
	- Password and other security checks