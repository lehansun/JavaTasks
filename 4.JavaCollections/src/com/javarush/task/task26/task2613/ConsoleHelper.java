package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String string = "";
        try {
            string = bis.readLine();
            if (string.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignore) {
        }

        return string;
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String code = readString();
        if (code.length() == 3) {
            return code.toUpperCase();
        }
        writeMessage(res.getString("invalid.data"));
        return askCurrencyCode();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        writeMessage(res.getString("choose.denomination.and.count.format"));
        String line = readString();
        if (line.matches("\\d+\\s\\d+")) {
            return line.split(" ");
        } else {
            writeMessage(res.getString("invalid.data"));
            return getValidTwoDigits(currencyCode);
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        writeMessage("\t1." + res.getString("operation.INFO"));
        writeMessage("\t2." + res.getString("operation.DEPOSIT"));
        writeMessage("\t3." + res.getString("operation.WITHDRAW"));
        writeMessage("\t4." + res.getString("operation.EXIT"));
        try {
            int answer = Integer.parseInt(readString());
            return Operation.getAllowableOperationByOrdinal(answer);
        } catch (InterruptOperationException e) {
            return askOperation();
        }
    }

}
