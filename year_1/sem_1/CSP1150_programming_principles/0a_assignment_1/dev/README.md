# AnnulusMandelbrot Calculator

### CSP1150 Assignment 1 - Martin Ponce, Student 10371381

## Features:

- Designed and written in MVC pattern
- GUI for both Annulus and Mandelbrot calculator
- Annulus calculator allows user to input outer and inner radius
	- Calculates area using approximate and monte carlo estimation
		- Error message when no values are entered
		- Error message when outer radius is less than inner radius
	- Displays image after calculation
- Mandelbrot calculator has fixed dimensions, always calculates the same size at default zoom level
	- Calculates area using monte carlo estimation
	- User can then view image of Mandelbrot
		- Area must be calculated first
- The images can be manipulated
	- User can left click and drag on either image to draw rectangle
		- Rectangle selects zoom area
		- Zoom is confirmed with "Zoom In" button
			- Error message when no zoom area selected and "Zoom In" button is clicked
		- User can reset image, which resets zoom and reverts to greyscale image
	- Mandelbrot image can be generated with random colours
- User can save either Annulus or Mandelbrot image separately
	- Message notifies user where file is saved

## TODO:

- Replace hardcoded filename/directory with JFileChooser

## v5.3.1 20141024

### Resolved issues:

- If user viewing Mandelbrot image for the first time and has random colour ticked, and zoom area selected, clicking OK button will no longer generate a black image
	- Changed the fields that hold the random values to be static so they are not reset every time a new image object is instantiated
	- These fields are also preloaded with a random int so they do not give zero when initially called

## v5.3.0 20141022

### Resolved issues:

- Colour is no longer randomized while zooming
- User must now calculate Mandelbrot area first before viewing greyscale or colour image
	- Error message notifies user
- User must select zoom area first before zooming in
	- Error message notifies user

### Bug/s:

Listed bugs fixed, see resolved issues above.

- ~~Zooming image with "Random colour" ticked without previously viewing a random colour image results in black image~~
	- ~~Need to update the controller to introduce random colours, could use mandelbrotColourImageExists to check~~

## v5.2.0 20141020

### Bug/s:

Listed bugs fixed, see resolved issues above.

1. ~~User can generate coloured image without calculating Mandelbrot area first~~
2. ~~Zooming while random colour is ticked, colour changes~~
	- ~~Colour shouldn't change while zooming~~
3. ~~"Zoom In" button still works even though no zoom selection has been made~~

## Screenshots

![window](http://i.imgur.com/XBpWOmP.png)

![mandy 1](http://i.imgur.com/Sg2l7d8.png)

![mandy 2](http://i.imgur.com/rwJM5ds.png)

![mandy 3](http://i.imgur.com/03G21iu.png)