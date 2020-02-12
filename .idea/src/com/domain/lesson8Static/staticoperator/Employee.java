package com.domain.lesson8Static.staticoperator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {


    //static - не принадлежит объекту, а принадлежит классу

    // статическое свойство
    static String company;

    // статический блок загружается в память один раз вместе с программой хранится там же где и класс Metaspace
    static {
        company = "HEV";
    }

    //статический метод
    static void changeCompany(String newCompany){
        company = newCompany;
    }

    void printCompany(){
        System.out.println(company);// из нестатического метода можно обратиться к статическому свойству,  но не наоборот!!
    }

    private String name;
    private String position;

    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;


    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getTimeStart() {
        return timeStart.format(DateTimeFormatter.ofPattern("d MMMM yyyy в  HH:mm"));
    }

    public String getTimeEnd() {
        return timeEnd.format(DateTimeFormatter.ofPattern("d MMMM yyyy в  HH:mm"));
    }

    public void printCurrentDayStatistic(){
        System.out.println(this.position + " " + this.name + " пришел: " + getTimeStart() + " ушел " + getTimeEnd());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                '}';
    }
}
