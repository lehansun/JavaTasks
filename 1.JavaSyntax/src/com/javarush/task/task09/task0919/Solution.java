package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divideByZero();
        }
        catch (Exception e) {
            e.printStackTrace();
            printStack(e);
        }
    }

    public static void divideByZero() throws ArithmeticException {
        System.out.println(8/0);
    }

    public static void printStack(Throwable throwable) {
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }

    }


}
