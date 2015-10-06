import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * A class for a robot that navigates around a rectangular field
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class Robot
{
    public Robot(boolean[][] room, Random random)
    {
        this.room = room;
        this.random = random;
        
        this.visited = new boolean[room.length][room.length];
    }
    
    public void draw(Graphics g, Rectangle viewport)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.black);
        for(int i = 0; i < room.length; i++)
        {
            for(int j = 0; j < room.length; j++)
            {
                if(visited[i][j])
                {
                    Rectangle where = RobotProblem.getSquare(viewport, room.length, i, j);        
                    g2.fill(where);
                 }
             }
        }
        
        Rectangle where = RobotProblem.getSquare(viewport, room.length, x, y); 

        // draw radar        
        g2.setColor(Color.green);
        int startX = (int)Math.round(where.x+where.width*0.5);
        int startY = (int)Math.round(where.y+where.height*0.5);

        for(int i = 0; i < RobotDirection.DIRECTIONS.length; i++)
        {
            RobotDirection dir = RobotDirection.DIRECTIONS[i];
            RobotDirection world = direction.robotToWorld(dir);
            int far = far(dir);
            
            int endX = startX + far*world.DX*where.width;
            int endY = startY + far*world.DY*where.height;
            
            g2.drawLine(startX, startY, endX, endY);
        }
        
        // draw body
        g2.setColor(Color.cyan);
        g2.fillOval(where.x, where.y, where.width, where.height);

        // draw "eye"
        g2.setColor(Color.red);
        int eyeX;
        int eyeY;
        if(direction == RobotDirection.NORTH)
        {
            eyeX = (int)Math.round(where.x + where.width*0.25);
            eyeY = where.y;
        }
        else if(direction == RobotDirection.SOUTH)
        {
            eyeX = (int)Math.round(where.x + where.width*0.25);
            eyeY = (int)Math.round(where.y + where.height*0.5);
        }
        else if(direction == RobotDirection.EAST)
        {
            eyeX = (int)Math.round(where.x + where.width*0.5);
            eyeY = (int)Math.round(where.y + where.height*0.25);
        }
        else // if(direction == RobotDirection.WEST)
        {
            eyeX = where.x;
            eyeY = (int)Math.round(where.y + where.height*0.25);
        }

        g2.fillOval(eyeX, eyeY, where.width/2, where.height/2);             
}
    
    public void initialise()
    {
        for(int i = 0; i < room.length; i++)
        {
            for(int j = 0; j < room.length; j++)
            {
                visited[i][j] = false;
            }
        }

        do
        {
            x = random.nextInt(room.length);
            y = random.nextInt(room.length);
        } while(!room[x][y]);
        
        visited[x][y] = true;
        direction = RobotDirection.DIRECTIONS[random.nextInt(RobotDirection.DIRECTIONS.length)];
        nVisited = 1;
    }
    
    public void doAction(RobotAction action)
    {
        if(action == RobotAction.LEFT)
        {
            direction = direction.left();
        }
        else if(action == RobotAction.RIGHT)
        {
            direction = direction.right();
        }
        else if(action == RobotAction.FORWARD)
        {
            forward();
        }
        else if(action == RobotAction.BACKWARDS)
        {
            backwards();
        }
    }
    
    public void forward()
    {
        int newX = x + direction.DX;
        int newY = y + direction.DY;
        
        if(0 <= newX && newX < room.length &&
           0 <= newY && newY < room.length &&
           room[newX][newY])
        {
            x = newX;
            y = newY;
            if(!visited[x][y])
            {
                visited[x][y] = true;
                nVisited++;
            }
        }
    }
    
    public void backwards()
    {
        int newX = x - direction.DX;
        int newY = y - direction.DY;
        
        if(0 <= newX && newX < room.length &&
           0 <= newY && newY < room.length &&
           room[newX][newY])
        {
            x = newX;
            y = newY;
            if(!visited[x][y])
            {
                visited[x][y] = true;
                nVisited++;
            }
        }
    }
    
    public int getNVisited()
    {
        return nVisited;
    }
    
    // how many squares in this direction (robot's idea of direction - e.g. NORTH = straight ahead) to the next obstacle or wall
    public int far(RobotDirection robotDir)
    {
        RobotDirection world = direction.robotToWorld(robotDir);
        int distance = 0;
        
        int newX = x + world.DX;
        int newY = y + world.DY;
        while(0 <= newX && newX < room.length &&
              0 <= newY && newY < room.length &&
              room[newX][newY])
        {
            distance++;
            
            newX += world.DX;
            newY += world.DY;
        }
        
        return distance;
    }
    
    // how many squares in this direction yet to be visited (robot's idea of direction - e.g. NORTH = straight ahead) before the next obstacle or wall
    public int free(RobotDirection robotDir)
    {
        RobotDirection world = direction.robotToWorld(robotDir);
        int nfree = 0;
        
        int newX = x + world.DX;
        int newY = y + world.DY;
        while(0 <= newX && newX < room.length &&
              0 <= newY && newY < room.length &&
              room[newX][newY])
        {
            if(!visited[newX][newY]) nfree++;
            
            newX += world.DX;
            newY += world.DY;
        }
        
        return nfree;
    }
    
    // whether the next in this direction (robot's idea of direction - e.g. NORTH = straight ahead) is good
    public boolean isGood(RobotDirection robotDir)
    {
        RobotDirection world = direction.robotToWorld(robotDir);
        
        int newX = x + world.DX;
        int newY = y + world.DY;
        if(0 <= newX && newX < room.length &&
           0 <= newY && newY < room.length)
        {
            return room[newX][newY] && !visited[newX][newY];
        }
        else
        {
            return false;
        }
    }
    
    private Random random;
    private boolean[][] room;
    private boolean[][] visited;
    private int nVisited;
    private int x;
    private int y;
    private RobotDirection direction;
}
