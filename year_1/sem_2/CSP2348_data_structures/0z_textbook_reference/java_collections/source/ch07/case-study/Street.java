import WattBrown.Queue;
import WattBrown.LinkedQueue;

class Street {

    private int meanArrivalPeriod, lightsDuration;
    private long nextArrivalTime, nextLightsTime;
    private Queue vehicles;

    Street (int meanArrivalPeriod, int lightsDuration, int numVehicles) {
        this.meanArrivalPeriod = meanArrivalPeriod;
        this.lightsDuration = lightsDuration;
        this.nextArrivalTime = 0;
        this.nextLightsTime = 0;
        this.vehicles = new LinkedQueue();
        for (int i = 0; i < numVehicles; i++)
            vehicles.addLast(new Vehicle(0));
    }

    boolean arrivalDue (long currentTime) {
        return (currentTime >= nextArrivalTime);
    }

    void setArrivalTime (long currentTime) {
        nextArrivalTime = currentTime +
                Math.round((Math.random() + 0.5) * meanArrivalPeriod);
    }

    boolean lightsDue (long currentTime) {
        return (currentTime >= nextLightsTime);
    }

    void setLightsTime (long currentTime) {
        nextLightsTime = currentTime + lightsDuration;
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
        nextLightsTime += duration - lightsDuration;
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
