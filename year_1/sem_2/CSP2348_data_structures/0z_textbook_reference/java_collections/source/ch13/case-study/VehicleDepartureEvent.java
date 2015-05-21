import WattBrown.*;

public class VehicleDepartureEvent extends SimulationEvent {

    private Street street;
    private StreetIntersection intersection;

    public VehicleDepartureEvent (long timeStamp, PriorityQueue eventQueue,
                            StreetIntersection intersection, Street street) {
        super(timeStamp, eventQueue);
        this.intersection = intersection;
        this.street = street;
    }

    public void perform () {
        if (street == intersection.getGreenStreet()) {
            street.removeVehicle();
            if (street.hasVehicles())  {
                Vehicle vehicle = street.getFirstVehicle();
                long nextDepartureTime = timeStamp + vehicle.getDelay();
                VehicleDepartureEvent nextDepartureEvent =
                        new VehicleDepartureEvent(nextDepartureTime,
                                eventQueue, intersection, street);
                eventQueue.add(nextDepartureEvent);
            }
        }
    }

}