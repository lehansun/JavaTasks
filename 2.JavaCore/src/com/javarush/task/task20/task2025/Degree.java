package com.javarush.task.task20.task2025;

public class Degree {
    private static long tempValue = 0;

    //    degree[степень][число]
    private static long[][] degrees = new long[20][10];

    static {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                degrees[i][j] = Degree.degree(j, i);
            }
        }
    }

    public long getDegree(int degree, int number) {
        return degrees[degree][number];
    }

    private static long degree(long value, int degree) {
        long result = value;

        if (degree>1) {
            if (tempValue>0) {
                tempValue = tempValue * value;
                result = degree(value, degree-1);
            } else {
                tempValue = value*value;
                result = degree(value, degree-1);
            }
        } else {
            if (degree == 1) {
                if (tempValue>0) {
                    result = tempValue;
                    tempValue = 0;
                }
                return result;
            }
        }
        return result;
    }
}