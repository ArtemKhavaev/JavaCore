package com.domain.lesson6.Units.Units;

public class Warrior extends BattleUnit{
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit enemy) {
        System.out.println("Воин атаковал " +  enemy.getName());
        enemy.health -= this.attackScore;

    }

    @Override
    public void rest() {
        health +=5;
        System.out.println(name + " отдыхает");
    }
}
