package ru.timofeeva.sweets;

import ru.timofeeva.calculator.CostCalculator;

public abstract class Sweet {
    private double price, weight;
    private String name;


    public Sweet(double price, double weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public double getPrice(CostCalculator costCalculator) {
        return costCalculator.calculate(price);
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sweet : " + getName() + ", weight - " + getWeight() + ", price - " + getPrice() + "class - ";
    }

    public String toString(CostCalculator costCalculator) {
        return "Sweet : " + getName() + ", weight - " + getWeight() + ", price - " + getPrice(costCalculator);
    }
}
