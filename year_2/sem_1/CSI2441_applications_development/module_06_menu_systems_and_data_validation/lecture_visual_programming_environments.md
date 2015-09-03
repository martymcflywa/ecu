# Visual programming environments

## Objectives

- Examine visual programming environments
- Look at Rapid Application Development (RAD) features of such environments
- Look at pre-built components
- Look under the bonnet at coding around visual components
- Interface and navigation automation
- Benefits and drawbacks of visual programming environments

## Introduction to visual programming environments

- Integrated development environments (IDE) can come in the form
	- Text based
	- Visual programming systems
	- Both
- Visual programming environments are designed to speed up traditional programming processes
	- Contain pre-built components which encapsulate programming tasks
		- Database connections
		- Data retrieval/display
		- Interface/navigation
		- Login/authentication
- Whole idea of visual system is to allow drag/drop rapid application development (RAD)

## Visual programming environments

- There are a number of visual programming environments on the market, ranging from freeware to expensive enterprise level softwre
- Some of the current include
	- Microsoft Visual Studio
	- Lily
	- BlueJ
		- Java
	- Adobe Dreamweaver CS4
	- Authorware
	- ColdFusion
	- Oracle Forms
- There are dozens if not hundreds of other environments which are designed for specialized programming tasks
	- Games
	- Audio
	- Multimedia
- Examples to follow are from Visual Studio 2008 in web programming mode

### Visual interface

![visual interface](http://i.imgur.com/NN0roiH.png)

### Split visual interface

![split visual interface](http://i.imgur.com/XmaR0Cv.png)

### Source code view

![source code view](http://i.imgur.com/fkY1gGe.png)

### Visual vs. text based coding

- As previous slides show, the developer can choose what mode they wish to use to develop
- In reality, if you are using a visual IDE like Visual Studio 2008, then you are probably doing so to make use of the visual drag and drop tools
	- Using a tool like this in code-only mode is like swatting a fly with a battleship
		- Overkill
	- There are more efficient text only tools to do such a job
- The benefits of the visual environment include
	- Pre-built controls
	- Auto-complete features
	- Limited on the fly error checking
		- Such as undefined variables being highlighted
- In almost any visual IDE, you will inevitably need to switch into source code mode to tweak features that cannot be done visually

## Visual site management

- When working in a visual IDE, adding new pages to a site and managing site navigation is typically a point and click affair

![visual site management](http://i.imgur.com/wn9Iw8K.png)

### Navigation

- Rather than hand coding navigation for each page, and links to other pages,
	- Navigation controls can be used to automatically manage navigation

![navigation 1](http://i.imgur.com/MMrxc6P.png)

- In this example, the sitemap is defined in a simple xml file
- In each page that requires navigation, this menu control can be used to present the same navigation
- For complex site structures, pre-built controls can be placed on each page which indicate to the user which page they are on within the site structure
- To do this in written code is both complex and time consuming
- Using pre-built controls, there is no code required and almost no code associated with the control doing all the work

![navigation 2](http://i.imgur.com/E0svZYG.png)

### Controls and components

- Whilst the terminology varies across platforms, normally we refer to a control or a component
- Controls
	- An encapsulation of a process into a pre-built representation of that process
	- Can receive input and produce output
		- But underlying code that makes them work is hidden
			- Most cases, copyrighted intellectual property
	- Can be customized to a certain degree by tweaking their settings
		- In terms of
			- Look
			- Feel
			- Functionality
	- Try to be specific in nature whilst also being as general as possible
		- Such as database connection control
		- To be able to be used in a large variety of applications

### Setting control properties

- The image below shows just some of the properties or settings for a drop down control list
- These are categorized in terms of
	- How it looks
	- How it is accessed
	- What it is called
	- How it interacts with data
- These properties represent the public programming interface between the control and the developer

![control properties](http://i.imgur.com/2MWdnQa.png)

## Data driven controls

- In terms of both desktop and web based development
	- Interaction between users and databases represent the core functionality of most applications
		- These interactions can be time consuming
			- Pulling data out of a database
			- Presenting it to users
			- Allowing users to interact with that data
				- Add
				- Edit
				- Update
				- Delete
- Real power of visual development environments is the provision of pre-built controls to assist in these processes
- As the following images demonstrate, drag and drop visual programming can be extremely quick and easy compared to hand coded solutions

### Data controls

- Using VS 2008 as an example, we can see a number of controls which perform common tasks
	- ie. Form view and data list
- In this example, we will take some product data from the Nwind DB
- Before performing any actions with the data, we must link to the database using the `AccessDataSource` control

![data controls 1](http://i.imgur.com/c7MHP3G.png)

- Here the control asks for the location of the DB file
- Then we can choose which parts of the DB we wish to read

![data controls 2](http://i.imgur.com/I82xa2r.png)

- Once the data source is configured and named, we can then add another control to display and manipulate the contents of the datasource
- In this case we hooked up a `GridView` data display control to our `Products` data source

![data controls 3](http://i.imgur.com/b9VbOBL.png)

- The pre-rendered `GridView` now displays all records in the `Products` table on the screen without a line of code being written

![data controls 4](http://i.imgur.com/WFOSAyR.png)

- With some simple clicks we can now heavily extend the functionality of the `GridView` control
- The left image below enables data sorting and management functions
	- Adding
	- Editing
	- Deleting
- The right image below enables pre-defined presentation styles

![data controls 5](http://i.imgur.com/hjhh7af.png)

- The the result is shown below
- We can manipulate each record by
	- Viewing
	- Editing
	- Deleting
- By clicking `Select` we can also send the `ProductID` out of this control into another one
	- Such as a `DetailsView` control

![data controls 6](http://i.imgur.com/4W6a9Q3.png)

- To implement something similar above in classic ASP may take around 200 lines of code

### Form input controls

- The structure of the DB can be used to define the form that inputs data
- In this case, a `FormView` control has been linked to an `AccessDataSource` control which is connected again to the `Products` table in the database
- As the image below shows, the resulting form has created itself as a representation of the database table it is linked to
- By default, it also provides options to edit and delete a record

![form input control 1](http://i.imgur.com/EkLXd1f.png)

- By default, this control allows us to manipulate records
	- View
	- Edit
	- Add
- Obviously, the default form is very crude, however the developer can go in and alter
	- The layout
	- Colours
	- Spacing
	- Labels
	- Buttons
	- Everything
- However, the most time consuming elements are done already

![form input control 2](http://i.imgur.com/wuL3G52.png)

### Validation controls

- Input validation is another time consuming coding task that can be made easier
- Built-in validation controls in VS 2008 are shown below
- These can be added to a form and then set up for the required validation rules
- Using the form in the previous image as an example
	- We can ensure `Product Name` is a required field

![validation control 1](http://i.imgur.com/lQTvYYU.png)

- We drag the `RequiredFieldValidator` next to the form field we wish to validate
- We set the properties for the control, including
	- The message
	- The field to validate
	- Whether we want the field with the error to end up with the cursor in it
		- Known as **focus**

![validation control 2](http://i.imgur.com/Ay73UEZ.png)

- If we try and add a new product but leave the name field blank
	- The error appears and the cursor goes straight to that field
- Multiple validation controls can be linked to one field
- Instead of one field at a time
	- All errors can be reported as a group
- Obviously, this is basic physical validation
- Complex logical validation is more complex and beyond the capacity of these built-in controls
	- ie. Checking data in the DB before inserting

![validation control 3](http://i.imgur.com/xAqtmaZ.png)

### User login and management

- User management can be one of the most time consuming function points to include in an application
- IDEs like VS 2008 include some core controls to deal with
	- User login/authentication
	- Session management
	- User creation
	- Password management
- These can be hooked to existing databases of valid users
	- Or the system can create an authentication model on the fly
- Again, a certain level of customization is available
	- But for complex or unusual user management tasks, default controls may not be suitable

![user management](http://i.imgur.com/1ld5Iw0.png)

## Issues with visual IDEs

- Three basic examples have shown the types of controls and components that modern visual IDEs can provide
- In these cases, the default controls provide easy drag and drop development of tasks which would otherwise be very time consuming to code by hand
- However there are drawbacks
	- Whilst being as generic as possible, such controls/components may not suit all scenarios
	- Though customizable, they tend to have a generic look
	- Experience indicates that while you can do 90% of your developing using drag and drop
		- The last 10% can be very tricky and time consuming
- Environments themselves can have significant processing requirements
	- ie. Need expensive hardware
- Usually platform dependent
	- VS 2008 depends on ASP.net, IIS 7
- Visual environments can obscure coding structures and make learning to code more difficult
- Visual environments are not designed to replace coding knowledge
	- But rather to complement such knowledge and speed up time consuming tasks
- Good database structures are essential when using data driven controls
	- But database design usually means non functional applications

## Conclusion

- Different visual IDEs offer different sets of controls and functionality
- However, the aim of most environments is to encapsulate complex and time consuming tasks into simple to use, drag and drop components
- Environments like VS 2008 have a huge range of Commercial Off The Shelf (COTS) control and components packages that can be purchased to add to the default
- Whilst these can be expensive, they can pay for themselves in saved development time and testing costs
- Visual IDEs should be used where they will save on the development
	- Time
	- Effort
	- Money
- In most development houses, they are used alongside traditional text coding environments
