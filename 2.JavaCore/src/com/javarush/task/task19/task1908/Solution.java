package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        FileReader fileReader = new FileReader(file1);
        BufferedReader bfReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(file2);
        BufferedWriter bfWriter = new BufferedWriter(fileWriter);

        while (bfReader.ready()) {
            String data = bfReader.readLine();
            String[] buffer = data.split("\\s");

            for (String test : buffer) {
                if (test(test)) {
                    bfWriter.write(test + " ");
                }
            }
        }

        bfReader.close();
        bfWriter.close();
        fileReader.close();
        fileWriter.close();

    }

    public static boolean test(String testString){
        Pattern p = Pattern.compile("^[0-9]+");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
}
