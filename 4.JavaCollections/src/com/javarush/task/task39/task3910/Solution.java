package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(3));

    }

    public static boolean isPowerOfThree(int n) {
        if (n==1) return true;
        if (n % 3 == 0) {
            int three = 1;
            while (three<n) {
                three = three*3;
            }
            return three==n;
        }
        return false;
    }
}
