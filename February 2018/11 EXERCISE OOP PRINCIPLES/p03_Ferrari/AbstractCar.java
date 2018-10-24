package p03_Ferrari;


public class AbstractCar implements Car {

    public static final String PUSHING_GAS = "Zadu6avam sA!";
    public static final String USING_BRAKES = "Brakes!";
    public static final String FERRARI_MODEL = "488-Spider";

    private String driver;

    public AbstractCar(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return this.driver;
    }

    @Override
    public String useBrakes() {
        return USING_BRAKES;
    }

    @Override
    public String pushGas() {
        return PUSHING_GAS;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s%n",
                FERRARI_MODEL,
                this.useBrakes(),
                this.pushGas(),
                this.getDriver());
    }
}
