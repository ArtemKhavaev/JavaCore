package com.domain.lesson7.Farm.HomeAnimal;

import com.domain.lesson7.Farm.Animals;

public class HomeAnimal extends Animals {

    private int health;
    private int res;
    private boolean eatable;
    private boolean resable;
    //конструктор
    public HomeAnimal(String name, int weiht, int speed, int health, int res, boolean eatable, boolean resable) {
        super(name, weiht, speed);
        this.health = health;
        this.res = res;
        this.eatable = eatable;
        this.resable = resable;
    }

    public void setHealth(int health) {
        this.health = health ;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

    public void setResable(boolean resable) {
        this.resable = resable;
    }

    public int getHealth() {
        return health;
    }

    public int getRes() {
        return res;
    }

    public boolean isEatable() {
        return eatable;
    }

    public boolean isResable() {
        return resable;
    }

    // дом. животное может убегать
    public void escapeWildAnimal(){
        // if homeAnimal.speed > wildAnimal.speed

    }

    // дом.животные могут пополнять здоровье когда их кормит фермер feedAnimals();
    public static void treat(){



        // +1
        // max <= healh
    }
}
