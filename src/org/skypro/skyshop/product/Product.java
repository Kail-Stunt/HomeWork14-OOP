package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    final String productName;

    public Product(String productName) throws IllegalArgumentException {
        if ((productName == null) || productName.isBlank()) {
                throw new IllegalArgumentException("Название товара не может быть пустым!");
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
        return "Product: " + "productName - " + productName + " productPrice - ";
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
