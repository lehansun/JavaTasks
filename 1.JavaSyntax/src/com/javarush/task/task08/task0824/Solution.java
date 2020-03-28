package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство
*/

public class Solution {
    public static void main(String[] args) throws Exception{
        Human child1 = new Human("Петя", true, 7);
        Human child2 = new Human("Дима", true, 9);
        Human child3 = new Human("Настя", false, 3);
        Human father = new Human("Лёша", true, 31, child1, child2, child3);
        Human mother = new Human("Таня", false, 30, child1, child2, child3);
        Human grandPa1 = new Human("Яша", true, 56, father);
        Human grandMa1 = new Human("Лена", false, 51, father);
        Human grandMa2 = new Human("Коля", true, 59, mother);
        Human grandPa2 = new Human("Алла", false, 53, mother); 
        
        System.out.println(child1);//напишите тут ваш код
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandPa1);
        System.out.println(grandMa1);
        System.out.println(grandPa2);
        System.out.println(grandMa2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children; //напишите тут ваш код

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
          //  this.children = new ArrayList<>(0);
        }
        
        public Human(String name, boolean sex, int age, Human child1,Human child2, Human child3) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>(3);
            this.children.add(child1);
            this.children.add(child2);
            this.children.add(child3);
        }

        public Human(String name, boolean sex, int age, Human child1) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>(1);
            this.children.add(child1);
        }
        
        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
