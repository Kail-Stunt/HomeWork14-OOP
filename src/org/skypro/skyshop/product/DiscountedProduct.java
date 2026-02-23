package org.skypro.skyshop.product;

import java.util.InputMismatchException;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) throws InputMismatchException {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
        try {
            if (basePrice <= 0) {
                System.out.println("\nЦена товара должна быть больше нуля!");
            }
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
        try {
            if (discount < 0 || discount > 100) {
                System.out.println("Скидка на товар должна быть больше нуля и меньше 100!");
            }
        } catch (InputMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getProductPrice() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "Продукт (есть скидка) - " + productName + ", цена со скидкой - " + getProductPrice() + " (скидка " + discount + " %).\n";
    }

    @Override
    public String searchTerm() {

        return null;
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
