package com.domain.lesson7.Farm;

abstract public class Animals {
    private String name;
    private int weiht;
    private int speed;

    //конструктор

    public Animals(String name, int weiht, int speed) {
        this.name = name;
        this.weiht = weiht;
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeiht(int weiht) {
        this.weiht = weiht;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getWeiht() {
        return weiht;
    }

    public int getSpeed() {
        return speed;
    }
}
