package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()))) {
            String[] words = bf.readLine().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < words.length; i++) {
            result = new StringBuilder(words[i]);
            List<String> list = new ArrayList<>();
            Collections.addAll(list, words);
            list.remove(words[i]);

            Pair pair = getPair(words[i]);

            for (int j = 0; j < list.size(); j++) {
                Pair innerPair = getPair(list.get(j));
                if (pair.end == innerPair.start) {
                    result.append(" ").append(list.get(j));
                    list.remove(j);
                    pair = innerPair;
                    j = -1;
                }
            }

            if (result.toString().split(" ").length == words.length) {
                return result;
            }

        }
        return result;
    }

    public static Pair getPair(String word) {
        char[] charArray = word.toLowerCase().toCharArray();
        Pair pair = new Pair(charArray[0], charArray[word.length()-1]);
        return pair;
    }

    public static class Pair {
        char start;
        char end;

        public Pair(char start, char end) {
            this.start = start;
            this.end = end;
        }
    }
}
