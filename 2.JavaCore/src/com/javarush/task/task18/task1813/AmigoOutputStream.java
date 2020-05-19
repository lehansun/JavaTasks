package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream wrapper;

    public AmigoOutputStream(FileOutputStream wrapper) throws FileNotFoundException {
        super(fileName);
        this.wrapper = wrapper;
    }
    @Override
    public void write(int b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrapper.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        wrapper.close();
    }

    @Override
    public FileChannel getChannel() {
        return wrapper.getChannel();
    }


    @Override
    public void flush() throws IOException {
        wrapper.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
