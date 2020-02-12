package com.domain.lesson27BuilderListenerPrototypeCommand.listener.tasks;

import java.util.ArrayList;

public class Sensor {
    private ArrayList<Alarm> alarms= new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }
    public void deleteAlarm(Alarm alarm){
        alarms.remove(alarm);
    }
//    public void notifyAlarm(Alarm alarm){
//        alarm.tempChanged(int temp);
//    }
//
//    public static void main(String[] args) {
//        Sensor sensor = new Sensor();
//
//        Alarm green = new Alarm() {
//            @Override
//            public void tempChanged(int temp) {
//                if (temp > 100 &&)
//            }
//        };
//    }
}
