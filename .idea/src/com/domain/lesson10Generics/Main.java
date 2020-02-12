package com.domain.lesson10Generics;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> LinkedList = new LinkedList<>();
        LinkedList.add("string 1");
        LinkedList.add("string 2");
        LinkedList.add("string 3");

        System.out.println(LinkedList.get(2));


        Transport transport1 = new Transport("Moscow", "Twer", "1241");
        Transport transport2 = new Transport("Piter", "Tombov", "43241");
        LinkedList<Transport> transportList = new LinkedList<>();
        transportList.add(transport1);
        transportList.add(transport2);

        Bus bus = new Bus("Samara", "Rayzan", "213143", true);
        transportList.add(bus);

        Transport transportFromList = transportList.get(1);
        // ClassCastExeption
//        Bus busFromList = (Bus)transportList.get(2);
        // busFromList.isWiFi();





    }

    public static Bus getFirst(LinkedList<? extends Transport> list){// можем получить!! объекты транспорта, но не можем добавить

        Transport transport = new Transport("Samara", "Rayzan", "213143");
       // list.add(bus); не можем  из-за несовпадения типов
        list.add(null);
        Transport  transport1 = list.get(2);

        return (Bus) list.get(0);

    }

    public void addToList(LinkedList<? super Transport> list){

        Bus bus = new Bus("Samara", "Rayzan", "213143", true);
        list.add(bus);

        // не можем получить Transport transport1 = list.get(2);
        // ну или только через приведение CastExeption
        Transport transport1 =(Transport) list.get(2);


    }
}
