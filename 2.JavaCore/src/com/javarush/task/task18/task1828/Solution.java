package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
//      D:\Алексей\file.txt

        if (args.length>0) {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            int id = Integer.parseInt(args[1].trim());
            StringBuilder fileCopy = new StringBuilder();

            switch (args[0]) {
                case "-u" :
                    while (fileReader.ready()) {
                        String line = fileReader.readLine();

                        if (id != getId(line)) {
                            fileCopy.append(line).append("\n");
                        } else {
                            StringBuilder updatedLine = new StringBuilder();
                            append(updatedLine, args[1], 8);
                            append(updatedLine, args[2], 30);
                            append(updatedLine, args[3], 8);
                            append(updatedLine, args[4], 4);
                            fileCopy.append(updatedLine.toString()).append("\n");
                        }
                    }
                    break;

                case "-d" :

                    while (fileReader.ready()) {
                        String line = fileReader.readLine();
                        if (getId(line) != id) {
                            fileCopy.append(line).append("\n");
                        }
                    }
                    break;
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
            fileWriter.write(fileCopy.toString());
            fileReader.close();
            fileWriter.close();
        }

    }

    private static int getId(String line) {
        return Integer.parseInt(line.substring(0,8).trim());
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
