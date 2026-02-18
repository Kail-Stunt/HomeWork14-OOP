package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class Main {
    public static void main(String[] args) {

        //Создадим несколько специальных товаров вводим константу
        DiscountedProduct gump = new DiscountedProduct("Большой зонт", 1500, 15);
        DiscountedProduct grill = new DiscountedProduct("Гриль", 4500, 25);
        FixPriceProduct matches = new FixPriceProduct("Спички");
        SimpleProduct umbrella = new SimpleProduct("Зонт", 1500);
        SimpleProduct socks = new SimpleProduct("Носки", 500);
        SimpleProduct mur = new SimpleProduct("Неизвестен", 2000);

        //Добавим продукты в корзину
        ProductBasket.productAdd(gump);
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
    }
}