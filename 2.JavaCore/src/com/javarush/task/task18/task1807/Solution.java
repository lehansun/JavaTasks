package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        final int COMMA = 44;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            if (inputStream.read() == COMMA) {
                result++;
            }
        }
        System.out.println(result);
        inputStream.close();
    }
}
