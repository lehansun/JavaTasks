package com.javarush.task.task25.task2505;

public class Clock implements Runnable
{
    public void run()
    {
        Thread current = Thread.currentThread();

        while (!current.isInterrupted())
        {
            try {
                Thread.sleep(1000);
                System.out.println("Tik");
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
