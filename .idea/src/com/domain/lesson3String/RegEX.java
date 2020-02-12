package com.domain.lesson3String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEX {
    public static void main(String[] args) {
        // регулярное выражение - набор символов,шаблон
        // Pattern & Matcher

        String regExp = "Java Junior";
        String someStr = "Java Junior";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(someStr);

        System.out.println( matcher.matches()); // вернет тру если вся строка соответствует регулярному выражению


        someStr = "Java Junior Developer";
        pattern = Pattern.compile("developer$", Pattern.CASE_INSENSITIVE); //поиск ез учета регистра
        matcher = pattern.matcher(someStr);

        // вернет тру если в строке есть подстрока, удовлетворяющая регулярному выражению
        System.out.println(matcher.find());

        someStr = "Java Junior Developer";
        pattern = Pattern.compile("[A-Z0-9]");
        pattern = Pattern.compile("[ert]"); // ищет опред символы в строке
        matcher = pattern.matcher(someStr);

        while (matcher.find()) System.out.println(matcher.group());

        // a.+o
        System.out.println(" жадный поиск");
        someStr = "Java Junior Developer";
        pattern =  Pattern.compile("a.+0"); // жадный поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group()); // ava Junior Develo

        System.out.println(" ленивый поиск");
        someStr = "Java Junior Developer";
        pattern =  Pattern.compile("a.+?0"); // ленивый поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());    // ava Junio

        System.out.println(" сверхжадный поиск");
        someStr = "Java Junior Developer";
        pattern =  Pattern.compile("a.++0"); // сверхжадный поиск
        matcher = pattern.matcher(someStr);
        while (matcher.find()) System.out.println(matcher.group());    // всегда  будет фолс




        // группировка и опережающие ретроспективные проверки

        someStr = "NJVNVJFJDvjksskdvskdv./?09983439583910";
        regExp = "(?=.*[0-9])(?=.*[,/?])(?=.*[A-Z])[0-9A-Za-z./?]{3,}";
        pattern = Pattern.compile(regExp);
        matcher = pattern.matcher(someStr);
        //System.out.println(matcher.find());
        while (matcher.find()) System.out.println(matcher.group());
        // ?= -опережающая проверка

        // для email


        // найти все предложения в тексте (начинаются с заглавной заканчиваются на . ? !
        regExp="[A-Z].+?[?.1]";
        // найти все слова на f
        regExp="^f.*\b";
        // найти все слова ( 5-8 символов)на f
        regExp="^f(.*\\b){5,8}";
        // найти  номер телефона в формате +7ххх-ххх-хх-хх
        regExp="^+7[0-9]{3}-[0-9]{3}-[0-9]{3}-[0-9]{3}";




        //ДОМА !!!! имеется 2 строки . Найти количество вхождений однойстроки в другую

        // даны два слова , состоящие из четного количества букв. Нужно составить третье слово из 1 половины 1 го и второй половины второго

        // Найти самое длинное слово предложении (все слова разной длинны)
    }
}
