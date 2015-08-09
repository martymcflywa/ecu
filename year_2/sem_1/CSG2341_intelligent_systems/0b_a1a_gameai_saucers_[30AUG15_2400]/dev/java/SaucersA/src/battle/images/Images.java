package battle.images;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Colourful background images
 * 
 * @author phi
 */
public class Images
{
    public static final int N_IMAGES = 5;
    private static Image[] images = new Image[N_IMAGES];
    private static String[] imageFilenames = 
    {
        "PIA17171.jpg",
        "PIA14728.jpg",
        "heic0703a.jpg",
        "opo0036a.jpg",
        "opo9919i.jpg"
    };
    private static String[] imageInfo1 = 
    {
        "The Day the Earth Smiled: Sneak Preview",
        "Into the Depths of the Lagoon Nebula",
        "This image of NGC 2440 shows the colourful \"last hurrah\" of a star like our Sun.",
        "Hubble Space Telescope image of a dark interstellar cloud being destroyed by the passage a star in the Pleiades",
        "Hubble Space Telescope Image of Supernova 1994D in Galaxy NGC 4526"
    };
    private static String[] imageInfo2 = 
    {
        "Image credit: NASA/JPL-Caltech/Space Science Institute from http://www.jpl.nasa.gov/spaceimages/details.php?id=PIA17171",
        "Image credit: NASA/JPL-Caltech from http://www.jpl.nasa.gov/spaceimages/details.php?id=PIA14728",
        "Image credit: NASA, ESA, and K. Noll (STScI) from www.spacetelescope.org/images/html/heic0703a.html",
        "Image credit: NASA/ESA and The Hubble Heritage Team STScI/AURA), George Herbig and Theodore Simon (University of Hawaii) from www.spacetelescope.org/images/html/opo0036a.html",
        "Image credit: NASA/ESA, The Hubble Key Project Team, and The High-Z Supernova Search Team from www.spacetelescope.org/images/html/opo9919i.html"
    };
    private static String[] additionalInfo = 
    {
        "In this rare image taken on July 19, 2013, the wide-angle " +
        "camera on NASA's Cassini spacecraft has captured Saturn's " +
        "rings and our planet Earth and its moon in the same frame. " +
        "It is only one footprint in a mosaic of 33 footprints covering " +
        "the entire Saturn ring system (including Saturn itself). At each " +
        "footprint, images were taken in different spectral filters for a " +
        "total of 323 images: some were taken for scientific purposes and " +
        "some to produce a natural color mosaic. This is the only " +
        "wide-angle footprint that has the Earth-moon system in it.",
        
        "Swirling dust clouds and bright newborn stars dominate the view " +
        "in this image of the Lagoon nebula from NASA's Spitzer Space " +
        "Telescope. Also known as Messier 8 and NGC 6523, astronomers " +
        "estimate it to be between 4000 and 6000 light years away, lying " +
        "in the general direction of the center of our galaxy in the constellation Sagittarius.",
                
        "This image of NGC 2440 shows the colourful \"last hurrah\" of a star like " +
        "our Sun. The star is ending its life by casting off its outer layers of gas, " +
        "which formed a cocoon around the star\'s remaining core. Ultraviolet light from " +
        "the dying star makes the material glow. The burned-out star, called a white dwarf, " +
        "is the white dot in the centre.",
        
        "The Hubble Space Telescope has caught the eerie, wispy tendrils of a dark " +
        "interstellar cloud being destroyed by the passage of one of the brightest stars " +
        "in the Pleiades star cluster. Like a flashlight beam shining off the wall of " +
        "a cave, the star is reflecting light off the surface of pitch black clouds of " +
        "cold gas laced with dust. These are called reflection nebulae.",
        
        "Hubble Space Telescope Image of Supernova 1994D in Galaxy NGC 4526"
    };
    
    public static void loadImages()
    {
        for(int i = 0; i < N_IMAGES; i++)
        {
            try
            {
                URL url = new URL("file:"+imageFilenames[i]);
                images[i] = new ImageIcon(url).getImage();           
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
                images[i] = null;
            }
        }
    }
    
    public static Image getImage(int i)
    {
        return images[i];
    }
    
    public static String getImageInfo1(int i)
    {
        return imageInfo1[i];
    }

    public static String getImageInfo2(int i)
    {
        return imageInfo2[i];
    }
}
