package com.javarush.task.task39.task3913.util;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyParser {

    public static Date getDate(String source) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Event getEvent(String source) {

        if (source.contains("TASK")) {
            source = source.split(" ")[0];
        }
        switch (source) {
            case ("LOGIN") :
                return Event.LOGIN;
            case ("DOWNLOAD_PLUGIN") :
                return Event.DOWNLOAD_PLUGIN;
            case ("WRITE_MESSAGE") :
                return Event.WRITE_MESSAGE;
            case ("DONE_TASK") :
                return Event.DONE_TASK;
            default :
                return Event.SOLVE_TASK;
        }
    }

    public static Status getStatus(String source) {
        switch (source) {
            case ("OK") :
                return Status.OK;
            case ("FAILED") :
                return Status.FAILED;
            default :
                return Status.ERROR;
        }
    }

    public static String[] getMediumQueryArray(String query) {
        String[] queryArray = new String[3];
        String[] partsOfQuery = query.replaceAll("\"", "").split("= ");
        queryArray[2] =  partsOfQuery[1];
        partsOfQuery = partsOfQuery[0].split(" ");
        queryArray[0] = partsOfQuery[1];
        queryArray[1] = partsOfQuery[3];

        return queryArray;
    }

    public static String[] getLongQueryArray(String query) {
//        get ip for user = "Eduard Petrovich Morozko"
//        and date between "11.12.2013 0:00:00" and "03.01.2014 23:59:59".

        String[] queryArray = new String[5];

        String[] partsOfQuery = query.split(" and date between ");
        String[] firstPart = getMediumQueryArray(partsOfQuery[0]);

        for (int i = 0; i < 3; i++) {
            queryArray[i] = firstPart[i];
        }

        partsOfQuery  = partsOfQuery[1].replaceAll("\"", "").split("and ");
        queryArray[3] =  partsOfQuery[0];
        queryArray[4] = partsOfQuery[1];

        return queryArray;
    }
}
