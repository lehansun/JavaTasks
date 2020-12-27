package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Генератор паролей
*/

public class Solution {
    private static final ArrayList<String> password = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        Randomizer randomizer = new Randomizer();
        StringBuilder pass =  new StringBuilder();
        for (int i = 0; i < 8 ; i++) {
            pass.append((char) randomizer.getRandomSymbol());
        }
        String word = pass.toString();

        if (matches(word) || !password.contains(word)) {
            password.add(word);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            stream.write(word.getBytes(StandardCharsets.UTF_8));
            return stream;
        } else {
            return getPassword();
        }
    }

    private static boolean matches(String password) {
        Pattern upperCaseSymbol = Pattern.compile("[A-Z]");
        Pattern lowerCaseSymbol = Pattern.compile("[a-z]");
        Pattern digitSymbol = Pattern.compile("\\d");

        Matcher digitMatcher = digitSymbol.matcher(password);
        Matcher upperCaseMatcher = upperCaseSymbol.matcher(password);
        Matcher lowerCaseMatcher = lowerCaseSymbol.matcher(password);

        return upperCaseMatcher.find() && lowerCaseMatcher.find() && digitMatcher.find();
    }
}
