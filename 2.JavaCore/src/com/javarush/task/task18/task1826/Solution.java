package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]));
        int key = 133;

        switch (args[0]) {
            case "-e" :
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() + key);
                }
                break;

            case "-d" :
                while (inputStream.available() > 0) {
                    outputStream.write(inputStream.read() - key);
                }
                break;
        }

        inputStream.close();
        outputStream.close();
    }

}
