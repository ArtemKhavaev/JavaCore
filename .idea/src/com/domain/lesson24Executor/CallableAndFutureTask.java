package com.domain.lesson24Executor;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureTask {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);// создаем пул на 3 потока
        Callable<Unit> unitCallable = new UnitCreator();
        ArrayList<Future<Unit>> list  = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
           Future <Unit> future = service.submit(unitCallable);// когда задача по созд. юнита будет выполнена объект юнита помещается в контейнер future
            /*
            task1 -> unit1 -> контейнер для unit1 (future1)
            task2 -> unit2 -> контейнер для unit2 (future2)
            task3 -> unit3 -> контейнер для unit3 (future3)
            task4 -> unit4 -> контейнер для unit4 (future4)
            task5 -> unit5 -> контейнер для unit5 (future5)
             */
            // submit связывет task с контейнером
           list.add(future);
        }
//        for (Future<Unit> future: list) {
//            System.out.println("Waiting future....");
//            try {
//                System.out.println("Unit: " + future.get());
//
//               // (future1 = unit 1 ) -> future.get() -
//                // future.get() - ждет пока в контейнере что-нибудь появится
//
//            } catch (InterruptedException | ExecutionException e) {
//                e.printStackTrace();
//            }
//        }
//        service.shutdown();


        //если в контейнере ничего не появилось отрабатывает TimeoutException
        for (Future<Unit>future:list
             ) {
            try {
                System.out.println("Unit "+ future.get((long)(Math.random()*3000), TimeUnit.MILLISECONDS));
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("----TimeoutException------");
            }
        }

        service.shutdown();

        ExecutorService service1 = Executors.newFixedThreadPool(3);// создаем пул на 3 потока
        Callable<Unit> unitCallable1 = new UnitCreator();
        Callable<Unit> unitCallable2 = new UnitCreator();

        Future<Unit> task1 = new FutureTask<>(unitCallable1);
        Future<Unit> task2 = new FutureTask<>(unitCallable2);

        service1.execute((Runnable) task1);
        service1.execute((Runnable) task2);

        //isShutdown() возвращает true если ExecutorService остановлен
        //isTerminated() возвращает true если задачи выполнены при вызове метода shutdown()

        while (!service1.isShutdown()){
            // методы future:
            //task1.isCancelled();
            //task2.cancel(true);//определяет можем прерывать задачу или нет
            if (task1.isDone() && task2.isDone()){
                try {
                    System.out.println("TASK 1: "+ task1.get());
                    System.out.println("TASK 2: "+ task2.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                service1.shutdown();

            }
        }

    }
}

class UnitCreator implements Callable <Unit>{// создает и возвращает объект в потоке

    @Override
    public Unit call() throws Exception {
        Thread.sleep((long)(Math.random()*5000));// кажд.задача будет выполнятся разное количество времени
        Random random = new Random();
        Unit unit = new Unit();
        unit.setName(Thread.currentThread().getName());
        unit.setHealth(random.nextInt(20));
        unit.setAttackScore(random.nextInt(15));
        return unit;
    }


}
class Unit {
    private String name;
    private int health;
    private int AttackScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackScore() {
        return AttackScore;
    }

    public void setAttackScore(int attackScore) {
        AttackScore = attackScore;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", AttackScore=" + AttackScore +
                '}';
    }
}