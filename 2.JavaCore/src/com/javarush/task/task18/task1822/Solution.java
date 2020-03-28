package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream input = new FileInputStream(path);
        byte[] array = new byte[input.available()];
        input.read(array, 0, array.length);

        reader.close();
        input.close();

        String data = new String(array);
        String[] part = data.split("\n");

        for (String str : part) {
            int id = Integer.parseInt(str.split(" ")[0]);
            if (id == Integer.parseInt(args[0])) {
                System.out.println(str);
                return;
            }
        }
    }
}
