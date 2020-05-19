package com.javarush.task.task16.task1632;

public class ThreadFour extends Thread implements Message {
    boolean isRunning = true;

    @Override
    public void run() {
        while(isRunning) {

        }
    }

    @Override
    public void showWarning() {
        isRunning = false;
    }
}
