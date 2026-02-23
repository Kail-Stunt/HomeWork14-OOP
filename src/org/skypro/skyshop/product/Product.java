package org.skypro.skyshop.product;

import java.util.InputMismatchException;

public abstract class Product implements Searchable {

    final String productName;

    public Product(String productName) throws InputMismatchException {
        if ((productName == null) || productName.isBlank()) {
            try {
                System.out.println("\nИмя не может быть пустым!");
            } catch (InputMismatchException e) {
                throw new RuntimeException(e);
            }
        }
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    public abstract boolean isSpecial();


    @Override
    public String toString() {
        return "Product: " + "productName - " + productName + " productPrice - \"\n";
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    @Override
    public String contentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        Searchable.super.getStringRepresentation();
        return null;
    }
}
