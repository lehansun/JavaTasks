package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   // d:/source.txt
        File address = new File(reader.readLine());
        List<Integer> buffer = new ArrayList<>();

        InputStream inStream = new FileInputStream(address);
        reader = new BufferedReader(new InputStreamReader(inStream));

        String line;
        while((line = reader.readLine()) != null) {
            int number = Integer.parseInt(line);
            if (number%2 == 0) {
                buffer.add(number);
            }
        }

        Collections.sort(buffer);
        for (int i : buffer) {
            System.out.println(i);
        }

        reader.close();
        inStream.close();
    }
}
