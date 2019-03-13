package ru.timofeeva;

import ru.timofeeva.box.Box;
import ru.timofeeva.box.PresentBox;
import ru.timofeeva.sweets.*;
import ru.timofeeva.sweets.chocolate.*;
import ru.timofeeva.sweets.factory.BarFactory;
import ru.timofeeva.sweets.factory.ChocolateFactory;
import ru.timofeeva.sweets.factory.SweetFactory;
import ru.timofeeva.sweets.gingerbread.Filling;
import ru.timofeeva.sweets.gingerbread.Gingerbread;
import ru.timofeeva.sweets.marmalade.Marmalade;
import ru.timofeeva.sweets.marmalade.MarmaladeTaste;

public class Main {

    public static void main(String[] args) {
        Box box = new PresentBox();

        System.out.println("***************Tests for filled box*****************");
        System.out.println("Simple method add");
        box.add(new ChocolateFactory());
        box.add(new BarFactory());
        System.out.println("Method add(SweetFactory sweetFactory)");
        box.add(new ChocolateFactory());
        box.add(new BarFactory());
        System.out.println("Static method");
        box.add(BlackChocolate::create);
        box.add(WhiteChocolate::create);
        System.out.println("lambda expressions");
        box.add(() -> new BlackChocolate(115, "test"));


        box.printBox();


    }
}
