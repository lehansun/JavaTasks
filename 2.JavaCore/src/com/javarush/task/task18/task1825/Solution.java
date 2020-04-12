package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//      D:\\Алексей\\file.txt.part1

        String file;
        Map<Integer, String> files = new HashMap<>();

        Pattern digit = Pattern.compile("\\d+");
        Matcher matcher;

        while (!(file = reader.readLine()).equals("end")) {
            String part = file.split("\\.")[file.split("\\.").length-1];
            matcher = digit.matcher(part);
            if (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                files.put(number, file);
            }
        }
        reader.close();

        String out = files.get(1);
        Pattern outFile = Pattern.compile(".part\\d+");
        matcher = outFile.matcher(out);

        if (matcher.find()) {
            int end = matcher.start();
            out = out.substring(0, end);
        }


        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(out));
        BufferedInputStream inputStream;

        for (int i = 0; i < files.size(); i++) {
            inputStream = new BufferedInputStream(new FileInputStream(files.get(i+1)));
            while (inputStream.available()>0) {
                outputStream.write(inputStream.read());
            }
            inputStream.close();
        }
        outputStream.close();

//        files.forEach((a,b) -> System.out.println(b));
    }
}
