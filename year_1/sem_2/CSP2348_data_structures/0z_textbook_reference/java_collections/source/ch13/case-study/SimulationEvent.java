import WattBrown.*;

public abstract class SimulationEvent implements Comparable {

    long timeStamp;
    PriorityQueue eventQueue;

    public SimulationEvent (long timeStamp, PriorityQueue eventQueue) {
        this.timeStamp = timeStamp;
        this.eventQueue = eventQueue;
    }

    public int compareTo (Object that) {
        SimulationEvent other = (SimulationEvent) that;
        return (int) (this.timeStamp - other.timeStamp);
    }

    public abstract void perform ();
}