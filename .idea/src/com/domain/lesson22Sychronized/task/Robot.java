package com.domain.lesson22Sychronized.task;

//public class Name {
//    volatile boolean currenName = true;
//    class Name implements Runnable{
//        String name;
//        boolean leg;
//
//        public Name(String name, boolean leg) {
//            this.name = name;
//            this. leg = leg;
//        }
//        public void step(){
//            System.out.println(name);
//
//        }
//
//        @Override
//        public void run (){
//            while (true){
//                if (name == currentName){
//                    step();
//                    currentName = !name;
//                    Thread.yield();//ставит текущий поток на паузу и передает управление др. случайному потоку c  приоритетом выше текущего
//
//                }
//            }
//        }
//    }
//
//    public static void main (String []args){
//        Name name1 = new Name ("1", false);
//        Name name2 = new Name ("2", true);
//        new Name(new Thread(name1).start());
//        new Name(new Thread(name1).start());
//    }
//
//}
