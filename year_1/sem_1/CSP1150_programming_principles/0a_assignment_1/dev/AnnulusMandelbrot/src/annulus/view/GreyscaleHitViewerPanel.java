package annulus.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * A panel for displaying an image defined by a 2D array of greyscale values
 *
 * @author phi
 */
public class GreyscaleHitViewerPanel extends JPanel implements HitViewerInterface
{
    /**
     * image to display
     */
    private BufferedImage image;
    /**
     * width of the image (and the array)
     */
    private int width;
    /**
     * height of the image (and the array)
     */
    private int height;

    /**
     * Construct the panel
     *
     * @param width of the image (and array)
     * @param height of the image (and array)
     */
    public GreyscaleHitViewerPanel(int width, int height)
    {
        this.width = width;
        this.height = height;

        // construct a BufferedImage of teh right size and type
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // make it all white to start with
        Graphics2D g2 = image.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
    }

    /**
     * Change the greyscale values in the image using the values from an array
     *
     * @param hits the array
     */
    public void viewHits(double[][] hits)
    {
        for(int x = 0; x < width; x++)
        {
            for(int y = 0; y < height; y++)
            {
                float grey = (float)(1.0 - hits[x][y]);

                setPixel(x, y, grey);
            }
        }
    }

    /**
     * Set one pixel in the image using integer RGB values
     *
     * @param x the column number
     * @param y the row number
     * @param red 0-255
     * @param green 0-255
     * @param blue 0-255
     */
    private void setPixel(int x, int y, int red, int green, int blue)
    {
        int pixel = (blue << 0) | (green << 8) | (red << 16) | (255 << 24);

        // height-y-1 because the y-axis coordinates are inverted(0 is at the top)
        image.setRGB(x, height-y-1, pixel);
    }

     /**
     * Set one pixel in the image using a greyscale value
     *
     * @param x the column number
     * @param y the row number
     * @param grey 0-1.0
     */
    private void setPixel(int x, int y, float grey)
    {
        // convert to interegr RGB values
        int greyByte = (int)(255*grey);

        setPixel(x, y, greyByte, greyByte, greyByte);
    }

    /**
     * Overriden paintComponent - the world gets drawn here
     *
     * @param g a graphics object to draw the component with
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, null);
    }

}
