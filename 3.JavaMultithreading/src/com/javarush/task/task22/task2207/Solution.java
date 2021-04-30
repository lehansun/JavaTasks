package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();
    private static final HashMap<String, String> pairs = new HashMap<>();


    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine());
        BufferedReader reader = new BufferedReader(fileReader)){

            StringBuilder builder;

            ArrayList<String> words = new ArrayList<>();
            while (reader.ready()) {
                Collections.addAll(words, reader.readLine().split(" "));
            }
            getPairs(words);
            result.forEach(System.out::println);

        } catch (IOException ignore) {
        }
    }

    private static void getPairs(List<String> words) {
        if (words.size()>1) {
            String word = words.remove(0);
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (words.contains(reversedWord)) {
                Pair pair = new Pair();
                pair.first = word;
                pair.second = reversedWord;
                words.remove(reversedWord);
                result.add(pair);
            }
            getPairs(words);
        }
    }

    public static class Pair {
        String first;
        String second;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
