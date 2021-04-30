package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 0, 1, 0, 1, 1, 1 }
        };

        System.out.println(maxSquare(matrix));

    }

    public static int maxSquare(int[][] matrix) {
        if (matrix==null) return 0;
        int answer = 0;
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                if (matrix[y][x] == 1) {
                    int maxSquare = getMaxSquare(x, y, matrix);
                    answer = Math.max(answer, maxSquare);
                }
            }
        }
        return answer*answer;
    }

    private static int getMaxSquare(int x, int y, int[][] matrix) {

        if (y < matrix.length && x < matrix[0].length) {
            int length = Math.min(matrix.length - y, matrix[0].length - x);


            for (int i = 0; i < length; i++) {
                if (matrix[y+i][x] != 1) {
                    length = i;
                    if (length == 1) return length;
                }
                for (int j = 1; j < length; j++) {
                    if (matrix[y+i][x+j] != 1) {
                        length = j;
                        if (length == 1) return length;
                    }
                }
            }
            return length;

        }

        return 1;
    }
}
