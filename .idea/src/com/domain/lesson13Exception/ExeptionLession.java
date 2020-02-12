package com.domain.lesson13Exception;

public class ExeptionLession {
    public static void main(String[] args) {
        int a = 9;
        int b = 0;
//        System.out.println(a / b );   //ArithmeticException

        int [] arr = new int[2];
//        arr[10] = 44;    //ArrayIndexOutOfBoundsException

        String string = null;
//        string.equals("str");   //NullPointerException
        "str".equals(string); // делай так

//        Integer.parseInt("string"); //NumberFormatException в аргументе д.б инт-число

        Object someData = "123";
//        Integer someInt = (Integer) someData; //ClassCastException

        // try catch обернуть кусок кода в котором м.б. ошибка
        try{
            Integer someInt = (Integer) someData;
            System.out.println( "code after ClassCastException");

        } catch (ClassCastException e){
            System.out.println("catch ClassCastException");
            e.printStackTrace();// выводит оригинальный текст сообщения
        }
        System.out.println("code after try catch");

        // объединение catch - блоков
        try{

        }catch(ClassCastException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        // 2 вариант
        try{

        }catch (ClassCastException | ArithmeticException e){
            e.printStackTrace();
        }

        // 3 вариант (через общий тип данных)
        try{

        }catch (RuntimeException e){
            e.printStackTrace();
        }


        try{

        }catch (ClassCastException | ArithmeticException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }



        finally {// код в этом блоке выполнится в любом случае даже если программа сломается в пердыдущем коде(исп.для высвобождения ресурсов)


        }

        // Exception - ошибки компиляции (нужно обрабатывать)
        // RuntimeException - ошибки выполнения (не обязательно обрабатывать)





    }
}
