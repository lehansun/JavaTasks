package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;


public class FemaleFactory implements AbstractFactory {

    @Override
    public Human getPerson(int age) {
        if (age < 13) return new KidGirl();
        if (age < 20) return new TeenGirl();
        return new Woman();
    }
}
