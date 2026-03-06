package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
