package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
//    private static InputStream defaultInputStream = System.in;
//    private static InputStream[] inputStream  = new InputStream[3];
//    private static InputStreamReader inputStreamReader = null;
//    private static BufferedReader reader = null;
//
//
//    static {
//        String[] file = new String[3];
//        file[0] = "D:\\Алексей\\test1.txt";
//        file[1] = "D:\\Алексей\\test2.txt";
//        file[2] = "D:\\Алексей\\test3.txt";
//        for (int i = 0; i < 3; i++) {
//            inputStream[i] = new ByteArrayInputStream(file[i].getBytes());
//        }
//    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] file = new String[3];

        for (int i = 0; i < 3; i++) {
            file[i] = reader.readLine();
        }
        reader.close();

        FileWriter writer = new FileWriter(file[0], true);
        FileReader reader1 = new FileReader(file[1]);
        int i;
        while ((i = reader1.read()) != -1) {
            writer.write(i);
        }
        reader1.close();

        reader1 = new FileReader(file[2]);
        while ((i = reader1.read()) != -1) {
            writer.write(i);
        }

        reader1.close();
        writer.close();
//        inputStreamReader.close();
    }

//    private static String readFileName(int index) throws IOException {
//        System.setIn(inputStream[index]);
//        inputStreamReader = new InputStreamReader(System.in);
//        reader = new BufferedReader(inputStreamReader);
//        return reader.readLine();
//    }
}
