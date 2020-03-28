package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String word : array) {
            System.out.println(word);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i=0; i<array.length ; i++){
            list1.add(array[i]);//напишите тут ваш код
        }
        for (int i = 0; i < array.length; i++) {
            String word = array[i];
            for (int j = 0; j < list1.size(); j++) {
                if (isGreaterThan(list1.get(j), word)) word = list1.get(j);
            }
            list2.add(word);
            list1.remove(word);
        }
        for (int i = 0; i < array.length; i++) {
            array[i]=list2.get(i);
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
