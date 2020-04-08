package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String result = outputStream.toString().replaceAll("[\\n\\r]", "");
        String[] data = result.split(" ");

        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[2]);
        int digit = 0;

        switch (data[1]) {
            case "+" :
                digit = a+b;
                break;
            case "-" :
                digit = a-b;
                break;
            case "*" :
                digit = a*b;
                break;
        }

        System.out.println(result + digit);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

