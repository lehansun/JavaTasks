package com.javarush.task.task14.task1411;

public interface Person {
    public void doWork();

    class User implements Person {
        void live() {
            System.out.println("I usually just live.");
        }

        @Override
        public void doWork() {
            live();
        }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("I usually do nothing.");
        }

        @Override
        public void doWork() {
            doNothing();
        }
    }

    class Coder implements Person {
        void writeCode() {
            System.out.println("I usually write code.");
        }

        @Override
        public void doWork() {
            writeCode();
        }
    }

    class Proger implements Person {
        void enjoy() {
            System.out.println("It's a wonderful life!");
        }

        @Override
        public void doWork() {
            enjoy();
        }
    }

}
