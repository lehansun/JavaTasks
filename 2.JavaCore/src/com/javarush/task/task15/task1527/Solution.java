package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        reader.close();

        String line = url.split("\\?")[1];
        String[] parameters = line.split("&");

        String object = null;
        StringBuilder result = new StringBuilder();

        for (String str : parameters) {
            if (str.contains("=")) {
                result.append(str.split("=")[0]).append(" ");
                if (str.split("=")[0].equals("obj")) {
                    object = str.split("=")[1];
                }
            } else {
                result.append(str).append(" ");//add your code heres
                if (str.equals("obj")) {
                    object = str;
                }
            }
        }
        System.out.println(result.toString().trim());

        if (object != null) {
            Pattern digit = Pattern.compile("\\d+\\.?\\d*");
            Matcher matcher = digit.matcher(object);
            if (matcher.matches()) {
                alert(Double.parseDouble(object));
            } else {
                alert(object);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
