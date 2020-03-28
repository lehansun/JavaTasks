package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static java.lang.System.*;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator<Cat> i = cats.iterator();
        cats.remove(i.next());
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();//напишите тут ваш код. step 2 - пункт 2
        
        Cat cat1 = new Cat("Pushok");
        Cat cat2 = new Cat("Mutzik");
        Cat cat3 = new Cat("Barsik");
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        cats.forEach(out::println);
    }
    
    public static class Cat {
        String name;
        
        public Cat(String n) {
            name = n;
        }

        public  Cat() {
            name = "Новый котик без имени";
        }
    }

    // step 1 - пункт 1
}
