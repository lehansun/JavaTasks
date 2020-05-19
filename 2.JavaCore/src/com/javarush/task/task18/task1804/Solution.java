package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();

        FileInputStream inputStream = new FileInputStream(filePath);
        HashMap<Integer, Integer> bites = new HashMap<>();

        while (inputStream.available() > 0) {
            int bite = inputStream.read();
            bites.putIfAbsent(bite, 0);

            int value = bites.get(bite) + 1;
            bites.replace(bite, value);
        }

        inputStream.close();

        int minValue = Collections.min(bites.values());

        bites.forEach((k,v) -> {
            if (v == minValue) System.out.print(k + " ");
        });

        inputStream.close();
        scanner.close();
    }

}
