# AnnulusMandelbrot Calculator

## v5.2.0 20141020:

- Designed and written in MVC pattern
- GUI for both Annulus and Mandelbrot calculator
- Annulus calculator allows user to input outer and inner radius
	- Image is then displayed
- Mandelbrot calculator has fixed dimensions, always calculates the same size
	- Mandelbrot can generate random coloured image
- User can click and drag on either image to draw rectangle
	- Rectangle determines zoom
	- Zoom is confirmed with "Zoom In" button
- User can reset image, which resets zoom and reverts to greyscale image
- User can save either Annulus or Mandelbrot image separately
	- JOptionPane notifies user where file is saved

## TODO:

1. Replace with JFileChooser rather than hardcoded filename/directory
2. Fix issue where user can generate coloured image without calculating Mandelbrot area first
3. Fix issue where zooming while random colour is ticked, colour changes
	- Colour shouldn't change while zooming
4. Stop "Zoom In" button from working if no zoom selection has been made

## Screenshots

![window](http://i.imgur.com/XBpWOmP.png)

![mandy 1](http://i.imgur.com/Sg2l7d8.png)

![mandy 2](http://i.imgur.com/rwJM5ds.png)

![mandy 3](http://i.imgur.com/03G21iu.png)