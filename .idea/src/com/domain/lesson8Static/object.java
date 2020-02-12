package com.domain.lesson8Static;


public class object {
    public static void main(String[] args) throws CloneNotSupportedException {
        // родительский класс для всех классов
        // toString ();возвращает строчку, описывающую объект
        // hashCode (); возвращает хэш код объекта
        // equals()проверяет на соответствие
        // clone(); для создания копии объектов
        //Object obj = new Object();

        Owner owner1 = new Owner("Tom", "+79999999999");
        Owner owner2 = new Owner("Mike", "+7888888888");
        Owner owner3 = new Owner("Tom", "+79999999999");

        Car opel = new Car( "opel", "yellow", owner1);
        System.out.println(opel.toString());

        Car mazda = new Car ("mazda", "red", owner2);

        Car opel2 = new Car("opel", "yellow", owner3);

        System.out.println(opel.hashCode());
        System.out.println(opel2.hashCode());
        System.out.println(mazda.hashCode());

        System.out.println(opel.equals(opel2));// тру -только если ссылки будут на один объект //если переопределить euals и hashCode тогда будут сравниваться свойства объектов, а не ссылки и на выходе будет тру
        // clone();

        Object newCar = opel.clone();// для использования clone(); нужно в соотв. классе имплементировать интерфейс Cloneable и переопределить метод clone()


    }
}
