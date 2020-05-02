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
                    return result;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
//
//    public static void main(String[] args) throws Exception {
//        System.out.println(degree(9,1));
//        System.out.println(degree(9, 2));
//        System.out.println();
//        System.out.println(9*9*9);
//        System.out.println(degree(9,3));
//        System.out.println();
//        System.out.println(9*9*9*9);
//        System.out.println(degree(9, 4));
//        System.out.println();
//        System.out.println(9*9*9*9*9);
//        System.out.println(degree(9,5));
//        System.out.println();
//        System.out.println(9*9*9*9*9*9);
//        System.out.println(degree(9, 6));
//
//        System.out.println();
//        System.out.println(9*9*9*9*9*9*9);
//        System.out.println(degree(9,7));
//        System.out.println(degree(9, 8));
//        System.out.println(degree(9,9));
//        System.out.println(degree(9, 10));
//        System.out.println(degree(9,11));
//        System.out.println(degree(9, 12));
//        System.out.println(degree(9,13));
//        System.out.println(degree(9, 14));
//        System.out.println(degree(9, 15));
//        System.out.println(degree(9,16));
//        System.out.println(degree(9, 17));
//        System.out.println(degree(9, 18));
//        System.out.println(degree(9,19));
//        System.out.println(degree(9, 20));

//    }
}
