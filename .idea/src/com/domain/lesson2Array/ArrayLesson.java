package com.domain.lesson2Array;

import java.util.Arrays;

public class ArrayLesson {
    public static void main(String[] args) {
        // объявление переменной массива
     int [] arr;
     int arr1 [];

     arr = new int[5]; //массив будет состоять из пяти элементов со значениями по умолчанию 0, false, null

        System.out.println(Arrays.toString(arr)); // посмотреть содержимое ячеек массива

        // размер массива изменить нельзя
        System.out.println("размер массива: " + arr.length);

        // наполнение массива значениями при инициализации
        int [] arr2 = {5, 67, 12, -12, 0, 1};

        // доступ к элементам массива
        System.out.println(arr2[3]); //-12
        System.out.println(arr2[1+2]); //-12
       // System.out.println(arr2[15]); //ArrayIndexOutOfBoundsException

        arr2[1]=853;
        System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] += 1;// длбавляет 1 к каждому элементу массива
        }

        // копирование массива
        int [] arr3 = {23, 78,  12};

        // int [] arr4 = arr3; так не копировать!! изменения в одном массиве будут переноситься в другой



        //1 var
        int [] cloneArr = arr3.clone();
        System.out.println(Arrays.toString(cloneArr));

        // 2var
        int [] arr5 = new int [15];
        System.arraycopy(arr3, 1, arr5, 3, 1);
        System.out.println(Arrays.toString(arr5));

        //3 var
        int [] copyArr = Arrays.copyOf(arr3, 7);
        System.out.println(Arrays.toString(copyArr));



        arr3= new int []{2, 67, 123, 90, 1};
        // перебор массива
        for (int i = 0; i < arr3.length ; i++) {
            arr3[i] *= 2;
        }
        System.out.println(Arrays.toString(arr3));


        for (int elem: arr3) {
            elem *=2;
            System.out.println(elem);
        }


        //сравнение массивов
        arr3 = new int [] {2, 67, 123};
        arr = new int [] {2, 67, 123};

        System.out.println(Arrays.equals(arr3, arr));

// ДОМА!!! узнать как сравнивать двумерные массивы


        // сортировка массивов
        arr3 = new int[]{2, 67, 123, -304, 0, 13};
        Arrays.sort(arr3); // Arrays.sort(arr3, 1, 5);
        // быстрая сортировка сложность 0 (n log n )

        //бинарный поисксложность 0 (log n)
        arr3 = new int[]{3, 5, 6, 7, 10, 34};
        System.out.println(Arrays.binarySearch(arr3, 6));
        System.out.println(Arrays.binarySearch(arr3, 8));


        /*
        0(1) -константное время
        0(log n)- логарифмическая сложность
        считаются высокоэффективными
        0 (n) - линейная сложность
        0 (n log n) квазилогарифмическая сложность

         */


        //1. Написать программу перевода числа из 10 системы счисления в 2 систему  счисления
        //2. Написать программу перевода числа из 10 системы счисления  в 16 систему счисления
        /* 3. Дан массив целых чисел. Массив не отсортирован числа могут повторяться.
        Необходимо найти в данном массиве такие два числа n  и m, чтобы их сумма была равна 7
        Наиболее оптимальным способом
        напр. 2+5=7  6+1=7   -2+9=7

         */




    }
}
