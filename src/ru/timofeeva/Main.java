package ru.timofeeva;

import ru.timofeeva.box.Box;
import ru.timofeeva.box.PresentBox;
import ru.timofeeva.calculator.*;
import ru.timofeeva.sweets.*;
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
        box.printBox();
        System.out.println("по весу");
        box.setPolicy((Sweet s) -> {
            return s.getWeight() < 200;
        });


        box.printBox();
        System.out.println("***************Task№3*****************");
        System.out.println("Стоимость подарка в долларах");
        Dollar dollar = new Dollar();
        System.out.println(String.format("Result = " + "%.2f", dollar.costCalculator(box.getBoxPrice())));
        System.out.println("Стоимость подарка в евро");
        Euro euro = new Euro();
        System.out.println(String.format("Result = " + "%.2f", euro.costCalculator(box.getBoxPrice())));

        box.getBoxPrice();
        box.printBox();


    }
}
