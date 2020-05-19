package com.javarush.task.task16.task1632;

public class ThreadTwo implements Runnable {
    @Override
    public void run() {
        try {
            fee();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }

    public void fee() throws InterruptedException {
        throw new InterruptedException();
    }
}
