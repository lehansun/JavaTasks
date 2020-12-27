package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File file = new File(args[1]);
        File destinationFile = new File((file.getParent() + "\\allFilesContent.txt"));

        if (FileUtils.isExist(file)) {
            FileUtils.renameFile(file, destinationFile);
        }

        Queue<File> directories = new LinkedList<>();
        directories.add(path);
        List<File> files = new ArrayList<>();

        walkThrow(directories, files);
        files.sort(new FileComparator());
        write(destinationFile, files);

    }

    public static void walkThrow(Queue<File> directories, List<File> files) {
        while (!directories.isEmpty()) {
            for (File file : Objects.requireNonNull(directories.poll().listFiles())) {
                if (file.isDirectory()) {
                    directories.add(file);
                } else {
                    if (file.length() <= 50) {
                        files.add(file);
                    }
                }
            }
        }
    }

    public static void write(File path, List<File> files) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (File file : files) {
            BufferedReader reader = new BufferedReader(new BufferedReader(new FileReader(file)));
            while (reader.ready()) {
                writer.write(reader.read());
            }
            writer.write("\n");
            reader.close();
        }
        writer.close();
    }

}
