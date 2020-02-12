package com.domain.lesson6.Units.Units;

abstract public class BattleUnit extends Unit implements AttackAble {

    protected int attackScore;

    public static BattleUnit Spaun (String unitType){
        BattleUnit battleUnit = null;


        if ("warrior".equals(unitType)){
            battleUnit = new Warrior("Воин #" +  (int)((Math.random() * 10 )+1), (int)((Math.random() * 5 )+1),  (int)((Math.random() * 10 )+11), (int)((Math.random() * 10 )+11));
        } else if ("knight".equals(unitType)){
            battleUnit = new Knight("Рыцарь #" +  (int)((Math.random() * 10 )+1), (int)((Math.random() * 5 )+1),  (int)((Math.random() * 10 )+11), (int)((Math.random() * 10 )+11));
        } else if ("doctor".equals(unitType)){
            battleUnit = new Doctor("Доктор #" +  (int)((Math.random() * 10 )+1), (int)((Math.random() * 5 )+1),  (int)((Math.random() * 10 )+11), (int)((Math.random() * 10 )+11));
        } else { System.out.println("введите правильный тип юнита (warrior knight doctor)"); }
            return battleUnit;
    }

    public BattleUnit(String name, int speed, int health, int attackScore) {
        super(name, speed); // вызов конструктора родительского класса
        this.health = health;
        this.attackScore = attackScore;
    }

    @Override
    public String toString() {
        return "BattleUnit{" +
                " name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                ", attackScore=" + attackScore +
                '}';
    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит " + this.name + "сбежал с поля боя");
    }




}
