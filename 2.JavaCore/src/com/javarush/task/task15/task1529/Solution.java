package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();//add your code here - добавьте код тут
        } catch (IOException e) {
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        switch (str) {
            case "helicopter" :
                result = new Helicopter();
                break;
            case "plane" :
                result = new Plane(Integer.parseInt(reader.readLine()));
                break;
        }

        reader.close();
        //add your code here - добавьте код тут
    }
}
