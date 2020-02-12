package com.domain.lesson25MTClasses;

import java.util.concurrent.Exchanger;

public class ExchangeExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new Make(exchanger)).start();
        new Thread(new Use(exchanger)).start();
    }
}

class Make implements Runnable{
    private Exchanger <String> stringExchanger;
    private String string;

    public Make(Exchanger<String> stringExchanger) {
        this.stringExchanger = stringExchanger;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i ++){
            string =  "Make created string "+ 1;
            try {
                string  = stringExchanger.exchange(string);
                System.out.println("make got string " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Use implements Runnable{
    private Exchanger <String> stringExchanger;
    private String string;

    public Use(Exchanger<String> stringExchanger) {
        this.stringExchanger = stringExchanger;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                string  = stringExchanger.exchange(string);
                System.out.println("make got string " + string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}