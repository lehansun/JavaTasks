package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        key = reader.readLine();//тут цикл по чтению ключей, пункт 1

        while (key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("proger")) {
            switch (key) {
                case ("user"):
                    person = new Person.User();
                    break;
                case ("loser"):
                    person = new Person.Loser();
                    break;
                case ("coder"):
                    person = new Person.Coder();
                    break;
                case ("proger"):
                    person = new Person.Proger();
                    break;
            }
            doWork(person);
            key = reader.readLine();
        }

    }
    public static void doWork (Person person){
        person.doWork();
    }
}
