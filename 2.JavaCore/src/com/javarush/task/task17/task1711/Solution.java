package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        DateFormat setDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        switch (args[0]) {
                case "-c" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i+=3) {
                            Date date = setDate.parse(args[i+2]);
                            Sex sex = args[i+1].equals("м") ? Sex.MALE : Sex.FEMALE;
                            Person create = sex == Sex.MALE ?
                                Person.createMale(args[i], date) :
                                Person.createFemale(args[i], date);
                            allPeople.add(create);
                            System.out.println(allPeople.indexOf(create));
                        }
                    }
                    break;

                case "-u" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i+=4) {

                            Person update = allPeople.get(Integer.parseInt(args[i]));
                            update.setName(args[i + 1]);
                            update.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                            update.setBirthDate(setDate.parse(args[i + 3]));
                        }
                    }
                    break;

                case "-d" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person delete = allPeople.get(Integer.parseInt(args[i]));
                            delete.setBirthDate(null);
                            delete.setName(null);
                            delete.setSex(null);
                        }
                    }
                    break;

                case "-i" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            Person inform = allPeople.get(Integer.parseInt(args[i]));
                            String informSex = inform.getSex() == Sex.MALE ? "м" : "ж";
                            DateFormat outDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            System.out.println(inform.getName() + " " + informSex + " " + outDate.format(inform.getBirthDate()));
                        }
                    }
                    break;
        }

    }
}
