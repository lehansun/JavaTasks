package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();//напишите тут ваш код
        map.put("Смирнов", "Александр");
        map.put("Смирнов", "Андрей");
        map.put("Сидоров", "Станислав");
        map.put("Петров", "Валерий");
        map.put("Иванов", "Иван");
        map.put("Иванова", "Наташа");
        map.put("Сидорова", "Лера");
        map.put("Крюков", "Стас");
        map.put("Чечваркин", "Кирилл");
        map.put("Потемкин", "Александр");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
