package p03_Ferrari;

import p03_Ferrari.constants.Constants;
import p03_Ferrari.impl.AbstractCar;

public class Ferrari extends AbstractCar {

    public Ferrari(String driver) {
        super(Constants.FERRARI_MODEL, driver);
    }
}
