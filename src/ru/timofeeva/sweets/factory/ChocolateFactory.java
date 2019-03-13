package ru.timofeeva.sweets.factory;

import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.chocolate.BlackChocolate;
import ru.timofeeva.sweets.chocolate.MilkChocolate;
import ru.timofeeva.sweets.chocolate.WhiteChocolate;

import java.util.Random;

public class ChocolateFactory implements SweetFactory {
    @Override
    public Sweet create() {
        Random random = new Random();
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                return new WhiteChocolate(155, "Milka");

            case 1:
                return new BlackChocolate(210, "President");

            case 2:
                return new MilkChocolate(125, "Alpen Gold");

            default: return new BlackChocolate(250,"Alpen Gold Black");

        }

    }
}
