package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//        FileOutputStream fileOutput = new FileOutputStream("your.file.name");
        ObjectOutputStream outputStream = new ObjectOutputStream(byteArray);

        Solution solution = new Solution();
        outputStream.writeObject(solution);

        byteArray.close();
        outputStream.close();

        //load
        ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray.toByteArray());
//        FileInputStream fiStream = new FileInputStream("your.file.name");
        ObjectInputStream objectStream = new ObjectInputStream(inputStream);

        Solution loadedObject = (Solution) objectStream.readObject();

        inputStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
