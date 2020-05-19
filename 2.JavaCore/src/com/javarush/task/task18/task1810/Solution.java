package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        int bytes;
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            bytes = inputStream.available();
            inputStream.close();
            if (bytes < 1000) {
                throw new DownloadException();
            }
        } while (true);
    }

    public static class DownloadException extends Exception {

    }
}
