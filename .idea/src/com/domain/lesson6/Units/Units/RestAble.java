package com.domain.lesson6.Units.Units;

public interface RestAble {
    void rest();

    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }
}

