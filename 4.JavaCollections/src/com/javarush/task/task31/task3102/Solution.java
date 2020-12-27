package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> lines = new ArrayList<>();
        Queue<File> folders = new LinkedList<>();
        folders.add(new File(root));

        while (!folders.isEmpty()) {
            File file = folders.poll();
            for (File innerFile : file.listFiles()) {
                if (innerFile.isDirectory()) {
                    folders.add(innerFile);
                } else {
                    lines.add(innerFile.getAbsolutePath());
                }
            }
        }

        return lines;
    }

    public static void main(String[] args) {
        try {
            for (String str : getFileTree("D:\\Алексей\\TestFolder")) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
