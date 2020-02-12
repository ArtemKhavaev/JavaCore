package com.domain.lesson27BuilderListenerPrototypeCommand.listener;

import java.util.ArrayList;

public class Agency {
    private ArrayList<Listener> listeners = new ArrayList<>();
    public void addlistener(Listener listener){
        listeners.add(listener);
    }
    public void deleteListener(Listener listener){
        listeners.remove(listener);
    }

    public void notifyListeners(String data){
        for (Listener listener: listeners){
            listener.publish(data);
        }
    }
    public void someChanges(String data){
        System.out.println("изм. в объекте: " + data);
        notifyListeners(data);
    }

    public static void main(String[] args) {
        Agency agency = new Agency();

        Listener listener1 = new Listener() {// АНОНИМНЫЙ КЛАСС
            @Override
            public void publish(String data) {
                System.out.println("listener1 получил " + data);
            }
        };
        agency.addlistener(listener1);
        Listener listener2 = new Listener() {
            @Override
            public void publish(String data) {
                System.out.println("listener2 получил " + data);
            }
        };
        agency.addlistener(listener2);
        agency.someChanges("Изменения в agency");
    }
}
