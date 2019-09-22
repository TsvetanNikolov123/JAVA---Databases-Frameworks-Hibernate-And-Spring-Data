package p08_01_Vehicles.impl;

public class Truck extends Vehicle{
    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer);
    }

    // override abstract car setter
    @Override
    protected void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer) {
        super.setFuelConsumptionPerKilometer(fuelConsumptionPerKilometer + SUMMER_MODE_PERMANENT_ON);
    }

    // override refuel method because we have a hole in truck tank and he get only 95% of the refueling
    @Override
    public void refuel(double fuelQuantity) {
        double realFuelQuantity = fuelQuantity - (fuelQuantity * 5 / 100);
        super.refuel(realFuelQuantity);
    }
}
