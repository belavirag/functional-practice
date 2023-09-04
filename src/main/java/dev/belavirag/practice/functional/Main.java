package dev.belavirag.practice.functional;

import dev.belavirag.practice.functional.interfaces.Action;
import dev.belavirag.practice.functional.interfaces.Conditional;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Sprite", 100, 20));
        products.add(new Product("Coke", 140, 0));
        products.add(new Product("Fanta", 80, 20));
        products.add(new Product("Blue", 150, 4));
        products.add(new Product("Bubble Man", 200, 8));

        Action printerAction = p -> System.out.println(p);
        Action priceIncreaser = p -> p.setPrice(p.getPrice() * 1.5d);

        System.out.println("---------Zero Stock----------");
        applyAction(products, p -> p.getStock() == 0, printerAction);
        System.out.println("---------Start with B----------");
        applyAction(products, p -> p.getProductName().startsWith("B"), printerAction);
        System.out.println("---------Price above 100 and lower than 150----------");
        applyAction(products, p -> p.getPrice() > 100 && p.getPrice() < 150, printerAction);

        applyAction(products, p -> p.getStock() < 10 && p.getStock() > 0, priceIncreaser);
        System.out.println("---------All products after price increase----------");
        applyAction(products, a -> true, printerAction);
    }

    public static void applyAction(List<Product> products, Conditional conditional, Action action) {
        products.stream().filter(conditional::test).forEach(action::execute);
    }
}