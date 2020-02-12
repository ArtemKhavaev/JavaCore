package com.domain.lesson22Sychronized.homework;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class homework {
    //bufferMap -мапа, в которую собираем данные ( для объединения данных нескольких потоков)
    static Map<String, Integer> bufferMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        // 1. Создаем главный поток
        MainThread mainThread = new MainThread();
        mainThread.start();

    }

}
class MainThread extends Thread{


    @Override
    public void run(){
// 2. Определяем количество потоков
        int freeProc = (Runtime.getRuntime().availableProcessors() );
        System.out.println("количество доступных процессоров: " + freeProc);

        // 3. Определяем задачу каждому потоку (делим List строк на количество потоков , каждый поток получает свой диапазон строк листа)
        File file1 = new File("resource/wp.txt");
        List<String> strings = null;
        try {
            strings = Files.readAllLines(file1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numberStrings = strings.size();
        System.out.println("количество строк в файле: "+ numberStrings);
        int threadLimit = numberStrings/freeProc; // количество строк для обработки одному потоку
        System.out.println("количество строк для обработки одному потоку: "+ threadLimit);



        ArrayList<WorkThread>threads = new ArrayList<>();

        for (int j = 0; j < numberStrings; j += threadLimit ){// цикл работает скачками ( 1 скачок = диапазон значений List для потока)
            // количество скачков = количеству диапазонов = количеству потоков = количеству свободных процессоров
            if (j == 0 ) continue;
            ArrayList<String> str = new ArrayList<String>();
            for (int k =(j - threadLimit); k < j; k ++) {// внутри диапазона: строки принадлеж. диапазону  передаем в список строк str
                str.add(strings.get(k));

            }




            // 4. Создаем рабочий поток и передаем  список строк для обработки
            // создание потока в цикле -> т.о. потоков будет несколько, в зависимости на сколько частей программа поделит исх.текст(на основании данных о количестве свободных процессоров)

            threads.add(new WorkThread(str));

        }
        for (WorkThread thread: threads) {
            thread.start();
        }
        for (WorkThread thread: threads) {
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        print(homework.bufferMap);

    }


    public void print(Map <String, Integer> bufferMap){
        // topMap - для сортировки слов по частоте встречаемости
        Map <Integer, String>  topMap= new TreeMap<>();
        for (Map.Entry<String, Integer> entry3: bufferMap.entrySet()){
            topMap.put(entry3.getValue(), entry3.getKey());
        }
        //  т.к. в TreeMap  int-ключи будут расплогатся от меньшего к большему по возрастанию, а нам для топ-100 нужно наоборот, исп. след. код для инверсии
        int top [] = new int [101];
        for (Map.Entry<Integer, String> entry4: topMap.entrySet()){
            for (int i = 100; i > 0 ; i--) top[i] = top[i-1];
            top[0] = entry4.getKey();
        }
        for (int i = 1; i < 100; i++) {
            System.out.println(top[i] + " : " + topMap.get(top[i]));
        }
    }
}






class WorkThread extends Thread implements Runnable{
    ArrayList <String> str;
    WorkThread (ArrayList<String> str ){
        this.str  = str;
    }

    @Override
    public void run(){
        // поток создает список слов из текста с помощью регулярных выражений и String -методов
        ArrayList<String> words = new ArrayList<>();
        for (String iteratedString: str){

            String tempString1= iteratedString.replaceAll("\\p{P}", " ");// заменяет символ на пробел
            String tempString= tempString1.replaceAll("\\d", " ");//заменяет цифры на пробел
            String [] tempList = tempString.split(" ");
            for (int i = 0; i < tempList.length; i++){
                words.add(tempList[i].trim());
            }

        }
        // из списка слов создается мапа, у которой ключ - слово, значение - количество его повторов в тексте
        Map<String, Integer> mapWords= new TreeMap<>();
        for (String word: words){
            mapWords.put(word, 1);
        }
        for (String word: words){
            if(mapWords.get(word) != null) {
                int count = mapWords.get(word) + 1;
                mapWords.put(word, count);
            }
        }

        for (Map.Entry<String, Integer> entry: mapWords.entrySet()){
            if ((homework.bufferMap.containsKey(entry.getKey()))&&(true)){
                homework.bufferMap.put(entry.getKey(), (entry.getValue()+homework.bufferMap.get(entry.getKey())));

            }
            else homework.bufferMap.put(entry.getKey(), entry.getValue());
        }



    }
}