package com.javarush.task.task18.task1812;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private final static String EXIT_VALUE = "Д";
    private AmigoOutputStream decorator;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        decorator = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        decorator.flush();
    }

    @Override
    public void write(int b) throws IOException {
        decorator.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        decorator.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        decorator.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equals(EXIT_VALUE)) {
            decorator.close();
        }
    }
}

