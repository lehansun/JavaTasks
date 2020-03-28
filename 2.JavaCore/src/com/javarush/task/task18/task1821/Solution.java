package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(args[0]));
        int i;

        TreeMap<Integer, Integer> result = new TreeMap<>();

        while((i = reader.read())!= -1){
            if (result.containsKey(i)) {
                int value = result.get(i);
                result.put(i, value+1);
            } else {
                result.put(i, 1);
            }
        }

        reader.close();

        for (Map.Entry e : result.entrySet()) {
            int num = (int) e.getKey();
            char ch = (char)num;
            String str = String.valueOf(ch);
            System.out.println(str + " " + e.getValue());
        }

    }
}
