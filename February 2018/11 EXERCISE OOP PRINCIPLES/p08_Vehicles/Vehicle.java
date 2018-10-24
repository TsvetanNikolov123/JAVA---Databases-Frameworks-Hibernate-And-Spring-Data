package p08_Vehicles;

public interface Vehicle {
    void drive(Double km);
    void refuel(Double quantity);
    boolean canTravel(Double km);
    Double getQuantity();
    Double getConsumption();
}
