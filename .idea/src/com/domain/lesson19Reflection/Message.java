package com.domain.lesson19Reflection;

import java.time.LocalDateTime;

public class Message {
    public String title;
    protected LocalDateTime sent;

    public Message(String title) {
        this.title = title;
        sent = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent(LocalDateTime sent) {
        this.sent = sent;
    }

    public  void printTitle(){
        System.out.println("Тема сообщения: "+ this.title);
    }

    public  void printTitle(String data){
        System.out.println("Тема сообщения: "+ data);
    }

}

