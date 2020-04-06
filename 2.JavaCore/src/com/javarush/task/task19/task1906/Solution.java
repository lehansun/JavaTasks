package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader freader = new FileReader(file1);
        FileWriter writer = new FileWriter(file2);

        int count = 1;

        while (freader.ready()) {
            int data = freader.read();
            if (count % 2 == 0) {
                writer.write(data);
            }
            count++;
        }

        freader.close();
        writer.close();

    }
}
