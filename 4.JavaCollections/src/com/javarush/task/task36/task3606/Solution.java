package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/

public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        packageName = packageName.replace("%d0%90%d0%bb%d0%b5%d0%ba%d1%81%d0%b5%d0%b9", "АЛЕКСЕЙ");
        for (File innerFile : new File(packageName).listFiles()) {
            if (innerFile.isFile() && innerFile.getName().endsWith(".class")) {
                String className = packageName.replaceAll("/", ".").substring(packageName.indexOf("com")) + "."+ innerFile.getName().substring(0, innerFile.getName().length() - 6);
                System.out.println(className);
                hiddenClasses.add(Solution.class.getClassLoader().loadClass(className));
            }
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        for (Class aClass : hiddenClasses) {
            if (aClass.getSimpleName().toLowerCase().contains(key.toLowerCase())) {
                try {
                    Constructor declaredConstructor = aClass.getDeclaredConstructor();
                    declaredConstructor.setAccessible(true);
                    return (HiddenClass) declaredConstructor.newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

