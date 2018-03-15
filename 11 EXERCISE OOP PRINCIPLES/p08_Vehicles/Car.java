package p08_Vehicles;

public class Car extends VehicleImpl {
    protected Car(Double quantity, Double consumption) {
        super(quantity, consumption + 0.9);
    }
}
