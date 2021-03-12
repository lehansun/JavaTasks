package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        strategy.put(1l, "Cnhj");
        strategy.put(2L, "str2");

        testStrategy(new HashMapStorageStrategy(), 10);
        testStrategy(new OurHashMapStorageStrategy(), 10);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        strings.forEach(s -> result.add(shortener.getId(s)));
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        keys.forEach(k -> result.add(shortener.getString(k)));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Shortener shortener = new Shortener(strategy);
        Set<String> testLines = new HashSet<>();

        for (int i = 0; i < elementsNumber; i++) {
            testLines.add(Helper.generateRandomString());
        }

        Date startTime = new Date();
        Set<Long> testIDs =  getIds(shortener, testLines);
        Date endTime = new Date();
        Helper.printMessage("" + (endTime.getTime()-startTime.getTime()) );

        startTime = new Date();
        Set<String> shortenerTestLines = getStrings(shortener, testIDs);
        endTime = new Date();
        Helper.printMessage("" + (endTime.getTime()-startTime.getTime()) );

        Helper.printMessage(testLines.containsAll(shortenerTestLines) ? "Тест пройден." : "Тест не пройден.");
    }
}
