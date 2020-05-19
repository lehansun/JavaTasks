package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filename);
        HashMap<Integer, Integer> repeats = new HashMap<>();

        while (inputStream.available() > 0) {
            int bite = inputStream.read();
            repeats.putIfAbsent(bite, 0);

            if (repeats.containsKey(bite)) {
                int value = repeats.get(bite)+1;
                repeats.replace(bite, value);
            }
        }

        int mostFrequentValue = mostFrequentValue(repeats);

        for (Map.Entry<Integer, Integer> pair : repeats.entrySet()) {
            int key = pair.getKey();
            int value = pair.getValue();
            if (value == mostFrequentValue) {
                System.out.print(key + " ");
            }
        }

        inputStream.close();


    }

    private static Integer mostFrequentValue(HashMap<Integer, Integer> map) {
        int mostFrequentValue = 0;

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int value = pair.getValue();

            if (mostFrequentValue == 0) {
                mostFrequentValue = value;

            } else {
                if (value > mostFrequentValue) {
                    mostFrequentValue = value;
                }
            }
        }

        return mostFrequentValue;
    }
}
