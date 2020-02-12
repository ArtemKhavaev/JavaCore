package com.domain.lesson23ConcurredCollectionQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class BlockingQueue {
    public static void main(String[] args) {
//        ArrayBlockingQueue // FIFO
//        linkedBlockingQueue
        ArrayBlockingQueue<String > strings = new ArrayBlockingQueue<>(23, true);// емкость задавать обязательно, fair - флаг справедливости

        // SynchronousQueue<Object> каждая операция добавления находится в ожидании соответствующей операции удаления

        // DelayQueue

        // linkedTransferQueue чем отличается от linkedBlockingQueue? (по интерфейсам)


        LinkedBlockingDeque<Signal> signals = new LinkedBlockingDeque<>();
        // LinkedBlockingDeque<Signal> signals = new LinkedBlockingDeque<>(34); можно указать размер очереди

        new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
    }
}

class WriteSignals implements Runnable {
    LinkedBlockingDeque<Signal> signals;

    public WriteSignals(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Write "+ Thread.currentThread().getState());

            try {
                Thread.sleep(5000);
                Signal signal = Signal.getSignal();
                signals.put(signal);
                System.out.println("Write Signal "+ signal);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
class ReadSignals implements Runnable{
    private LinkedBlockingDeque<Signal> signals;

    public ReadSignals(LinkedBlockingDeque<Signal> signals) {
        this.signals = signals;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("read "+ Thread.currentThread().getState());
            try{
                System.out.println("Read Signal "+ signals.take());// take()  удаляет элемент из очереди и возвращает его
            } catch (InterruptedException e ){
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Signal {
    enum Priority {
        HIGH, MEDIUM, LOW;
        public static Priority getPriority(int ord){
            for (Priority priority:values()){
                if (ord == priority.ordinal()){
                    return priority;
                }
            }
            throw new AssertionError("wrong ordinal");
        }

    }
    private Priority priority;
    private int code;

    public Signal(Priority priority, int code) {
        this.priority = priority;
        this.code = code;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "priority=" + priority +
                ", code=" + code +
                '}';
    }

    public static Signal getSignal(){
        Random random = new Random();
        return new Signal(Priority.getPriority(random.nextInt(Priority.values().length)), random.nextInt(30));
    }



}
