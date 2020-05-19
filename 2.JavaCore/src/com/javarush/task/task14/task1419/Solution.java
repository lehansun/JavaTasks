package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        // 2
        try {
            Integer.parseInt(null);
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 3
        try {
            Double.parseDouble(null);
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 4
        try {
            int[] array = new int[1];
            int b = array[7];
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 5
        try {
            ArrayList<String> list = new ArrayList<>();
            System.out.println(list.get(2));
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 6
        try {
            File file = new File("path");
            FileInputStream fis = new FileInputStream(file);
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 7
        try {
            Object szStr[] = new String[10];
            szStr[0] = new Character('*');
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 8
        try {
            Object ch = new Character('*');
            System.out.println((Byte)ch);
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 9
        try {
            int[] nNegArray = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        // 10
        try {
            String szShortString = "123";
            char chr = szShortString.charAt(10);
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
