package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread one = new Thread(new ThreadOne());
        threads.add(one);
        threads.add(new Thread(new ThreadTwo()));
        threads.add(new Thread(new ThreadThree()));
        threads.add(new ThreadFour());
        threads.add(new Thread(new ThreadFive()));
    }


    public static void main(String[] args) {
    }
}