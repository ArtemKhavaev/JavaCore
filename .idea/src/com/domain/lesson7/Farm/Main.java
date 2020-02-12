package com.domain.lesson7.Farm;

import com.domain.lesson7.Farm.HomeAnimal.*;
import com.domain.lesson7.Farm.WildAnimal.Bear;
import com.domain.lesson7.Farm.WildAnimal.Fox;
import com.domain.lesson7.Farm.WildAnimal.WildAnimal;
import com.domain.lesson7.Farm.WildAnimal.Wolf;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        // создание дом. животных
        HomeAnimal[] farm = new HomeAnimal[10];

        for (int i = 0; i < 10; i++) {
            int animalType = (int)(Math.random() * 5 )+1;

            switch (animalType) {
                case 1: {
                    HomeAnimal newCat = new Cat(("кот №" + i), 3, 3, 9, 0, false, false);
                    farm[i] = newCat;
                    break;
                }
                case 2: {
                    HomeAnimal newCaw = new Caw(("корова №" + i), 100, 1, 20, 2, true, true);
                    farm[i] = newCaw;
                    break;
                }
                case 3: {
                    HomeAnimal newChicken = new Chicken(("курица №" + i), 2, 2, 5, 1, true, true);
                    farm[i] = newChicken;
                    break;
                }
                case 4: {
                    HomeAnimal newRabbit = new Rabbit(("кролик №" + i), 5, 5, 5, 0, true, false);
                    farm[i] = newRabbit;
                    break;
                }
                case 5: {
                    HomeAnimal newDog = new Dog(("пес №" + i), 10, 4, 10, 0, false, false);
                    farm[i] = newDog;
                    break;
                }
            }
        }



        // создание массива диких. животных
        WildAnimal[] wild = new WildAnimal[3];

        for (int i = 0; i < 3; i++) {
            int animalType = (int)(Math.random() * 5 )+1;

            switch (animalType) {
                case 1:
                case 2: {
                    WildAnimal fox = new Fox(("лис №" + i), 3, 4, 20, false);
                    wild[i] = fox;
                    break;
                }
                case 3:
                case 4: {
                    WildAnimal wolf = new Wolf(("волк №" + i), 10, 5, 20, false);
                    wild[i] = wolf;
                    break;
                }
                case 5: {
                    WildAnimal bear = new Bear(("медведь №" + i), 100, 3, 100, false);
                    wild[i] = bear;
                    break;
                }
                }
            }


// создаем фермера
       Farmer farmer = new Farmer("фермер", 10 );



        Scanner in = new Scanner(System.in);
        System.out.println("задайте количество дней на ферме: ");
        int days = in.nextInt();
        int i = 0;

        // день на ферме

        while ((i < days)&&(farmer.isAlive() == true)&&(farmer.getRes() > 0)) {
            System.out.println();
            System.out.println((i+1) +"-й день наступил");
            farmer.lastRes();// -фермер тратит ресурсы если ресурсы кончились-конец игры

            // выбор рандомного дикого животного

            int animalType =((int)(Math.random() * 10 )+1) ;
            if (animalType <= 3) wild[0].setActive(true);
            else if (animalType <= 6)wild[1].setActive(true);
            else wild[2].setActive(true);

            for (int j = 0; j < 3; j++) {
                if (wild[j].isActive() == true){
                    System.out.println(wild[j].getName() + "забежал на ферму");// -на ферму приходит рандомное дикое животное
                    if(farmer.dispossWildAnimals () == true){// фермер может его прогнать   (рандомно да/нет)
                        System.out.println("но фермер его прогнал!");
                        wild[j].setActive(false);
                        break;
                    }else {
                        animalType =((int)(Math.random() * 5 )+1) ;// -если фермер не прогнал выбирается рандомное домашнее животное
                        if ( farm [animalType] != null) System.out.println("и решил напасть на " + farm [animalType].getName());
                        // -дикое животное пытается догнать  домашнее catchHomeAnimal ();
                        if ((wild [j].catchHomeAnimal(farm [animalType].getSpeed()) == true)&&(farm [animalType] != null)) { // если догоняет
                            if ((wild [j].huntHomeAnimal (farm [animalType].getHealth()) == true)&&(farm [animalType] != null)){

                                System.out.println("в схватке " +farm [animalType].getName() + " был убит и сЪеден" );
                                farm [animalType] = null;// если strength > health съел, объект уничтожается
                            }else {
                                farm [animalType].setHealth(farm [animalType].getHealth()-wild[j].getStrength());// если strength < health ранил
                                System.out.println("в схватке " +farm [animalType].getName() + " был ранен" );
                            }
                        } else System.out.println("но " + farm [animalType].getName() + " убежал!");
                    }
                }
            }// может атаковать не более трех раз

            // -фермер кормит животных feedAnimals ();
            System.out.println("Фермер покормил животных");
            for (int j = 0; j < 10; j++) {
                if (farm [j] != null) farmer.feedAnimals(farm[j]);
            }

            //  -фермер собирает ресурсы takeRes();
            int willEat = 0;
            for (int j = 0; j < 10; j++) {
                if ((farm [j] != null) && (farm[j].isResable() == true)) farmer.takeRes(farm[j]);
                else willEat ++;
            }

            if (willEat == 10) { // -если ресурсов для сбора нет -начинает есть животных eatHomeAnimal();
                for (int j = 0; j < 10; j++) {
                    if ((farm[j] != null) && (farm[j].isEatable() == true)) farmer.eatHomeAnimal(farm[j]);
                    farm [j] = null;
                }
            }

              // вывод в консоль: количество животных по типам, количество ресурсов у фермера
            System.out.println("ИТОГИ ДНЯ:");
            System.out.println("Животные на ферме:");
            for (int j = 0; j < 10; j++) {
                if (farm [j] != null) System.out.println(farm[j].getName());
            }
            System.out.println("Ресурсы фермера: "+farmer.getRes());
            i ++;

        }


    }
}
