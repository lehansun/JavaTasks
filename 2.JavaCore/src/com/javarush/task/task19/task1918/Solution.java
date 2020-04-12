package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static List<Integer> startList = new ArrayList<>();
    private static List<Integer> endList = new ArrayList<>();
    private static StringBuilder data = new StringBuilder();
    private static Map<Integer, String> tegList = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
//      D:\\Алексей\\test1.txt
        reader.close();

        String regex = args[0];


        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        while (fileReader.ready()) {
            data.append(fileReader.readLine());
        }
        fileReader.close();

        Pattern startPattern = Pattern.compile("<" + regex);
        Pattern endPattern = Pattern.compile("</" + regex + ">");

        Matcher matcher = startPattern.matcher(data);
        while (matcher.find()) {
            startList.add(matcher.start());
        }

        matcher = endPattern.matcher(data);
        while (matcher.find()) {
            endList.add(matcher.end());
        }

        createCorrectSubstrings();

        for (int number : startList) {
            System.out.println(tegList.get(number));
        }
    }

    private static void createCorrectSubstrings() {
        ArrayList<Integer> innerStartList = new ArrayList<>(startList);

        for (int i = 0; i < endList.size(); i++) {
            int start = innerStartList.get(0);
            int end = endList.get(i);

            for (int j = 0; j < innerStartList.size(); j++) {
                if (endList.get(i) > innerStartList.get(j)) {
                    start = innerStartList.get(j);
                    if (j == innerStartList.size()-1) {
                        tegList.put(start, data.substring(start, end));
                        innerStartList.remove(j);
                    }
                } else {
                    if (!tegList.containsKey(start)) {
                        tegList.put(start, data.substring(start, end));
                        innerStartList.remove(j - 1);
                    }
                }
            }
        }
    }
}
