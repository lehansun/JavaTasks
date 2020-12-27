package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        String line = args[2];
        int length = line.length();
        byte[] b = new byte[length];
        raf.seek(Integer.parseInt(args[1]));
        raf.read(b, 0, length);
        String newLine = new String(b);
        raf.seek(raf.length());
        raf.write(Boolean.toString(newLine.equals(line)).getBytes());
        raf.close();
    }
}
