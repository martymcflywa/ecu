package csp1150.assignment1;

// import view
import view.*;

/**
 * Subclass of GreyscaleHitViewerPanel.
 * Created to create coloured mandelbrot image
 * based on escape time, and overrides viewHits().
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
@SuppressWarnings("serial")
public class ColourHitViewerPanel extends GreyscaleHitViewerPanel {

	public void viewHits(int[][] escapeArray) {
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
                
				int pixel = escapeArray[x][y];

				setPixel(x, y, pixel, pixel, pixel);
            }
        }
    }
}
