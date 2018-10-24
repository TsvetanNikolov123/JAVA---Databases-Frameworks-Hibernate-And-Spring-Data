package p02_CarShop;

import java.io.Serializable;

public class Seat implements Car, Serializable {

    private String countryProduced;
    private String model;
    private String color;
    private int horsePower;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        this.countryProduced = countryProduced;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
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
        StringBuilder sb = new StringBuilder();
        /*
        sb
                .append(String.format("%s is %s and have %d horse powers",
                        this.getModel(),
                        this.getColor(),
                        this.getHorsePower()))
                .append(System.lineSeparator())
                */
        sb      .append(String.format("This is %s produced in %s and have %d tires",
                        this.getModel(),
                        this.countryProduced,
                        TIRES));

        return sb.toString();
    }
}
