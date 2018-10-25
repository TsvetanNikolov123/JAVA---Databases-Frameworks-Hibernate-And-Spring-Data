package p03_Ferrari.impl;

import p03_Ferrari.constants.Constants;
import p03_Ferrari.interfaces.Car;

public abstract class AbstractCar implements Car {

    private String model;
    private String driver;

    public AbstractCar(String model, String driver) {
        this.model = model;
        this.driver = driver;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String useBrakes() {
        return Constants.USE_BRAKES;
    }

    @Override
    public String pushGas() {
        return Constants.PUSH_GAS;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",
                this.model,
                this.useBrakes(),
                this.pushGas(),
                this.getDriver()) +
                System.lineSeparator();
    }
}
