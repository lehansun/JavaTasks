package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i < 4; i++) {
            Cat cat = new Cat();
            result.add(cat);
        }

        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++) {
            Dog dog = new Dog();
            result.add(dog);
        }

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> joinedSet1;//напишите тут ваш код
        joinedSet1 = new HashSet<>();
        joinedSet1.addAll(cats);
        joinedSet1.addAll(dogs);
        return joinedSet1;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);//напишите тут ваш код
    }

    public static void printPets(Set<Object> pets) {
        Iterator<Object> i = pets.iterator();
        while (i.hasNext()) {
            Object nextPet = i.next();
            System.out.println(nextPet);
        }
        //напишите тут ваш код
    }

    public static class Pet {
        String name;

        public Pet() {
            name = "Питомец без имени";
        }

        public Pet(String n) {
            name = n;
        }
    }//напишите тут ваш код

    public static class Cat extends Pet {

        public Cat() {
            name = "Котик без имени";
        }
    }
    public static class Dog extends Pet {

        public Dog() {
            name = "Собачка без имени";
        }
    }

}
