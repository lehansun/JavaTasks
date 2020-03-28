package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
//
//        FileReader reader = new FileReader(new File("D:\\Алексей\\test.txt"));
//        Scanner scanner = new Scanner(reader);
//        PersonScanner myScaner = new PersonScannerAdapter(scanner);
//        System.out.println(myScaner.read());
//        myScaner.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String data = fileScanner.nextLine();
            String[] part = data.split(" ");
            int year = Integer.parseInt(part[5]) - 1900;
            int month = Integer.parseInt(part[4]) - 1;
            int day =Integer.parseInt(part[3]);
            Date date = new Date(year, month, day);
            Person person = new Person(part[1], part[2], part[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
