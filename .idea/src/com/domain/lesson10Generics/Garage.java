package com.domain.lesson10Generics;

public class Garage <T extends Bus> {

    private T bus;

    public Garage (T bus){
        this.bus = bus;
    }

    public T makeDefault (){
        bus.setDepartureSt("Moscow");
        bus.setDestSt ("SPb");
        bus.setNum("12314");
        bus.setWiFi(false);
        return bus;
    }


}
