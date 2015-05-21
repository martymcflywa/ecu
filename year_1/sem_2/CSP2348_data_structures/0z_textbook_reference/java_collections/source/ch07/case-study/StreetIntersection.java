import javax.swing.JApplet;

public class StreetIntersection implements Runnable {

    public static final int NUM_STREETS = 4;
    private Street[] streets;

    private long currentTime;
    private int currentStreetNum = 0;

    private TrafficGraph theGraph;
    private JApplet theApplet;
    private Thread simulator;

    //////////// Constructor ////////////

    public StreetIntersection (JApplet applet, TrafficGraph graph) {
    // Create a new intersection by creating the streets of the intersection,
    // and adding 5 ± 2 vehicles to each street. Set the current time to 0,
    // and select the first street in the intersection as at green.
        streets = new Street[NUM_STREETS];
        int lightsDuration = randomInt(100, 10);
        for (int i = 0; i < streets.length; i++) {
            int arrivalPeriod = randomInt(20, 5);
            int numVehicles = randomInt(5, 2);
            streets[i] = new Street(arrivalPeriod, lightsDuration, numVehicles);
            streets[i].setArrivalTime(0);
        }
        currentTime = 0;
        currentStreetNum = 0;
        streets[currentStreetNum].setLightsTime(currentTime);
        theApplet = applet;
        theGraph = graph;
    }

    private void simulateOneTick () {

        Street currentStreet = streets[currentStreetNum];

        if (currentStreet.hasVehicles()) {
            Vehicle v = (Vehicle) currentStreet.getFirstVehicle();
            if (v.isThroughIntersection())
                currentStreet.removeVehicle();
            else
                v.decrementDelay();
        }

        for (int i = 0; i < NUM_STREETS; i++) {
            Street s = streets[i];
            if (s.arrivalDue(currentTime)) {
                s.addVehicle(new Vehicle(currentTime));
                s.setArrivalTime(currentTime);
            }
        }

        if (currentStreet.lightsDue(currentTime)) {
            currentStreetNum = (currentStreetNum + 1) % NUM_STREETS;
            streets[currentStreetNum].setLightsTime(currentTime);
        }

        currentTime++;

        theGraph.setCurrentValue(currentStreetNum);
        theGraph.setValues(getQueueLengths());
        theApplet.repaint();
    }


	public void start () {
	// Start the simulation of this intersection.
		if (simulator == null)  simulator = new Thread(this);
		simulator.start();
	}

	public void stop () {
	// Stop this simulation.
		simulator = null;
	}

    public void run () {
        while (Thread.currentThread() == simulator) {
            // Run the simulation for one tick of the clock...
            simulateOneTick();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) { }
        }
    }


    private static int randomInt (int mean, int bounds) {
        return (int) (Math.random() * bounds * 2) + mean - bounds;
    }


    public int[] getQueueLengths () {
    // Return the length of the queue of vehicles in each street.
        int[] lengths = new int[NUM_STREETS];
        for (int i = 0; i < NUM_STREETS; i++)
            lengths[i] = streets[i].numVehicles();
        return lengths;
    }

    public void setMeanArrivalPeriod (int i, int period) {
        streets[i].setMeanArrivalPeriod(period);
    }

    public void setLightsDuration (int duration) {
        for (int i = 0; i < NUM_STREETS; i++)
            streets[i].setLightsDuration(duration);
    }

    public int getLightsDuration () {
        return streets[0].getLightsDuration();
    }

    public int getMeanArrivalPeriod (int i) {
        return streets[i].getMeanArrivalPeriod();
    }

    public int getCurrentStreetNum () {
        return currentStreetNum;
    }
}
