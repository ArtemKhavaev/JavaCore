package com.domain.lesson5.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Book java = new Book(); // вызов конструктора
         Book cleanCode = new Book(); //

        // доступ к свойству объекта (имя_объекта.свойство)
        //java.title = "философия Java";
        //cleanCode.title = "Чистый код";

        //java.author = "Брюс Эккель";
        //cleanCode.author = "Роберт Мартин";

        // вызов метода или доступ к метод-через точку
        java.setTitle("философия Java");
        cleanCode.setTitle("Чистый код");

        java.setAuthor("Брюс Эккель");
        cleanCode.setAuthor("Роберт Мартин");

        java.setForHome(true);
        cleanCode.setForHome(false);

//        System.out.println(java.getTitle());
//        System.out.println(cleanCode.getTitle());

        Book forBeginners = new Book("Руководство для начинающих", "Герберт Шилдт");

        java.setAvalible(false);
        cleanCode.setAvalible(true);
        forBeginners.setAvalible(true);

//        System.out.println(java); // метод toString() вызывается автоматически  методом println()
//        System.out.println(cleanCode);
//        System.out.println(forBeginners);

        Library library = new Library();
        library.addBook(java);
        library.addBook(cleanCode, forBeginners);

        System.out.println( "Для получения информации о книге введите название");
        Scanner in = new Scanner(System.in);
        String bookTitle = in.nextLine();
        library.getInfo(bookTitle);

        String exit1 = null;
        do {
         System.out.println("Чтобы получить книгу введите название");
         bookTitle = in.nextLine();
         library.takeHome(bookTitle);
         System.out.println("Если хотите взять еще книгу нажмите пробел");
         exit1 = in.nextLine();
        } while (exit1.equalsIgnoreCase(" ") == true);

        do {
         System.out.println("Чтобы вернуть книгу введите название");
         bookTitle = in.nextLine();
         library.returnBook(bookTitle);System.out.println("Если хотите вернуть еще книгу нажмите пробел");
         exit1 = in.nextLine();
        } while (exit1.equalsIgnoreCase(" ") == true);





   }
}
