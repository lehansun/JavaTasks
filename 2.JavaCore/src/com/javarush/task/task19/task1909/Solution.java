package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        // D:\\Алексей\\test1.txt
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));

        while (bufferedReader.ready()) {
            String data = bufferedReader.readLine();
            bufferedWriter.write(data.replaceAll("\\.", "!"));
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
