package com.javarush.task.task39.task3904;

import java.util.Arrays;

/* 
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n<0) return 0;
        if (n<2) return 1;
        if (n==2) return 2;
        Long[] array = new Long[n+1];
        array[0] = 1L;
        array[1] = 1L;
        array[2] = 2L;

        for (int i = 3; i < n + 1; i++) {
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }
        return array[n];
    }
}

