package com.javarush.task.task20.task2025;

public class ArmstrongNumbers {
    private static byte count = 0;
    private static final long MAX_VALUE = Long.parseLong(new String("8999999999999999999"));
    //    degree[степень][число]
    static long[][] degrees = new long[20][10];

    static {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                degrees[i][j] = Degree.degree(j, i);
            }
        }
    }
}
