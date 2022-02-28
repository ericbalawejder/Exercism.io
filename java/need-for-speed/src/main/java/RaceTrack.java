record RaceTrack(int distance) {

    boolean carCanFinish(NeedForSpeed car) {
        final int numberOfDrivesOnBattery = car.getBattery() / car.getBatteryDrain();
        return numberOfDrivesOnBattery * car.getSpeed() >= this.distance;
    }

}