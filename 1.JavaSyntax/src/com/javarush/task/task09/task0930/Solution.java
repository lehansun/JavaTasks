package com.javarush.task.task09.task0930;

/*
Задача по алгоритмам
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }

//        System.out.println(isGreaterThan("800", "9"));
    }

    private static class Elevator {
        private boolean type;
        private boolean hasPassenger = false;

        private String passenger1;
        private String passenger2;
        private int intPassenger2;
        private int floor;

        public Elevator(String passenger1) {
            this.passenger1 = passenger1;
            this.type = isNumber(passenger1);
        }

        public String getFirstPassenger() {
            return passenger1;
        }

        public String getSecondPassenger() {
            return (passenger2 == null) ? "" + intPassenger2 : passenger2;
        }

        public int getFloor() {
            return this.floor;
        }

        public boolean equalType(String str) {
            return type == isNumber(str);
        }

        public void setAnotherPassenger(String passenger2, int floor) {
            if (this.equalType(passenger2)) {
                if (hasPassenger) {
                    if (type) {
                        int visitor = Integer.parseInt(passenger2);
                        if (intPassenger2 < visitor) {
                            intPassenger2 = visitor;
                            this.floor = floor;
                        }
                    } else {
                        if (isGreaterThan(this.passenger2, passenger2)) {
                            this.passenger2 = passenger2;
                            this.floor = floor;
                        }
                    }
                } else {
                    if (type) {
                        int visitor = Integer.parseInt(passenger2);
                        if (Integer.parseInt(passenger1) < visitor) {
                            hasPassenger = true;
                            intPassenger2 = visitor;
                            this.floor = floor;
                        }
                    } else {
                        if (isGreaterThan(passenger1, passenger2)) {
                            hasPassenger = true;
                            this.passenger2 = passenger2;
                            this.floor = floor;
                        }
                    }
                }
            }
        }

    }

    public static void sort(String[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1) {
                Elevator elevator = new Elevator(array[i]);
                for (int j = i+1; j < array.length; j++) {
                    if (elevator.equalType(array[j])) {
                        elevator.setAnotherPassenger(array[j], j);
                    }
                }
                if (elevator.hasPassenger) {
                    array[i] = elevator.getSecondPassenger();
                    array[elevator.getFloor()] = elevator.getFirstPassenger();
                }
            }
        }
        // напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
