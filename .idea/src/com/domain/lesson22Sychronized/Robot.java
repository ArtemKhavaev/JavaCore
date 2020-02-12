package com.domain.lesson22Sychronized;

public class Robot {
    volatile boolean currentLeg = true; // внешний ресурс  за который борятся потоки left & right
    // для кажд.потока создается кэшированное знач. переменной currentLeg
    // может возникнуть ситуация когда оба кэшированных значения true
    // для исключения этой ситуации (для атомарных операций) исп. кл. слово volatile
    // с кл. словом volatile потоки не создают кэшированные значения и обращаются к переменой напрямую
    class Leg implements Runnable{
        String name;
        boolean leg;

        public Leg(String name, boolean leg) {
            this.name = name;
            this. leg = leg;
        }
        public void step(){
            System.out.println(name);

        }

        @Override
        public void run (){
            while (true){
                if (leg == currentLeg){
                    step();
                    currentLeg = !leg;
                    Thread.yield();//ставит текущий поток на паузу и передает управление др. случайному потоку c  приоритетом выше текущего

                    /*
                    10 - самый высокий приоритет
                    5 - нормальный приоритет
                    1 -самый низкий приоритет

                    setPriority(int);
                    getPriority();
                    final static int MIN_PRIORITY = 1;
                    final static int NORM_PRIORITY = 5;
                    final static intMAX_PRIORITY = 10;
                    * */

                    //два потока по очереди выводят свое имя в консоль

                }
            }

        }



    }

    Leg left = new Leg ("left", false);
    Leg right = new Leg ("right", true);

    public void startRun(){
        new Thread(left).start();
        new Thread(right).start();
    }

    public static void main (String []args){
        new Robot().startRun();
    }

}
