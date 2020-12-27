package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        Path path = Paths.get(line);
        if (Files.isDirectory(path)) {
            MyFileVisitor visitor = new MyFileVisitor();
            Files.walkFileTree(path, visitor);
            System.out.println("Всего папок - " + visitor.getDirectoryCount());
            System.out.println("Всего файлов - " + visitor.getFileCount());
            System.out.println("Общий размер - " + visitor.getBytes());
        } else {
            System.out.println(line + " - не папка");
        }
    }
}
