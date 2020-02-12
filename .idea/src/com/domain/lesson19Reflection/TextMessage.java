package com.domain.lesson19Reflection;

import java.io.Serializable;

public class TextMessage extends Message implements Serializable {
   private String text;

    public TextMessage(String title, String text) {
        super(title);
        this.text = text;
    }


    private String getMessageInfo () {
        return "Тема сообщения" + title + ".\n" +
                "Текст сообщения" + text +".\n" +
                "Отправлено"+ sent + ".\n";
    }

    static void someVoid(){
        System.out.println("some static void ");
    }
}
