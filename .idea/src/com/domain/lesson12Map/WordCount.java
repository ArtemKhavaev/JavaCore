package com.domain.lesson12Map;
import java.io.*;
import java.nio.file.Files;
import java.util.*;


class WordCount {

    public static void main(String[] args) throws  IOException {


        File file1 = new File("resource/wp.txt");
        List<String> strings = Files.readAllLines(file1.toPath());

        ArrayList<String>words = new ArrayList<>();// хранит все слова из файла без сортировки

        for (String iteratedString: strings){
           String tempString1= iteratedString.replaceAll("\\p{P}", " ");// заменяет символ на пробел
            String tempString= tempString1.replaceAll("\\d", " ");//заменяет цифры на пробел
           String [] tempList = tempString.split(" ");
           for (int i = 0; i < tempList.length; i++){
               words.add(tempList[i].trim());
           }
        }

        // частота встречаемости слов
        Map <String, Integer>  mapWords= new TreeMap<>();// хранит уникальные слова из файла в алф.порядке, а также инфу о количестве этих слов

        for (String word: words){
            mapWords.put(word, 1);
        }
        for (String word: words){
            if(mapWords.get(word) != null) {
                int count = mapWords.get(word) + 1;
                mapWords.put(word, count);
            }
        }
        System.out.println("частота встречаемости слов в файле:");
        for (Map.Entry<String, Integer> entry: mapWords.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() );
        }


        // сортировка слов по количеству символов
        System.out.println("сортировка слов по количеству символов");
        Map <String,Integer>  mapWordGroupLength= new TreeMap<>();// новая мапа: ключ- слово, значение - кол-во символов
        for (String word: words){
             mapWordGroupLength.put(word, word.length());
        }

        int maxVal = 0;// определяем максимальное значение Value (слово с наибольшим количеством символов)
        for (Map.Entry<String, Integer> entry: mapWordGroupLength.entrySet()){
            if (entry.getValue() > maxVal) maxVal = entry.getValue();
        }

        for (int k = 1; k < maxVal; k ++){
            System.out.println(); // выводим сначала все слова с 1 символом, потом с 2-мя, и т.д. до maxVal
            System.out.println(k + " :");
            for (Map.Entry<String, Integer> entry3: mapWordGroupLength.entrySet())
            if (entry3.getValue() == k)System.out.print(entry3.getKey() + ", ");
        }


        // топ 10 слов по частоте встречаемости:
        System.out.println();
        System.out.println();
        System.out.println("топ 10 слов по частоте встречаемости:");

        Map <Integer, String>  topMap= new TreeMap<>();

        for (Map.Entry<String, Integer> entry3: mapWords.entrySet()){
            topMap.put(entry3.getValue(), entry3.getKey());
        }
        int top [] = new int [11];
        for (Map.Entry<Integer, String> entry4: topMap.entrySet()){
            for (int i = 10; i > 0 ; i--) top[i] = top[i-1];
            top[0] = entry4.getKey();
        }
        for (int i = 1; i < 10; i++) {
            System.out.println(top[i] + " : " + topMap.get(top[i]));
        }

        // частота встречаемости букв
        Map <String, Integer>  mapChar= new TreeMap<>();
        ArrayList<String>chars = new ArrayList<>();

        for (String iteratedString: strings){
            String tempString1= iteratedString.replaceAll("\\p{P}", " ");
            String tempString2= tempString1.replaceAll("\\d", " ");
            String tempString3= tempString2.replaceAll("\\W", " ");
            String tempString4= tempString3.toLowerCase();
            String tempString= tempString4.replaceAll("\\s", "");
            String [] tempList = tempString.split("");
            for (int i = 0; i < tempList.length; i++){
                chars.add(tempList[i].trim());
            }
        }

        for (String char1: chars){
            mapChar.put(char1, 1);
        }
        for (String char1: chars){
            if(mapChar.get(char1) != null) {
                int count = mapChar.get(char1) + 1;
                mapChar.put(char1, count);
            }
        }
        int maxValChar = 0;
        for (Map.Entry<String, Integer> entry: mapChar.entrySet()){
            if (entry.getValue() > maxValChar) maxValChar = entry.getValue();
        }
        System.out.println("частота встречаемости букв в файле:");
        for (Map.Entry<String, Integer> entry5: mapChar.entrySet()){
            System.out.println(entry5.getKey() + " : " + Math.round((double)(entry5.getValue())/maxValChar*100) + " % " );
        }












    }
}

