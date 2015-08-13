# Modularization, hierarchies and documentation

## Objectives

- Describe advantages of modularization
- Modularize a program
- Understand how a module can call another module
- Explain how to declare variables
- Create hierarchy charts
- Understand documentation
- Design output
- Interpret file descriptions
- Understand attributes of complete documentation

## Modules

- A module is a unit of code that performs one small task
- Called
	- Subroutine
	- Procedure
	- Function
	- Method

### Modularization

- Breaking a large program into modules
- Should be considered non optional
- Advantages
	- Provides **abstraction**
	- Allows multiple programmers to work simultaneously
	- Allows code reuse
	- Makes identifying structures easily

### Abstraction

- Focusing on important properties while ignoring non essential details
- Avoids the low level details and uses a high level approach
- Makes complex tasks look simple

#### Abstraction example: To-do list

- With abstraction
	- Do laundry
	- Call Aunt
	- Start term paper
- Without abstraction
	- Pick up laundry basket
	- Put laundry basket in car
	- Drive to laundromat
	- Walk into laundromat
	- Set basket down
	- Find quarters for machine machine
	- ...

### Multiple programmers to work on a problem

- Large programming projects can be divided into modules
- Modules can be written by different programmers
- Development time is significantly reduced

![multiple programmers](http://snag.gy/Vpmbw.jpg)

### Reusability, reliability and efficiency

- Reusability
	- The ability to use modules in a variety of applications
		- Error trapping
		- Logging
		- User authentication
- Reliability
	- Assurance that a module has been tested and proven to function correctly
	- If the module has been written as a standalone entity then linked to other code and errors occur
		- The links or other code is the first place to look for problems
- Efficiency
	- Makes it much easier to locate code elements for maintenance
	- Only one change needed to update one instance of function
		- Which then updates application wide code
	- ie. Only one error trapping module to be updated for entire application
		- Instead of updating every instance of non modularized error trapping

![error module](http://snag.gy/hU24s.jpg)

### Identify structures easier

- Combining several tasks into modules may make it easier for beginning programmers to
	- Determine if a program is structured
	- Identify structures in a program
- Experienced programmers modularize for
	- Abstraction
	- Ease of dividing the work
	- Reusability
- Minimal structure

![structures 1](http://i.imgur.com/hvtR4f6.png)

![structures 2](http://i.imgur.com/pEkLRk0.png)

## Modularizing a program

### Typical structure

- Most programs contain a **main module**
	- Contains the **mainline logic**
	- Access other modules or subroutines as required
	- In most structures:
		- Subroutines are called
			- Do their job
		- Return to the mainline logic

### Naming modules (functions / subs)

- Rules for module names used here:
	- Must be one word
	- Should be meaningful
	- Are followed by a set of parenthesis `()`

![module names](http://i.imgur.com/z6lRSbz.png)

### Module flowchart

- Calling program (or calling module)
	- One that uses another module
- Flowchart symbol for calling a module
	- Rectangle with bar across the top
- Flowchart for the module contains
	- Module name in the start symbol
	- `exit` or `return` in the stop symbol
- When a module is called
	- Logic transfers to the module
- When the module ends
	- Logic transfers back to the caller

![module flowchart](http://i.imgur.com/O6tODg8.png)

### Modules calling other modules

- Knowing when to break a module into its own subroutine or submodules is an art
- **Best practice:**
	- Place together statements that contribute to one specific task
- **Functional cohesion:**
	- Extent to which the statements contribute to the same task
- **Note:**
	- Over-modularised applications can be as difficult to manage as under-modularised ones

![modules calling other modules](http://i.imgur.com/fgcGYrG.png)

## Variables and modularisation

- **Local variables:**
	- Declared within a module and only work within that module
- **Global variables:**
	- Declared at the beginning of the program
	- Can be accessed by all modules
- **Data dictionary:**
	- List of variables used in a program
	- Includes
		- Type
		- Size
		- Description
		- Which modules use them

### Declaring variables

![declaring variables](http://i.imgur.com/l1edfef.png)

### Passing variables as parameters

- In most instances of calling a module
	- You need to send it data to work with:

``` asp
workingWeek = 40
workedHours = 50

if workedHours > workingWeek then
	call overtimeModule(workedHours, workingWeek)
end if

function overtimeModule(workedHours, workingWeek)
	totalOvertime = workedHours - workingWeek
	return totalOvertime
end

print "You worked a total of " . totalOvertime . " hours of overtime."
```

- In the example above
	- The mainline logic has called the `overtimeModule()`
	- Sent it some data to work with
		- `workedHours` and `workingWeek`
	- And received a computed value

### Calling modules without parameters

- If your module does not need any input
	- Then you can call it as is:

``` asp
call logoutModulel()

sub logoutModule()
	destroySession
	print "You have been logged out"
	exit
end
```

- Another option is where you call a module with parameters
	- But do not return to the mainline logic:

``` asp
call errorModule(errorType="1")

sub errorModule(errorType)
	print "The following error has occurred: " . errorType
	print " and the program is exiting."
	exit
end
```

## Creating hierarchy charts

- Hierarchy chart
	- Illustrates module's relationships
	- Tells when routines call which other routines
	- Does not tell when or why the modules are called

![hierarchy chart](http://i.imgur.com/K3m7GnA.png)

- Dark corner indicates a module that is **used more than once**

![dark corner more than once](http://i.imgur.com/aBTU66I.png)

## Understanding documentation

- **Documentation:**
	- All supporting material that goes with a program
	- Two major categories
		- For users
		- For programmers
	- Usually created by system analysis and/or tech writers
	- May be printed or digital
- **End users:**
	- People who use computer programs
- **Program documentation:**
	- Internal documentation
		- Comments within code
	- External documentation
		- Supporting paperwork written before programming begins

### Code comments

- Comments should be
	- Short
	- Sharp
	- Sweet
	- To the point
- Do not just repeat the code that you are trying to comment
- Write commends
	- Before the code
	- Or on the same line
	- Never after

``` java
String s = "Wikipedia"; // assigns the value "Wikipedia" to the variable s.
```

``` c
 /*
  * Check if we are over our maximum process limit, but be sure to
  * exclude root. This is needed to make it possible for login and
  * friends to set the per-user process limit to something lower
  * than the amount of processes root is running. -- Rik
  */
 if (atomic_read(&p->user->processes) >= p->rlim[RLIMIT_NPROC].rlim_cur
	 && !capable(CAP_SYS_ADMIN) && !capable(CAP_SYS_RESOURCE))
	 goto bad_fork_free;
```

- The the **multiline** example above
	- Align comments to the left
	- Include basic name details of the dev who wrote the code

### Output documentation

- Usually written first
- Represents the information needed by end users
	- May be initially created by end users

#### Print chart

- Printed reports
	- Designed using a **print chart**
- This is how you would plan for printed outputs

![print chart](http://i.imgur.com/rwQMMe2.png)

#### On-screen reports

- Reports to screen are typically more flexible as you do not have to fit-to-page
- As with printed reports, you will have
	- Headings
	- Totals
	- Other summary data
- However, you can enhance the output by linking to more detailed reports

![on-screen reports](http://i.imgur.com/ZAy17E9.png)

### Input documentation

- **Input documentation:**
	- Describes what input is available to produce the output
- **Database description:**
	- Describes the data stored in a file
	- Indicates
		- Fields
		- Data types
		- Lengths

![database description](http://i.imgur.com/2UJJDJj.png)

- You **must always** reflect the field lengths and data type requirements of your database in your web forms
- In the example above, if your form allows `> 15 char` to be entered for the `name` of an item
	- You will cause a data insert error on your database
- So in your user documentation and code commenting, you need to indicate for each field in a database table
	- Does it allow null
	- What is the datatype
	- Is there min/max length
	- Is there a set number of possible inputs
		- ie. `M` or `F`
	- Is the data reasonable
		- ie. Would you allow a date of birth `1850-01-01`
	- Is the data in the correct format
		- ie. `dd/mm/yyyy` OR `mm/dd/yyyy`
- Thus we are checking for the
	- Presence of data
	- Type of data
	- Reasonableness of data
- Some of these things can be checked on the client side before the form is submitted
	- Others need to be processed within the server side business logic of the application

![data validation to database](http://snag.gy/NNiIv.jpg)

### Completing the documentation

- Program documentation may contain
	- Output design
	- Input description
	- Flowcharts
	- Pseudocode
	- Program code listing
	- Data dictionary
	- ERDs
- User documentation may contain
	- Manuals
		- One for each functional step of the app
	- Instructional material
		- Tested with users
	- Operating instructions
		- Lots of screenshots
- User documentation
	- Written clearly in plain language
	- Usually prepared by system analysts and/or tech writers
		- Preferably not the programmers
			- Too technical?
- User documentation usually indicates
	- How to prepare input
	- User navigation
	- Allowable data
	- FAQs

## Summary

- Modules, subroutines, procedures, functions, methods
	- Smaller, reasonable units of code that provide reusability
- Modules can call other modules
- Variable declarations define the name and type of the data to be stored
- Hierarchy chart illustrates module relationships
- Documentation
	- All supporting material for a program
- Output documentation
	- Includes report designs
- File description
	- Details data types and lengths of each field of data in the file
- User documentation
	- Includes
		- Manuals and instructional materials for non-technical people
		- Operating instructions for operators and data entry people
