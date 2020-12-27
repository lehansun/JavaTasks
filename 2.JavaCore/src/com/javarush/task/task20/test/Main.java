package com.javarush.task.task20.test;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(Arrays.compareUnsigned(new byte[]{1,2,3}, new byte[]{3,2,1}));
//        //создаем наш объект
//        String[] territoryInfo = {"У Испании 6 провинций", "У России 10 провинций", "У Франции 8 провинций"};
//        String[] resourcesInfo = {"У Испании 100 золота", "У России 80 золота", "У Франции 90 золота"};
//        String[] diplomacyInfo = {"Франция воюет с Россией, Испания заняла позицию нейтралитета"};
//
//        SavedGame savedGame = new SavedGame(territoryInfo, resourcesInfo, diplomacyInfo);
//
//        //создаем 2 потока для сериализации объекта и сохранения его в файл
//        FileOutputStream outputStream = new FileOutputStream("D:\\Алексей\\save.ser");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//
//        // сохраняем игру в файл
//        objectOutputStream.writeObject(savedGame);
//
//        //закрываем поток и освобождаем ресурсы
//        objectOutputStream.close();
//        outputStream.close();
//
////        Десериализуем объект
//
//        FileInputStream fileInputStream = new FileInputStream("D:\\Алексей\\save.ser");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//        SavedGame desSavedGame = (SavedGame) objectInputStream.readObject();
//
//        System.out.println(desSavedGame);
    }
}