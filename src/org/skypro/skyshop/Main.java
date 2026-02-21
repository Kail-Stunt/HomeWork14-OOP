package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class Main {
    public static void main(String[] args) {

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

        //Добавим товар в полную корзину
        System.out.println("\nДобавим продукт в полную корзину");
        ProductBasket.productAdd(socks);

        //Найдём в корзине элемент по имени, он есть в корзине
        System.out.println("\nИщем товар, который есть в корзине:");
        ProductBasket.productCheck(grill);

        //Найдём в корзине элемент по имени, его там нет
        System.out.println("\nИщем товар, которого нет в корзине");
        ProductBasket.productCheck(mur);

        //Очистим корзину и выведем после этого содержимое корзины
        System.out.println("\nОчистим корзину, заполнив все элементами пустыми значениями");
        ProductBasket.clearBasket();
        ProductBasket.basketList();

        //Найдём в пустой корзине элемент по имени
        System.out.println("\nИщем товар, который был в корзине, при этом корзина пустая:");
        ProductBasket.productCheck(umbrella);

        //Реализуем поиск по статьям
        System.out.println("\nВводим новый функционал - поиск товара и статеё о товаре:\n");
        SearchEngine searchEngine = new SearchEngine(10);
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

        //Найдём нужную статью
        searchEngine.search("Большой зонт");
        searchEngine.search("Спички");
        searchEngine.search("Носки");
    }
}