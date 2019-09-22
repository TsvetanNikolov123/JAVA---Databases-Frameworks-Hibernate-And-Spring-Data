package p03_CarShopExtend.models;

import p03_CarShopExtend.contracts.Car;

public abstract class AbstractCar implements Car {

    private final String model;
    private final String color;
    private final int horsePower;
    private final String countryProduced;

    public AbstractCar(String model, String color, int horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires.",
                this.getModel(), this.countryProduced, TIRES);
    }
}
