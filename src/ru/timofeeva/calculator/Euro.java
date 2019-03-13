package ru.timofeeva.calculator;

import ru.timofeeva.sweets.Sweet;

public class Euro implements CostCalculator {


    @Override
    public double costCalculator(double c) {
        double rubleToEuro = c/75;
        return rubleToEuro;
    }
}
