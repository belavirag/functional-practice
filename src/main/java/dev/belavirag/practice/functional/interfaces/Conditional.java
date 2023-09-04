package dev.belavirag.practice.functional.interfaces;

import dev.belavirag.practice.functional.Product;

@FunctionalInterface
public interface Conditional {
    boolean test(Product p);
}
