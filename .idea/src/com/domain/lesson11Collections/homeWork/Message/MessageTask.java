package com.domain.lesson11Collections.homeWork.Message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        int countLow = 0;
        int countMedium = 0;
        int countHigh = 0;
        int countUrgent = 0;
        for(Message mes: messageList){
            if(mes.getPriority().equals(MessagePriority.LOW))countLow++;
            if(mes.getPriority().equals(MessagePriority.MEDIUM))countMedium++;
            if(mes.getPriority().equals(MessagePriority.HIGH))countHigh++;
            if(mes.getPriority().equals(MessagePriority.URGENT))countUrgent++;
        }
        System.out.println("Количество сообщений по приоритетам:");
        System.out.printf("LOW: %d\n", countLow);
        System.out.printf("MEDIUM: %d\n", countMedium);
        System.out.printf("HIGH: %d\n", countHigh);
        System.out.printf("URGENT: %d\n", countUrgent);
        //  Ответ в консоль
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        for(Message mes: messageList){
            if(mes.getCode() == 0)count0 ++;
            if(mes.getCode() == 1)count1 ++;
            if(mes.getCode() == 2)count2 ++;
            if(mes.getCode() == 3)count3 ++;
            if(mes.getCode() == 4)count4 ++;
            if(mes.getCode() == 5)count5 ++;
            if(mes.getCode() == 6)count6 ++;
            if(mes.getCode() == 7)count7 ++;
            if(mes.getCode() == 8)count8 ++;
            if(mes.getCode() == 9)count9 ++;
        }
        System.out.println("Количество сообщений по коду:");
        System.out.printf("0 : %d\n", count0);
        System.out.printf("1 : %d\n", count1);
        System.out.printf("2 : %d\n", count2);
        System.out.printf("3 : %d\n", count3);
        System.out.printf("4 : %d\n", count4);
        System.out.printf("5 : %d\n", count5);
        System.out.printf("6 : %d\n", count6);
        System.out.printf("7 : %d\n", count7);
        System.out.printf("8 : %d\n", count8);
        System.out.printf("9 : %d\n", count9);

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messageHashSet = new HashSet<>(messageList);
        System.out.println("Количество уникальных элементов: " + messageHashSet.size());//количество уникальных сообщений = размер коллекции HashSet где все элементы уникальны
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> messageLinkedHashSet = new LinkedHashSet<>(messageList);
        LinkedList<Message>messageList2 = new LinkedList<>(messageLinkedHashSet);
        return messageList2;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        List<Message> removeList = new ArrayList<>(messageList);
        for(Message mes: messageList){
            if(mes.getPriority().equals(priority))removeList.remove(mes);
        }
        System.out.println("Список сообщений ДО удаления:");
        System.out.println(messageList);
        System.out.println("Список сообщений ПОСЛЕ удаления:");
        System.out.println(removeList);


    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        List<Message> removeList = new ArrayList<>(messageList);
        for(Message mes: messageList){
            if(!(mes.getPriority().equals(priority)))removeList.remove(mes);
        }
        System.out.println("Список сообщений ДО удаления:");
        System.out.println(messageList);
        System.out.println("Список сообщений ПОСЛЕ удаления:");
        System.out.println(removeList);
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(34);//генерация сообщений
        System.out.println(messages); // вывод исх. коллекции сообщений
        countEachPriority(messages); // статистика сообщений по приоритету
        countEachCode(messages);// статистика сообщений по коду
        uniqueMessageCount (messages);// статистика уникальных сообщений
        System.out.println(uniqueMessagesInOriginalOrder(messages));// вывод уникальных сообщений в изначальном порядке

        System.out.println("------Удаление сообщений с заданным приоритетом--------");
        Scanner in = new Scanner(System.in);
        System.out.println("введите приоритет");
        switch (in.nextLine()){
            case "LOW":
                removeEach(messages, MessagePriority.LOW);break;
            case "MEDIUM":
                removeEach(messages, MessagePriority.MEDIUM);break;
            case "HIGH":
                removeEach(messages, MessagePriority.HIGH);break;
            case "URGENT":
                removeEach(messages, MessagePriority.URGENT);break;
            default:
                System.out.println("приоритет задан неверно");
        }

        System.out.println("------Удаление сообщений кроме тех, что с заданным приоритетом--------");
        System.out.println("введите приоритет");
        switch (in.nextLine()){
            case "LOW":
                removeOther(messages, MessagePriority.LOW);break;
            case "MEDIUM":
                removeOther(messages, MessagePriority.MEDIUM);break;
            case "HIGH":
                removeOther(messages, MessagePriority.HIGH);break;
            case "URGENT":
                removeOther(messages, MessagePriority.URGENT);break;
            default:
                System.out.println("приоритет задан неверно");
        }

    }


}
