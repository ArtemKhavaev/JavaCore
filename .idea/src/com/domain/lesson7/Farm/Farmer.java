package com.domain.lesson7.Farm;


import com.domain.lesson7.Farm.HomeAnimal.*;

public class Farmer implements Owner {
    private String name;
    private  int res;
    private boolean alive;
    private boolean disposs;

    //конструктор

    public Farmer(String name, int res) {
        this.name = name;
        this.res = res;
        this.alive = true;
    }
// геттеры
    public String getName() {
        return name;
    }

    public int getRes() {
        return res;
    }

    public boolean isAlive() {
        return alive;
    }

    //сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // должен тратить ресурсы
    public void lastRes(){
        int a = getRes();
        a -= 3;
        if (a > 0)setRes(a);
        else {
            System.out.println("Ресурсы Фермера закончены");
            setAlive(false);}
       // если ресурсы закончились - конец игры

    }

    // должен уметь собирать ресурсы
    public void takeRes(HomeAnimal homeAnimal){
        setRes(getRes()+homeAnimal.getRes());
        System.out.println("Фермер получил "+homeAnimal.getRes()+ " единиц ресурса от "+ homeAnimal.getName());
    }

    // может съесть животное если ресурсы заканчиваются
    public void eatHomeAnimal(HomeAnimal homeAnimal){
           // 1кг = 1 у.е. ресурса
        setRes(getRes()+homeAnimal.getWeiht());
        System.out.println("Фермер съел "+ homeAnimal.getName()+ " и получил " +homeAnimal.getRes()+ " единиц ресурса");
    }

    // может кормить животных  (животные пополняют здоровье- treat();  )
    public void feedAnimals (HomeAnimal homeAnimal) {
        int temp = homeAnimal.getHealth();
            if ((homeAnimal instanceof Cat) && (temp < 9)) homeAnimal.setHealth(homeAnimal.getHealth() + 1);
            if ((homeAnimal instanceof Caw) && (temp < 20)) homeAnimal.setHealth(homeAnimal.getHealth() + 1);
            if ((homeAnimal instanceof Rabbit) && (temp < 5)) homeAnimal.setHealth(homeAnimal.getHealth() + 1);
            if ((homeAnimal instanceof Chicken) && (temp < 5)) homeAnimal.setHealth(homeAnimal.getHealth() + 1);
            if ((homeAnimal instanceof Dog) && (temp < 10)) homeAnimal.setHealth(homeAnimal.getHealth() + 1);
        }

        // может прогнать дикое животное с фермы //рандомно да/нет
        public boolean dispossWildAnimals(){
            if (((int) (Math.random() * 10) + 1) > 5) disposs = true;
            else disposs = false;
            return disposs;
        }






}
