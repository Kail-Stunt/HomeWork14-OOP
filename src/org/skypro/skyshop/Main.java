package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        //Создадим несколько специальных товаров вводим константу
        DiscountedProduct gumpUmbrella = new DiscountedProduct("Большой зонт", 1500, 15);
        DiscountedProduct grill = new DiscountedProduct("Гриль", 4500, 25);
        FixPriceProduct matches = new FixPriceProduct("Спички");
        SimpleProduct umbrella = new SimpleProduct("Зонт", 1500);
        SimpleProduct socks = new SimpleProduct("Носки", 500);
        SimpleProduct mur = new SimpleProduct("Неизвестен", 2000);


        //Добавим продукты в корзину
        ProductBasket.productAdd(gumpUmbrella);
        ProductBasket.productAdd(grill);
        ProductBasket.productAdd(matches);
        ProductBasket.productAdd(umbrella);
        ProductBasket.productAdd(socks);

        //Выведем содержимое корзины
        ProductBasket.basketList();

        //Найдём в корзине элемент по имени, он есть в корзине
        System.out.println("\nИщем товар, который есть в корзине:");
        ProductBasket.productCheck(grill);

        //Найдём в корзине элемент по имени, его там нет
        System.out.println("\nИщем товар, которого нет в корзине");
        ProductBasket.productCheck(mur);

        //Найдём в пустой корзине элемент по имени
//        System.out.println("\nИщем товар, который был в корзине, при этом корзина пустая:");
//        ProductBasket.clearBasket();
//        ProductBasket.productCheck(umbrella);

        //Реализуем поиск по статьям
        System.out.println("\nВводим новый функционал - поиск товара и статей о товаре:\n");
        SearchEngine searchEngine = getSearchEngine();

        //Найдём нужную статью
        searchEngine.search("Большой зонт");
        searchEngine.search("Спички");
        searchEngine.search("Носки");

//        Для удобства скроем под комменты работу с исключениями
//        Обработка исключений
//        System.out.println("\nРаботаем с исключениями:");
//        System.out.println("\nДобавим пустой товар");
//        try {
//            SimpleProduct nullNameProduct = new SimpleProduct(null, 0);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nДобавим товар с нулевой ценой");
//        try {
//            SimpleProduct nullPriceProduct = new SimpleProduct("Мышь", 0);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\n\nДобавим пустой товар по скидке с нулевой ценой и отрицательной скидкой:");
//        try {
//            DiscountedProduct nullDiscountedProduct = new DiscountedProduct(null, 0, -10);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nДобавим товар по скидке с нулевой ценой и отрицательной скидкой:");
//        try {
//            DiscountedProduct nullDiscountedProduct = new DiscountedProduct("Маяк", 0, -10);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nДобавим товар по скидке с отрицательной скидкой:");
//        try {
//            DiscountedProduct nullDiscountedProduct = new DiscountedProduct("Маяк", 1000, -10);
//        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nНайдём элемент \"зонт\" в массиве товаров");
//        try {
//            searchEngine.mostSuitable("зонт");
//        } catch (BestResultNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("\nНайдём элемент \"мумука\" в массиве товаров");
//        try {
//            searchEngine.mostSuitable("мумука");
//        } catch (BestResultNotFoundException e) {
//            e.printStackTrace();
//        }

        //Добавим товар в полную корзину
        System.out.println("\nДобавим продукт в полную корзину. Добавим носки и гриль:");
        ProductBasket.productAdd(socks);
        ProductBasket.productAdd(grill);
        ProductBasket.basketList();

        //Удалим товары из корзины по имени
        System.out.println("\nУдалим товары из корзины по имени, при условии что товар в корзине есть (удалим зонт, носки):");
        ProductBasket.removeProduct(umbrella.getProductName());
        ProductBasket.removeProduct(socks.getProductName());
        //ProductBasket.basketList();
        System.out.println("\nВыведем корзину, из которой удалили товары:");
        ProductBasket.basketList();
        System.out.println("\nУдалим товары из корзины по имени, при условии что товара в корзине нет (удалим Неизвестен):");
        ProductBasket.removeProduct(mur.getProductName());

    }

    private static SearchEngine getSearchEngine() {
        SearchEngine searchEngine = new SearchEngine();
        Article gumpArticle = new Article("Большой зонт", "Большой, закрывающий не только голову, но и плечи зонт.");
        Article grillArticle = new Article("Гриль", "Спициальное устройство для приготовления продуктов на углях или на огне.");
        Article matchesArticle = new Article("Спички", "Спички детям не игрушка!");
        Article umbrellaArticle = new Article("Зонт", "Просто зонт.");
        Article socksArticle = new Article("Носки", "Носки незаменимый атрибут современного мужчины.");
        Article murArticle = new Article("Неизвестен", "Проверить же надо!");
        searchEngine.add(gumpArticle);
        searchEngine.add(grillArticle);
        searchEngine.add(matchesArticle);
        searchEngine.add(umbrellaArticle);
        searchEngine.add(socksArticle);
        searchEngine.add(murArticle);
        searchEngine.add(gumpArticle);
        searchEngine.add(grillArticle);
        searchEngine.add(matchesArticle);
        searchEngine.add(gumpArticle);
        return searchEngine;
    }
}