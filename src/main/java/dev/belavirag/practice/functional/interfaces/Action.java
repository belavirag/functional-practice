package dev.belavirag.practice.functional.interfaces;

import dev.belavirag.practice.functional.Product;

@FunctionalInterface
public interface Action {
    void execute(Product p);
}
