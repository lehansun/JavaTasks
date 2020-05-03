package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        byte preLine = 0;
        byte preColumn = 0;

        for (int line = 0; line < a.length; line++) {
            for (int column = 0; column < a[line].length; column++) {
                if (column > 0) {
                   preLine = a[line][column-1];
                }
                if (line > 0) {
                    preColumn = a[line-1][column];
                }
                if (a[line][column] == 1 && preLine == 0 && preColumn == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
