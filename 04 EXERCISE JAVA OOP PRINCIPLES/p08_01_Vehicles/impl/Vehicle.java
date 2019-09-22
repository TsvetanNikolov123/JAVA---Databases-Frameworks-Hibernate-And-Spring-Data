package p08_01_Vehicles.impl;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    // method witch check, do we have enough fuel for given distance
    public boolean drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionPerKilometer;

        if (this.fuelQuantity < neededFuel) {
            return false;
        }

        this.fuelQuantity -= neededFuel;
        return true;
    }

    // method for refueling
    public void refuel(double fuelQuantity){
        this.fuelQuantity += fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
