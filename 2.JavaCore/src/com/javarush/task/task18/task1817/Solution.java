package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        int spaceCount = 0;
        byte space = (byte)' ';
//        "D:\\Алексей\\test.txt"

        FileInputStream reader = new FileInputStream(args[0]);
        int i;
        while ( (i = reader.read()) != -1) {
            count++;
            if (i == space ) {
                spaceCount++;
            }
        }
        reader.close();

//        System.out.printf("Всего букв в файле - %d, из них пробелов - %d.\n", count, spaceCount);
        BigDecimal result = new BigDecimal(spaceCount*1.0/count*100);
        System.out.println(result.setScale(2, RoundingMode.HALF_UP));
    }
}
