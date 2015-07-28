package ponce.csg2341.ws01.mystery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.PrintStream;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Mystery
        extends JPanel {
    private int size;
    private double[][] coords;
    private int[] tour;
    private JPanel container;

    private Mystery(Random random, int size) {
        this.size = size;
        this.coords = new double[size][];
        for (int i = 0; i < size; i++) {
            this.coords[i] = new double[2];
        }
        for (int i = 0; i < size; i++) {
            this.coords[i][0] = random.nextDouble();
            this.coords[i][1] = random.nextDouble();
        }
        this.tour = null;

        this.container = new JPanel();
        this.container.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(400, 400));
        this.container.add(this, "Center");
    }

    public Mystery() {
        this.coords = new double[][]{{0.5013070090572934D, 0.034664301060053915D}, {0.2547956322452125D, 0.6528835382781787D}, {0.10359236705500763D, 0.6614459347554367D}, {0.3944582809295607D, 0.9434001331381733D}, {0.3791463463199203D, 0.5237754291802993D}, {0.23227252904534845D, 0.8000245707361361D}, {0.0397143742444136D, 0.006605346525780709D}, {0.006738041968876729D, 0.10182904797531322D}, {0.42111014143648207D, 0.7166373076311461D}, {0.00895383096708191D, 0.360735753979723D}, {0.48953232242516886D, 0.8640447580633703D}, {0.9145339199620528D, 0.9684423657501484D}, {0.38512944765935675D, 0.6110396828790433D}, {0.7818064811492871D, 0.28070589841395577D}, {0.1240155198932279D, 0.15507045385621332D}, {0.09455839394659793D, 0.873564985090129D}, {0.11108918129200074D, 0.2989089497096754D}, {0.4636734908302318D, 0.9595873116301883D}, {0.3159003172012729D, 0.029945343466889596D}, {0.254203286927687D, 0.7903390821236306D}, {0.9436844268007322D, 0.40325735366067805D}, {0.10843159341037956D, 0.05880168124824192D}, {0.1945450965063209D, 0.6340195010982176D}, {0.29571150530409684D, 0.6344602650978091D}, {0.5471433908292886D, 0.42403014846085174D}};


        this.size = this.coords.length;

        this.tour = null;

        this.container = new JPanel();
        this.container.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(400, 400));
        this.container.add(this, "Center");
    }

    private double getDistance(int from, int to) {
        return Math.sqrt((this.coords[from][0] - this.coords[to][0]) * (this.coords[from][0] - this.coords[to][0]) + (this.coords[from][1] - this.coords[to][1]) * (this.coords[from][1] - this.coords[to][1]));
    }

    public double evaluate(int[] tour)
            throws Exception {
        double length = 0.0D;
        this.tour = tour;
        if (tour.length != this.size) {
            throw new Exception("Solution is wrong length: " + tour.length + " instead of " + this.size + ".");
        }
        boolean[] check = new boolean[this.size];
        for (int i = 0; i < this.size; i++) {
            if ((tour[i] < 0) || (tour[i] > this.size - 1)) {
                throw new Exception("Solution entry " + tour[i] + " is invalid. Must be in the range 0 to " + (this.size - 1) + ".");
            }
            if (check[tour[i]]) {
                throw new Exception("Solution entry " + tour[i] + " is repeated.");
            }
            check[tour[i]] = true;
        }
        for (int i = 0; i < tour.length - 1; i++) {
            length += getDistance(tour[i], tour[(i + 1)]);
        }
        length += getDistance(tour[0], tour[(tour.length - 1)]);

        return length;
    }

    public void updateDisplay() {
        repaint();
    }

    public void draw(Graphics g, Rectangle viewport) {
        g.setColor(Color.lightGray);
        for (int i = 0; i < this.size; i++) {
            int x1 = (int) Math.round(viewport.x + viewport.width * this.coords[i][0]);
            int y1 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[i][1]);
            for (int j = 0; j < i; j++) {
                int x2 = (int) Math.round(viewport.x + viewport.width * this.coords[j][0]);
                int y2 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[j][1]);
                g.drawLine(x1, y1, x2, y2);
            }
        }
        g.setColor(Color.gray);
        for (int i = 0; i < this.size; i++) {
            int x1 = (int) Math.round(viewport.x + viewport.width * this.coords[i][0]);
            int y1 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[i][1]);
            g.fillOval(x1 - 5, y1 - 5, 11, 11);
        }
        g.setColor(Color.red);
        for (int i = 0; i < this.size; i++) {
            int x1 = (int) Math.round(viewport.x + viewport.width * this.coords[i][0]);
            int y1 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[i][1]);
            g.drawString("" + i, x1, y1);
        }
    }

    public void drawTour(Graphics g, int[] tour, Rectangle viewport) {
        try {
            double cost = evaluate(tour);

            g.setColor(Color.black);
            for (int i = 0; i < tour.length - 1; i++) {
                int x1 = (int) Math.round(viewport.x + viewport.width * this.coords[tour[i]][0]);
                int y1 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[tour[i]][1]);
                int x2 = (int) Math.round(viewport.x + viewport.width * this.coords[tour[(i + 1)]][0]);
                int y2 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[tour[(i + 1)]][1]);
                g.drawLine(x1, y1, x2, y2);
            }
            int x1 = (int) Math.round(viewport.x + viewport.width * this.coords[tour[0]][0]);
            int y1 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[tour[0]][1]);
            int x2 = (int) Math.round(viewport.x + viewport.width * this.coords[tour[(tour.length - 1)]][0]);
            int y2 = (int) Math.round(viewport.y + viewport.height - viewport.height * this.coords[tour[(tour.length - 1)]][1]);
            g.drawLine(x1, y1, x2, y2);

            g.setColor(Color.blue);
            g.drawString("" + cost, viewport.x + 5, viewport.y + 10);
        } catch (Exception e) {
            g.setColor(Color.blue);
            g.drawString(e.getMessage(), viewport.x + 5, viewport.y + 10);
        }
    }

    public String toString() {
        String result = "{\n";
        for (int i = 0; i < this.size; i++) {
            result = result + "\t{ " + this.coords[i][0] + ", " + this.coords[i][1] + "}";
            if (i < this.size - 1) {
                result = result + ",";
            }
            result = result + "\n";
        }
        result = result + "};";

        return result;
    }

    public void display() {
        JFrame viewer = new JFrame("Mystery problem");
        viewer.setDefaultCloseOperation(3);
        viewer.getContentPane().add(this.container);
        viewer.pack();
        viewer.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int GAP = 10;
        Rectangle viewport = new Rectangle(10, 10, getWidth() - 20, getHeight() - 20);

        draw(g, viewport);
        if (this.tour != null) {
            drawTour(g, this.tour, viewport);
        }
    }

    public static void main(String[] args)
            throws Exception {
        if (args.length < 1) {
            throw new Exception("No solution provided.");
        }
        Mystery mystery = new Mystery();

        int[] tour = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            tour[i] = Integer.parseInt(args[i]);
        }
        System.out.println("Your solution costs " + mystery.evaluate(tour));
    }
}

