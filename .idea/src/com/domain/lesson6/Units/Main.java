package com.domain.lesson6.Units;

import com.domain.lesson6.Units.Units.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // пользовательский ввод
        Scanner in = new Scanner(System.in);
        System.out.println("укажите тип персонажа");
        String userChoice = in.nextLine();

        // создаем объект персонажа  в зависимости от выбранного типа
        BattleUnit userBattleUnit = BattleUnit.Spaun(userChoice);
        System.out.println("ваш выбор: " + userBattleUnit);

        // реализуем метод rest() персонажа
        userBattleUnit.rest();

        // создаем противника
        BattleUnit enemyChoice = new Knight("Рыцарь противника #"+ (int)((Math.random() * 10 )+1), (int)((Math.random() * 5 )+1), (int)((Math.random() * 10 )+11), (int)((Math.random() * 10 )+11));

        // реализуем метод rest() противника
        enemyChoice.rest();

        // реализуем метод attack() персонажа
        userBattleUnit.attack(enemyChoice);

        // победивший юнит становится королем (на основе большего значения параметра "health"):
        King newKing;
        if (userBattleUnit.getHealth() > enemyChoice.getHealth()) {
            newKing = new King(userBattleUnit);
        }else {
            newKing = new King(enemyChoice);
        }
        System.out.println("королем  стал :" + newKing);

    }
}
