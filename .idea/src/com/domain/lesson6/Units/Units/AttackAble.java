package com.domain.lesson6.Units.Units;

public interface AttackAble {
    void attack(Unit enemy);

    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }

}
