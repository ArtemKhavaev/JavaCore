package com.domain.lesson24Executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorLesson {
    public static void main(String[] args) {
        // ExecutorService несколько задач обрабатывают несколько потоков ( у нас 2)
        ExecutorService fixedPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 7; i++) {
            //метод execute запускает задачу на выполнение
            fixedPool.execute(new RunnableTask("fixedPool"));
        }
        //fixedPool.shutdown();// после завершения задачи не берет на выполнение новые(новые не принимает, ждет завершения запущенных)
        List<Runnable>runnables = fixedPool.shutdownNow();// прерывает выполнение задач немедленно и выводит список невыполненых задач
        System.out.println(runnables);

        // пул на один поток:
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.execute(new RunnableTask("singleThread"));
        singleThread.shutdown();

        // отложенное выполнение
        ScheduledExecutorService scheduledService = Executors.newSingleThreadScheduledExecutor();// позволяет задать врем. параметры
        scheduledService.schedule(new RunnableTask("scheduledService"), 5, TimeUnit.SECONDS);// ждет 5 сек, потом выполняется
        scheduledService.shutdown();

        // повторение задачи (выполнение каждые 5 секунд) (м.б. неск. задач если незавершены
        ScheduledExecutorService everyFiveSeconds = Executors.newSingleThreadScheduledExecutor();
        everyFiveSeconds.scheduleAtFixedRate(new RunnableTask("scheduledService"),
                0, // через какое время начнется выполнение
                5,// прериод ожидания
                TimeUnit.SECONDS);// ед.измерения

        // выполнение задачи каждую секунду (м.б.  только 1 задача
        ScheduledExecutorService everySeconds = Executors.newSingleThreadScheduledExecutor();

        everySeconds.scheduleWithFixedDelay(
                new RunnableTask("everySeconds"),
                0,
                1,
                TimeUnit.SECONDS
        );

    }

}
class RunnableTask implements Runnable {
    private String poolName;

    public RunnableTask(String poolName){
        this.poolName = poolName;
    }

    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName()+ " из пула ");
    }
}