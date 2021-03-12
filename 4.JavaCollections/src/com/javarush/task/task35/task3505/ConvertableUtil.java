package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, E extends Convertable<K>> Map<K, E> convert(List<E> list) {
        Map<K, E> result = new HashMap();
        for (E e : list) {
            result.put(e.getKey(), e);
        }
        return result;
    }
}
