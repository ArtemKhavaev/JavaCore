package com.domain.lesson10Generics;

public class Primitive {
    public static void main(String[] args) {

        // классы обертки хранят значения соответсвующего примитива
        // int -> Integer

        int a = 56;
        Integer integer  = a;
        int b = integer;


        Double d = 3.78;
        Boolean boo = Boolean.FALSE; // =false;

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Byte.parseByte("2")); // возвращает примитив
        System.out.println(Byte.valueOf("2")); // возвращает объект

        System.out.println(Integer.parseInt("56")); // возвращает примитив
        System.out.println(Integer.valueOf("56")); // возвращает объект

        // NumberFormatExeption System.out.println(Integer.valueOf("56dhgfvhjrj"));


        // сравнение примитивов осуществляется в пределах значений -128 .. 127
        Integer integer1 = 3;
        Integer integer2 = 3;
        if (integer1 == integer2) System.out.println("=="); // =
        // если значение выходит за диапазон производится сравнение ссылок объектов
        Integer integer3 = 500;
        Integer integer4 = 500;

        if (integer3 == integer4) System.out.println("=="); // !=

        // правильно сравнивать через equals
        integer3.equals(integer4);

        // др. метод сравнения
        System.out.println(integer.compare(integer1, integer2));// -1  0  1
        System.out.println(integer.min(integer1, integer2));// min int
        System.out.println(integer.max(integer1, integer2));// max int

        // вернуть значение примитива
        integer1.doubleValue();
        integer1.longValue();

        // ДОМА посмотреть др. методы

        System.out.println(integer.sum(integer1, integer2));// sum int
        System.out.println(integer.hashCode(integer1));//hash Code  для int -это значение int


    }
}
