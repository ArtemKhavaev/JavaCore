package com.domain.lesson12Map;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class MapLesson {
    public static void main(String[] args) throws IOException {
        User user1 = new User("awe", "123", User.Role.USER);
        User user2 = new User("awfgnfgn", "346", User.Role.ADMIN);
        User user3 = new User("agfnfgn", "154", User.Role.USER);
        User user4 = new User("agnfn", "346", User.Role.ADMIN);

        System.out.println("---HashMap----");
        // для объектов, которые используются в качестве ключей обязательно д.б. переопределены методы
        // equals hashCode, null м.б использован в качестве ключа
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(), user1);
        userHashMap.put(user2.getLogin(), user2);// добавление (ключ+значение)
        userHashMap.put(user3.getLogin(), user3);
        userHashMap.put(user4.getLogin(), user4);
        userHashMap.put(null, null);

        userHashMap.remove("awe");// удаление по ключю
        userHashMap.remove("hhhh");

        System.out.println(userHashMap);
        System.out.println(userHashMap.get("awe")); // вызов по ключю
        System.out.println(userHashMap.get("hhhh"));

        // перебор
        for (Map.Entry<String, User> entry: userHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() );
        }

        System.out.println("----EnumMap-----");
        // enum используется в качестве ключей
        // null нельзя исп. в качестве ключа
        EnumMap<User.Role, ArrayList<User>> enumMap = new EnumMap<>(User.Role.class);
        enumMap.put(User.Role.USER, new ArrayList<>(Arrays.asList(user1, user3)));
        enumMap.put(User.Role.ADMIN, new ArrayList<>(Arrays.asList(user2, user4)));

        System.out.println(enumMap.get(User.Role.USER));
        System.out.println(enumMap.get(User.Role.ADMIN));

        User user5 = new User("agfgjdnnfn", "366", User.Role.USER);
         enumMap.get(user5.getRole()).add(user5);



         WeakHashMap<Object, String> objectHashMap = new WeakHashMap<>();

         Object weakHashKey = new Object();
         String weakHashVal = "str";

       objectHashMap.put(weakHashKey,weakHashVal);

       weakHashKey = null;
       weakHashVal = null;

        System.out.println(objectHashMap);


        System.out.println("---TreeMap----");
        // основан на красно-черном дереве
        // сортировка по ключам
        // null не м.б исп в качестве ключа

        TreeMap<String, User> treeMap = new TreeMap<>();
        treeMap.put(user1.getLogin(), user1);
        treeMap.put(user2.getLogin(), user2);
        treeMap.put(user3.getLogin(), user3);
        System.out.println(treeMap);


        // считывание из файла:
//        ClassLoader loader = MapLesson.class.getClassLoader();
//        File file = new File(loader.getResource("wp.txt").getFile());

        File file1 = new File("resource/wp.txt");

        List<String> strings = Files.readAllLines(file1.toPath());
        // каждая строка файла - отдельный элемент списка




    }
}
