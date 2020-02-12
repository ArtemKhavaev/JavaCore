package com.domain.lesson21ThreadCreate.tasks.exe;

public class Thread2 extends Thread{
    @Override
    public void run(){

        try {
            sleep (2000);
            System.out.println(" обработка help потоком "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
