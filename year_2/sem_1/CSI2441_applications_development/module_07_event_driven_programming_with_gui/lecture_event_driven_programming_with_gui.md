# Event driven programming with GUI

## Objectives

- Understand the principles of event driven programming
- Describe user initiated actions and GUI components
- Design GUI
- Modify the attributes of GUI components
- List the steps of building an event driven application
- Understand the disadvantages of traditional error handling techniques
- Understand the advantages of object oriented technique of throwing exceptions

## Event driven programming terminology

- Command line
	- Screen location where you type entries
	- Very rare in the web development world
- Icons
	- Pictures representing objects or actions
- Graphical user interface (GUI)
	- Allows user to interact with an application by clicking icons to select icons
- Event
	- An occurrence that generates a message to an object
- Event-based/event-driven
	- Actions occur in response to user initiated events
- Source of the event
	- A component from which an event is generated
- Listener
	- An object that will respond to the event

### Event driven emphasis

- User is able to manipulate GUI objects
- User can initiate events with those objects

### Events used in web development

- Hyperlinks
- JS/Flash events with on screen objects
- Form based post backs in ASP.net or other web programming environments
- Procedural programming controls the sequence of events
- Sequence is controlled by the user's actions
	- Particularly in web applications
- Programmer writes code that defines what actions are taken when the event occurs

![event code](http://i.imgur.com/Iow7on8.png)

## User initiated actions and GUI components

### Common user initiated events

![table 14-1](http://i.imgur.com/ZmGftfP.png)

### Common GUI components

![table 14-2](http://i.imgur.com/AVrbPra.png)

![figure 14-1](http://i.imgur.com/SPV37v5.png)

- GUI components are usually predefined classes that act like black boxes
- Programmer must write statements to manipulate GUI objects and take actions when events occur
- The ASP.net drop down list control shown below has a setting which automatically posts the selected item back into the form as soon as the user selects a value
- This value can then be trapped in a `isPostBack` event and then dealt with accordingly

![dropdown control](http://i.imgur.com/6zx5r55.png)

## Designing GUI

### Principles

- Natural and predictable
	- Consistent
- Attractive and user friendly
- Allow the user to customize the application if possible
	- In many applications this is available to a certain degree
		- But in programming perspective, it means a lot of extra work
		- ie. What if you allowed users to edit their background/foreground colors and wanted the same color for both?
- Program should be forgiving
	- Should never let users paint themselves into a corner
- GUI is only a means to an end

#### Natural and predictable

- Natural
	- Icons that look like their real world counterparts
- Predictable
	- Use standard icons for the same purpose
- Layout of screen should be predictable
	- As discussed in previous lecture
		- Menus, menu position and menu options should be consistent across all pages
	- Use the same icons for each page
		- Do not have a back arrow on one page
		- And a back link (with words) on another
	- If you change wording or iconography
		- Most users will assume it is for a reason and become confused
		- Followed closely by aggravated

#### Attractive and user friendly

- Attractive interfaces are more likely to be used
	- Though this is of course highly subjective
- Fancy fonts and weird color combinations are signs of amateur designers
- Unavailable or inappropriate screen or menu options should be
	- Disabled
	- Invisible
	- Or greyed out
- Screen design should not be distracting
	- No
		- Flashing
		- Blinking
		- Noise
		- High contrast events
	- Interfaces should not rely on 3rd party plugins
		- Most users will not install them

#### Allow user to customize the application if possible

- Arrange components in the order they want
	- ie. Menu options
- Change color schemes
- Change profile image
- Change what information is publicly viewable and which is not

#### Program should be forgiving

##### Good programming design

- Always provide an escape route from bad choices
- Allow users to back out of *dead end* choices
- If a user has to use the *back* button in the web browser
	- Something is seriously wrong with interface design

##### Do not expose users to record ID's if not necessary

- Record IDs are there for the database and application to use in the background
	- For the most part they should not be near the user interface
- Too many applications in the past have relied on record ID to perform the following
	- Which is a mark of appalling application design
		- Search
		- Edit
		- Delete
- Users cannot be expected to know the underlying workings of a system
	- They are there to get the job done

### GUI is only a means to an end

- GUI is only an interface
	- Not the purpose of the program
- GUI should help make users more productive
- GUI design should
	- Help users see what options are available
	- Allow components to be used as normal
	- Not force the user to figure out how to interact and how the underlying logic of the application works
- Real work of GUI is done **after** the user makes an action
	- Good interface design is hard to achieve and time consuming
	- Bad interface design is quick and easy
		- Will always come back to haunt the developer
			- In terms of user complaints

## Modify attributes of GUI components

- Appearance of GUI components can be changed by modifying the attributes
- Common types of changes
	- Size
	- Color
	- Screen location
	- Font for text in component
	- Visible/invisible
	- Enabled/disabled
		- Dimmed/undimmed

### GridView example

![gridView](http://i.imgur.com/hOdMJFS.png)

### Modify attributes with code

- Different languages have different ways to change attribute values
	- With code statements
	- By calling a method and passing arguments
	- Accessing a properties list or table
		- See `GridView` example
	- All of the above
- Code below shows a `Page_LoadComplete` event in ASP.net
	- It contains instructions which programmatically make the previously shown `GridView` control invisible by default

``` asp
protected sub Page_LoadComplete(byVale sender as object, byVal e as System.EventArgs) handles me.LoadComplete
	GridView1.Visible = false
end sub
```

## Steps to developing event driven application

### Developing any program

- Understand the problem
- Plan the logic
- Code the program
- Translate the program into machine language
- Test the program
- Put program into production

### Developing event driven program

- Understand the problem
- Create story boards
- Define objects
- Define connections between screens
- Plan the logic
- Code the program
- Translate the program into machine language
- Test the program
- Put program into production

### Understand the problem

- Using the example in Table 14-3:

![table 14-3](http://i.imgur.com/ol2Pm4g.png)

### Create story boards

- Storyboard
	- A picture or sketch of the user screen
- Draw one storyboard cell/frame for each user screen

![figure 14-2](http://i.imgur.com/M9MZaiH.png)

### Define objects

- Object dictionary
	- List of objects used in a program
	- Indicates which screens the objects are used in
	- Indicates if code or script is associated with object
	- May show which variables are affected by an action on the object
- This is the kind of thing which would be delivered as part of a technical manual
	- And by developers during development
	- Not user manual

![figure 14-3](http://i.imgur.com/UBQ94za.png)

### Define connections between screens

- Interactivity diagram
	- Shows the relationship between screens in an interactive GUI program

![figure 14-4](http://i.imgur.com/S0LeF2D.png)

![figure 14-5](http://i.imgur.com/vDgC4LJ.png)

### Plan the logic

- After you have
	- Designed screens
	- Defined objects
	- Defined how screens will connect
- Plan the logic

![figure 14-6](http://i.imgur.com/uJgLqCt.png)

## Disadvantages of traditional error handling techniques

- Validating user input is a large part of any program
- GUI data entry objects may help control what user can enter
- One error handling technique was to terminate the program
	- Very unforgiving

![figure 14-7](http://i.imgur.com/D7pbAPN.png)

- Can create an error flag
	- Prompt the user to re-enter valid value
	- Loop until data becomes valid
- Disadvantages
	- Makes module less reusable
	- Not as flexible as it might be
	- Only works with interactive programs

![figure 14-8](http://i.imgur.com/OhoC9R7.png)

## Advantages of object oriented exception handling

- Exception handling methods
	- Used in object oriented, event driven programs
	- Check for and manage errors
- Exception
	- An object that represents an error
- Try
	- Attempt to execute a module that might throw an error
- Throw
	- Pass an exception from called module back to caller
- Catch
	- Receive an exception from called module
- Exception object that is thrown can be any data type

![figure 14-9](http://i.imgur.com/f844muT.png)

### `try`/`catch`

- `try` block
	- Contains code that may throw an exception
- `catch` block
	- Contains code that executes when an exception is thrown from within a `try` block

![figure 14-10](http://i.imgur.com/UMvNt3C.png)

### `catch` block

- Specifies the data type of the exception it will handle
- Executes only when an exception of that data type is thrown in the corresponding `try` block

![figure 14-11](http://i.imgur.com/slimpr9.png)

![figure 14-12/13](http://i.imgur.com/OLmNU2I.png)

### General object oriented exception handling principle

- Module that uses data should be able to detect errors
	- But it is not required to handle them
- Handling is left to the application that uses the object

## Summary

- Event driven GUI interface allows users to manipulate objects on screen
- Source event
	- Component that generates event
- Listener
	- Object interested in an event
- GUI components are created from predefined classes
	- Act like black boxes
- GUI interface should be
	- Neutral
	- Predictable
	- Attractive
	- Easy to read
	- Non distracting
- GUI program should allow user to customize the application
	- Should be forgiving
- Modify the GUI component attributes to change its appearance
- Use storyboards to help plan GUI program
- Traditional error handling methods have limitations
- OOP error handling involves throwing exceptions
