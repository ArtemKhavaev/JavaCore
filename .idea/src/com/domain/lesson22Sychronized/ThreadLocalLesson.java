package com.domain.lesson22Sychronized;
public class ThreadLocalLesson {
    private static String staticString;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>(); //кэширующаяся переменная (создается для каждого отдельного потока- будет своя)
    public static void main(String[] args) {
        staticString = "main";
        threadLocal.set("main");
        Thread thread1 = new Thread(new SomeThread(staticString, threadLocal));
        thread1.start();
    }
}

class SomeThread implements Runnable{

    private static String string;
    private static ThreadLocal<String> threadLocal;

    public SomeThread(String string1, ThreadLocal<String> threadLocal1) {
        string = string1;
        threadLocal = threadLocal1;
    }

    @Override
    public void run() {
        System.out.println(threadLocal.get());
        System.out.println(string);
    }
}
