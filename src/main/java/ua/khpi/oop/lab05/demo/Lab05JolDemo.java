package ua.khpi.oop.lab05.demo;

import org.openjdk.jol.info.ClassLayout;
import ua.khpi.oop.lab05.model.GamingLaptop;

public class Lab05JolDemo {
    public static void main(String[] args) {
        GamingLaptop laptop = new GamingLaptop("Asus ROG", 2000.0, "AMD Ryzen 9", 90.0, "RTX 4090");

        // вивід структури об'єкта в пам'яті
        System.out.println(ClassLayout.parseInstance(laptop).toPrintable());
    }
}