package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        withdrawAmountTransaction(manipulator);
    }

    private void withdrawAmountTransaction(CurrencyManipulator manipulator) throws InterruptOperationException {
        try {
            int expectedAmount;

            do {
                expectedAmount = getExpectedAmount();
                if (!manipulator.isAmountAvailable(expectedAmount)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            } while (!manipulator.isAmountAvailable(expectedAmount));


            Map<Integer, Integer> withdrawAmount = manipulator.withdrawAmount(expectedAmount);

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), expectedAmount, manipulator.getCurrencyCode()));
            printWithdrawAmount(withdrawAmount);
        } catch (NotEnoughMoneyException e) {
            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            withdrawAmountTransaction(manipulator);
        }
    }

    private void printWithdrawAmount(Map<Integer, Integer> withdrawAmount) {
        withdrawAmount.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(k -> ConsoleHelper.writeMessage("\t" + k + " - " + withdrawAmount.get(k)));
    }

    private int getExpectedAmount() throws InterruptOperationException {
        Integer amount = null;
        while (amount == null) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String answer = ConsoleHelper.readString();
            if (answer.matches("\\d+")) {
                int expectedAmount = Integer.parseInt(answer);
                if (expectedAmount > 0) amount = expectedAmount;
            }
            if (amount == null) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
        return amount;
    }
}
