package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
//      D:\\Алексей\\test1.txt

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()) {
            System.out.println(reverse(fileReader.readLine()));
        }
        fileReader.close();
    }

    private static String reverse(String str) {
        char[] data = str.toCharArray();
        char[] result = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            result[i] = data[data.length-1-i];
        }
        return new String(result);
    }
}
