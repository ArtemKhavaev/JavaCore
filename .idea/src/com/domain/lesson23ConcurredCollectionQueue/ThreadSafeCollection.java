package com.domain.lesson23ConcurredCollectionQueue;

import java.util.*;
import java.util.concurrent.*;


public class ThreadSafeCollection {
    public static void main (String []args){
        /*
        потокобезопасные коллекции
        Vector
        HashTable
        Stack

        однопоточные коллекции и мапы в потокобезопасные коллекци  и мапы
        */
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer>map = Collections.synchronizedMap(new HashMap<>());

        // потокобезопасные коллекции и мапы из пакета java.util.concurrent.*
       // CopyOnWriteArrayList // много чтения, мало вставок
        CopyOnWriteArrayList<Book>books = new CopyOnWriteArrayList<>();
        books.addIfAbsent(new Book("Java", 1800));
        books.addIfAbsent(new Book("Java", 1800));
        System.out.println(books);
        new Thread(new WriteThread(books)).start();
        new Thread(new ReadThread(books)).start();

        //CopyOnWriteArraySet
        CopyOnWriteArraySet<String>strings = new CopyOnWriteArraySet<>();
        strings.add("qwe");
        strings.add("asd");
        strings.add("zxc");
        strings.add("rty");
        strings.removeIf(s -> s.equals("asd")); // принимает на вхо придикат
        //ConcurrentSkipListMap элементы будут хранится в сортированном порядке

        //ConcurrentNavigableMap<>
        ConcurrentNavigableMap<String, Integer> navigableMap = new ConcurrentSkipListMap<>();
        navigableMap.put("qwe", 2);
        navigableMap.putIfAbsent("qwe", 2);
//        navigableMap.computeIfPresent();// принимает на вх. ключ и функцию (lambda)
//        navigableMap.computeIfAbsent();// для проверки что значение по ключу null


    }
}
class WriteThread implements Runnable{
    CopyOnWriteArrayList<Book>books;

    public WriteThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run(){
        for (int i = 0; i < 50 ; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            books.addIfAbsent(Book.getBook());
        }
    }
}
class ReadThread implements Runnable{
    private CopyOnWriteArrayList<Book> books;

    public ReadThread(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void run(){
        Scanner scanner = new Scanner(System.in);
        while(!Thread.currentThread().isInterrupted()){
            System.out.println("Введите название книги");
            String title = scanner.nextLine();
            for(Book book: books){
                if (title.equals(book.getTitle())){
                    System.out.println(book);

                }
            }
        }
    }



}
class Book  {
    private String title;
    private int pageCount;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getPageCount() == book.getPageCount() &&
                getTitle().equals(book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getPageCount());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

    public static  Book getBook (){
        Random random = new Random();
        String [] titles = {"Алфавит", "Философия Java", " Обломов", "Война и мир"};
        return new Book(titles[random.nextInt(titles.length-1)], random.nextInt(2000));

    }
}