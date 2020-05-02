package com.javarush.task.task20.task2025;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Solution {



    public static void main(String[] args) throws IOException {
        Date start = new Date();
        ArmstrongNumbers.armstrong.forEach(a-> System.out.println(a));
        Date end = new Date();
        long time = (end.getTime()-start.getTime())/1000;
        System.out.println(time);
    }

}
