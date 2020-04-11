package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(file));
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] data = reader.readLine().split(" ");
            Double number = Double.parseDouble(data[1]);

            map.merge(data[0], number, (a,b) -> b + map.get(data[0])); //запись эквивалентна закоментированному коду
//            if (map.containsKey(data[0])) {
//                Double result = map.get(data[0]) + number;
//                map.put(data[0], result);
//            } else {
//                map.put(data[0], number);
//            }
        }

        reader.close();

        map.forEach((a,b) -> System.out.println(a + " " + b)); //запись эквивалентна закоментированному коду
//        for (Map.Entry<String, Double> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }
}
