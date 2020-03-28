package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path;

        while (true) {
            path = reader.readLine();
            try (FileInputStream inputStream =  new FileInputStream(path)) {

            } catch (FileNotFoundException e) {
                System.out.println(path);
                return;
            }
        }
    }
}
