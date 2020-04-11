package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] data = line.split("\\s");

            for (String word : data) {
                if (containsDigit(word)) {
                    fileWriter.write(word + " ");
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }

    private static boolean containsDigit(String word) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }
}
