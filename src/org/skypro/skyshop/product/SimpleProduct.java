package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.InputMismatchException;

public class SimpleProduct extends Product implements Comparable<Searchable> {
    private int productPrice;

    public SimpleProduct(String productName, int productPrice) throws IllegalArgumentException {
        super(productName);
        this.productPrice = productPrice;
        if (productPrice <= 0) {
                throw new IllegalArgumentException("Цена не может быть меньше нуля!");
        }
    }

    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "Продукт - " + productName + ", цена - " + productPrice + ".";
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String contentType() {

        return null;
    }

    @Override
    public String getStringRepresentation() {

        return null;
    }

    @Override
    public int compareTo(Searchable o) {
        return 0;
    }
}
