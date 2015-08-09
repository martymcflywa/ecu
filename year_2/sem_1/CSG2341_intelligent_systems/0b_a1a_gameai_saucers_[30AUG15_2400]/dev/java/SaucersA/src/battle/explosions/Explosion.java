package battle.explosions;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Random;

/**
 * Visual effects for an explosion
 * 
 * @author phi
 */
public class Explosion
{
    private static final Random random = new Random();
    private static final double MIN_SIZE = 1;
    private static final int N_PARTICLES = 8;
    private static final double MIN_SPEED = 0.3;
    private static final double MAX_SPEED = 2.5;
    
    private ArrayList<Particle> particles;
    private int particles_not_done;
   
    /** Creates a new instance of Explosion */
    public Explosion(double x, double y, double max_size)
    {
        particles = new ArrayList<Particle>();
        
        for(int i = 0; i < N_PARTICLES; i++)
        {
            double speed = MIN_SPEED + (MAX_SPEED-MIN_SPEED)*random.nextDouble();
            double heading = 2*Math.PI*random.nextDouble();
            double speed_x = speed*Math.cos(heading);
            double speed_y = speed*Math.sin(heading);
            double size = MIN_SIZE + (max_size - MIN_SIZE)*random.nextDouble();

            particles.add(new Particle(x, y, speed, speed_x, speed_y, size));
        }
        
        particles_not_done = N_PARTICLES;
    }
    
    public void update(double seconds)
    {
        int count_not_done = 0;
        
        for(Particle particle: particles)
        {
            if(!particle.isDone())
            {
                count_not_done++;
                particle.update(seconds);
            }
        }
        
        particles_not_done = count_not_done;
    }
    
    public boolean allDone()
    {
        return particles_not_done == 0;
    }
    
    public void draw(Graphics2D g2)
    {
        for(Particle particle: particles)
        {
            if(!particle.isDone())
            {
                particle.draw(g2);
            }
        }
    }
    
    // an inner class about explosion  particles
    public class Particle
    {
        private static final double DECEL = 0.7;

        private double x;
        private double y;
        private double speed;
        private double speed_x;
        private double speed_y;
        private double size;
        
        public Particle(double x, double y, double speed, double speed_x, double speed_y, double size)
        {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.speed_x = speed_x;
            this.speed_y = speed_y;
            this.size = size;
        }
        
        public void update(double seconds)
        {
            x += speed_x;
            y += speed_y;
            
            double decel = Math.pow(DECEL, seconds);
            
            speed *= decel;
            speed_x *= decel;
            speed_y *= decel;
            size *= decel;
        }
        
        public boolean isDone()
        {
            return size < MIN_SIZE;
        }

        public void draw(Graphics2D g2)
        {
            AffineTransform saveAT = g2.getTransform();
            
            g2.translate(x, y);

            int level = 127+(int)(128*speed/MAX_SPEED);
            g2.setColor(new Color(255, level, 0));
            g2.fillOval((int)(-size), (int)(-size), (int)(2*size), (int)(2*size));
            
            g2.setTransform(saveAT);
        }
   }
}
