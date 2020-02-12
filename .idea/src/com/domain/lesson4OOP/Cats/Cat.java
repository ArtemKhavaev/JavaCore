package com.domain.lesson4OOP.Cats;

public class Cat {
    private String name = "неизвестно";
    private int age = 0;
    private int weight = 0;
    private String color = "неизвестно";
    private String ownerAdress = "неизвестно";

    public Cat(String name) { // конструктор, через который можно задать имя
        this.name = name;
    }

    public Cat(String name, int weight, int age){// конструктор, через который можно задать имя, вес, возраст
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, int age) {// конструктор, через который можно задать имя, возраст
        this.name = name;
        this.age = age;
    }

    public Cat(int weight, String color){// конструктор, через который можно задать вес, цвет
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String ownerAdress){// конструктор, через который можно задать вес, цвет, адрес владельца
        this.weight = weight;
        this.color = color;
        this.ownerAdress = ownerAdress;
    }

    // сеттеры

    public void setName (String name){
        this.name = name;
    }

    public void setAge (int age){
        this.age = age;
    }

    public void setWeight (int weight){
        this.weight = weight;
    }

    public void setColor (String color){
        this.color = color;
    }

    public void setOwnerAdress (String ownerAdress){
        this.ownerAdress = ownerAdress;
    }

    // геттеры

    public String getName (){
        return name;
    }

    public String getAge (){
        if (age == 0) return "неизвестно";
        else return (Integer.toString(age));
    }

    public String getWeight (){
        if (weight == 0) return "неизвестно";
        else return (Integer.toString(weight));
    }

    public String getColor (){
         return color;
    }

    public String getOwnerAdress (){
        return ownerAdress;
    }

    public void printCatInfo(){
        System.out.println("имя: "+getName()+", возраст: "+getAge()+", вес: "+getWeight()+", цвет: "+getColor()+", адрес владельца: "+getOwnerAdress());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
               ", age=" + age +
               ", weight=" + weight +
                ", color='" + color + '\'' +
                ", ownerAdress='" + ownerAdress + '\'' +
                '}';

    }
}
