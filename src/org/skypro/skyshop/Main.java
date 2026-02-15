package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {
    public static void main(String[] args) {

        //Создадим продукты
        Product umbrella = new Product("Зонт", 1500);
        Product tshirt = new Product("Футболка", 1500);
        Product trousers = new Product("Брюки", 2500);
        Product socks = new Product("Носки", 500);
        Product tie = new Product("Галстук", 700);
        Product mur = new Product("Неизвестен", 2000);

        //Добавим продукты в корзину
        ProductBasket.productAdd(umbrella);
        ProductBasket.productAdd(tshirt);
        ProductBasket.productAdd(trousers);
        ProductBasket.productAdd(tie);
        ProductBasket.productAdd(socks);

        //Выведем содержимое корзины
        ProductBasket.basketList();


        //Добавим товар в полную корзину
        System.out.println("\nДобавим продукт в полную корзину");
        ProductBasket.productAdd(socks);

        //Найдём в корзине элемент по имени, он есть в корзине
        System.out.println("\nИщем товар, который есть в корзине:");
        ProductBasket.productCheck(umbrella);

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
    }
}