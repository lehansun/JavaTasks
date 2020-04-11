package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
//        D:\\Алексей\\test1.txt

        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        int count = 0;

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] data = line.split("\\s");

            for (String regex : data) {
                if (words.contains(regex)) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println(line);
            }
            count = 0;
        }

        fileReader.close();


    }
}
