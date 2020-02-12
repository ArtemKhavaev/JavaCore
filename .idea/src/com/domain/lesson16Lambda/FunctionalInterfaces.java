package com.domain.lesson16Lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        // встроенные функциональные интерфейсы
        // интерфейс Predicate<T>
        // boolean test(T t);
        // default:
        // boolean or (Predicate p)
        // boolean and (Predicate p)
        // boolean negative (Predicate p)


        Predicate<Integer> pos = num -> num > 0;      // импорт только из util
        Predicate<Integer> neg = num -> num < 0;
        Predicate<Integer> isEven = num -> num % 2 == 0;

        System.out.println(pos.test(23)); // true
        System.out.println(neg.test(234)); // false
        System.out.println(pos.and(isEven).test(45)); // false
        System.out.println(neg.or(isEven).test(22)); // true

        //Интерфейс   Functjin <T, R.
        // R applay(T t);
        // default
        // andThen(Function after
        // compose(Function befere

        Function <Integer, Double> tenPerxent = num -> num * 0.1;
        Function <Integer, Integer> plusTen = num -> num + 10;
        Function <Integer, Integer> plusFive= num -> num + 5;

        System.out.println(plusTen.andThen(plusFive).andThen(tenPerxent).apply(16));

        Function<Integer, Integer> addTwo = num -> num * 2;
        Function<Integer, Integer> sqrt = num -> num * num;

        System.out.println(addTwo.andThen(sqrt).apply(3));
        System.out.println(addTwo // 3: 162
                .compose(sqrt)// 1:  9
                .andThen(sqrt)// 4: 26244
                .compose(sqrt)// 2: 81
                .apply((3)));// 26244


        // 4 -> "4$"
        Function<Integer, String> dol = num -> num + "$";

        // дан Predicate condition и две function ifTrue  ifFalse
        //написать метод, который вернет нов. функцию (Function), возвращающую результат работы функции ifTrue,
        //если condition == true  и наоборот

        Predicate<Integer> cond = num -> num > 0;
        Function<Integer, Integer> func = integerFunction(cond, plusFive, plusTen);
        System.out.println(func.apply(5));


        // BinaryOperator<T> бинарный оператор
        // T apply (T t1, T t2); принимает два объекта опред. типа и после обработки возвращает два объекта того же типа

        //UnaryOperator<T> унарный оператор
        // T apply (T t);принимает объект опред. типа и после обработки возвращает объект того же типа

        // Consumer<T> метод ничего не возвращает
        // void accept(T t);


    }
    public static Function<Integer, Integer> integerFunction(
            Predicate<Integer>condition,
            Function<Integer, Integer> ifTrue,
            Function<Integer, Integer> ifFalse
    ){
        return num -> condition.test(num) ? ifTrue.apply(num) : ifFalse.apply(num);
    }


}
