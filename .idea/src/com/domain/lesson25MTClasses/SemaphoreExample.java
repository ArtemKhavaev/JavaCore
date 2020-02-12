package com.domain.lesson25MTClasses;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new IncrementThread(semaphore)).start();
        new Thread(new DecrementThread(semaphore)).start();

    }
}
class Counter{
    static int count = 0;

}
class IncrementThread implements Runnable{
    private Semaphore semaphore;

    public IncrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("начало работы потока Increment");
        try {
            semaphore.acquire();// поток запрашивает разрешение и будет приостановлен пока это разрешение не будет получено
            System.out.println("Increment получил разрешение");
            for (int i = 0; i < 8 ; i++) {
                Counter.count++;
                System.out.println("Increment Count = "+ Counter.count);
                //THread.sleep(500);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Increment отработал с общим ресурсом");
        semaphore.release();
    }
}

class DecrementThread implements Runnable{
    private Semaphore semaphore;

    public DecrementThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("начало работы с Decrement");
        try {
            semaphore.acquire();
            System.out.println("Decrement получил разрешение");
            for (int i = 0; i < 8; i++) {
                Counter.count--;
                System.out.println("Decrement Count = " + Counter.count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Decrement отработал с общим ресурсом");
    }
}