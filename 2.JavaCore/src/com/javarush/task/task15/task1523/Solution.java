package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public Solution() {
    }
    private Solution(String str) {
        System.out.println("Private constructor");
    }
    protected Solution(int n) {
        System.out.println("Protected constructor");
    }
    Solution(char ch) {
        System.out.println("Package constructor");
    }


    public static void main(String[] args) {

    }
}

