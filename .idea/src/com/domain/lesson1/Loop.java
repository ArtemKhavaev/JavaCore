package com.domain.lesson1;

import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        // цикл while
        /*
        while (условие ){
            тело цикла;
            if (условие2) break; позволяет выйти из цикла
            if (условие2)continue; позволяет перейти на след.итерацию
        } */
        /*int a= 1 ;
        while (a<=15){
            a+=3;
            System.out.printf("а= %d\n", a);
        }
*/
        // программа загадывает число от 1 до 5
        // пользователь вводит число, программа в зависимости от ввода пользователя выводит следущее:
        // 1. загаданное число меньше
        // 2. загаданное число больше
        // 3. вы угадали
        // 0 -выход из программы

        /*


        int programNum = (int) (Math.random()* ((5-1)+1))+1;
        System.out.printf("программа загадала число %d\n", programNum);

        while (true){
        Scanner in = new Scanner(System.in);
        System.out.println("введите число");
        int UserNum = in.nextInt();
        System.out.printf("вы ввели %d\n", UserNum);

        if (UserNum ==0){
        System.out.println("выход");break;}

        if (programNum>UserNum) System.out.println("введеное число меньше");
        else if (programNum<UserNum) System.out.println("введеное число больше");
        else {System.out.println("вы угадали"); break;}
        }
        */

        //  цикл  do while
        // do {
        //     тело цикла
        //     } while (условие);


        //цикл for

        int n = 5;
        int res = 1;
        for (int i = 1; i < n; i++) {   // fori
            res *= i;
        }
        System.out.println(res);

// ДОМА!!!! наибольший общий делитель двух чисел

// LoopName:
//        while (условие ){
//            while (условие ){
  //          break LoopName; }
//        }



    }
}
