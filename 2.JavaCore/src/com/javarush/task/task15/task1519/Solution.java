package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data;

        while ( !(data = reader.readLine()).equals("exit")) {

//          Если введенная строка содержит точку(".") и может быть корректно преобразована в число типа Double
            if (doubleTest(data)) {
                print(Double.parseDouble(data));
            }

//          Если введенная строка может быть корректно преобразована в число типа Integer
            if (digitTest(data)) {
                int num = Integer.parseInt(data);

//              Если полученное число больше 0, но меньше 128
                if (num>0 && num<128) {
                    print((short)num);

//              Если полученное число меньше или равно 0 или больше или равно 128
                } else {
                    print(num);
                }
            }
//          Метод поумолчанию
            if (!digitTest(data) && !doubleTest(data)) {
                print(data);
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }

    public static boolean digitTest(String testString){
        Pattern p = Pattern.compile("^-?\\d+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

    public static boolean doubleTest(String testString){
        Pattern p = Pattern.compile("^-?\\d+\\.\\d*$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }

}
