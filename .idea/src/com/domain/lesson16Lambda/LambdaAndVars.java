package com.domain.lesson16Lambda;

public class LambdaAndVars {
    static int  a = 12;
    static  int b  = 22;
    public static void main(String[] args) {
        int n = 10, m = 20;

        Message message = new Message("message");
        SomeInterface someInterface = (x, y) -> {// не можем исп в качестве аргументов n m
            message.setText("new message");
            return n + m;
        };
        System.out.println(someInterface.doSomething(9, 0 ));

    }
}
@FunctionalInterface
interface SomeInterface {
    int doSomething(int x, int y);
        }

        class Message{
    String text;

            public Message(String text) {
                this.text = text;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }
        }
