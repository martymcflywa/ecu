# Designing and writing applications

## Objectives

- Plan the mainline logic for a complete program
- Describe typical housekeeping tasks
- Describe tasks typically performed in the main loop of a program
- Describe tasks performed in the end-of-job module
- Understand the need for good program design
- Appreciate the advantages of storing program components in separate files
- Select superior variable and module names
- Design clear module statements
- Understand the need for maintaining good programming habits

## Understanding the mainline logical flow through a program

- Understand what the goals are
	- Ask the user to clarify if necessary
- Ensure you have all the data required to produce the desired output
	- Do all your forms and form fields match what is being stored and returned from the database
- Understand the big picture first

## Understanding the need for good program design

- Good design is
	- Critical for large programs
	- Needed to guarantee that components work together properly
- Well designed program modules should work
	- As standalone modules
	- As part of larger systems

# The application environment

## Environment selection

- Developers cannot always assume they will be using the same languages and environments on all jobs
- You should choose the environment that suites the task
	- Not the one that suites the developer/s
- Issues include
	- What environment will your web app run on
		- Linux
		- Windows
		- Mac
	- What language will you use
	- What database system
	- What are the hosting cost implications
		- Open source solutions such as php/mysql are cheaper to host
			- Compared to proprietary solutions
				- ie. .net / mssql

## Hosting services

- Web apps can be hosted in-house within a company
- Can also be hosted with external providers
- Along with hosting comes the cost of domain names
- There are a huge selection of hosting services in Australia and worldwide
- Some hosts provide all possible solutions while others specialise
	- Languages
	- Databases
	- Operating systems
- If a client already has a host
	- Then as developers you may be locked into the environments and versions supported by that host
- If not
	- The client needs to know the costs and issues involved with web application hosting so that they can be involved in the selection process
- While hosting services do not necessarily need to be selected prior to deployment
	- It does help

### Internal hosting

- Means that a company should have sufficient technical support to keep web and database servers up and running
- Internally hosted web applications can either be
	- Internally accessible only
	- Externally accessible from public web
- Most large web apps separate public and internal access
	- Restrict this through
		- User accounts
		- Domain restrictions
			- Only local ip address can access certain parts of the site
- Internal hosting gives more control and privacy to a company and its systems
	- Brings with it the requirement of
		- Support
		- Management of system uptime
- Disadvantage
	- Can be expensive
		- Leased lines
		- Static ip
		- Support staff

### External hosting

- Reduces in-house technical support requirements
- Most hosting services will provide service level agreements (SLA)
	- System will be up a certain amount of time
		- ie. 99%
- Can also provide load balancing for heavy use periods
- Application errors are not covered by their support
	- Only provide the environment in which an application runs
- Modern hosting services have user friendly interfaces for
	- Managing
	- Configuring
	- Uploading
	- Back up
- Hosting services typically now include out of the box
	- Payment gateways
	- HTTPS
	- Shopping cart
- Disadvantage
	- Lack of control of environment and application

### RDBMS selection and issues

- Business data stored in relational database management systems
- Mainstream solutions
	- MySQL
	- MSSQL
	- Oracle
	- IBM DB2
- Require multi processor machines
	- Licensed on per processor basis
		- ie. 4 processors = 4 licenses
- For mission critical applications
	- Database server needs to be mirrored
	- Or have fail over capacity
		- ie. Exact duplicate machine takes over instantly if primary server fails
- Databases should **NEVER** be facing the public web

## The web / database server environment

![web db server environment](http://snag.gy/tcrqr.jpg)

- In the example above
	- The database server sits inside a local only network topology
- The public facing web server and application can access the database through a secured, port locked connection
- Firewalls can protect the web server
	- While proxies and firewalls protect the internal network
- The public facing side of the environment is called the
	- Demilitarized zone (DMZ)
		- ie. Less control and order
- The public facing machine should be as secure as possible and run only what it needs to service the function
	- ie. Only
		- OS
		- Web server
		- Scripting environment
- Unless otherwise required, all ports except port 80 should be locked off
	- HTTP port

### Test environments

- Where possible
	- Development environment should mimic production environment
- This means that changes made in the test environment should be more predictably reflected once moved to the production environment
- Especially critical is that both test and prod environments have same versions of
	- Scripting language
	- Web server
	- Database server
	- User / security privileges

## Code libraries and includes

- Just as you can store functionality in modules, functions or procedures
	- You can store these structures in files external to your mainline logic
- Instead of having one or more huge script files
	- You place all your common and reusable code elements into external files
		- Which can be read in as needed
- Common type of code libraries can include
	- Menu systems
	- Database connections
	- User auth
	- Usage logging

### Include example

- In this example, we create a menu in one page
- We call it in all pages that then need a menu included in it
- If we need to alter the menu system
	- We open one file and make our changes
- All files to include that menu see the change next time they load

**`menu.php` code:**

``` html
<html>
<body>
<a href="http://www.example.com/index.php">Home</a>
<a href="http://www.example.com/about.php">About Us</a>
<a href="http://www.example.com/links.php">Links</a>
<a href="http://www.example.com/contact.php">Contact Us</a><br />
```

**`index.php` code:**

``` html
<?php include("menu.php"); ?>
<p>This is my home page that uses a common menu to save me time when
	I add new pages to my website!</p>
</body>
</html>
```

![includes](http://snag.gy/kaETf.jpg)

### Storing program components in separate files

- There are some issues with storing files separately, especially in web apps
	- Must ensure files do not sit in the website proper
		- So that external users can access them directly
	- This can be done by configuring a virtual folder in the web server which sits outside the web server root
	- The extension should be in the processing language
		- Else if clicked, it will display the code as a page in the browser
			- ie. Name all asp files with .asp extension
		- Will ensure that .asp files will be processed instead of displayed
- The following example illustrates the issue with putting function files in publicly accessible locations

#### Publicly accessible code example

- This is my db connection function file sitting in publicly accessible web folder

![public code 1](http://i.imgur.com/IcY9DEp.png)

- When clicked, the server tries to process it
	- But as it has no handler for .inc files
		- MIME type
	- It spits it out as text

![public code 2](http://i.imgur.com/gHvg3HV.png)

- Now a potential hacker knows the db location and passwords

![public code 3](http://i.imgur.com/sYLCsBF.png)

## Application features

## Core features of any application

- While there are obviously far too many types of applications and features to cover
	- The following are some core basics
- These are more guidelines than rules
	- But can lead to a better quality outcome
- Some seem obvious, others can rear their head only once development has commenced

### Navigation

- Role of navigation is to make the application easier to use
	- Not harder
- Navigation style and method should be consistent
	- ie. Do you have menus across the top, side, bottom
		- Never in all three places at once
- Ensure it is the same on ALL pages
- Every page should have a link to the home page
- Users should never have to resort to using the back button in the browser to navigate between pages
- Where possible, use breadcrumb menus to show users where they are in a structure
- Users should be no more than three clicks away from homepage to desired content

### Interface

- It should be consisten across all pages
- Use centralised CSS to format all pages
- Keep font, color and sizing variation to a minimum
- Do not include annoying background sounds or mouse altering gimmicks
- Ensure images and other non-text content is appropriately sized
	- So it does not take forever to load
- Try to avoid functionality that requires non-standard plugins to be installed
- Try design for minimal screen resolutions
	- ie. Assume something along the lines of 1024 x 768
	- Users do not mind scrolling up/down
		- But do not like scrolling left/right

### Browser compatibility

- At a minimum, web app should run with
	- IE
	- Mozilla
	- Safari
	- Chrome
- The more specialist your client side interface is, the less likely it is to work across all browsers and platforms
	- ie. ActiveX
- Backwards compatibility can be a real issue
	- Do you test against the current crop of browsers
	- Or backtest for the last few versions
- This is a decision that needs to be made in conjunction with clients
	- Not just by the devs to make things easier
- Organisation across the world are littered with web apps that only work on specific environments, which defeat the purpose
	- A specific browser and version
	- A specific OS

### User management

- Can be very time consuming element of web app coding
- Number of issues
	- Adding, editing, removing users
	- Users with different levels of access
	- Users editing their own data
	- Do you delete users or only disable their access
	- Login limits
	- Lost passwords
- Most systems allow users to change their own password
	- Do you enforce password policies
	- Do you prevent them from using previous passwords
- When logging in, do you enforce a limit
	- If so, is the lockout based on
		- Time
		- Or does admin have to re-enable the account
- Do you give users a reminder question to retrieve forgotten passwords
	- If so, do you show the password on-screen, or generate a temp password and make them login and change it
- When creating a new user account or allowing a user to change their password
	- Always include the password field twice to confirm they typed it correctly

### Logging

- In any application where users login to add, edit or delete data, a record should be kept, including
	- When users logged in/out
	- IP address
	- When data was added/edited/deleted
- There is no need to capture all data
	- Just enough to be useful later
- Try not to capture record id, as these may later be deleted which makes reading logs more difficult
- A simple log may be:
	- `USER jbrown LOGGED-IN AT TIME 12:00:05-22-08-2010 FROM 203.123.23.99`
	- `USER jbrown ADDED ITEM BrandCo Plasma TV AT TIME 12:01:45-22-08-2010 FROM 203.123.23.99`
- Logs provide an audit trail and accountability
- Also indicate patterns of unusual usage such as
	- Multiple failed login attempts
	- Users logging in at unusual times
	- Patterns of incorrect usage
	- Usage patterns for load balancing
		- ie. High/low periods
- Can also record other details such as what browser people are using to connect to the site
- More advanced logging includes click-stream analysis where you can track a user from the time they enter a site until they leave
	- Especially useful for commercial sites to analyse patron browsing habits

### Validation and error messaging

- On any form you present to a user
	- Make it clear what is a required field
- For some fields, provide a simple example of acceptable input
	- For example, `dd/mm/yyyy` next to the date field
- When the form is validated, display ALL errors in a list
	- Not one at a time, otherwise users have to go back and forth to the point where they give up
- For large forms it may be necessary to use sessions to record all form fields
	- So that if the user has to go back and fill the form again, all the fields can be automatically repopulated

### Accessibility

- People with sight impairment should be able to use the web application as well
- W3C has guidelines of making sites usable
	- Including Web Content Accessibility Guidelines (WCAG) 1 & 2
- By 2015, compliance to WCAG 2.0 for Australian Government websites will be mandatory
- Depending upon the application, site owners can face discrimination claims if their site is not reasonably accessible

# Summary

- Three steps to designing a good program
	- Understand the output that is required
	- Ensure you have the necessary input data
	- Plan mainline logic
- Housekeeping tasks done at the beginning of the program
	- Declaring variables
	- Opening files
	- Printing headings
- Main loop is controlled by EOF decision
- Each data record passes through the main loop once
- End of job steps done at end of the program
	- Printing summaries, closing files
- Good design becomes more critical as programs get larger
- Program components can be stored in separate files
- Select meaningful, pronouncable names
- Avoid confusing line breaks
	- Use temporary variables
	- Use constants where possible
