package com.javarush.task.task20.task2025;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution {
    static  long[] armstrong = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};

//    static {
//        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\Алексей\\armstrong.txt"))) {
//            for (int i = 0; i < 50; i++) {
//                String line = reader.readLine().replaceAll("\n", "");
//                armstrong[i] = Long.parseLong(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static long[] getNumbers(long N) {
        if (N > 1) {
            int size = 0;
            for (int i = 0; i < 50; i++) {
                if (armstrong[i] < N) {
                    size = i+1;
                } else {
                    break;
                }
            }
            long[] result = new long[size];
            for (int i = 0; i < size; i++) {
                result[i] = armstrong[i];
            }
            return result;
        }
            return new long[0];
    }

    public static void main(String[] args) throws IOException {
        Date start = new Date();
//        System.out.println(Long.MAX_VALUE);
        long [] result = getNumbers(8300);
        long [] result1 = getNumbers(2);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
        Date end = new Date();
        System.out.println((end.getTime()-start.getTime()));
    }
}
