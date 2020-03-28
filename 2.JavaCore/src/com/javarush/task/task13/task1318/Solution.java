package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String address = reader.readLine();

        InputStream inputStream = null;
        BufferedInputStream buffer = null;

        try {

            inputStream = new FileInputStream(address);
            buffer = new BufferedInputStream(inputStream);
            String str = ""; // Пустая строка, которая будет создана из файла потока ввода

            while(buffer.available()>0) {
                str = str + (char)buffer.read();
            }
            System.out.print(str);

        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            inputStream.close();
            buffer.close();
            reader.close();
        }
// напишите тут ваш код
    }
}