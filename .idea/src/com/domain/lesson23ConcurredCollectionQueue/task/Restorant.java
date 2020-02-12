package com.domain.lesson23ConcurredCollectionQueue.task;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Restorant {
    public static void main(String[] args) {
        LinkedBlockingDeque<Order> orders = new LinkedBlockingDeque<>();

//        new Thread(new WriteSignals(signals)).start();
//        new Thread(new ReadSignals(signals)).start();
    }
}
class PutOrder implements Runnable{
    LinkedBlockingDeque<Order> orders;

    public PutOrder(LinkedBlockingDeque<Order> orders) {
        this.orders = orders;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Заказал "+ Thread.currentThread().getState());

            try {
                Thread.sleep(5000);
                Order order = Order.getOrder();
                orders.put(order);
                System.out.println("Заказал "+ order);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
class Client{

}
class Oficiant{

}
class Cooker{

}
class Order{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                '}';
    }
    public static Order getOrder(){
       Random random = new Random();
       Order order = new Order();
       order.setName("order" + random.nextInt(30));
       return  order;
    }
}