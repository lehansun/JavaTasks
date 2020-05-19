package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] fileName = new String[2];

        for (int i = 0; i < 2; i++) {
            fileName[i] = scanner.next();
        }
        FileInputStream inputStream = new FileInputStream(fileName[0]);
        FileOutputStream outputStream = new FileOutputStream(fileName[1]);
        Stack<Integer> stack = new Stack<>();

        while (inputStream.available() > 0) {
            stack.push(inputStream.read());
        }
        while (!stack.empty()) {
            outputStream.write(stack.pop());
        }

        inputStream.close();
        outputStream.close();
    }
}
