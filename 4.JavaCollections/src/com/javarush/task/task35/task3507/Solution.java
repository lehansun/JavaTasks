package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

/*
ClassLoader - что это такое?
*/

public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
        pathToAnimals = pathToAnimals.replaceAll("%d0%90%d0%bb%d0%b5%d0%ba%d1%81%d0%b5%d0%b9", "Алексей");


        File file = new File(pathToAnimals);
        ClassLoader loader = Solution.class.getClassLoader();
        pathToAnimals = pathToAnimals.substring(pathToAnimals.indexOf("com")).replaceAll("/", ".");

        for (File listFile : file.listFiles()) {
            String path = pathToAnimals +  listFile.getName().replace(".class", "");
            try {
                Class<?> aClass = Solution.class.getClassLoader().loadClass(path);
                Class<?>[] interfaces = aClass.getInterfaces();
                for (Class<?> anInterface : interfaces) {
                    if (anInterface.equals(Animal.class)) {

                        try {
                            Animal animal = (Animal) aClass.getConstructor().newInstance();
                            animals.add(animal);
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

                        }

                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return animals;
    }
}
