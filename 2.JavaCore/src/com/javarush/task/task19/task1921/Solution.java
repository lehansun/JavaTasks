package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Pattern namePattern = Pattern.compile("[a-zа-яА-Я]+[a-zа-яА-Я\\s-]+", Pattern.CASE_INSENSITIVE);
        Pattern datePattern = Pattern.compile("\\d+[\\d\\s]++");

        DateFormat format = new SimpleDateFormat("dd MM yyyy");

        while (reader.ready()) {
            String data = reader.readLine();
            String newName;
            Date newDate;

            Matcher name = namePattern.matcher(data);
            Matcher date = datePattern.matcher(data);

            if (name.find() && date.find()) {
                newName = name.group().trim();
                newDate = format.parse(date.group());
                PEOPLE.add(new Person(newName, newDate));
            }
        }

        reader.close();

//        PEOPLE.forEach(a -> System.out.println(a.getName() + " " + format.format(a.getBirthDate())));
    }

}
