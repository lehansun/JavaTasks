package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Тайфун", 3, 0));
        horses.add(new Horse("Буран", 3, 0));
        horses.add(new Horse("Буцефал", 3, 0));

        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignore) {
            }
        }
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        for (Horse horse : horses) {
            if (winner == null) {
                winner = horse;
            }
            if (winner.getDistance() < horse.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        String s = String.format("Winner is %s!", getWinner().getName());
        System.out.println(s);
    }
}
