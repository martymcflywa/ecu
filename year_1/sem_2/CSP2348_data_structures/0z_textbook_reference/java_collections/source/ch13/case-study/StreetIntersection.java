import javax.swing.JApplet;
import WattBrown.*;

public class StreetIntersection implements Runnable {

    public static final int NUM_STREETS = 4;
    private Street[] streets;
    private PriorityQueue eventQueue;
    private int currentStreetNum;

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
        }
        eventQueue = new HeapPriorityQueue(8);
        createArrivalEvents();
        createLightChangeEvent();
        currentStreetNum = 0;
        theApplet = applet;
        theGraph = graph;
    }

    private void createArrivalEvents () {
    	for (int i = 0; i < streets.length; i++) {
            long nextArrivalTime = Math.round((Math.random() + 0.5) *
                    streets[i].getMeanArrivalPeriod());
    	    VehicleArrivalEvent nextArrivalEvent = new VehicleArrivalEvent(
    	            nextArrivalTime, eventQueue, this, streets[i]);
            eventQueue.add(nextArrivalEvent);
        }
    }

    private void createLightChangeEvent () {
        LightsChangeEvent nextLightsEvent = new LightsChangeEvent(
                0, eventQueue, this, streets[0], streets[1]);
    	eventQueue.add(nextLightsEvent);
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
            SimulationEvent nextEvent =
                    (SimulationEvent) eventQueue.removeLeast();
            nextEvent.perform();
            theGraph.setValues(getQueueLengths());
            theApplet.repaint();
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

    public void setGreenStreet (Street street) {
    	for (int i = 0; i < streets.length; i++) {
    	    if (streets[i] == street) {
    	    	currentStreetNum = i;
    	    	break;
    	    }
    	}
    	theGraph.setCurrentValue(currentStreetNum);
    }

    public Street getGreenStreet () {
    	return streets[currentStreetNum];
    }

    public Street getStreetAfter (Street street) {
    	for (int i = 0; i < streets.length; i++) {
    	    if (streets[i] == street)
    	    	return streets[(i+1) % streets.length];
    	 }
        return null;
    }

    public int getCurrentStreetNum () {
        return currentStreetNum;
    }
}
