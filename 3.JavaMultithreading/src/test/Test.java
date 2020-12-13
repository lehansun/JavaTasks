package test;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File folder = new File("D:/Алексей/");
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}
