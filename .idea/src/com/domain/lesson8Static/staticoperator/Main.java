package com.domain.lesson8Static.staticoperator;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Том", "дворник");
        employee1.setTimeStart(LocalDateTime.of(2019, Month.OCTOBER, 25, 6, 0));
        employee1.setTimeEnd(LocalDateTime.of(2019, Month.OCTOBER, 25, 14, 0));
        Employee employee2 = new Employee("Майк", "охранник");
        employee2.setTimeStart(LocalDateTime.of(2019, Month.OCTOBER, 25, 8, 0));
        employee2.setTimeEnd(LocalDateTime.of(2019, Month.OCTOBER, 25, 21, 0));


        employee1.printCurrentDayStatistic();
        employee2.printCurrentDayStatistic();

        System.out.println(Employee.company);

        Employee.changeCompany("dfvdfnvd");

        employee1.printCompany();


        employee1.company = "employee1 company";
        employee2.printCompany(); // вывод будет "employee1 company" !!!!т.к static не принадлежит объекту
    }
}
