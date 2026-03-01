package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

//Создадим класс ProductBasket
public class ProductBasket {
    private static final Map<String, LinkedList<Product>> basket = new LinkedHashMap<>();

    //Реализуем метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public static void productAdd(Product product) {
        basket.computeIfAbsent(product.getProductName(), k -> new LinkedList<Product>()).add(product);
    }

    //Реализуем метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public static int basketPrice() {
        int basketPrice = 0;
        for (Map.Entry<String, LinkedList<Product>> products : basket.entrySet()) {
            for (Product p : basket.get(products.getKey())) {
                int productPrice = products.getValue().element().getProductPrice();
                basketPrice += productPrice;
            }
        }
        return basketPrice;
    }

    //Выведем содержимое корзины и её полную стоимость
    public static void basketList() {
        System.out.println("Содержимое корзины:\n");
        basket.forEach((key, value) -> System.out.println(key + " : " + value));
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
        for (Map.Entry<String, LinkedList<Product>> products : basket.entrySet()) {
            if (product.getProductName().equals(products.getValue().element().getProductName())) {
                isInBasket = true;
            }
            if (isInBasket) {
                break;
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
        for (Map.Entry<String, LinkedList<Product>> products : basket.entrySet()) {
            for (Product p : basket.get(products.getKey())) {
                if (p.isSpecial()) {
                    ++special;
                }
            }
        }
        return special;
    }

    //Удаляем из корзины указанный товар и возвращаем список удалённых продуктов
    public static ArrayList<String> removeProduct(String productName) {
        ArrayList<String> removeProductsList = new ArrayList<>();
        removeProductsList.add(productName);
        basket.keySet().removeIf(productName::equals);

        if (removeProductsList.isEmpty()) {
            System.out.println("Список пуст:\n" + removeProductsList);
        } else {
            System.out.println("Список удалённых продуктов:" + removeProductsList);
        }
        return removeProductsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return super.equals(product);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}


