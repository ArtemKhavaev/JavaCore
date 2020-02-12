package com.domain.lesson8Static.finaloperator;

public class Writer {

    public final String ip = "444.444.444"; // final  в переменной не даст изменить ее в дальнейшем (значение присваивается при инициализации или в конструкторе)

    public Writer(final String ip) {//внутри метода нельзя поменять ip изза final
       // this.ip = ip

    }

    public final void sendMassage(final Massage massage){ //final в названии метода- не даст переопределить метод

       // massage = new Massage("e", "a", "djdjdj"); так  нельзя изза final
        massage.from = "newfrom";

        System.out.println("Send massage..." + "from: "+ massage.getFrom() + " to: " + massage.getTo() +  " " + massage.getDateSend());
    }
}
