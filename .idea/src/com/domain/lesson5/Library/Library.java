package com.domain.lesson5.Library;

public class Library {
    private Book [] books = new Book[10];

    // в библиотеку можно добавить одну книгу
    public void addBook(Book newBook){
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                return; // break;
            }

        }
    }
    // в библиотеку можно добавить сразу несколько книг
    public void addBook(Book ...newBooks){ // ... - можно передать несколько значений через запятую
        // проверка на правильность количества вводимых книг (не допускает переполнение массива)
        int i = 0;
        for (i = 0; i <this.books.length ; i++) {
            if (this.books[i] == null) break;
            }
             i = this.books.length - i;
        if (newBooks.length > i) {
            System.out.printf("библиотека заполнена, введите количество книг не более  %d\n", i );
             return;
        }else {
        for (int j = 0; j < this.books.length; j++) {
            if (this.books[j] == null) {
                System.arraycopy(newBooks, 0, this.books, j, newBooks.length);
                break;
            }
        }
        }
        }







// должна быть возможность получить информацию по книге  указав ее название
    // (получаемая информация: автор, название, можно ли взять ее домой, доступна ли книга )

    public void  getInfo(String bookTitle) {

        System.out.println("размер библиотеки " + books.length );
        for (int i = 0; i < books.length; i++) {
            if (bookTitle.equalsIgnoreCase(books[i].getTitle()) == true) {
                System.out.print("Автор: " + books[i].getAuthor() + ", ");
                System.out.print("Название: " + books[i].getTitle() + ", ");
                if (books[i].getisForHome() == true) System.out.println("книгу можно взять домой, ");
                else System.out.print("книгу можно почитать в читальном зале, ");
                if (books[i].getisAvalible() == true) System.out.println("она сейчас доступна в библиотеке");
                else {
                    System.out.print("но она, к сожалению, сейчас выдана");
                    break;
                }

            } else if (i == (books.length-1)) System.out.println("Книга в библиотеке не найдена");
        }
    }
// д.б. возможность взять книгу домой, указав название

    public Book takeHome (String bookTitle){

        // проверить доступна ли книга для выдачи домой
        int k = 0;
        for (int i = 0; i < books.length; i++) {
            if (bookTitle.equalsIgnoreCase(books[i].getTitle()) != false) {
                if (books[i].getisAvalible() == true) {
                    if (books[i].getisForHome() == true ) {// если книгу можно взять домой
                        System.out.println("Вы взяли книгу домой");
                        books[i].setAvalible(false);
                    }
                    else System.out.print("Книгу можно почитать только в читальном зале");// если книгу можно взять только в читальном зале
                }
                else System.out.print("К сожалению книга сейчас выдана!");// если книга выдана
                break;
            } else k++;
        }
        if (k == books.length) System.out.println("Книга в библиотеке не найдена");// если книга не найдена

        Book returnBook  = null;
        return returnBook;
    }


    public Book returnBook (String bookTitle){

        int k = 0;
        for (int i = 0; i < books.length; i++) {
            if (bookTitle.equalsIgnoreCase(books[i].getTitle()) != false) {
                if (books[i].getisAvalible() == true) {
                    if (books[i].getisForHome() == true ) {// если книгу можно взять домой
                        System.out.println("Вы вернули книгу в библиотеку");
                        books[i].setAvalible(true);

                    }
                    else System.out.print("Книгу можно почитать только в читальном зале");// если книгу можно взять только в читальном зале
                }
                else System.out.print("К сожалению книга сейчас выдана!");// если книга выдана
                break;



            } else k++;
        }
        if (k == books.length) System.out.println("Такая книга в библиотеке не числится");// если книга не найдена


    Book returnBook  = null;
    return returnBook;
    }


}
