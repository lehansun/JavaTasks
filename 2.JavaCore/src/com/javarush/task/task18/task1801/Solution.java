package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        FileInputStream inputStream = new FileInputStream(fileName);
        int maxBite = 0;

        while (inputStream.available() > 0) {
            System.out.println(inputStream.read());
        }
        inputStream.close();
    }
}
