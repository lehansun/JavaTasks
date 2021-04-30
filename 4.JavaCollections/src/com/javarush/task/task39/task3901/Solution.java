package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();
        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
        test("ttttwt", 2);
        test("a123bcbcqwe", 6);
        test("ttttt", 1);
        test("a123bcbcqwelmnopq", 10);
        test("abcdeaouiz", 9);

    }

    private static void test(String str, int expected) {
        System.out.printf("%s %d = %d\n", str, expected, lengthOfLongestUniqueSubstring(str));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int length = myAlgorithm(s);
        int subLength = lengthOfLongestUniqueSubstring(s.substring(1));
        return Math.max(subLength, length);
    }

    private static int myAlgorithm(String s) {
        int maxLength = 0;
        Set<Character> characters = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (characters.contains(c)) {
                if (characters.size() > maxLength) {
                    maxLength = characters.size();
                }
                characters = new HashSet<>();
            }
            characters.add(c);
        }
        return characters.size() == s.length() ? s.length() : maxLength;
    }
}
