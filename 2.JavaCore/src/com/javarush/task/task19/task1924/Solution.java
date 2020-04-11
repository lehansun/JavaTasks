package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
//        D:\\Алексей\\test1.txt

        BufferedReader fileReader = new BufferedReader(new FileReader(file));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split("\\s");
            StringBuilder newLine = new StringBuilder();

            for (String word : words) {
                if (word.matches("\\d+")) {
                    int number = Integer.parseInt(word);
                    newLine.append(map.getOrDefault(number, word)).append(" ");
                } else {
                    newLine.append(word).append(" ");
                }
            }

            System.out.println(newLine.toString());
        }

        fileReader.close();
    }
}
