package com.domain.lesson25MTClasses.tasks;

import java.util.concurrent.Semaphore;

public class Port {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();
        new Thread(new Ship(semaphore)).start();

    }
}
class Ship implements Runnable {

    private Semaphore semaphore;

    public Ship( Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Pier.count ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
class Pier {
    static int count;

    public Pier() {
        count =1;
    }



}