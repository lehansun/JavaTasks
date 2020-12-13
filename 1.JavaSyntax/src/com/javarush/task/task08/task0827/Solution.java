package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat in = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        DateFormat out = new SimpleDateFormat("D");
        return Integer.parseInt(out.format(in.parse(date))) % 2 == 1;
    }
}
