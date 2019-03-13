package ru.timofeeva.sweets.factory;

import ru.timofeeva.sweets.Sweet;
@FunctionalInterface
public interface SweetFactory {
    Sweet create();
}
