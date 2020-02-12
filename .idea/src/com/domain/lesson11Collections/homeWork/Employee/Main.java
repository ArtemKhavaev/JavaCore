package com.domain.lesson11Collections.homeWork.Employee;

import java.util.*;

import static com.domain.lesson11Collections.homeWork.Employee.Employee.employeeGenerator;
import static com.domain.lesson11Collections.homeWork.Employee.Employee.printEmployee;

public class Main {
    public static void main(String[] args) {

        List<Employee> listEmployee = new ArrayList<>(employeeGenerator(20));

        System.out.println("Исходный список сотрудников");
        printEmployee(listEmployee);// вывод списка

        System.out.println("\n");

        // сортировка по имени
        System.out.println("Список сотрудников, сортированный по имени");
        printEmployee(Employee.SortByName(listEmployee));// вывод списка

        // сортировка по имени и зп
        System.out.println("Список сотрудников, сортированный по имени и зарплате");
        printEmployee(Employee.SortByNameSal (listEmployee));// вывод списка

        // сортировка по имени, зп и возрасту
        // в тесте результат не видно, т.к. рандомно трудно сгенерировать сотрудников с одинаковыми именами и зп
        System.out.println("Список сотрудников, сортированный по имени и зарплате");
        printEmployee(Employee.SortByNameSalAge (listEmployee));// вывод списка

        // сортировка по имени, зп, возрасту и компании
        System.out.println("Список сотрудников, сортированный по имени и зарплате");
        printEmployee(Employee.SortByNameSalAgeCo (listEmployee));// вывод списка



    }
}
