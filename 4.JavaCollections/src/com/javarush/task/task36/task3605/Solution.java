package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line;
        TreeSet<Character> characters = new TreeSet<>();

        while (reader.ready()) {
            line = reader.readLine().toLowerCase().replaceAll("[^a-z]", "");
            for (char e : line.toCharArray()) {
                characters.add(e);
            }
        }

        reader.close();
        printAnswer(characters);
    }

    public static void printAnswer(TreeSet<Character> set) {
        int count = 0;
        for (char ch : set) {
            System.out.print(ch);
            count++;
            if (count==5) break;
        }
    }
}
