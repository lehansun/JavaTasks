package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        FileInputStream inputStream = new FileInputStream(fileName);
        int minimumBite = inputStream.read();
        do {
            int anotherBite = inputStream.read();
            if (minimumBite > anotherBite) {
                minimumBite = anotherBite;
            }
        } while (inputStream.available() > 0);

        System.out.println(minimumBite);
        inputStream.close();
    }
}
