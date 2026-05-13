package ua.khpi.oop.lab05.model;

// кінцевий клас, забороняємо подальше успадкування через final
public final class GamingLaptop extends Laptop {
    private final String gpu;

    public GamingLaptop(String name, double price, String processor, double batteryCapacity, String gpu) {
        super(name, price, processor, batteryCapacity);
        this.gpu = gpu;
    }

    public String getGpu() {
        return gpu;
    }

    @Override
    public String description() {
        return super.description() + ", GPU: " + gpu;
    }
}