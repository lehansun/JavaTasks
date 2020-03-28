package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static final String EXIT_VALUE = "exit";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = reader.readLine()).equals(EXIT_VALUE)) {
            new ReadThread(str).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(fileName), 1000)) {
                Map<Integer, Integer> bytes = new HashMap<>();
                int key;

                while ((key=reader.read())> -1) {
                    if (bytes.containsKey(key)) {
                        bytes.put(key, bytes.get(key)+1);
                    } else {
                        bytes.put(key, 0);
                    }
                }
                key = Collections.max(bytes.values());

                for (int i : bytes.keySet()) {
                    if (bytes.get(i) == key) {
                        key = i;
                        break;
                    }
                }
                resultMap.put(fileName, key);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
