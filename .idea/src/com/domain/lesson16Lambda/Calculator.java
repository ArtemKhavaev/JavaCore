package com.domain.lesson16Lambda;

public class Calculator {
    public double calculate (double a, double b, Operation operation){
        return operation.execute(a, b);
    }

    public static void main(String[] args) {
        Operation plus = (a, b) -> a + b;// предпологается что лямбда возвращает результат, если действий более одного - взять в  скобки {  }
        Operation div = (a, b) -> {
            if (b == 0)throw new IllegalArgumentException(" b не может быть 0");
                return a / b;
        };
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(2, 2, plus));
        System.out.println(calculator.calculate(2, 2, div));
/*       аргумент -> реализация
        () -> описание действия
        (a, b) -> описание действия
        a -> описание действия
        (a, b) -> a + b
        (a, b) -> {
            действие 1
            действие 2
            действие 3
            return результат
        }

        */



    }
}
@FunctionalInterface
interface Operation {
    double execute (double a, double b);// у функционального интерфеса д.б  только один абстрактный метод и любое количество дефолтных методов

}