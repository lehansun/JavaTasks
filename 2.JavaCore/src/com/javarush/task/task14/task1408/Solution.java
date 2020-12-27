package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen();
        System.out.println(hen.getDescription());
    }

    static class HenFactory {

        static Hen getHen() {
            Hen hen = null;
            if (Country.BELARUS.equals(Country.BELARUS)) {
                hen = new BelarusianHen();
            }
            if (Country.BELARUS.equals(Country.RUSSIA)) {
                hen = new RussianHen();
            }if (Country.BELARUS.equals(Country.UKRAINE)) {
                hen = new UkrainianHen();
            }
            if (Country.BELARUS.equals(Country.MOLDOVA)) {
                hen = new MoldovanHen();
            }
            return hen;
        }
    }


}
