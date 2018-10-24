package p03_CarShopExtend.models;

import p03_CarShopExtend.contracts.Car;
import p03_CarShopExtend.contracts.Sellable;


public class Seat extends AbstractCar implements Sellable {

    private final double price;

    public Seat(String model, String color, int horsePower, String countryProduced, double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }


    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Price: " + this.getPrice();
    }
}
