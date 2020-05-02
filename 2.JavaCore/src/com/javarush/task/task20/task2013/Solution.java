package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            age = in.readInt();
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("D:\\Алексей\\test1.txt");
//        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Алексей\\test1.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        Person person1 = new Person("Ivan", "Ivanov", 24);
//        Person father = new Person("Father", "Old", 52);
//        Person mother = new Person("Mother", "old", 49);
//        Person child = new Person("Child", "Yang", 2);
//        person1.setFather(father);
//        person1.setMother(mother);
//        List<Person> children = new ArrayList<>();
//        children.add(child);
//        person1.setChildren(children);
//
//        person1.writeExternal(objectOutputStream);
//
//        Person person2 = new Person("Test", "test", 0);
//        person2.readExternal(objectInputStream);
//
//        System.out.println(person2.firstName + " " + person2.lastName + " " + person2.children.get(0).firstName);

    }
}
