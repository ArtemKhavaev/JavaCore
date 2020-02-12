package com.domain.lesson4OOP.Cats;

public class Main {
    public static void main(String[] args) {
        //создание объектов
        Cat barsik = new Cat ("Барсик");
        Cat murzik = new Cat ("Мурзик", 2, 3);
        Cat muska = new Cat ("Муська", 5);
        Cat noName = new Cat (1, "черный");
        Cat fatest = new Cat (15, "рыжий", "наб. Кутузова, д.9");

        // вывод информации о коте (1-й способ):
        barsik.printCatInfo();
        murzik.printCatInfo();
        muska.printCatInfo();
        noName.printCatInfo();
        fatest.printCatInfo();
        // вывод информации о коте (2-й способ):
        System.out.println(barsik.toString());
        System.out.println(murzik.toString());
        System.out.println(muska.toString());
        System.out.println(noName.toString());
        System.out.println(fatest.toString());

    }
}
