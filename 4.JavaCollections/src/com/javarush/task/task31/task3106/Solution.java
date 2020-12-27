package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path result = Paths.get(args[0]);

        List<Path> parts = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            parts.add(Paths.get(args[i]));
        }
        Collections.sort(parts);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (Path part : parts) {
            System.out.println(part);
            FileInputStream inputStream = new FileInputStream(part.toString());
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            byteArrayOutputStream.write(bytes);
            inputStream.close();
        }

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Files.createFile(result);
        FileOutputStream outputStream = new FileOutputStream(args[0]);

        if (zipInputStream.getNextEntry() != null) {
            int length;
            byte[] buffer = new byte[2048];
            while ((length = zipInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
        }
        zipInputStream.close();
    }
}
