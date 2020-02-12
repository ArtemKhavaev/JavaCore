package com.domain.lesson13Exception.HomeWork;

import java.util.Scanner;

public class Calc {
    public static String userIn  () throws CheckedException {
        System.out.println("Введите выражение");
        Scanner in = new Scanner(System.in);  // полььзовательский ввод
        String userExp = in.nextLine().toLowerCase();
        if (userExp == null || userExp.trim().length() > 4) {
                    throw new CheckedException("неверное количество символов");
                }
        if (!("exit".equalsIgnoreCase(userExp))&& (userExp.trim().length() == 4)) {
            throw new CheckedException("неверный ввод");
        }
        return  userExp;
    }

    public static UserExp splitter(String userInStr)throws CheckedException {
        String[] expChar = userInStr.split(""); //захват символов в массив

        if (!(expChar[1] != "+"||expChar[1] != "-"||expChar[1] != "*"||expChar[1] != "/"))  {
            throw new CheckedException("не корректный символ оператора!!!");
        }

        try {


            int n = Integer.parseInt(expChar[0]);
            int m = Integer.parseInt(expChar[2]);
            String o = expChar[1];
            UserExp expression = new UserExp(n, o, m);
            return expression;
        }catch (NumberFormatException e){
            System.out.println("не цифровой символ операнда!!!");
        }
        return null;


    }

    public static void main(String[] args) throws CheckedException {
        String userExp = null;
        while (!("exit".equalsIgnoreCase(userExp))) {// будет просить ввести выражение пока не получит exit
            String userIn = userIn();
            if ("exit".equalsIgnoreCase(userExp))return;
            UserExp in = splitter(userIn);
            in.calculation();
        }
    }
}

class CheckedException extends Exception{
    public CheckedException(String message) {



        //super(message);
    }

//    public CheckedException(String message, Throwable cause) {
//        super(message, cause);
//    }
}

class UserExp {
    private int n;
    private int m;
    private String o;

    public UserExp(int n, String o, int m) {
        setN(n);
        setM(m);
        setO(o);
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setO(String o) {
        this.o = o;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public String getO() {
        return o;
    }

    public void calculation() {
        switch (o) {
            case "+": {
                System.out.println(" = " + (n + m));
                break;
            }
            case "-": {
                System.out.println(" = " + (n - m));
                break;
            }
            case "*": {
                System.out.println(" = " + (n * m));
                break;
            }
            case "/": {
                System.out.println(" = " + (n / m));
                break;
            }
        }

    }





}