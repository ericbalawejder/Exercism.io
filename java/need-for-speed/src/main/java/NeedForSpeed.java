class NeedForSpeed {

    private final int speed;
    private final int batteryDrain;
    private int distanceDriven = 0;
    private int battery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    boolean batteryDrained() {
        return battery == 0;
    }

    int distanceDriven() {
        return this.distanceDriven;
    }

    void drive() {
        if (this.battery >= this.batteryDrain) {
            this.distanceDriven += this.speed;
            this.battery -= batteryDrain;
        }
    }

    int getSpeed() {
        return speed;
    }

    int getBatteryDrain() {
        return batteryDrain;
    }

    int getDistanceDriven() {
        return distanceDriven;
    }

    int getBattery() {
        return battery;
    }

    static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

}
