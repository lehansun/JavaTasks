package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
    }

    public void recurse(int n) {
        if (n>1) {
            int delitel = 2;

            while (delitel <= n) {
                if (n % delitel == 0) {
                    System.out.print(delitel + " ");
                    recurse(n/delitel);
                    break;
                } else {
                    delitel++;
                }
            }
        }

    }
}
