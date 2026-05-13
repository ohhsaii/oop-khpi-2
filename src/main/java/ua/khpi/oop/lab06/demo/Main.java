package ua.khpi.oop.lab06.demo;

import ua.khpi.oop.lab06.model.*;

public class Main {
    public static void main(String[] args) {
        // масив базового типу для демонстрації поліморфізму
        InsurancePolicy[] policies = {
                new HealthPolicy("h-01", "Veronika Nikolenko", true, "central city"),
                new VehiclePolicy("v-09", "Veronika Nikolenko", true, "ax 1234 bb"),
                new TravelPolicy("t-45", "Veronika Nikolenko", false, "poland")
        };

        for (InsurancePolicy p : policies) {
            System.out.println(p.summary());
            System.out.println(p.calculateCoverage());
        }
    }
}