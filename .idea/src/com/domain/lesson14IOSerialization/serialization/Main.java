package com.domain.lesson14IOSerialization.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args)  {


        // сериализация- преобразование объектов в последовательность байт
        // десериализация- наоборот
        // ObjectInputStream
        // ObjectOutputStream
/*
        File file = new File("stat.bin");
        LaunchStatistic statistic = null;
        if(!file.exists()){
            statistic = new LaunchStatistic();
        } else {
            // десериализация данных которые мы забрали из потока
            try (ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file))){
                statistic = (LaunchStatistic) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        if (statistic.isFirstLaunch()){
            System.out.println("First Launch");
        } else {
            System.out.println(statistic);
        }
        statistic.update();
        // сериализация (запись)
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutput.writeObject(statistic);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
        File file1 = new File("stat2.bin");
        LaunchStatisticExternalizable launch =null;
        if (!file1.exists()){
            launch = new LaunchStatisticExternalizable();
        } else {
            try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file1))){
                launch = (LaunchStatisticExternalizable) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        if (launch.isFirstLaunch()){
            System.out.println("First Launch");
        } else {
            System.out.println(launch);
        }
        launch.update();
        try (ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file1))){
            objectOutput.writeObject(launch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
