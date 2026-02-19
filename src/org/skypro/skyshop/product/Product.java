package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

    final String productName;

    public Product(String productName) {
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
