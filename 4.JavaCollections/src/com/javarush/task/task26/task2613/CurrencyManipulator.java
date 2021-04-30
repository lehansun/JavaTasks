package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            count += denominations.get(denomination);
        }
        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            result += k * v;
        }
        return result;
    }

    public boolean hasMoney() {
         if (!denominations.isEmpty()) {
            for (Integer e : denominations.values()) {
                if (e > 0) return true;
            }
        }
        return false;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        denominations.forEach((k, v) -> {
            if (k <= expectedAmount) {
                treeMap.put(k, k*v < expectedAmount ? v : expectedAmount / k);
            }
        });

        if (!treeMap.isEmpty()) {
            do {
                Map<Integer, Integer> withdrawAmount = new HashMap<>();
                int amount = 0;

                for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                    Integer nominal = entry.getKey();
                    Integer count = entry.getValue();
                    int rest = expectedAmount - amount;
                    if (nominal <= rest) {
                        withdrawAmount.put(nominal, (rest / nominal > count ? count : rest / nominal));
                        amount += nominal * withdrawAmount.get(nominal);
                    }

                    if (amount == expectedAmount) {
                        reduceDenominations(withdrawAmount);
                        return withdrawAmount;
                    }
                }

                minimizeThree(treeMap);

            } while (getAmount(treeMap) >= expectedAmount);
        }

        throw new NotEnoughMoneyException();
    }

    private void minimizeThree(TreeMap<Integer, Integer> treeMap) {
        int maxNominal = treeMap.firstKey();
        if (treeMap.get(maxNominal) > 1) {
            treeMap.put(maxNominal, treeMap.get(maxNominal) - 1);
        } else {
            treeMap.remove(maxNominal);
        }
    }

    private void reduceDenominations(Map<Integer, Integer> withdrawAmount) {
        withdrawAmount.forEach( (k, v) -> {
            int rest = denominations.get(k) - v;
            denominations.put(k, rest);
        });
    }



    private int getAmount(Map<Integer, Integer> denominations) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            result += k * v;
        }
        return result;
    }
}
