package com.domain.lesson21ThreadCreate.tasks.exe;

public class Thread1 extends Thread{
    @Override
    public void run(){

        try {
            sleep (10000);
            System.out.println(" обработка time потоком "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
