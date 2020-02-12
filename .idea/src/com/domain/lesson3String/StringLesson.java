package com.domain.lesson3String;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringLesson {
    public static void main(String[] args) {
        /*
        Строки
        до 9 версиии - массив char
        каждый символ 2 байта
        кодировка UTF 16

        начиная с 9 версии - компактные строки
        строки хранятся как массив byte []
        LATYN-1  если хватает
        UTF -16  если не хватает
        при сохранении строки сохраняется еще и тип кодировки byte coder;
        byte LATIN1 = 0;
        byte UTF16 = 1;

        Строки в JAVA  неизменны и потокобезопасны
         */

        char []charsArr = {'j', 'a', 'v', 'a'};
        String str = new String(charsArr);
        String str1 = "Java"; // создавать так строка хранится в пуле строк
        String str2 = new String("Java"); // так не создавать строка хранится в куче
        String str3 = "Java"; // в пуле хранятся уникальные строчки, такая строка уже есть, поэтому здесь будет ссылка
        String str4 = str2.intern();// создает в пуле новую строку(для str2) если она уникальна, если не уникальна- то возвращает ссылку на нее


        str3.codePoints().forEach(System.out::println);

        //методы:
        //количество символов в строке
        System.out.println("количество символов в строке " + str3.length());

        // сравнение строк
        str = "JAVA";
        str1 = "Java";
        System.out.println(str.equals(str1));// false возвращает ттру если строчки одинаковы, через = не сравнивать
        System.out.println(str.equalsIgnoreCase(str1));// ,без учета регистра- true

        int compareRes = str.compareTo(str1);
        System.out.println("compareTo "+ compareRes);//-32

        compareRes = str.compareToIgnoreCase(str1);
        System.out.println("compareToIgnoreCase "+ compareRes);//0

        /* возвращает 0 -если строки равны
        положит.цел.число - если первая строка следует за второй
        отрицательное цел.число -если первая строка предшествует второй

        целое число-разница между номерами символов UTF-16 проверяется до первого различия
         */


        // поиск в строке
        System.out.println(str.startsWith("JA")); // false ищет с начала строки
        System.out.println(str.endsWith("b")); // false ищет с конеца строки

        // idexOf ("символ") - для поиска первого вхождения указанного символа либо подстроки (вернет индекс)
        // lastIndexOf - для поиска последнего вхождения указанного символа либо подстроки (вернет индекс)
        // -1  возвращает, если не нашел
        System.out.println(str.indexOf("v"));
        System.out.println(str.indexOf("v", 2)); // ищет после указанного индекса

        str = "Java Junior Developer";
        str1 = "Java";
        System.out.println(str.contains(str1)); // true
        System.out.println(str1.contains(str)); // false

       /* модификация строк
                при модификации будет создана новая строка*/

               // toLowerCase() - в нижний регистр
                String lowerStr = str.toLowerCase();

                // toUpperCase() -  в верхний регистр
                // trim() - убирает  пробелы
                 // reverse () - переворачивает строки
        str = "Java Junior Developer";
        str1 = "Java";
        String newStr = str.replace("Junior", " ");
        System.out.println(newStr); // не подходитдля регулярных выражений

       // String newStr = str.replace("v", "V");
        System.out.println(newStr);


        str = "Java Junior Developer";
        // разбивает строку возвращает массив
        String [] strins  = str.split("\\s");
        System.out.println(Arrays.toString(strins));

        // взятие подстроки
        // substring(int begin, int end) начало включительно, конец- нет
        // substring(int begin)


        // конкатенация строк     //не использовать в циклах!!
        String concatString = "java" + " Developer";
        System.out.println(concatString);
        // метод работает по другому!!! не использовать в циклах!!
        concatString = concatString.concat("Developer").concat("!");
        System.out.println(concatString);

        str = "String";
        for (int i = 0; i < 7; i++) {
            str += " iteration " + i; // на каждой итерации создается нов. объект
        }

        //классы для работы со строками без создания объекта и возможностью изменения
        // StringBuilder -работает быстрее но не потокобезопасен (для однопоточных прил)
        // StringBuffer - работает медленее но потокобезопасен (для  многопоточных прил)

        str= "String";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i = 0; i < 7 ; i++) {
            stringBuilder.append(" iteration ").append(i);// так новый объект не создается
        }
        str = stringBuilder.toString();// обратное преобразование строки

        // объединение строк
        StringJoiner joiner = new StringJoiner(", "); // joiner - не тип String !!!
        joiner.add("one");
        joiner.add("two");

        String joinString = joiner.toString();
        System.out.println(joinString); // или System.out.println(joiner.ToString());

        System.out.println(String.join(": ", "One", "Two"));

        // текстовые блоки  JAVA 13
       /* String textBlock = """
                строка " в кавычках"

                с переносами


                """;
                System.out.println(textBlock);
                */
       // работа с чар
        System.out.println('a'+'a');
        System.out.println('б'-'a');
        System.out.println('б'+'a');
        System.out.println(+'с');



    }
}
