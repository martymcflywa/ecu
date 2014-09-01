# Website Navigation

## Introduction

- Examines issues relating to navigating a website and presents a notation so that the navigation can be displayed
- Some websites are well-designed in the sense that there is a consistent look and feel as one traverses the website
	- For example, the same icon in the same place to call up help
- Absence of irritating or unnecessary pathways or commands to navigate to a frequently used destination
- Because of the work done earlier in defining business process workflows, the use cases provide a good starting point for organising a website
- The combination of good navigation with well-designed pages make for good website design
- It's about what's on a page, what's not on a page and how pages are linked together
- As we make decisions about navigating from one page to another, we must have a sense of what the user's experience will be and what they will find simple, intuitive and practical
- We use the concept cohesion to examine this

## Cohesion

- Cohesion is the measure of the strength of functional association of elements within (in this case) a page
- Highly-cohesive pages are good because their elements are strongly related
	- For example, if we are ordering a book, it makes sense to include all the aspects that we need to know or do on that page, including:
		- Show the price
		- Display testimonials from previous purchasers
		- Be able to add the book to shopping cart
- What is cohesive depends on where you are on the site
	- For example, if you are on the home page you probably need an overview of what you can (and by absence) what you can't do on the website
	- Cohesion here would be in terms of how well the home page provides that overview and allows you to jump quickly to where you need to be

## Quiz

- Examine the following diagram and determine if it is well designed
- What questions would you be asking to ascertain the goodness of its design

### Screen Hierarchy Chart

![screen hierarchy chart](http://i.imgur.com/Dd4LLyN.png)

### Answers

- Who would be doing what and when?
	- This can be determined from use cases
	- Chances are, staff might need to do different tasks around the same time
		- For example, obatin a report of (bad) creditors and then delete a creditor
- Would the person deleting customers be the same person deleting creditors?
	- Probably not
	- So why locate them both under a *delete* function and necessitate two clicks

## Website Features

- Many well-designed sites have started to incorporate more sophisticated features
	- For example, the SCSS website has a standard set of icons at the top and bottom of each page throughout the website
	- At the top, the common icons are:
		- SCSS Home
		- Online resources
		- Student
		- Courses
		- Research
		- International
		- Staff
- These icons represent the main areas of interest that students are likely to want to use and so provide a quick way of progressing to a different activity
	- Saves the need to return to home page and then navigate to a different part of the website
- Balance needs to be struck when the number of icons on any one page overwhelms
	- Here we organise into hierarchical groupings
- Pages that call up another page are referred to as parent pages
- Pages that are called up are therefore called children
- Ancestors are any pages hierarchically above a page
- Descendents are any page hierarchically below

## Web Design Guidelines

- Some guidelines for a well-designed website are:
	- Always allow return to home page from any page within the site
		- Ensures a user never gets stuck inside a website (closure)
	- Always allow return to a parent page
		- Ensures closure
	- Links within a page are not shown on the navigation map
		- This will clutter up that diagram and will be shown on the page layout anyway

## Navigation Map

- A navigation map is a diagram showing the pathways a user can take through a website
- The constructs were devised with the above guidelines in mind to keep the visual complexity to a minimum

**Note:** Shapes from lecture do not exist in Visio 2013 "Website Map Shapes" or "Conceptual Website Shapes". I will be using Visio 2013 stencils to demonstrate the navigation map elements below.

### Pages

![nav element home & page](http://i.imgur.com/UIqwP0i.png)

- A page is any web page within the website that has content of some sort
	- Text
	- Pictures etc.
	- It could be the home page for the site
	- Or a page within the site

![nav element leaf](http://i.imgur.com/Bh8hyc5.png)

- A special type of page is a leaf page
	- A leaf page does not link to any other further pages
	- Leaf pages may return to previous pages
	- They may call up pop-up pages

![nav element popup](http://i.imgur.com/Ic61XdZ.png)

- A pop-up page is any applet, servlet program, or any opened document
- They are opened up in a new window and overlayed on the website rather than intrinsic part of navigation

![nav element new app](http://i.imgur.com/FEcHngu.png)

- A new application is any new website that links to the existing website
- A different URL

### Links

![nav element link bi](http://i.imgur.com/AMREr5p.png)

- A bi-directional link is a connection between two pages
- It is the most common link due to "return to parent" guideline

![nav element link uni](http://i.imgur.com/XjHfsNK.png)

- Occasionally there is a need for uni-directional links
	- For example, to jump to another part of the website

![nav element link selected](http://i.imgur.com/kEzzM0y.png)

- Sometimes there is a need to show that a link between two pages is only permitted for certain types of user
	- For example, and administrator might be allowed different access from a normal user

### Other Constructs

![nav element harel](http://i.imgur.com/Gip8n0Y.png)

- The Harel blob can be used as an encapsulator where the grouping serves a common purpose
	- For example, showing inheritance of a group of links

![nav element inherits](http://i.imgur.com/b5CfuYc.png)

- Where a page link is inherited to all descendents of that page
	- Within a website

![nav element continued](http://i.imgur.com/aH0kfoM.png)

- Denotes that a navigation map is continued on a new page
	- Usually for space limitations
- Or to link to another part of the website

### Page Numbering

- Pages are numbered using a catenation technique similar to that used in DFDs
- The home page is always designated with a **H**
- One level below that the pages are numbered serially
	- 1, 2, 3, etc
- If page number 2 is *exploded*, then the pages would be numbered:
	- 2.1, 2.2, 2.3, etc
Similarly at level 3, the explosion of 2.1 would be numbered:
	- 2.1.1, 2.1.2, 2.1.3, etc

## SCSS Website (ca. 2004)

![navmap scss 1](http://i.imgur.com/TEzSk33.png)

![navmap scss 2](http://i.imgur.com/xVhi5p1.png)

### Notes

- Notice how powerful inheritance is
	- Here we are saying that these icons appear in the homepage and also every descendant page
- By definition, new applications would not usually inherit icons
	- Because we have no control over those systems

## Review

- Why is cohesion important in website navigation?
	- Highly-cohesive pages are good because their elements are strongly related
	- For example, if we are ordering a book, it makes sense to include all the aspects that we need to know or do on that page, including:
		- Show the price
		- Display testimonials from previous purchasers
		- Be able to add the book to shopping cart
- Define:
	- Homepage
		- The base or landing page when a user views the URL
		- The starting point of navigation in a website
	- Leaf page
		- A leaf page does not link to any other further pages
		- Leaf pages may return to previous pages
		- They may call up pop-up pages
	- Pop-up page
		- A pop-up page is any applet, servlet program, or any opened document
		- They are opened up in a new window and overlayed on the website rather than intrinsic part of navigation
	- New application
		- A new application is any new website that links to the existing website
		- A different URL
- List three links between pages
	- Bi-directional
	- Uni-directional
	- Selected link
- Why do we need page connectors in website navigation?
	- To express the navigational pathways a user can take between pages and elements of a website
- What is the Harel blob used for in website navigation?
	- The Harel blob can be used as an encapsulator where the grouping serves a common purpose
	- For example, showing inheritance of a group of links