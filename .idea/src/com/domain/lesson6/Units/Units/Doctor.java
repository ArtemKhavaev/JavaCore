package com.domain.lesson6.Units.Units;

public class Doctor extends BattleUnit {
    public Doctor(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit friend) {
        System.out.println("Доктор вылечил " +  friend.getName());
        friend.health += this.attackScore;
    }

    @Override
    public void rest() {
        System.out.println(name + " отдыхает");
        health += 10;
    }
}
