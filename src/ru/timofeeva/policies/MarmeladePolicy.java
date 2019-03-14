package ru.timofeeva.policies;

import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.marmalade.Marmalade;

public class MarmeladePolicy {
    public static boolean checkIfMarmelade(Sweet sweet){
        return sweet instanceof Marmalade;
    }
}
