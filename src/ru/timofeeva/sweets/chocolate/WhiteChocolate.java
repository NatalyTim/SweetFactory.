package ru.timofeeva.sweets.chocolate;
import ru.timofeeva.sweets.Sweet;
/**
 * @author Timofeeva Natalia
 * @see #WhiteChocolate(double, String)
 */

public class WhiteChocolate extends Chocolate {

    public WhiteChocolate(double price, String name) {

        super(price, 200, name, ChocolateType.WHITE_CHOCOLATE_TILE);
    }
     public static Sweet create(){
        return new WhiteChocolate(110,"AVR");
    }

}
