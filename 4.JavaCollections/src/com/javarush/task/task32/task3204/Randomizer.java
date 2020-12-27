package com.javarush.task.task32.task3204;

import java.util.Random;

public class Randomizer {
    private final Random random;

    public Randomizer() {
        this.random = new Random(System.currentTimeMillis());
    }

    public int getRandomDigit() {
        return random.nextInt(10) + 48;
    }

    public int getRandomLowerCaseLatter() {
        return random.nextInt(26) + 97;
    }

    public int getRandomUpperCaseLatter() {
        return random.nextInt(26) + 65;
    }

    public int getRandomSymbol() {
        int symbol;
        switch (random.nextInt(3)) {
            case 0 :
                symbol = getRandomDigit();
                break;
            case 1 :
                symbol = getRandomUpperCaseLatter();
                break;
            case 2 :
                symbol = getRandomLowerCaseLatter();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + random.nextInt(3));
        }
        return symbol;
    }

}
