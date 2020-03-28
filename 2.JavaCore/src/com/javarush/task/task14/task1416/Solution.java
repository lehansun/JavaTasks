package com.javarush.task.task14.task1416;

/* 
Исправление ошибок
*/

public class Solution {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.displaySwim();
        }

        private void displaySwim() {
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal implements Swimmable {

        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Whale extends OceanAnimal implements Swimmable {

        @Override
        Swimmable getCurrentAnimal() {
            return this;
        }
    }

    static class Otter implements Swimmable, Walkable {

        @Override
        public void walk() {
            System.out.println(this.getClass().getSimpleName() + " is walking");
        }

        @Override
        public void swim() {
            System.out.println(this.getClass().getSimpleName() + " is swimming");
        }
    }
}
