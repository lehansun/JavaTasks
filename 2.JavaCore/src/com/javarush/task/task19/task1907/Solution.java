package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        int count = 0;

//        "D:\\Алексей\\test1.txt"

        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader); //поскольку FileReader читает файл по одному символу, я использовал Scanner, который умеет читать файл сразу строками

        while (scanner.hasNext()) {
            String data = scanner.nextLine();
            String[] buffer = data.split("\\W"); //любой символ, кроме буквенного, цифрового или знака подчёркивания
            for (String testString : buffer) {
                if (testString.equals("world")) {
                    count++;
                }
            }
        }

        scanner.close();
        fileReader.close();

        System.out.println(count);
    }
}
