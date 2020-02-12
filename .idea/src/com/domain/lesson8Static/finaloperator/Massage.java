package com.domain.lesson8Static.finaloperator;

import java.time.LocalDateTime;

final public class Massage {// final- запрещает дальнейшее наследование для класса (создание дочерних классов)
    public   String from;
    private String to;
    private String text;
    private LocalDateTime dateSend;


     public  Massage(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        dateSend = LocalDateTime.now(); // для работы с датой и временем начиная с 8 версии
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }
}
