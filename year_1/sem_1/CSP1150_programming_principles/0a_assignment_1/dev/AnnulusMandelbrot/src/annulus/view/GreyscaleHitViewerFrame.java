package annulus.view;

import javax.swing.JFrame;

/**
 * A class to display a shape based on a 2D array of greyscale values
 * @author phi
 */
public class GreyscaleHitViewerFrame extends JFrame implements HitViewerInterface
{
    /**
     * a panel to display the image
     */
    private GreyscaleHitViewerPanel panel;

    /**
     * Construct a frame for viewing a shape
     *
     * @param title appears in the title bar of the window
     * @param width of the image - equal to the number of columns in the array
     * @param height of the image - equal to the number of rows in the array
     */
    public GreyscaleHitViewerFrame(String title, int width, int height)
    {
        super(title);

        panel = new GreyscaleHitViewerPanel(width, height);
        getContentPane().add(panel);

        setBounds(0, 0, width+20, height+50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Method to set the greyscale values
     *
     * @param hits the 2D array of greyscale values
     */
    public void viewHits(double[][] hits)
    {
        panel.viewHits(hits);
        repaint();
    }

}
