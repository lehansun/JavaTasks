package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        FileInputStream inputStream = new FileInputStream(filePath);
        TreeSet<Integer> bytes = new TreeSet<>();

        while (inputStream.available() > 0) {
            bytes.add(inputStream.read());
        }

        for (int value : bytes) {
            System.out.print(value + " ");
        }

        inputStream.close();
        reader.close();
    }
}
