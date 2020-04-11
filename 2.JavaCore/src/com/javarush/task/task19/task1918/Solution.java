package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static List<Integer> startList = new ArrayList<>();
    private static List<Integer> endList = new ArrayList<>();
    private static StringBuilder data = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = args[1];   // reader.readLine();
//      D:\\Алексей\\test1.txt
        reader.close();

        String regex = args[0];


        reader = new BufferedReader(new FileReader(file));
        while (reader.ready()) {
            data.append(reader.readLine());
        }
        reader.close();

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

        for (int i = 0; i < startList.size(); i++) {
            print(i);
        }
    }

    private static void print(int number) {
        System.out.println(data.subSequence(startList.get(number), endList.get(correctEnd(number))));
    }

    private static int correctEnd(int number) {
        if (number <= startList.size()-1) {
            if (endList.get(number) <= startList.get(number + 1)) {
                return number;
            } else {
                replace(number, correctEnd(number+1));
            }
        }
        return number;
    }

    private static void replace(int num, int newNum) {
        int replacement = endList.get(newNum);
        endList.set(newNum, endList.get(num));
        endList.set(num, replacement);
    }
}
