package org.skypro.skyshop.product;

import java.util.InputMismatchException;

public class SimpleProduct extends Product {
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
        return "Продукт - " + productName + ", цена - " + productPrice + ".\n";
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
}
