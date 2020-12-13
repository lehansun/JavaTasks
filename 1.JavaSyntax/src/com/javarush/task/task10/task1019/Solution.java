package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        String line;

        while (!(line = reader.readLine()).equals("")) {
            map.put(reader.readLine(), Integer.parseInt(line));
        }

        map.forEach( (k,v) -> System.out.println(v + " " + k));
    }
}
