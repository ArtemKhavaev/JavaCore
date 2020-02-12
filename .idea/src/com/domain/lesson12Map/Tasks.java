package com.domain.lesson12Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tasks {
    public static void main(String[] args) {
        // map хранит логин и город
        // написать методб кот.принимает на вх. мапу и город
        // и формирует список логинов, кот. соотв. переданному городу
      // String city;
        // \\p{Punct} ""

        HashMap<String, String> map = new HashMap<>();
        map.put("qwe", "Тамбов");
        map.put("qdf", "Тамбов");
        map.put("dfe", "Тамбов");
        map.put("rty", "Москва");
        map.put("fgh", "Магадан");
        String city = "Тамбов";

        System.out.println(getPeopleByCity(map, city));

    }
    public static List<String >getPeopleByCity(Map <String, String> map, String city){
        List <String> logins = new ArrayList<>();
        for(Map.Entry<String, String> entry: map.entrySet()){
            if(entry.getValue().equals(city)){
                logins.add(entry.getKey());
            }
        }
        return logins;
    }
}
