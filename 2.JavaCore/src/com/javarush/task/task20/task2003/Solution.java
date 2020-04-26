package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties2 = new Properties();//напишите тут ваш код
        properties2.putAll(runtimeStorage);
        properties2.store(outputStream, "");
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties1 = new Properties();//напишите тут ваш код
        properties1.load(inputStream);
        properties1.forEach( (a, b)  -> runtimeStorage.put((String) a, (String) b));
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
