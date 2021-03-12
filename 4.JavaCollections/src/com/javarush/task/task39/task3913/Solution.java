package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException {
        Path logsPath = Paths.get("D:\\Алексей\\IMAGINATION\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task39\\task3913\\logs\\");
        LogParser logParser = new LogParser(logsPath);
        logParser.execute("get ip for user = \"Eduard Petrovich Morozko\"").forEach(System.out::println);

    }
}