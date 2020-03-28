package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
//
//        D:\\Алексей\\test1.txt
//        D:\\Алексей\\test2.txt
        ArrayList<Integer> buffer = new ArrayList<>();

        FileInputStream input = new FileInputStream(file1);
        while (input.available() > 0) {
            buffer.add(input.read());
        }
        input.close();

        FileOutputStream out = new FileOutputStream(file1);

        input = new FileInputStream(file2);
        while (input.available() > 0) {
            out.write(input.read());
        }
        input.close();

        for (int i : buffer) {
            out.write(i);
        }

        out.close();

    }
}
