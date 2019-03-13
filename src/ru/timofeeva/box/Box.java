package ru.timofeeva.box;

import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.factory.SweetFactory;

public interface Box {
    void add(SweetFactory sweet);
    void add(Sweet sweet);
    double getBoxWeight();
    double getBoxPrice();
    void delete(int index);
    void optimizeWeight(double maxWeight);
    void optimizePrice(double maxPrice);
    void printBox();
}
