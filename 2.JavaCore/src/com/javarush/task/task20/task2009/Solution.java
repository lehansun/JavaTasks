package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Алексей\\test1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        ClassWithStatic test = new ClassWithStatic();
        test.i = 31;
        test.j = 19;

        objectOutputStream.writeObject(test);


        FileInputStream fileInputStream = new FileInputStream("D:\\Алексей\\test1.txt");
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        ClassWithStatic testObject  = (ClassWithStatic) ois.readObject();

        System.out.println(testObject.i + " "  + testObject.j + " " + testObject.staticString);

        fileOutputStream.close();
        fileInputStream.close();
        objectOutputStream.close();
        ois.close();
    }
}
