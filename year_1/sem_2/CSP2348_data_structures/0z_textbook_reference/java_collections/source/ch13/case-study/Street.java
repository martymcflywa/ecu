import WattBrown.Queue;
import WattBrown.LinkedQueue;

class Street {

    private int meanArrivalPeriod, lightsDuration;
    private Queue vehicles;

    Street (int meanArrivalPeriod, int lightsDuration, int numVehicles) {
        this.meanArrivalPeriod = meanArrivalPeriod;
        this.lightsDuration = lightsDuration;
        this.vehicles = new LinkedQueue();
        for (int i = 0; i < numVehicles; i++)
            vehicles.addLast(new Vehicle(0));
    }

    int getMeanArrivalPeriod () {
        return meanArrivalPeriod;
    }

    void setMeanArrivalPeriod (int period) {
        meanArrivalPeriod = period;
    }

    int getLightsDuration () {
        return lightsDuration;
    }

    void setLightsDuration (int duration) {
        lightsDuration = duration;
    }

    Vehicle getFirstVehicle () {
        return (Vehicle) vehicles.getFirst();
    }

    void addVehicle (Vehicle v) {
        vehicles.addLast(v);
    }

    void removeVehicle () {
        vehicles.removeFirst();
    }

    boolean hasVehicles () {
        return ! vehicles.isEmpty();
    }

    int numVehicles () {
        return vehicles.size();
    }
}
