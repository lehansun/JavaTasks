package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        int count = 0;
        FileInputStream stream = new FileInputStream(file);
        int i;
        while((i=stream.read())!= -1){
            if ((i > 64 && i < 91) || (i > 96 && i < 123)) count++;
        }
        System.out.println(count);
        stream.close();
    }
}
