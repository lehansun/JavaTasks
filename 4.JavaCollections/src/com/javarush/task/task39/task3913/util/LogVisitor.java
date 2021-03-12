package com.javarush.task.task39.task3913.util;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Log;
import com.javarush.task.task39.task3913.Status;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogVisitor extends SimpleFileVisitor<Path> {
    private List<Log> logList;
    private Date after;
    private Date before;

    public LogVisitor(Date after, Date before) {
        this.after = after;
        this.before = before;
        logList = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".log")) {
            try(BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                String line;
                while (reader.ready()) {
                    line = reader.readLine();
                    String[] arguments = line.split("\t");
                    Date date = MyParser.getDate(arguments[2]);
                    selectValues(date, arguments);
                }
            }
            ;
        }
        return FileVisitResult.CONTINUE;
    }

    private void selectValues(Date date, String[] source) {
        if (before == null && after == null) {
            addLog(source);
        } else {
            if (before == null) {
                if (date.after(this.after)) addLog(source);
            }
            if (after == null) {
                if (date.before(this.before)) addLog(source);
            }
        }
        if (before != null && after != null) {
            if (date.before(before) && date.after(this.after)) addLog(source);
        }
    }

    private void addLog(String[] source) {
        Date date = MyParser.getDate(source[2]);
        Event event = MyParser.getEvent(source[3]);
        Status status = MyParser.getStatus(source[4]);
        Log log = new Log(source[0], source[1], date, event, status);
        if (event == Event.SOLVE_TASK || event == Event.DONE_TASK) {
            int task = Integer.parseInt(source[3].split(" ")[1]);
            log.setTask(task);
        }
        logList.add(log);
    }

    public List<Log> getLogs() {
        return this.logList;
    }
}
