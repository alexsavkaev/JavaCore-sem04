package ru.gb.core.homework.exceptions;

public class InsufficientFundsException extends Exception {
    double amount;
    double balance;
    public InsufficientFundsException (double amount, double balance) {
        this.amount = amount;
        this.balance = balance;
    }
    @Override
    public String getMessage () {
        return "Недостаточно средств на счету: " + "запрошено " + amount + "₽, на счету - " + balance + "₽"+ "\n";
    }
}
