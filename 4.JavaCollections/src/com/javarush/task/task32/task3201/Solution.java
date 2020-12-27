package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Math.min(randomAccessFile.length(), Long.parseLong(args[1])));
        randomAccessFile.writeBytes(args[2]);
        randomAccessFile.close();
    }
}
