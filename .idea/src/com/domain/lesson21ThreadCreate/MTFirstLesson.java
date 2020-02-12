package com.domain.lesson21ThreadCreate;

public class MTFirstLesson {
    public static void main(String[] args) {
    /*
    жизненный цикл потока:
        1. создание
        2. запуск
        3. выполнение
        4. ожидание или блокировка
        5. завершение

        каждый поток работает со своим стеком вызова , но обращается к общей куче heap

    Thread.currentThread() - возвращает текущю поток
    setName() задает имя для потока
    getName() возвращает имя потока
    getState() возвращает состояние потока (создан, запущен, заблокирован, завершен)
    join() -основной поток будет ждать завершения второстепенных потоков у которых вызван метод join()

    */
    FirstThread firstThread = new FirstThread(); // синтаксис создания первого(основного) потока
    firstThread.start();
    System.out.println("основной поток "+ Thread.currentThread().getName());

    Thread thread1 = new Thread(new SecondThread()); // синтаксис создания второго потока
    Thread thread2 = new Thread(new SecondThread());
    Thread thread3 = new Thread(new SecondThread());

    thread1.start();
        System.out.println("thread1 "+ thread1.getState());
    thread2.start();
    thread3.start();

        try {
            System.out.println(Thread.currentThread().getName() + "ожидает завершения потоков");
            thread1.join(); // поток thread будет ждать завершения thread1
            thread2.join(); // поток thread будет ждать завершения thread2
            thread3.join(); // поток thread будет ждать завершения thread3

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Thread someThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from someThread1");
            }
        });

        // можно описать реализацию метода Run(); через лямбду
        Thread someTread2 = new Thread(() ->{
            System.out.println("someThread2 " + Thread.currentThread().isAlive());
            System.out.println("someThread2 " + Thread.currentThread().getState());
        });
        someTread2.start();

        // демон
//        Thread deamonThread = new Thread(new DeamonThread());
//        deamonThread.setDaemon(true);// делаем поток фоновым - завершится когда завершатся все прочие  потоки, без этой строки будет работать бесконечно
//        deamonThread.start();

        //перрывание потока
        /* поток останавливается
        1. выполнил все инструкции
        2. выброшено необработанное исключение
        3. остановилась JVM
        4. если поток был deamon а все остальные завершились
         */

        Thread interrupt = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){//isInterrupted() возвращает значение флага //false по умолчанию
                System.out.println("some actions...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }




            }
            System.out.println("while End");
        });
        interrupt.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        interrupt.interrupt();//interrupt() меняет значение флага//true

        System.out.println("завершение основного потока "+ Thread.currentThread().getName());
    }



    // первый вариант создания потока -наследование от Thread
}
class FirstThread extends Thread{
    @Override
    public void run(){
        Thread.currentThread().setName("FirstThread");
        System.out.println(Thread.currentThread().getName());
    }
}
// второй вариант создания потока -расширение интерфейса Runnable
class SecondThread implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 5; i ++){
            System.out.println(Thread.currentThread().getName() + ": "+ i);
        }

    }


}

class DeamonThread implements Runnable {
    @Override
    public void run(){
        while (true){
            System.out.println("DeamonThread");
        }
    }

}
