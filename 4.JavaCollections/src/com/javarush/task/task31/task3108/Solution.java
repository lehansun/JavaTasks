package com.javarush.task.task31.task3108;

import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Исследуем Path
*/
public class Solution {
    public static void main(String[] args) {
        Path path1 = Paths.get("D:/test/data/firstDir");
        Path path2 = Paths.get("D:/test/data/secondDir/third");
        Path resultPath = getDiffBetweenTwoPaths(path1, path2);
        System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'
        System.out.println(5%-2);
        int x = (10%7%2*-2);
        System.out.println("X = " + x);
        int y = x-(x+(x-x*2)*(x-x*-1)+x)*x;
        System.out.println("Y = "+ y);
        System.out.println(y*-2*x%3);
        int z = x+y*-2*x%3;
        System.out.println("Z = " + z);
    }

    public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {
        return path1.relativize(path2);
    }
}
