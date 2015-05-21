class Vehicle {

    private final static int MAX_DELAY = 5;

    private int delay;
    private long arrivalTime;

    Vehicle (long arrivalTime) {
        this.delay = ((int) (Math.random() * MAX_DELAY)) + 1;
        this.arrivalTime = arrivalTime;
    }

    Vehicle (long arrivalTime, int delay) {
        this.delay = delay;
        this.arrivalTime = arrivalTime;
    }

    int getDelay () {
        return delay;
    }
}
