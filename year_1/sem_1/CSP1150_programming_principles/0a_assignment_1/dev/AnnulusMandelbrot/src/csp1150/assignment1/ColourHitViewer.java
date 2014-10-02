package csp1150.assignment1;

// import graphics classes
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// import random class to generate random colours
import java.util.Random;

// import view
import view.*;

/**
 * Subclass of GreyscaleHitViewerPanel.
 * Created to create coloured mandelbrot image
 * based on escape time, and overrides viewHits(),
 * so that it uses the colour version of setPixel() instead.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
@SuppressWarnings("serial")
public class ColourHitViewer extends HitViewerGenerator {
	
    /**
     * Construct the panel, copied from GreyscaleHitViewerPanel.
     *
     * @param width of the image (and array)
     * @param height of the image (and array)
     */
    public ColourHitViewer(int width, int height) {
    	
        this.width = width;
        this.height = height;

        // construct a BufferedImage of the right size and type
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // make it all white to start with
        Graphics2D g2 = image.createGraphics();
        g2 = image.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
    }

	/**
	 * This method overrides GreyscaleHitViewerPanel's
	 * viewHits method which uses the colour version
	 * of setPixel() instead.
	 * 
	 * @param int[][] escapeArray
	 */
	public void viewHits(int[][] escapeArray) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
                
				int pixel = escapeArray[x][y];

				//setPixel(x, y, pixel * 3, pixel + 5, pixel + 120);
				setPixel(x, y, pixel, pixel, pixel);
            }
        }
    }
	
	/**
	 * This method generates a random coloured image.
	 * 
	 * @param int[][] escapeArray
	 */
	public void viewHitsRandomColour(int[][] escapeArray) {
		
		Random randomRGB = new Random();
		int randomRed = randomRGB.nextInt(255 - 0) + 1;
		int randomGreen = randomRGB.nextInt(255 - 0) + 1;
		int randomBlue = randomRGB.nextInt(255 - 0) + 1;
		
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
                
				int pixel = escapeArray[x][y];

				setPixel(x, y, pixel * randomRed / 25, pixel * randomGreen / 25, pixel * randomBlue / 25);
            }
        }
	}
}
