package com.javarush.task.task19.task1916;

import java.io.*;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
//        D:\\Алексей\\test1.txt D:\\Алексей\\test2.txt

        List<String> fileLines1 = initFileLines(file1);
        List<String> fileLines2 = initFileLines(file2);

        boolean flag = fileLines1.get(0).equals(fileLines2.get(0));

        while ((fileLines1.size() + fileLines2.size()) != 0) {
//          Если строки одинаковые, то:
            if (flag) {
                lines.add(new LineItem(Type.SAME, fileLines1.get(0)));
                fileLines1.remove(0);
                fileLines2.remove(0);

//          Если строки не одинаковые
            } else {
                if (fileLines1.size() > 1) {
                    if (fileLines1.get(1).equals(fileLines2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, fileLines1.get(0)));
                        fileLines1.remove(0);
                    } else {
                        lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
                        fileLines2.remove(0);
                    }
                } else {
                    if (fileLines2.size() > fileLines1.size()) {
                        lines.add(new LineItem(Type.ADDED, fileLines2.get(0)));
                        fileLines2.remove(0);
                    } else {
                        lines.add(new LineItem(Type.REMOVED, fileLines1.get(0)));
                        fileLines1.remove(0);
                    }
                }
            }
            flag = !flag;
        }

//        lines.forEach(System.out::println);

    }

    private static List<String> initFileLines(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        List<String> list = new ArrayList<>();

        while (fileReader.ready()) {
            list.add(fileReader.readLine());
        }
        fileReader.close();
        return list;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

//        @Override
//        public String toString() {
//            return type.toString() + "\t" + line ;
//        }
    }
}
