package com.domain.lesson11Collections;

import java.util.*;

public class CollectionLesson {
    public static void main(String[] args) {
        Student student1 = new Student("Иван", "Иванов", 22);
        Student student2 = new Student("Иван", "Иванов", 22);
        Student student3 = new Student("Иван", "Федоров", 18);
        Student student4 = new Student("Алексей", "Михайлов", 25);


        System.out.println("---LinkedList----");
        // быстрая вставка и удаление из середины списка
        // в других случаяхнеобходимо выбирать ArrayList
        // порядок элементов гарантирован
        // можно добавит null
        // допускает дублирование элементов


        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);
//        students.add(7, 3);  ! Exeption т.к. 7 > 2
        students.add(student2);
        //students.add(null);

        System.out.println(students);
        System.out.println(students.get(0));




        System.out.println("---ArrayList----");
        // порядок элементов гарантирован
        // можно добавит null
        // допускает дублирование элементов

        ArrayList<Student> studentArrayList = new ArrayList<>(20);
        System.out.println(studentArrayList.size());
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(null);
        studentArrayList.trimToSize();//освобождает избыточную емкость
        System.out.println(studentArrayList);
        System.out.println(studentArrayList.subList(0, 2));


        // список из массива

        Student [] studentsArr = {student1, student2, student3};
        studentArrayList.addAll(Arrays.asList(studentsArr));

        System.out.println(studentArrayList.size());

        // SET
        // используется для хранения уникальных элементов
        // обязательно д.б. переопределены методы equals и hashcode

        System.out.println("---HashSet---");
        // порядок элементов может менятся
        // можно хранить null (он всегда будет на нулевой позиции)

        HashSet<Student> studentHashSet = new HashSet<>(studentArrayList);
        System.out.println(studentHashSet.size());
        System.out.println(studentHashSet);


        // LinkedHashSet<Student>
        // порядок элементов гарантирован


        System.out.println("---TreeSet---");
        // нельзя добавить null
        // элементы хранятся в отсортированном порядке


        // ClassCastExeption
        TreeSet<Student> studentTreeSet = new TreeSet<>(Arrays.asList(studentsArr));
        // 1) класс должен имплементировать интерфейс Comparable и переопределить метод compareTo();
        studentTreeSet.add(student4);
        System.out.println(studentTreeSet);
        // 2) в конструктор treeSet передать Comparator
        Comparator<Student> studentComparator = new StudentNameComparator().thenComparing(new StudentAgeComparator());
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(studentComparator);
        studentTreeSet2.add(student1);
        studentTreeSet2.add(student1);
        studentTreeSet2.add(student2);
        studentTreeSet2.add(student3);
        studentTreeSet2.add(student4);
        System.out.println(studentTreeSet2);


        // перебор коллекций
        for (Student student: students) {
            System.out.println(student);
            System.out.println(student.getName());
            // students.remove(student);//удалять в  переборе нельзя !  ConcurrentModificationException
        }
        Iterator<Student> studentIterator = students.listIterator();
        while (studentIterator.hasNext()){
            if(studentIterator.next().getName().equals("Иван")){
                studentIterator.remove();
            }
        }
        System.out.println(students);










    }
}
