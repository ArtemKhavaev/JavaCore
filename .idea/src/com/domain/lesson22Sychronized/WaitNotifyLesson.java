package com.domain.lesson22Sychronized;

public class WaitNotifyLesson {
    public static void main(String[] args) {
        BookStorage storage  = new BookStorage();
        new Thread(new PutThread(storage)).start();
        new Thread(new GetThread(storage)).start();


    }
}
class BookStorage {
    int bookCount = 0;
    public synchronized void putBook() throws InterruptedException {
        // incr count to 1
        System.out.println("putBook начало вып.");
        //notify();
        while (bookCount >= 5){
            System.out.println("putBook в сост.ожидания");
            wait(); // поток может самостоятельно выйти из состояния ожидания! нужно проверять его состояние

        }
        bookCount++;
        System.out.println("putBook добавил 1 книга"+ bookCount);
        System.out.println("putBook завершил выполнение");
    }
    public synchronized void getBook() throws InterruptedException {
        // decr count to 1
        System.out.println("getBook start");
        while (bookCount <= 0){
            System.out.println("getBook в сост.ожидания");
            wait();

        }
        bookCount--;
        System.out.println("getBook забрали 1 книгу, осталось"+ bookCount);
        System.out.println("getBook завершил работу");
         notify(); //будит случ. поток, наход. в сост ожидания
        // notifyAll(); // будит все потоки наход. в сост ожидания
    }
}
class PutThread implements Runnable{
    BookStorage bookStorage;

    public PutThread(BookStorage bookStorage){
        this.bookStorage = bookStorage;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.putBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class GetThread implements Runnable{
    BookStorage bookStorage;

    public GetThread(BookStorage bookStorage){
        this.bookStorage = bookStorage;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                bookStorage.getBook();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}