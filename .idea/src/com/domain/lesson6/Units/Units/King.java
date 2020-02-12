package com.domain.lesson6.Units.Units;

public class King extends Unit {



    private King(String name, int speed, int health) {
        super(name, speed);
        this.health = health;
    }

// метод, альтернативный конструктору
    public King(BattleUnit winner){
        super(winner.name, winner.speed);
        this.health = 100;

    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void rest() {
        health +=10;
        System.out.println(name + " отдыхает");
    }
}
