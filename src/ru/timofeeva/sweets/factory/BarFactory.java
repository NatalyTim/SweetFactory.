package ru.timofeeva.sweets.factory;

import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.chocolate.*;

import java.util.Random;

public class BarFactory implements SweetFactory {

    @Override
    public Sweet create() {
        Random random = new Random();
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                return new Nuts();

            case 1:
                return new Snickers();

            case 2:
                return new Mars();

            default:
                return new Mars();

        }
    }
}

