package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {
        isOneEditAwayTest();
    }

    public static boolean isOneEditAway(String first, String second) {

        if (isSuitableLength(first, second)) {

            if (first.length() == second.length()) {
                if (first.equals(second)) return true;
                else {
                    char[] ch1 = first.toCharArray();
                    char[] ch2 = second.toCharArray();
                    int count = 0;
                    for (int i = 0; i < ch1.length; i++) {
                        if (ch1[i] == ch2[i]) {
                            count++;
                        }
                    }
                    if (count == ch1.length - 1) {
                        return true;
                    }
                }
            }
            if (first.length() == second.length() - 1) {
                return compare(first, second);
            } else {
                return compare(second, first);
            }

        }

        return false;
    }

    private static boolean isSuitableLength(String first, String second) {
        return first.length() == second.length()
                || first.length() == second.length() - 1
                || first.length() == second.length() + 1;
    }

    private static boolean compare(String smaller, String large) {
        for (int i = 0; i < large.length(); i++) {
            String s = new StringBuilder(large).deleteCharAt(i).toString();
            if (s.equals(smaller)) return true;
        }
        return false;
    }

    public static void isOneEditAwayTest() {
        System.out.println(Solution.isOneEditAway("letter", "letter"));
        System.out.println(Solution.isOneEditAway("leTTer", "letter"));
        System.out.println(Solution.isOneEditAway("leter", "letter"));
        System.out.println(Solution.isOneEditAway("letterA", "letterB"));
        System.out.println(Solution.isOneEditAway("letterA", "letter"));
        System.out.println(Solution.isOneEditAway("letter", "letterB"));
        System.out.println(Solution.isOneEditAway("letter", "letterBB"));
        System.out.println(Solution.isOneEditAway("leTter", "letterB"));
        System.out.println(Solution.isOneEditAway("A", "B"));
        System.out.println(Solution.isOneEditAway("A", ""));
        System.out.println(Solution.isOneEditAway("", ""));
    }
}
