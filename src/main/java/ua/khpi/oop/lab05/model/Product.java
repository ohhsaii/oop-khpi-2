package ua.khpi.oop.lab05.model;

// базовий клас для всіх товарів
public class Product {
    private final String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String description() {
        return "Product: " + name + ", price: " + price;
    }
}