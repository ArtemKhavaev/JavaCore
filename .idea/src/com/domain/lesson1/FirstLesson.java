package com.domain.lesson1;

import javax.swing.event.TreeExpansionEvent;
import java.util.Scanner;

public class FirstLesson {
    //однострочный комментарий Ctrl+/
   /* многострочный
            коментарий ctrl+shift+/   */
    public static void main(String[] args) {    // psvm
        // объявление переменных
        // тип Данных  имя Переменной;

        //ссылочные типы данных

        //примитивные типы данных
        //объявление пременной типа byte
        byte byteVar = 12;
        //  объявление short
        short shortVar = 19;
        short shortVar1 = 16;
        //short shortRes=shortVar+shortVar1; ошибка тк в арифм операциях вычисления выполняются как int
        // объявление int
        int intVar = 7;
        int intVar1 = 2;
        int intRes = intVar / intVar1; // дробная часть отбрасывается

        int intVar7 = 1_000_000;
        // int zeroDiv=intVar/0;  Arifmetic Exeption


        long longVar = 30000000000L; //чтобы не воспринимать как int

        //числа с плавающей точкой
        float floatVar = 3.6f;

        double doubleVar = 5.7;
        double zeroDivDouble = doubleVar / 0; // Infinity


        //char хранит символы  UTF-16 номера символов в диапазоне 0  65536

        //boolean   true/false
        boolean closed = true;
        boolean isActive = false;


        //приведение типов
        // автоматическое преобразование
        byte byteVar3 = 3;
        int intVar3 = byteVar3;
        // явное приведение типов
        intVar3 = 43;
        byteVar3 = (byte) intVar3;

        //операторы
        // присваивание =  +=  -=  *=  /=  %=
        // арифметические операторы +  -  *  /   %
        //    7 % 2; остаток =1

        //инкремент (увеличивает на 1)   i++     ++i

        //дикремент (уменьшает на 1)    i--    --i

        // операторы сравнения  >   <  >=  <=  !=  == результат  true / false


        // консольный вывод   //sout

        System.out.println("выводимая информация");//sout
        System.out.printf("выводимая информация %s\n", "данных");  //souf
        // %f вывод чисел  плавающей точкой
        // %d вывод целых чисел
        // %s вывод строк

        // консольный ввод
        Scanner in = new Scanner(System.in); //alt+Enter -> Import Class
        System.out.println("введите число");
        int num = in.nextInt();
        System.out.printf("вы ввели %d\n", num);

        // логические операторы (boolean)
        //  && И
        //  ||  ИЛИ
        // !   НЕ
        // ^ исключающее ИЛИ


        // побитовые операторы
        // логическое умножение
        int k= 2;// 010
        int j=4; // 100
        System.out.printf("результат  k * J  =%d\n", k & j); //000 -> 0

         k= 4;// 100
         j=5; // 101
        System.out.printf("результат  k * J  =%d\n", k & j); //100 -> 4

        /* логическое сложение */
        k= 2;// 010
        j= 4; // 100
        System.out.printf("результат  k | J  =%d\n", k & j); //110 -> 6

        // побитовое НЕ -унарный опрератор, инвертирует  биты операнда

        // операция сдвига
        // a<<b сдвигает часло а влево на  b разрядов
        // a<<1 эквивалентно умножению на 2
        System.out.printf("сдвиг влево 5 << 1 = %d \n" , 5<<1); // 101 на 1 разряд  -> 1010 ->10

        // a>>b сдвигает часло а вправо на  b разрядов
        // a>>1 эквивалентно делению на 2
        System.out.printf("сдвиг влево 4 >> 1 = %d \n" , 4>>1); // 100 на 1 разряд  -> 10 ->2

        // четность числа n & 1 если число четное, результат 0 иначе 1


        // НАЛОЖЕНИЕ МАСОК - ПОЧИТАТЬ!!!!!!!!!!



        //тернарные оператор ?
        //  переменная у = (условие) ? выражение1 : выражение 2; // если условие верно выполн. выражение 1 иначе выр 2
        int x = 3;
        int y = 2;
        int res = (x > y || x > 0) ? x - y : x + y;

        //конструкции ветвления
        int someCode = 345;
        // if (условие){
        // код выполнится если условие true

    // код если условие false

    // if (условие){
    // код выполнится если условие true
    //  }
    // else{
    // код если условие false
    //      }


    // if (условие){
    // код выполнится если условие true
    //  }
    // else if (условие 2{
    // код если условие1 false и условие 2 true
    //      }



    System.out.println("введите число");

    switch (in.nextInt()){

        case 1:
            System.out.println("вариант 1");
            break;

        case 2:
            System.out.println("вариант 2");
            break;
        case 3:
        case 4:
            System.out.println("вариант 3,4");
            break;
         default:
             System.out.println("вариант не определен");
             break;
    };


/* JAVA 13
    switch  (x) {
        case 1 -> System.out.println("аааа");
        case 2 -> System.out.println("аааа");
        case 3 -> System.out.println("аааа");
        default: System.out.println("олаооа" );
    }
*/
/* JAVA 12
    code  = 15

    String CodeRes = switch  (code) {
        case 1 -> System.out.println("аааа");
        case 2 -> System.out.println("аааа");
        case 3 -> System.out.println("аааа");
        default: System.out.println("олаооа" );
    }
*/





//даны три числа , целые не равны вывести наибольшее

int a=1;
int b=2;
int c=3;
        System.out.println("наибольшее число:");
if (a>b && a>c ){
            System.out.println(a);
        }
 if (b>a && b>c ){
            System.out.println(b);
        }
 else{
            System.out.println(c);
        }




        }}