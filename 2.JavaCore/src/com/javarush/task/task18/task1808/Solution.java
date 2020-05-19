package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] filePath = new String[3];

        for (int i = 0; i < 3; i++) {
            filePath[i] = reader.readLine();
        }

        FileInputStream inputStream = new FileInputStream(filePath[0]);
        FileOutputStream outputStream1 = new FileOutputStream(filePath[1]);
        FileOutputStream outputStream2 = new FileOutputStream(filePath[2]);
        int count = inputStream.available()/2;

        while (inputStream.available()>0) {
            int data = inputStream.read();
            if (inputStream.available()>=count) {
                outputStream1.write(data);
            } else {
                outputStream2.write(data);
            }
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
