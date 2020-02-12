package com.domain.lesson11Collections.enums;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User ();
        user.setLogin("qwe");
        user.setPwd("123");
        user.setRole (Role.ADMIN);

        System.out.println(Role.valueOf("ADMIN"));
        System.out.println(Arrays.toString(Role.values()));

        Operations operation = Operations.MULTI;
        System.out.println(operation.action(2, 3));
        Operations operation1 = Operations.SUM;
        System.out.println(operation1.action(2, 9));

        System.out.println(Priority.HIGH.getCode());
        System.out.println(Priority.LOW.getCode());

    }
}

enum  Role{
    USER, ADMIN;
}

enum Operations{
    SUM {
        public int action(int a, int b){
            return a + b;
        }
    },
    MULTI{
        public int action(int a, int b){
            return a * b;
        }
    };
    abstract  public int action (int a, int b);
}

enum Priority{
    HIGH(9), MIDDLE(6), LOW(3);
    private int code;

    Priority (int code){
        this.code = code;

    }

    public int getCode() {
        return this.code;
    }
}