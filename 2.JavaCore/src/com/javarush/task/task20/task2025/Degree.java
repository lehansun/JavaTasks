package com.javarush.task.task20.task2025;

public class Degree {
    private static long tempValue = 0;

    public static long degree(long value, int degree) {
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