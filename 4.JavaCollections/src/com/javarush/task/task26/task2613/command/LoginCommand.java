package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String cardNumber;
        String pin;
        boolean verified = false;
        do {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumber = getValidNumber("\\d{12}");
            pin = getValidNumber("\\d{4}");
            verified = validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(pin);
            if (!verified) {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }
        } while (!verified);

        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
    }

//    CardNumber    "\\d{12}"
//    PinNumber     "\\d{4}"
    private String getValidNumber(String regex) throws InterruptOperationException {
        String line = ConsoleHelper.readString();
        if (line.matches(regex)) {
            return line;
        } else {
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            return getValidNumber(regex);
        }
    }
}
