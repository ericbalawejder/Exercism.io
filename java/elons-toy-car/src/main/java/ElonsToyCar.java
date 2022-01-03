class ElonsToyCar {

    private int mileage = 0;
    private int battery = 100;

    static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    String distanceDisplay() {
        return "Driven " + this.mileage + " meters";
    }

    String batteryDisplay() {
        return this.battery > 0 ? "Battery at " + this.battery + "%" : "Battery empty";
    }

    void drive() {
        if (this.battery > 0) {
            this.mileage += 20;
            this.battery--;
        }
    }

}
