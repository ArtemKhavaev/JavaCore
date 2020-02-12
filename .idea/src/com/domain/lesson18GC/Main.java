package com.domain.lesson18GC;

import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
        //Stack память работает по принципопу LIFO первый зашел последний вышел
        // в стеке только локальные примитивы и ссылки
        // объекты и статика хранятся в др. обл. памяти
        // у каждого потока свой стек

        int age = 2;
        String name = "Dog";
        Dog dog = new Dog(name, age);
        System.out.println(dog.getAge());
        /*


            this.name = name;
        setName()
        блок для конструктора
            ссылка на name(сама строка создается в пуле строк)
            int age = 2;
        блок для метода main
         */

    }
}

class Dog {
    private String name;
    private int age;
    private LocalDateTime created;

    public Dog(String name, int age) {
        setName(name);
        this.age = age;
        created = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
