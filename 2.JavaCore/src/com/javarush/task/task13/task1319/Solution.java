package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// напишите тут ваш код
        String address = reader.readLine();

        List<String> buffer = new ArrayList<String>();
        String temp = "";

        while (!temp.equalsIgnoreCase("exit")) {
            temp = reader.readLine();
            buffer.add(temp);
        }

        try {
            File file = new File(address);
            FileWriter fileWriter = new FileWriter(file); // поток, который подключается к текстовому файлу
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); // соединяем FileWriter с BufferedWriter

            for(String s : buffer) {
                bufferedWriter.write(s + "\n");
            }

            bufferedWriter.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }

        reader.close();
    }
}
