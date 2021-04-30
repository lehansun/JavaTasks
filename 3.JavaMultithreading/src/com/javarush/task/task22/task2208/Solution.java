package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> paramsMap = new LinkedHashMap<>();
        paramsMap.put("name", "Ivanov");
        paramsMap.put("country", "Ukraine");
        paramsMap.put("city", "Kiev");
        paramsMap.put("age", null);

        System.out.println(getQuery(paramsMap));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder("");
        params.forEach((k, v) -> {
            if (k!= null && v != null) {
                builder.append(k).append(" = '").append(v).append("' and ");
            }
        });
        if(builder.length()!=0)builder.setLength(builder.length()-5);
        return builder.toString();
    }
}
