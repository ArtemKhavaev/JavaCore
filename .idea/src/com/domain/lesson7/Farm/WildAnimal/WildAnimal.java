package com.domain.lesson7.Farm.WildAnimal;

import com.domain.lesson7.Farm.Animals;

public class WildAnimal extends Animals {

    private int strength;
    private boolean active;
    protected boolean catchAnimal;
    protected boolean eatAnimal;


    //конструктор
    public WildAnimal(String name, int weiht, int speed, int strength, boolean active) {
        super(name, weiht, speed);
        this.strength = strength;
        this.active = false;

    }



    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStrength() {
        return strength;
    }

    public boolean isActive() {
        return active;
    }
    // дикое животное может догонять домашнее животное

    public boolean catchHomeAnimal (int homeAnimalSpeed){
        if (homeAnimalSpeed < getSpeed()) catchAnimal = true;
        return catchAnimal;
        // if homeAnimal.speed < wildAnimal.speed
    }

    // дикое животное может съесть или ранить домашнее животное
    public boolean huntHomeAnimal (int homeAnimalHealth){
        if (homeAnimalHealth < getStrength()) eatAnimal = true;
        else  eatAnimal = false;
        return eatAnimal;

    }
}
