package ua.khpi.oop.lab05.model;

// перший рівень успадкування
public class ComputerDevice extends Product {
    private final String processor;

    public ComputerDevice(String name, double price, String processor) {
        super(name, price); // виклик конструктора базового класу
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String description() {
        return super.description() + ", processor: " + processor;
    }
}