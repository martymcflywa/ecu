import java.awt.*;
import java.applet.*;

import WattBrown.LinkedStack;
import WattBrown.Stack;

public class Maze extends Applet implements Runnable {

    // The maze itself...
    private byte[][] maze;

    // Flag constants representing the different sides of a square...
    public static final byte NORTH = 0x01, EAST = 0x02,
                             SOUTH = 0x04, WEST = 0x08,
                             ALL = 0x0F;

    // Flag constants representing the different states of a square...
    public static final byte VISITED = 0x10, PATH = 0x20,
                             EXIT = 0x40, START = (byte) 0x80;


    // The size of the maze in squares...
    public static final int WIDTH = 50, HEIGHT = 50;


    // The thread to generate and solve the maze...
    private Thread mazeThread;


    public Maze () {
        maze = new byte[WIDTH][HEIGHT];
    }


    private Maze.Position randomPosition () {
        return new Maze.Position((int) (Math.random() * WIDTH),
                                (int) (Math.random() * HEIGHT));
    }


    private Maze.Position chooseStart () {
        Maze.Position start = new Maze.Position(0, 0);
        mark(start, START);
        return start;
    }


    private void chooseExit () {
        mark(new Maze.Position(WIDTH - 1, HEIGHT - 1), EXIT);
    }


    private void markAllSidesWalled () {
    // Mark all of sides of every square in the maze as walled.
        for (int i = 0; i < WIDTH; i++)
            for (int j = 0; j < HEIGHT; j++)
                maze[i][j] = ALL;
    }



    private boolean isIntact(int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            return (maze[x][y] & ALL) == ALL;
        else
            return false;
    }

    private int numIntactNeighbors (Maze.Position p) {
        return (isIntact(p.x-1, p.y) ? 1 : 0) + (isIntact(p.x+1, p.y) ? 1 : 0) +
               (isIntact(p.x, p.y-1) ? 1 : 0) + (isIntact(p.x, p.y+1) ? 1 : 0);
    }

    public boolean hasIntactNeighbors (Maze.Position p) {
        return numIntactNeighbors(p) > 0;
    }

    // Encode the differences in x and y co-ordinate and the corresponding
    // direction. The order of elements in these arrays is significant.
    private static int[] deltaX = new int[] {-1,  0, +1,  0};
    private static int[] deltaY = new int[] { 0, -1,  0, +1};
    private static byte[] flag =  new byte[] {WEST, NORTH, EAST, SOUTH};

    private Maze.Position chooseIntactNeighbor (Maze.Position p) {

        int choice = (int) (Math.random() * numIntactNeighbors(p));
        for (int i = 0; i < deltaX.length; i++) {
            if (isIntact(p.x+deltaX[i], p.y+deltaY[i]))
                if (choice == 0)
                    return new Maze.Position(p.x+deltaX[i], p.y+deltaY[i]);
                else
                    choice--;
        }
        return null;
    }

    private void removeWall (Maze.Position p1, Maze.Position p2) {
        for (int i = 0; i < deltaX.length; i++) {
            if (p1.x + deltaX[i] == p2.x && p1.y + deltaY[i] == p2.y) {
                unmark(p1, flag[i]);
                unmark(p2, flag[i ^ 2]);
                return;
            }
        }
    }

    private boolean isPath (Maze.Position p, int direction) {
        return ((maze[p.x][p.y] & direction) == 0);
    }

    private boolean isUnvisited (int x, int y) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT)
            return ((maze[x][y] & VISITED) == 0);
        else
            return false;
    }

    private boolean hasUnvisitedNeighbors (Maze.Position p) {
        return ((isPath(p, NORTH) && isUnvisited(p.x,   p.y-1)) ||
                (isPath(p, SOUTH) && isUnvisited(p.x,   p.y+1)) ||
                (isPath(p, WEST)  && isUnvisited(p.x-1, p.y))   ||
                (isPath(p, EAST)  && isUnvisited(p.x+1, p.y)));
    }

    private Maze.Position chooseUnvisitedNeighbor (Maze.Position p) {
        if (isPath(p, EAST) && isUnvisited(p.x+1, p.y))
            return new Maze.Position(p.x+1, p.y);
        else if (isPath(p, SOUTH) && isUnvisited(p.x, p.y+1))
            return new Maze.Position(p.x, p.y+1);
        else if (isPath(p, WEST) && isUnvisited(p.x-1, p.y))
            return new Maze.Position(p.x-1, p.y);
        else if (isPath(p, NORTH) && isUnvisited(p.x, p.y-1))
            return new Maze.Position(p.x, p.y-1);
        else
            return null;
    }

    private void mark (Maze.Position p, byte flag) {
        maze[p.x][p.y] |= flag;
    }

    private void unmark (Maze.Position p, byte flag) {
        maze[p.x][p.y] &= flag ^ 0xFF;
    }

    private boolean isMarked (Maze.Position p, byte flag) {
        return (maze[p.x][p.y] & flag) != 0;
    }

///////////////////////////////////////////////////////////////////////////////

    private int squareCount;

    private void resetSquareCount (int count) {
        squareCount = count;
    }


    private void showMaze (int duration) throws InterruptedException {
        repaint();
        Thread.sleep(duration);
    }


    private void maybeShowMaze (int duration, int count)
            throws InterruptedException {

        if (Thread.currentThread() != mazeThread)
            throw new InterruptedException();

        if (squareCount == 0) {
            squareCount = count;
            showMaze(duration);
        } else
            squareCount--;
    }

///////////////////////////////////////////////////////////////////////////////

    public void generate () throws InterruptedException {
    // Generate a perfect maze.

        markAllSidesWalled();
        Stack positionStack = new LinkedStack();
        positionStack.addLast(randomPosition());
        resetSquareCount(20);

        while (! positionStack.isEmpty()) {
            Maze.Position current = (Maze.Position) positionStack.getLast();
            if (hasIntactNeighbors(current)) {
                Maze.Position neighbor = chooseIntactNeighbor(current);
                removeWall(current, neighbor);
                positionStack.addLast(neighbor);
            } else
                positionStack.removeLast();

            // Allow the screen to catch up with the generation
            // every few squares visited...
            maybeShowMaze(10, 20);
        }
        showMaze(0);
    }



    public boolean findAPath1 (Maze.Position start) throws InterruptedException {
    // Find a path from the square at position start to an exit in this maze.
    // Recursive solution.
        mark(start, VISITED);  mark(start, PATH);
        maybeShowMaze(10, 10);
        if (isMarked(start, EXIT))  return true;
        while (hasUnvisitedNeighbors(start)) {
            Maze.Position neighbor = chooseUnvisitedNeighbor(start);
            if (findAPath1(neighbor))  return true;
        }
        unmark(start, PATH);
        return false;
    }


    public boolean findAPath2 (Maze.Position start) throws InterruptedException {
    // Find a path from the square start to an exit of this maze.
    // Iterative solution.
        mark(start, VISITED);  mark(start, PATH);
        resetSquareCount(10);
        Stack pathStack = new LinkedStack();
        pathStack.addLast(start);
        while (! pathStack.isEmpty()) {
            maybeShowMaze(10, 10);
            Maze.Position current = (Maze.Position) pathStack.getLast();
            if (isMarked(current, EXIT))  return true;
            if (hasUnvisitedNeighbors(current)) {
                Maze.Position neighbor = chooseUnvisitedNeighbor(current);
                mark(neighbor, VISITED);
                mark(neighbor, PATH);
                pathStack.addLast(neighbor);
            } else {
                pathStack.removeLast();
                unmark(current, PATH);
            }
        }
        return false;
    }

///////////////////////////////////////////////////////////////////////////////

    public void paint (Graphics g) {
        if (buffer != null)
            g.drawImage(buffer, 0, 0, this);
    }

    private static final int SCALE = 10;
    private static final int XOFFSET = 25, YOFFSET = 25;
    private Image buffer;

    private void drawWall(Graphics g, int x, int y, int direction) {
        int x1 = x * SCALE, x2 = x * SCALE, y1 = y * SCALE, y2 = y * SCALE;
        g.setColor(Color.black);
        if (direction == EAST)
            x1 += SCALE;
        if (direction == NORTH || direction == SOUTH || direction == EAST)
            x2 += SCALE;
        if (direction == SOUTH)
            y1 += SCALE;
        if (direction == WEST || direction == SOUTH || direction == EAST)
            y2 += SCALE;
        g.drawLine(x1 + XOFFSET, y1 + YOFFSET, x2 + XOFFSET, y2 + YOFFSET);
    }

    private void eraseWall(Graphics g, int x, int y, int direction) {
        if ((maze[x][y] & PATH) != 0)
            g.setColor(Color.yellow);
        else if ((maze[x][y] & VISITED) != 0)
            g.setColor(Color.gray);
        else
            return;

        int x1 = x * SCALE, x2 = x * SCALE, y1 = y * SCALE, y2 = y * SCALE;
        if (direction == EAST) {
            x1 += SCALE;
            x2 += SCALE;
            y1 += 1;
            y2 += SCALE - 1;
        } else if (direction == NORTH) {
            x1 += 1;
            x2 += SCALE - 1;
            y1 += 0;
            y2 += 0;
        } else if (direction == SOUTH) {
            x1 += 1;
            x2 += SCALE - 1;
            y1 += SCALE;
            y2 += SCALE;
        } else if (direction == WEST) {
            x1 += 0;
            x2 += 0;
            y1 += 1;
            y2 += SCALE - 1;
        }
        g.drawLine(x1 + XOFFSET, y1 + YOFFSET, x2 + XOFFSET, y2 + YOFFSET);
    }

    public void update (Graphics g) {

        Graphics g2 = buffer.getGraphics();
        g2.setColor(getBackground());
        g2.fillRect(0, 0, buffer.getWidth(null), buffer.getHeight(null));

        // Erase all of the missing walls...
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if ((maze[i][j] & NORTH) == 0)
                    eraseWall(g2, i, j, NORTH);
                if ((maze[i][j] & WEST) == 0)
                    eraseWall(g2, i, j, WEST);
                if (j == HEIGHT - 1 && (maze[i][j] & SOUTH) == 0)
                    eraseWall(g2, i, j, SOUTH);
                if (i == WIDTH - 1 && (maze[i][j] & EAST) == 0)
                    eraseWall(g2, i, j, EAST);
            }
        }

        // Draw all of the actual walls...
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if ((maze[i][j] & NORTH) != 0)
                    drawWall(g2, i, j, NORTH);
                if ((maze[i][j] & WEST) != 0)
                    drawWall(g2, i, j, WEST);
                if (j == HEIGHT - 1 && (maze[i][j] & SOUTH) != 0)
                    drawWall(g2, i, j, SOUTH);
                if (i == WIDTH - 1 && (maze[i][j] & EAST) != 0)
                    drawWall(g2, i, j, EAST);
            }
        }

        // Mark the various paths...
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if ((maze[i][j] & VISITED) != 0)
                    g2.setColor(Color.gray);
                else
                    g2.setColor(getBackground());

                if ((maze[i][j] & START) != 0)
                    g2.setColor(Color.green);
                else if ((maze[i][j] & EXIT) != 0)
                    g2.setColor(Color.red);
                else if ((maze[i][j] & PATH) != 0)
                    g2.setColor(Color.yellow);

                g2.fillRect(i * SCALE + 1 + XOFFSET,
                            j * SCALE + 1 + YOFFSET, SCALE - 1, SCALE - 1);
            }
        }

        g.drawImage(buffer, 0, 0, this);
    }


    public void run () {
        // This is the generating loop...
        while (Thread.currentThread() == mazeThread) {
            try {
                generate();
                Maze.Position start = chooseStart();
                chooseExit();
                findAPath1(start);
                showMaze(5000);
            } catch (InterruptedException e) { }
        }
    }

    public void init () {
        Dimension d = getSize();
        buffer = createImage(d.width, d.height);
        mazeThread = new Thread(this);
    }

    public void start () {
        if (mazeThread == null)
            mazeThread = new Thread(this);
        mazeThread.start();
    }

    public void stop () {
        mazeThread = null;
    }

    //////////// Inner class for maze positions ////////////

    private static class Position {

        private int x, y;

        private Position (int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString () {
            return "MazePosition (" + this.x + "," + this.y + ")";
        }

    }
}
