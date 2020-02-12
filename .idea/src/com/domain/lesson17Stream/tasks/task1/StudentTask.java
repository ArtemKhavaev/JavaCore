package com.domain.lesson17Stream.tasks.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentTask {
    public static void main(String[] args) {
        //TODO: найти студентов с уникальными предметами. Задачу решать с использованием stream API
        List<String>subjects1 = new ArrayList<String>();
        subjects1.add("Math");
        subjects1.add("Fiz");
        subjects1.add("Geo");
        List<String>subjects2 = new ArrayList<String>();
        subjects2.add("Math");
        subjects2.add("Astr");
        subjects2.add("Inf");
        List<String>subjects3 = new ArrayList<String>();
        subjects3.add("Fil");
        subjects3.add("Hist");
        subjects3.add("InYaz");
        List<String>subjects4 = new ArrayList<String>();
        subjects4.add("Math");
        subjects4.add("Fiz");
        subjects4.add("Geo");
        Student student1 = new Student("vasya", subjects1);
        Student student2 = new Student("petya", subjects2);
        Student student3 = new Student("volodya", subjects3);
        Student student4 = new Student("alex", subjects4);

        Stream<Student> stream = Stream.of(student1, student2, student3, student4);





    }
}

class Student {
    // можно добавить дополнительные поля
    private String login;
    private List<String> subjects;

    public Student(String login, List<String> subjects) {
        this.login = login;
        this.subjects = subjects;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
