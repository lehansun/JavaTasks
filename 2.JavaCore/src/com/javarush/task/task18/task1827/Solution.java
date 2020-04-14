package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//      D:\Алексей\file.txt
        String file = reader.readLine();
        reader.close();

//        Если программа запускается без аргументов
        if (args.length == 0) {

//        Если программа запускается с аргументами
        } else {
            if (args[0].equals("-c")) {
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));

                int id = 0;
                StringBuilder result = new StringBuilder();

                while (fileReader.ready()) {
                    String line = fileReader.readLine().substring(0, 8).trim();
                    int number = Integer.parseInt(line);
                    if (number>id) {
                        id = number;
                    }
                }
                fileReader.close();

                id++;
                result.append(increase("" + id, 8));

                append(result, args[1], 30);
                append(result, args[2], 8);
                append(result, args[3], 4);

                fileWriter.write("\n" + result.toString());
                fileWriter.close();
            }
        }

    }
    public static String increase(String line, int length) {
        StringBuilder result = new StringBuilder(line);
        while (result.length()<length) {
            result.append(" ");
        }
        return result.toString();
    }

    public static void append(StringBuilder str, String appender, int length) {
        if (appender.length() > length) {
            str.append(appender.substring(0, length));
        } else {
            str.append(increase(appender, length));
        }
    }
}
