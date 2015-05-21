import WattBrown.*;

public class VehicleArrivalEvent extends SimulationEvent {

    private Street street;
    private StreetIntersection intersection;

    public VehicleArrivalEvent (long timeStamp, PriorityQueue eventQueue,
                            StreetIntersection intersection, Street street) {
        super(timeStamp, eventQueue);
        this.intersection = intersection;
        this.street = street;
    }

    public void perform () {
        Vehicle vehicle = new Vehicle(timeStamp);
        street.addVehicle(vehicle);
        if (street.numVehicles() == 1 &&
                street == intersection.getGreenStreet()) {
            // This is the only vehicle in a street with a green light,
            // so schedule its departure too.
            long nextDepartureTime = timeStamp + vehicle.getDelay();
            VehicleDepartureEvent nextDepartureEvent =
                    new VehicleDepartureEvent(nextDepartureTime,
                            eventQueue, intersection, street);
            eventQueue.add(nextDepartureEvent);
        }
        long nextArrivalTime = timeStamp + Math.round((Math.random() + 0.5) *
                street.getMeanArrivalPeriod());
        VehicleArrivalEvent nextArrivalEvent =
                new VehicleArrivalEvent(nextArrivalTime, eventQueue,
                        intersection, street);
        eventQueue.add(nextArrivalEvent);
    }

}