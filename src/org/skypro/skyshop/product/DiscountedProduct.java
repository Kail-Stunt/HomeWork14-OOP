package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discount;

    public DiscountedProduct(String productName, int basePrice, int discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
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
}
