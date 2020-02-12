package com.domain.lesson2Array;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {

    // 1. ВЫЧИСЛЕНИЕ НОД ДВУХ ЧИСЕЛ
    public static void NOD (){
        System.out.println("1. Вычисление НОД двух чисел");
        //пользовательский ввод
        System.out.println("введите первое число");
        Scanner in = new Scanner(System.in);
        int FstNum = in.nextInt();
        System.out.println("введите второе число");
        int SecNum = in.nextInt();
        // берем абсолютное значение, чтоб исключить ошибку для отрицательных чисел
        FstNum = (Math.abs(FstNum));
        SecNum = (Math.abs(SecNum));

        int min = 0, max = 0;
        // находим наименьшее число
        if (FstNum > SecNum) {
            min = SecNum;
            max = FstNum;
        } else if (SecNum > FstNum) {
            min = FstNum;
            max = SecNum;
        } else System.out.printf("НОД: %d\n", SecNum);// если числа равны,  НОД соотв. числу

        for (int i = min; i > 0 ; i--) { //в цикле проверяем как числа от большего к меньшему делятся без остатка
            if (((min % i) == 0) && (max % i == 0)) {
                System.out.printf("НОД: %d\n", i);
                break;
            }
        }
    }



    //2.1 ПЕРЕВОД ДЕСЯТИЧНОГО ЧИСЛА В ДВОИЧНОЕ
    public static void DecToBin1 (){//метод выводит в консоль массив, элементы которого- разряды двоичного числа
        System.out.println("2.2 Перевод десятичного числа в двоичную систему счисления");

        // пользовательский ввод
        System.out.println("введите число");
        Scanner in = new Scanner(System.in);
        int DecNum;
        DecNum = in.nextInt();

        // объявление массивов и переенных
        int [] BinNum = new int[100];// 100- максимальное количество разрядов двоичного числа
        int [] BinNumFinal = new int[100];
        int ost, i;

        // последовательное деление десятичного числа с целью получения разрядов двоичного и запись их в массив
        for ( i = 0; DecNum >= 2 ; i++) {
            ost = DecNum%2;
            BinNum[i] = ost;
            DecNum /= 2;
        }
        // запись последнего разряда в конец массива
        BinNum[i] = DecNum ;

        // инвертирование массива для корректного отображения двоичного числа
        int k=i;
        for (int j = 0; j <= k ; j++) {
            BinNumFinal[j] = BinNum[i];// двоичное число хранится в массиве, где эл-т массива соответствует разряду дв.числа
            System.out.print(BinNumFinal[j]);// вывод двоичного числа
            i-=1;
        }
    }


    //2.2 ПЕРЕВОД ДЕСЯТИЧНОГО ЧИСЛА В ДВОИЧНОЕ
    public static void DecToBin2 (){ // метод позволяет использовать int-число в двоичном коде в дальнейших вычислениях
        System.out.println("2.1 Перевод десятичного числа в двоичную систему счисления");

        // пользовательский ввод
        System.out.println("введите число");
        Scanner in = new Scanner(System.in);
        int DecNum;
        do {
            DecNum = in.nextInt();// максимальное вводимое десятичное число 512, ограничено использованием типа int для разрядов двоичного числа
            if (DecNum < 0) System.out.println("ошибка! введите положительное число");// проверка корректности ввода
        } while (DecNum < 0);

        // объявление пременных
        int BinNum = 0;// неинвентированное число в двоичном коде
        int BinNumFinal = 0;// выводимое число в двоичном коде
        int ost; // для хранения остатка от деления числа на 2
        int n = 0; //счетчик нулей перед неинвертированным двоичным числом (остаток от деления четных чисел на 2)
        int m = 1; //счетчик количества разрядов неинвертированного двоичного числа (используется при инверсии двоичного кода)

        // последовательно делим введенное пользователем число на два чтобы получить разряды двоичного числа
        do {
            ost = DecNum % 2;// находим разряды двоичного числа как остаток от деления десятичного числа на 2
            BinNum += ost; //добавляем остаток от деления в неинвентированный двоичный код
            BinNum *= 10;  //увеличиваем разрядность двоичного числа
            m++; //увеличиваем значение счетчика разрядности двоичного числа
            if (BinNum == 0) n++; // если первыми цифрами двоичного кода будут нули-запоминаем их количество
            DecNum = DecNum / 2;// уменьшаем десятичное число делением на 2
        } while (DecNum >= 2); // повторяем итерации пока десятичное число делиться на 2

        // дописываем последний разряд
        if (DecNum == 1) BinNum ++; // если "1"
        else BinNum *= 10; // если "0"

        // поразрядно инвертируем полученный двоичный код для корректного представления
        for (int i = 0; i < m ; i ++) {
            BinNumFinal*=10;
            BinNumFinal+=(BinNum%10);
            BinNum/=10;
        }

        // добовляем недостающие нули (для четных чисел при инверсии)
        if (n>0){
            for (int j = 0; j < (n-1); j++) {
                BinNumFinal*=10;
            }
        }

        // вывод результатов работы программы
        System.out.printf("введеное число в двоичном коде: %d\n", BinNumFinal);

    }

    //3. ПЕРЕВОД ДЕСЯТИЧНОГО ЧИСЛА В ШЕСТНАДЦАТИРИЧНОЕ

    public static void DecToHex (){
        System.out.println("3. Перевод десятичного числа в шестнадцатиричную систему счисления");
        // пользовательский ввод
        System.out.println("введите число");
        Scanner in = new Scanner(System.in);
        int DecNum = in.nextInt();

        // объявление пременных
        char [] Hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char [] HexNum =new char[1000];
        char [] HexNumFinal =new char[1000];

        int ost; // для хранения остатка от деления числа на 16
        int i; //счетчик

        for (i = 0; DecNum>15 ; i++) {
            ost=DecNum%16;
            HexNum [i] = Hex [ost];
            DecNum=DecNum/16;
            ost=0;
        }
        HexNum [i] = Hex [DecNum];

        int k=i;
        for (int j = 0; j <= k ; j++) {
            HexNumFinal[j]=HexNum[i];
            System.out.print(HexNumFinal[j]);
            i-=1;
        }
    }

    public static void Srch() {
        System.out.println("4. Поиск чиcел из массива, удовлетворяющих условию n + m = 7");
        // создание неотсортированного массива целых случайных чисел
        int [] arrNum = new int[10];
        for (int i = 0; i <=9; i++) {
            arrNum[i] = (int) (Math.random() * 10 )+1;
        }
        System.out.println("исходный массив чисел:");
        System.out.println(Arrays.toString(arrNum));

        //сортировка массива
        Arrays.sort(arrNum);
        System.out.println("отсортированный массив чисел:");
        System.out.println(Arrays.toString(arrNum));
        //поиск пары чисел n + m = 7
        int n=0, m=0; // переменные для искомых чисел

        for (int i = 0; i <= 9 ; i++) {
            n = arrNum[i];//ищем по очереди пару каждому числу в отсортированном массиве
            if ((Arrays.binarySearch(arrNum, (7-arrNum[i]))) > 0){// если результат не отрицательный значит нужное число найдено
            m = arrNum[((Arrays.binarySearch(arrNum, (7-arrNum[i]))))]; //записываем его в переменную m по возвращенному индексу
            break; // и прерываем цикл чтобы не перебирать массив дальше
            }

        }
        if (m != 0) { // если m = 0  значит совпадения удовлетворяющие условию не найдены
            System.out.println("чиcла удовлетворяющие условию n + m = 7 из массива :" + n + " и " + m);
        }else System.out.println("числа удовлетворяющие условию n + m = 7 не найдены");
    }


    public static void main(String[] args) {

        NOD(); // вычисление НОД двух чисел
        DecToBin1();// перевод десятичного числа в двоичное
        DecToBin2();//  перевод десятичного числа в двоичное (через массив)
        DecToHex();//  перевод десятичного числа в шестнацатиричное
        Srch(); // поиск чиcел из массива, удовлетворяющих условию n + m = 7
           }
}



