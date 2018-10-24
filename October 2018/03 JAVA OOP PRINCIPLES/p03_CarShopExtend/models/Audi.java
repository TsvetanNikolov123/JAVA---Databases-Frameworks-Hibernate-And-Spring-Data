package p03_CarShopExtend.models;

import p03_CarShopExtend.contracts.Rentable;

public class Audi extends AbstractCar implements Rentable {

    private final int minRentDays;
    private final double pricePerDay;

    public Audi(String model, String color, int horsePower,
                String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDays = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDays;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + "Min Rent Days: " + this.getMinRentDay() + System.lineSeparator()
                + "Price per Day: " + this.getPricePerDay();
    }
}
