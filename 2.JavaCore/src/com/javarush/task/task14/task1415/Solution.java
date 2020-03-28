package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (Apartment apartment : apartments) {
            apartment.cleanApartment();
        }
    }

    static interface Apartment {
        void cleanApartment();
    }

    static class OneRoomApt implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }

        @Override
        public void cleanApartment() {
            clean1Room();
        }
    }

    static class TwoRoomApt implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }

        @Override
        public void cleanApartment() {
            clean2Rooms();
        }
    }

    static class ThreeRoomApt implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }

        @Override
        public void cleanApartment() {
            clean3Rooms();
        }
    }
}
