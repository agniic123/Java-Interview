package Liskov;

public class Car extends VehicleEngine{
    @Override
    public boolean hasEngine() {
        return super.hasEngine();
    }
}
