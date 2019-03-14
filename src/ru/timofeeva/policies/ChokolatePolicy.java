package ru.timofeeva.policies;

import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.chocolate.Chocolate;

import java.util.function.Predicate;

public class ChokolatePolicy implements Predicate<Sweet> {


    @Override
    public boolean test(Sweet sweet) {
        return sweet instanceof Chocolate;
    }
}
