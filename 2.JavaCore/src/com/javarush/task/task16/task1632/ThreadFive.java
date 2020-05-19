package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadFive implements Runnable {

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int num = 0;
            String str = reader.readLine();
            while (!str.equals("N")) {
                num+=Integer.parseInt(str);
                str = reader.readLine();
            }
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
