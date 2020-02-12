package com.domain.lesson21ThreadCreate.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MTTasks {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
            switch (br.readLine()){
                case "time":
                    com.domain.lesson21ThreadCreate.tasks.exe.Thread1 thread1 = new com.domain.lesson21ThreadCreate.tasks.exe.Thread1();
                    thread1.start();
                    break;
                case "help":
                    com.domain.lesson21ThreadCreate.tasks.exe.Thread2 thread2 = new com.domain.lesson21ThreadCreate.tasks.exe.Thread2();
                    thread2.start();
                    break;
                case "getFromFile":
                    com.domain.lesson21ThreadCreate.tasks.exe.Thread3 thread3 = new com.domain.lesson21ThreadCreate.tasks.exe.Thread3();
                    thread3.start();
                    break;
                default:
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

class Thread1 extends Thread{
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

class Thread2 extends Thread{
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

class Thread3 extends Thread{
    @Override
    public void run(){

        try {
            sleep (10000);
            System.out.println(" обработка getFromFile потоком "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}