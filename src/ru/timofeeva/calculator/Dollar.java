package ru.timofeeva.calculator;

public class Dollar implements CostCalculator {
    @Override
    public double calculate(double c) {
        double rubleToDollar = c/65;

        return rubleToDollar;

    }
}
