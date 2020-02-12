package com.domain.lesson11Collections.homeWork.ClassWorkTasks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        System.out.println("----Задача №3 Set<Integer>-----");
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        for (int i = 0; i < 20; i++) { // заносим в коллекцию 20 рандомных чисел
            integerTreeSet.add((int) ((Math.random() * 100) + 1));
        }
        System.out.println("Исходная коллекция чисел:");
        System.out.println(integerTreeSet);// вывод исх.коллекции:

        // через Iterator перебераем коллекцию и удаляем числа больше 10
        Iterator<Integer> integerIterator = integerTreeSet.iterator();
        while (integerIterator.hasNext()) { // цикл работает пока в множестве есть элементы
            if (integerIterator.next() > 10)
                integerIterator.remove(); // если текуший элемент больше 10, он удаляется из коллекциии
        }
        System.out.println("Отсортированная коллекция (удалены числа больше 10):");
        System.out.println(integerTreeSet); //вывод отсортированной коллекции


        System.out.println("----Задача №2 SortNumber-----");
        TreeSet<Integer> numberTreeSet = new TreeSet<>();
        TreeSet<Integer> numberTreeSet2 = new TreeSet<>();
        TreeSet<Integer> numberTreeSet3 = new TreeSet<>();
        TreeSet<Integer> numberTreeSetOther = new TreeSet<>();

        for (int i = 0; i < 20; i++) { // заносим в коллекцию 20 рандомных чисел
            numberTreeSet.add((int) ((Math.random() * 100) + 1));
        }
        System.out.println("Исходная коллекция чисел:");
        System.out.println(numberTreeSet);// вывод исх.коллекции:

        for (Integer nums : numberTreeSet){ // производим сортировку элементов по трем спискам:
            if ((nums.intValue() % 2) == 0)numberTreeSet2.add(nums.intValue()); // если тек.элемент делится на 2 -> 2й список
            if ((nums.intValue() % 3) == 0)numberTreeSet3.add(nums.intValue()); // если тек.элемент делится на 3 -> 3й список
            if(((nums.intValue() % 2) != 0) && ((nums.intValue() % 3) != 0)) numberTreeSetOther.add(nums.intValue()); // иначе тек.элемент -> список "прочие"
        }

        // вывод трехсписков:
        Task2.printList(numberTreeSet2, numberTreeSet3, numberTreeSetOther);


        System.out.println("----Задача №1 StringList-----");

        LinkedList<String> words = new LinkedList<>();
        words.add("a");
        words.add("ab");
        words.add("abr");
        words.add("abra");
        words.add("abrac");
        words.add("abr");// пятый элемент
        words.add("abracad");
        words.add("abracada");
        words.add("abracadab");
        words.add("abracadabr");
        words.add("abracadabra");

        int previusSize = 0;
        int count = 0;

        for (String wordIterator : words){
            if (wordIterator.length() < previusSize) {// если длина строки тек.элемента меньше предыдущего выход из цикла с сообщением
                System.out.println("Порядок сортировки строк нарушен на " + previusSize + "-м элементе!");
                break;
            }
            //если строки в списке по возрастанию:
            previusSize = wordIterator.length(); // запоминаем длину текущей строки для использования в след.итерации
            count ++;// увеличиваем значение счетчика количества проверенных эл-тов списка
        }
        // если количество проверенных эл-тов списка соответствует общему числу эл-тов списка
        // значит все строки были в порядке увеличения
        if (count == words.size()) System.out.println("Порядок сортировки строк не нарушен");


    }
}


class Task2 {// класс для реализации метода задачи № 2
    public static void printList(TreeSet<Integer> numberTreeSet2,TreeSet<Integer> numberTreeSet3,TreeSet<Integer> numberTreeSetOther){
        System.out.println("Числа, которые делятся без остатка на 2:");
        System.out.println(numberTreeSet2);
        System.out.println("Числа, которые делятся без остатка на 3:");
        System.out.println(numberTreeSet3);
        System.out.println("Остальные числа:");
        System.out.println(numberTreeSetOther);
    }
}


