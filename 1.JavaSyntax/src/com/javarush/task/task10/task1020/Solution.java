package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            Elevator elevator = new Elevator(array[i]);
            for (int j = i+1; j < array.length; j++) {
                elevator.setAnotherPassenger(array[j], j);
            }
            if (elevator.hasPassenger) {
                array[i] = elevator.getSecondPassenger();
                array[elevator.getFloor()] = elevator.getFirstPassenger();
            }
        }//напишите тут ваш код
    }

    private static class Elevator {

        private boolean hasPassenger = false;
        private int passenger1;
        private int passenger2;
        private int floor;

        public Elevator(int passenger1) {
            this.passenger1 = passenger1;
        }

        public int getFirstPassenger() {
            return passenger1;
        }

        public int getSecondPassenger() {
            return passenger2;
        }

        public int getFloor() {
            return this.floor;
        }


        public void setAnotherPassenger(int visitor, int floor) {
            if (hasPassenger) {
                if (visitor < passenger2) {
                    passenger2 = visitor;
                    this.floor = floor;
                }
            } else {
                if (visitor < passenger1) {
                    passenger2 = visitor;
                    this.floor = floor;
                    hasPassenger = true;
                }
            }

        }

    }


}
