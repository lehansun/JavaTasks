package com.javarush.task.task20.task2021;

import java.io.*;

/*
Сериализация под запретом
*/
public class Solution implements Serializable {

    public static class SubSolution extends Solution {
        private void writeObject() throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject() throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        SubSolution sol = new SubSolution();

        try {
            objectOutputStream.writeObject(sol);
        } catch (NotSerializableException e) {
            System.out.println("Метод сработал!");
        }

    }
}
