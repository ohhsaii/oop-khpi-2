package ua.khpi.oop.lab05.model;

// другий рівень успадкування
public class Laptop extends ComputerDevice {
    private double batteryCapacity;

    public Laptop(String name, double price, String processor, double batteryCapacity) {
        super(name, price, processor);
        this.batteryCapacity = batteryCapacity;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String description() {
        return super.description() + ", battery: " + batteryCapacity + "Wh";
    }
}