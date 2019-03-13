package ru.timofeeva.calculator;

public class Dollar implements CostCalculator {
    @Override
    public double costCalculator(double c) {
        double rubleToDollar = c/65;

        return rubleToDollar;

    }
}
