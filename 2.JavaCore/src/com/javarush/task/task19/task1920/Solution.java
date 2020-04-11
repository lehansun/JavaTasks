package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> map = new TreeMap<>();

        while (reader.ready()) {
            String[] data = reader.readLine().split("\\s");
            Double number = Double.parseDouble(data[1]);

            map.merge(data[0], number, (a, b) -> map.get(data[0]) + b);
        }

        reader.close();

        Double max = Collections.max(map.values());
        map.forEach((a,b) -> {
            if (b.equals(max)) {
                System.out.println(a);
            }
        });
    }
}
