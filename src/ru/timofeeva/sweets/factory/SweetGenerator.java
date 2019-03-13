package ru.timofeeva.sweets.factory;

import ru.timofeeva.sweets.Sweet;

public class SweetGenerator {
    public static Sweet generate(SweetFactory sweetFactory){
        return sweetFactory.create();
    }
}
