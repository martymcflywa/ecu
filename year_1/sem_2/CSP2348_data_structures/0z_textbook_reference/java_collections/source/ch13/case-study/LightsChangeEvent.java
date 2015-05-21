import WattBrown.*;

public class LightsChangeEvent extends SimulationEvent {

    private Street currStreet, nextStreet;
    private StreetIntersection intersection;

    public LightsChangeEvent (long timeStamp, PriorityQueue eventQueue,
                            StreetIntersection intersection,
                            Street currStreet, Street nextStreet) {
        super(timeStamp, eventQueue);
        this.intersection = intersection;
        this.currStreet = currStreet;
        this.nextStreet = nextStreet;
    }

    public void perform () {
    	intersection.setGreenStreet(nextStreet);
    	if (nextStreet.hasVehicles()) {
    	    Vehicle vehicle = nextStreet.getFirstVehicle();
    	    long nextDepartureTime = timeStamp + vehicle.getDelay();
    	    VehicleDepartureEvent nextDepartureEvent =
    	            new VehicleDepartureEvent(nextDepartureTime, eventQueue,
    	                    intersection, nextStreet);
            eventQueue.add(nextDepartureEvent);
        }
        long nextLightsTime = timeStamp + intersection.getLightsDuration();
        LightsChangeEvent nextLightsChange =
                new LightsChangeEvent(nextLightsTime, eventQueue, intersection,
                        nextStreet, intersection.getStreetAfter(nextStreet));
        eventQueue.add(nextLightsChange);
    }

}