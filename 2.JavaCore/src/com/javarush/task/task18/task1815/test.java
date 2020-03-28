package com.javarush.task.task18.task1815;

import java.io.*;
import java.util.Date;

public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Алексей\\test.txt");

        PrintStream filePrintStream = new PrintStream(file);

        filePrintStream.println("Hello!");
        filePrintStream.println("I'm robot!");

        filePrintStream.printf("My name is %s, my age is %d!", "Amigo", 18);

//        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
//        String greetings = "Привет! Добро пожаловать на JavaRush - лучшй сайт для тех, кто хочет стать программистом!\r\n";
//        fileOutputStream.write(greetings.getBytes());
//        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        int i;
        while((i=fileInputStream.read())!= -1){
            System.out.print((char)i);
        }




//        Date date = new Date();
//        FileInputStream fileInputStream = new FileInputStream(
//                "D:\\Алексей\\Книги\\Minaev_Sergei__Duhless_Povest_o_nenastoyashem_cheloveke_www.Litru.ru_49101.txt"
//        );
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//
//        int i;
//        date = new Date();
//        while((i = bufferedInputStream.read())!= -1){
////            System.out.print((char)i);
//        }
//
//        Date date1 = new Date();
//        System.out.println("Second");
//        System.out.println((date1.getTime() - date.getTime()));
//
//        fileInputStream = new FileInputStream(
//                "D:\\Алексей\\Книги\\Minaev_Sergei__Duhless_Povest_o_nenastoyashem_cheloveke_www.Litru.ru_49101.txt"
//        );
//        date = new Date();
//        while((i = fileInputStream.read())!= -1){
////            System.out.print((char)i);
//        }
//        date1 = new Date();
//        System.out.println("First");
//        System.out.println((date1.getTime() - date.getTime()));
    }
}
