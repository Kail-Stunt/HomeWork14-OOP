package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;

import java.util.List;

//Создадим класс ProductBasket
public class ProductBasket {
    private static List<Product> basket = new ArrayList<Product>(5);


    //Реализуем метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public static void productAdd(Product product) {
        if (basket.size() < 5) {
            basket.add(product);
        } else {
            System.out.println("Корзина заполнена!");
        }
    }

    //Реализуем метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public static int basketPrice() {
        int basketPrice = 0;
        for (Product product : basket) {
            int productPrice = product.getProductPrice();
            basketPrice += productPrice;
        }
        return basketPrice;
    }

    //Выведем содержимое корзины и её полную стоимость
    public static void basketList() {
        System.out.println("Содержимое корзины:");
        if (basket != null) {
            System.out.print(basket);
            System.out.println("Итого: " + basketPrice());
            System.out.println("Специальных товаров в корзине: " + findSpecial());
        } else {
            System.out.println("В корзине пусто!");
        }
    }

    //Проверим продукт по имени
    public static boolean productCheck(Product product) {
        boolean isInBasket = false;
        for (int i = 0; i < basket.size(); i++) {
            if (product.getProductName() == basket.get(i).getProductName()) {
                isInBasket = true;
            }
        }
        System.out.println("Продукт " + product.getProductName() + " в корзине? " + isInBasket);
        return isInBasket;
    }

    //Очистим корзину
    public static void clearBasket() {
        Product product = new SimpleProduct(null, 0);
        for (int i = 0; i < basket.size(); i++) {
            basket.set(i, product);
        }
    }

    //Находим количество специальных товаров
    public static int findSpecial() {
        int special = 0;
        for (Product product : basket) {
            if (product.isSpecial()) {
                special += 1;
            }
        }
        return special;
    }

}
