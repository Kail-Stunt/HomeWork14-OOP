package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

//Создадим класс ProductBasket
public class ProductBasket {
    private static final List<Product> basket = new ArrayList<Product>(5);


    //Реализуем метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public static void productAdd(Product product) {
        basket.add(product);
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
        for (Product item : basket) {
            System.out.print(item);
        }
        if (!basket.isEmpty()) {
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
        basket.clear();
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

    //Удаляем из корзины указанный товар и возвращаем список удалённых продуктов
    public static List<Product> removeProduct(String productName) {
        List<Product> removeProductsList = new ArrayList<Product>();
        for (Product product : basket) {
            if (Objects.equals(product.getProductName(), productName)) {
                removeProductsList.add(product);
            }
        }
        //IDE предложила заменить код и итератором на данный оператор! Я с ней согласен:-)
        basket.removeIf(removeProductsList::contains);

        if (removeProductsList.isEmpty()) {
            System.out.println("Список пуст:\n" + removeProductsList);
        } else {
            System.out.println("Список удалённых продуктов:" + removeProductsList);
        }
        return removeProductsList;
    }
}

