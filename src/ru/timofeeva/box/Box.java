package ru.timofeeva.box;

import ru.timofeeva.calculator.CostCalculator;
import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.factory.SweetFactory;

import java.util.function.Predicate;

public interface Box {
    void add(Sweet sweet);
    double getBoxWeight();
    double getBoxPrice();
    double getBoxPrice(CostCalculator costCalculator);
    void delete(int index);
    void optimizeWeight(double maxWeight);
    void optimizePrice(double maxPrice);
    void printBox();
    void printBox(CostCalculator costCalculator);
    void setPolicy(Predicate<Sweet> policy);
}
