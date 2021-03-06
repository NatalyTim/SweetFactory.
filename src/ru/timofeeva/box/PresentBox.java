package ru.timofeeva.box;

import ru.timofeeva.calculator.CostCalculator;
import ru.timofeeva.comparators.SweetComparatorByPrice;
import ru.timofeeva.comparators.SweetComparatorByWeight;
import ru.timofeeva.sweets.Sweet;
import ru.timofeeva.sweets.factory.SweetFactory;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Timofeeva Natalia
 * @see #add(Sweet)
 * @see #getBoxPrice()
 * @see #getBoxWeight()
 * @see #optimizePrice(double)
 * @see #optimizeWeight(double)
 * @see #printBox()
 */

public class PresentBox implements Box {
    private List<Sweet> sweets = new ArrayList<>();
    private Predicate<Sweet> policy = (sweet) -> true;

@Override
    public void setPolicy(Predicate<Sweet> policy) {
        this.policy = policy;
        applyToList();
    }

    private void applyToList() {
        for (int i = 0; i < sweets.size(); i++) {
            if (!policy.test(sweets.get(i))) {
                Sweet sweet = sweets.remove(i);
                System.out.println("The sweet " + sweet + " was removed");
            }
        }
    }

    public List<Sweet> getSweets() {
        return sweets;
    }


    @Override
    public void add(Sweet sweet) {
        if (sweet == null) {
            System.out.println("You can not insert null value");
            return;
        }
        if (policy.test(sweet)) {
            sweets.add(sweet);
        } else {
            System.out.println("The sweet " + sweet.toString() +" is not added because of policy");

        }

    }

    /*
     * Создаем метод для вывода массива.
     */
    @Override
    public void printBox() {
        if (isEmpty()) {
            System.out.println("Present box is empty!");
        }
        System.out.println("**********The itemms in the box****************");
        sweets.forEach(System.out::println);
    }

    @Override
    public void printBox(CostCalculator costCalculator) {
        if (isEmpty()) {
            System.out.println("Present box is empty!");
        }
        System.out.println("**********The itemms in the box****************");
        sweets.forEach(s -> System.out.println(s.toString(costCalculator)));
    }

    /*
     * Создаем метод для вычисления веса.
     */
    @Override
    public double getBoxWeight() {
        return sweets.stream().map(s -> s.getWeight()).reduce((sum, s) -> {return sum += s;}).get();
    }

    /*
     * Создаем метод для вычисления цены.
     */
    @Override
    public double getBoxPrice() {
        double boxPrice = 0;
        return sweets.stream().map(s -> s.getPrice()).reduce((sum, s) -> {return sum += s;}).get();
//        for (int i = 0; i < sweets.size(); i++) {
//            if (sweets.get(i) != null) {
//                boxPrice += sweets.get(i).getPrice();
//            }
//        }
//        return boxPrice;
    }

    @Override
    public double getBoxPrice(CostCalculator costCalculator) {
        double boxPrice = 0;
        for (int i = 0; i < sweets.size(); i++) {
            if (sweets.get(i) != null) {
                boxPrice += sweets.get(i).getPrice(costCalculator);
            }
        }
        return boxPrice;
    }
    /*
     *Создаем метод для оптимизции массива по весу.
     */
    @Override
    public void optimizeWeight(double maxWeight) {
        if (maxWeight < 0) {
            System.out.println("Max weight can not be negative!");
            return;
        }
        if (isEmpty()) {
            System.out.println("The box is empty!");
            return;
        }
        double difference = getBoxWeight() - maxWeight;
        if (difference > 0) {
            sweets = sweets
                    .stream()
                    .sorted(new SweetComparatorByWeight())
                    .collect(Collectors.toList());

            for (int i = sweets.size() - 1; difference > 0; i--) {
                if (sweets.get(i) != null) {
                    difference -= sweets.get(i).getWeight();
                    delete(i);

                }
            }
        }

        System.out.println("Present box weight after optimisation is " + getBoxWeight() + " grams");
    }

    /*
     *Создаем метод для оптимизции массива по цене.
     */
    @Override
    public void optimizePrice(double maxPrice) {
        if (maxPrice < 0) {
            System.out.println("Max price can not be negative!");
            return;
        }
        if (isEmpty()) {
            System.out.println("The box is empty!");
            return;
        }
        double difference = getBoxPrice() - maxPrice;
        if (difference > 0) {
            sweets = sweets
                    .stream()
                    .sorted(new SweetComparatorByPrice())
                    .collect(Collectors.toList());

            for (int i = sweets.size() - 1; difference > 0; i--) {
                if (sweets.get(i) != null) {
                    difference -= sweets.get(i).getPrice();
                    delete(i);
                }
            }
        }
        System.out.println("Present box price after optimisation is " + getBoxPrice() + " rubles");
    }

    /*
     *Создаем метод для удаления элементов из массива.
     */
    @Override
    public void delete(int index) {
        if (isEmpty()) {
            System.out.println("The box is empty");
            return;
        }
        if (index >= sweets.size() || index < 0) {
            System.out.println("Invalid index was entered!");
            return;
        }
        Sweet element = sweets.get(index);
        sweets.remove(index);
        System.out.println("Element " + element.getClass().getSimpleName() + " "
                + element.getName() + " at position " + index + " is deleted.");

    }


    /*
     * Проверяем пустая ли коробка.
     */
    private boolean isEmpty() {
        if (sweets == null || sweets.size() == 0) {
            return true;
        }
        return false;
    }


}

