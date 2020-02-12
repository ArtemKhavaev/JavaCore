package com.domain.lesson25MTClasses.tasks;
class Book{
    String name;
    boolean forHome;
    boolean isAvalible;

    public Book(String name) {
        this.name = name;
        forHome = true;
        isAvalible = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isForHome() {
        return forHome;
    }

    public void setForHome(boolean forHome) {
        this.forHome = forHome;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }
}
public class Library {
    public static void main(String[] args) {


    }
}
