package battle.starfield;

import battle.images.Images;
import battle.saucers.Saucer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 * A panel to view the action
 * 
 * @author phi
 */
public class StarfieldViewer extends JPanel
{
    private static Random random = new Random();
    
    private Starfield field;
    private Image stars;
    private String imageInfo1;
    private String imageInfo2;
    private int imageNo;
    
    /** Creates a new instance of StarfieldViewer */
    public StarfieldViewer(Starfield field)
    {
        this.field = field;
        
        imageNo = random.nextInt(Images.N_IMAGES);
        stars = Images.getImage(imageNo);
        imageInfo1 = Images.getImageInfo1(imageNo);
        imageInfo2 = Images.getImageInfo2(imageNo);

        setDoubleBuffered(true);
    }
    
    public void setStarfield(Starfield field)
    {
        this.field = field;
        repaint();
    }
    
    public void nextBackground()
    {
        imageNo = (imageNo+1)%(Images.N_IMAGES);
        stars = Images.getImage(imageNo);
        imageInfo1 = Images.getImageInfo1(imageNo);
        imageInfo2 = Images.getImageInfo2(imageNo);
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        int width = getWidth();
        int height = getHeight();
        
        super.paint(g);
        
        g2.drawImage(stars, 0, 0, width, height, null);
        
        g2.setColor(Color.WHITE);
        g2.drawString(imageInfo1, 5f, (float)(height-8));
        g2.drawString(imageInfo2, 5f, (float)(height-24));

        double scaleX = width/field.getWidth();
        double scaleY = height/field.getHeight();
        
        for(Saucer saucer: field.getSaucers())
        {
            if(saucer.isAlive()) saucer.drawInfo(g2, height, scaleX, scaleY);
        }

        // switch to starfield coordinates
        g2.translate(0, height);
        g2.scale(scaleX, -scaleY);
        
        for(Saucer saucer: field.getSaucers())
        {
            if(saucer.isAlive()) saucer.draw(g2);
        }
        
        field.getBlastManager().drawBlasts(g2);
        
        field.getExplosionManager().drawExplosions(g2);
    }

}
