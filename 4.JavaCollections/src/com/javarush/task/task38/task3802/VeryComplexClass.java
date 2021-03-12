package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.InputStreamReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        reader.close();
        reader.read();
    }

    public static void main(String[] args) {
    }
}
