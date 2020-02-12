package com.domain.lesson6.Units.Units;

public class Knight extends BattleUnit {
    public Knight(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit enemy) {
        System.out.println("Рыцарь атаковал " +  enemy.getName());
        enemy.health -= this.attackScore;
    }

    @Override
    public void rest() {
        health +=7;
        System.out.println(name + " отдыхает");
    }
}
