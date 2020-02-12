package com.domain.lesson6.Units.Units;

abstract public class Unit implements RestAble{
    protected String name;
    protected int health;
    protected int speed;

    public Unit(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int helth) {
        this.health = helth;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void run(){
        System.out.println("юнит перемещается со скоростью " + speed);
    }
}
