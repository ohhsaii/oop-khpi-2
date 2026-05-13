package ua.khpi.oop.lab05.demo;

import ua.khpi.oop.lab05.model.GamingLaptop;
import ua.khpi.oop.lab05.model.Laptop;
import ua.khpi.oop.lab05.model.Product;

public class Main {
    public static void main(String[] args) {
        // створення об'єктів різних рівнів ієрархії
        Product genericProduct = new Product("Generic Mouse", 15.5);
        Laptop workLaptop = new Laptop("OfficeBook", 600.0, "Intel i5", 55.0);
        GamingLaptop predator = new GamingLaptop("Predator Helios", 1500.0, "Intel i9", 90.0, "RTX 4080");

        System.out.println(genericProduct.description());
        System.out.println(workLaptop.description());
        System.out.println(predator.description());
    }
}