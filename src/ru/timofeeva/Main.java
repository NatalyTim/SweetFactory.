package ru.timofeeva;

import ru.timofeeva.box.Box;
import ru.timofeeva.box.PresentBox;
import ru.timofeeva.calculator.*;
import ru.timofeeva.policies.ChokolatePolicy;
import ru.timofeeva.policies.MarmeladePolicy;
import ru.timofeeva.sweets.*;
import ru.timofeeva.sweets.chocolate.BlackChocolate;
import ru.timofeeva.sweets.factory.BarFactory;
import ru.timofeeva.sweets.factory.ChocolateFactory;
import ru.timofeeva.sweets.factory.SweetGenerator;
import ru.timofeeva.sweets.gingerbread.Filling;
import ru.timofeeva.sweets.gingerbread.Gingerbread;
import ru.timofeeva.sweets.marmalade.Marmalade;
import ru.timofeeva.sweets.marmalade.MarmaladeTaste;


import java.util.Random;


public class Main {

    public static void main(String[] args) {
        Box box = new PresentBox();
        System.out.println("***************Task№1*****************");
        Sweet sweet = SweetGenerator.generate(new ChocolateFactory());
        box.add(sweet);
        sweet = SweetGenerator.generate(BarFactory::create);
        box.add(sweet);
        sweet = SweetGenerator.generate(() -> {
            Random random = new Random();
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    return new Marmalade(MarmaladeTaste.APPLE);

                case 1:
                    return new Marmalade(MarmaladeTaste.PEAR);

                case 2:
                    return new Marmalade(MarmaladeTaste.CHERRY);

                default:
                    return new Marmalade(MarmaladeTaste.CHERRY);

            }
        });
        box.add(sweet);
        sweet = SweetGenerator.generate(() -> {
            Random random = new Random();
            int index = random.nextInt(3);
            switch (index) {
                case 0:
                    return new Gingerbread(50, Filling.GINGERBREAD_WITH_APPLE);

                case 1:
                    return new Gingerbread(75, Filling.GINGERBREAD_WITH_BERRIES);

                case 2:
                    return new Gingerbread(45, Filling.CLASSIC_GINGERBREAD);

                default:
                    return new Gingerbread(45, Filling.CLASSIC_GINGERBREAD);

            }
        });
        box.add(sweet);
        box.printBox();
        System.out.println("***************Task№2*****************");
        System.out.println("по цене");
        box.setPolicy((Sweet s) -> {
            return s.getPrice() < 100;
        });
        box.add(new BlackChocolate(150, "Alpen Gold"));
        box.add(new BlackChocolate(70, "Alpen Gold"));
        box.printBox();

        System.out.println("по весу");
        box.setPolicy((Sweet s) -> {
            return s.getWeight() < 200;
        });
        box.add(new Marmalade(210,MarmaladeTaste.PEAR));
        box.add(new Marmalade(95, MarmaladeTaste.CHERRY));
        box.printBox();

        box.setPolicy(new ChokolatePolicy());

        box.add(new Marmalade(210,MarmaladeTaste.PEAR));
        box.add(new BlackChocolate(70, "Alpen Gold"));
        box.printBox();

        box.setPolicy(MarmeladePolicy::checkIfMarmelade);
        box.add(new Marmalade(210,MarmaladeTaste.PEAR));
        box.add(new BlackChocolate(70, "Alpen Gold"));
        box.printBox();

        System.out.println("***************Task№3*****************");
        System.out.println("Стоимость подарка в долларах");
        Dollar dollar = new Dollar();
        System.out.println(String.format("Result = " + "%.2f", box.getBoxPrice(dollar)));

        System.out.println("Стоимость подарка в фунтах");
        System.out.println(String.format("Result = " + "%.2f", box.getBoxPrice(Pounds::calculate)));

        System.out.println("Стоимость подарка в евро");
        System.out.println(String.format("Result = " + "%.2f", box.getBoxPrice(
                (double c) -> {
                    return c/75.;
                })
        ));

        System.out.println("Стоимость подарка в евроцентах");
        System.out.println(String.format("Result = " + "%.2f", box.getBoxPrice(
                (double c) -> {
                    return c/75. * 100.;
                })
        ));

        System.out.println("*****************Streams*****************");
        System.out.println("Общий вес: " + box.getBoxWeight());
        System.out.println("Общая стоимоть:" + box.getBoxPrice());
        box.optimizePrice(100);
        box.optimizeWeight(500);

    }
}
