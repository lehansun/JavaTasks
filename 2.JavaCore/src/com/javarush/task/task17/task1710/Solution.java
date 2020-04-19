package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        DateFormat setDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args.length > 0) {
            switch (args[0]) {
                case "-c" :
                    Date date = setDate.parse(args[3]);
                    Sex sex = args[2].equals("м") ? Sex.MALE : Sex.FEMALE;
                    Person create = sex == Sex.MALE ?
                            Person.createMale(args[1], date) :
                            Person.createFemale(args[1], date);
//                    System.out.println(allPeople.size());
                    allPeople.add(create);
//                    System.out.println(allPeople.size());
                    System.out.println(allPeople.indexOf(create));
                    break;

                case "-u" :
                    Person update = allPeople.get(Integer.parseInt(args[1]));
                    update.setName(args[2]);
                    update.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
                    update.setBirthDate(setDate.parse(args[4]));
                    break;

                case "-d" :
                    Person delete = allPeople.get(Integer.parseInt(args[1]));
                    delete.setBirthDate(null);
                    delete.setName(null);
                    delete.setSex(null);
                    break;

                case "-i" :
                    Person i = allPeople.get(Integer.parseInt(args[1]));
                    String bd = i.getSex() == Sex.MALE ? "м" : "ж";
                    DateFormat outDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    System.out.print(i.getName() + " " + bd + " " + outDate.format(i.getBirthDate()));
                    break;
            }
        }
    }
}
