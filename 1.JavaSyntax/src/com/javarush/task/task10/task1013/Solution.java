package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String secondName;
        private Date  birthday;
        private boolean sex;
        private int id;
        private String address;// Напишите тут ваши переменные и конструкторы

//      1
        public Human(String name) {
            this.name = name;
        }

//      2
        public Human(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }
//      3
        public Human(String name, String secondName, boolean sex) {
            this.name = name;
            this.secondName = secondName;
            this.sex = sex;
        }
//      4
        public Human(String name, String secondName, Date birthday, boolean sex, int id, String address) {
            this.name = name;
            this.secondName = secondName;
            this.birthday = birthday;
            this.sex = sex;
            this.id = id;
            this.address = address;
        }
//      5
        public Human() {
            this.birthday = new Date();
        }
//      6
        public Human(String name, String secondName, boolean sex, String address) {
            this.name = name;
            this.secondName = secondName;
            this.sex = sex;
            this.address = address;
        }
//      7
        public Human(String name, String secondName, Date birthday, boolean sex, String address) {
            this.name = name;
            this.secondName = secondName;
            this.birthday = birthday;
            this.sex = sex;
            this.address = address;
        }

//      8
        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

//      9
        public Human(String name, String secondName, int id, String address) {
            this.name = name;
            this.secondName = secondName;
            this.id = id;
            this.address = address;
        }
//      10
        public Human(int id) {
            this.id = id;
        }
    }
}
