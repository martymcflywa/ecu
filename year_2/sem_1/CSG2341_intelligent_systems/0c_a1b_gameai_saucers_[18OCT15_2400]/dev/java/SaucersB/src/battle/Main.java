package battle;

import battle.images.Images;
import battle.saucers.*;
import battle.saucers.controllers.*;
import battle.sounds.Sounds;
import battle.starfield.Starfield;
import battle.starfield.StarfieldViewer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame implements Runnable, Constants {
    // Here are the controllers used in each battle : replace some of the SimpleControllers for testing
    private static SaucerController[] controllers;

    static {
        try {
            controllers = new SaucerController[]
                    {
                            new SimpleController(),
                            new RoyalRumbleController(),
                            new SimpleController(),
                            new SimpleController(),
                            new SimpleController(),
                            new SimpleController(),
                            new SittingDuckController(),
                            new SittingDuckController(),
                            new SittingDuckController(),
                            new SittingDuckController(),
                            new SittingDuckController(),
                            new SittingDuckController()
                    };
        } catch (Exception e) {
            System.err.println("Unable to create controllers");
            e.printStackTrace(System.err);
            System.exit(0);
        }
    }

    private Starfield field;
    private StarfieldViewer viewer;
    private ControlPanel control;

    private boolean stop = true;
    private boolean paused = false;

    public Main() throws Exception {
        super("Battle Viewer");
        setLayout(new BorderLayout());
        setSize(750, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Images.loadImages();

        field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT, Constants.STARFIELD_N_POWERUPS);
        viewer = new StarfieldViewer(field);
        add(viewer, BorderLayout.CENTER);

        control = new ControlPanel();
        add(control, BorderLayout.SOUTH);

        Sounds.loadSounds();

        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }

    private void init() throws Exception {
        field = new Starfield(STARFIELD_WIDTH, STARFIELD_HEIGHT, STARFIELD_N_POWERUPS);

        for (int i = 0; i < controllers.length; i++) {
            field.addSaucer(new Saucer(field, controllers[i]));
        }

        viewer.setStarfield(field);
    }

    public void run() {
        try {
            init();

            paused = false;
            stop = false;

            double time = 0;
            while (field.getSaucerManager().numberAlive() > 1 && !stop && time < TIME_LIMIT) {
                try {
                    Thread.sleep(10, 0);
                } catch (InterruptedException ie) {
                }

                if (!paused) {
                    time += SECONDS;

                    field.update(SECONDS);
                    viewer.repaint();
                }
            }

            // finish off explosions
            while (field.numberOfExplosions() > 0 && !stop) {
                try {
                    Thread.sleep(10, 0);
                } catch (InterruptedException ie) {
                }

                field.updateExplosions(SECONDS);
                viewer.repaint();
            }

            control.done();

            field.finalisePlacings();

            report();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            stop = true;
        }
    }

    private void report() {
        System.out.println();
        for (Saucer saucer : field.getSaucers()) {
            System.out.println(saucer.getControllerName() + "\t\t" + saucer.getPlacing());
        }
        System.out.println();
    }

    public void stop() {
        stop = true;
    }

    public void pause(boolean pause) {
        paused = pause;
    }

    public boolean isPaused() {
        return paused;
    }

    public void reset() {
    }

    // inner class
    private class ControlPanel extends JPanel implements ActionListener {
        public ControlPanel() {
            startStop = new JButton(START);
            startStop.addActionListener(this);
            add(startStop);

            pauseResume = new JButton(PAUSE);
            pauseResume.addActionListener(this);
            add(pauseResume);

            nextBackground = new JButton("next background");
            nextBackground.addActionListener(this);
            add(nextBackground);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startStop) {
                if (!stop) {
                    Main.this.stop();
                    Main.this.pause(false);
                    startStop.setText(START);
                    pauseResume.setText(PAUSE);
                } else {
                    new Thread(Main.this).start();
                    Main.this.pause(false);
                    startStop.setText(STOP);
                    pauseResume.setText(PAUSE);
                }
            } else if (e.getSource() == pauseResume) {
                if (!stop) {
                    if (Main.this.isPaused()) {
                        Main.this.pause(false);
                        pauseResume.setText(PAUSE);
                    } else {
                        Main.this.pause(true);
                        pauseResume.setText(RESUME);
                    }
                }
            } else if (e.getSource() == nextBackground) {
                viewer.nextBackground();
                viewer.repaint();
            }
        }

        public void done() {
            stop = true;
            Main.this.pause(false);
            startStop.setText(START);
            pauseResume.setText(PAUSE);
        }

        private JButton startStop;
        private JButton pauseResume;
        private JButton nextBackground;
        private static final String START = "start";
        private static final String STOP = "stop";
        private static final String PAUSE = "pause";
        private static final String RESUME = "resume";
    }
}