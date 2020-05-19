package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int a = readInt();
        int b = readInt();

        if (a > b) {
            int min = b;
            b = a;
            a = min;
        }

        System.out.println(NOD(a, b));
    }

    private static int readInt() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        if (n>0) {
            return n;
        } else {
            System.out.println("Введите положительное число: ");
            return readInt();
        }
    }

    private static int NOD(int a, int b) {
        if (b%a==0) {
            return a;
        }
        else {
            for (int i = a-1; i > 0 ; i--) {
                if (a%i==0 && b%i==0) {
                    return i;
                }

            }
        }
        return 0;
    }


}
