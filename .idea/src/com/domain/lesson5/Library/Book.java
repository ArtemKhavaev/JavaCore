package com.domain.lesson5.Library;

public class Book {
    // свойства, поля, атрибуты  объекта
    // название книг
    private String title; // по умолчанию значение  null для ссылочных  типов
    // автор
    private String author;

    private boolean isForHome;

    private boolean isAvalible;

    // методы,  устанавливающие значение свойства  title и author
    public void setTitle(String title) {
        // this - ссылка на текущий объект
        if (title != null && !"".equals(title)) {
            this.title = title;
        }
    }
    // alt + ins  автоматическое создание

    public void setAuthor(String author) {
        if (author != null && !"".equals(author)) {
            this.author = author;
        }
    }

    // методы, которые возвращают значение свойств (геттеры)


    public String getTitle() {
        return title;  // return прекращает работу метода и возвращает значение , все что после return выполнено не будет
    }

    public String getAuthor() {
        return author;
    }

    public void setForHome(boolean forHome) {
        isForHome = forHome;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public boolean getisForHome() {
        return isForHome;
    }

    public boolean getisAvalible() {
        return isAvalible;
    }

    // конструкторы
    public Book (){ // создавать такой конструктор, только если создаем еще какой либо
    }

    public Book (String title){
        setTitle(title);
    }

    public Book (String title, String author){
        setTitle(title);
        setAuthor(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isForHome=" + isForHome +
                ", isAvalible=" + isAvalible +
                '}';
    }
}
