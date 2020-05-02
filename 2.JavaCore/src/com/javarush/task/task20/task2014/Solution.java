package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("D:\\Алексей\\test1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Алексей\\test1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution solution1 = new Solution(15);
        objectOutputStream.writeObject(solution1);

        Solution solution2 = (Solution) objectInputStream.readObject();

        System.out.println(solution1.string.equals(solution2.string));

        fileInputStream.close();
        fileOutputStream.close();
        objectInputStream.close();
        objectOutputStream.close();

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
