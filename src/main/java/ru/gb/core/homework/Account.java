package ru.gb.core.homework;

import ru.gb.core.homework.exceptions.InsufficientFundsException;
import ru.gb.core.homework.exceptions.IllegalArgumentException;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Функция для снятия денег со счета
     * @param input - сумма
     * @throws InsufficientFundsException - если сумма больше денег, лежащих на счету
     * @throws IllegalArgumentException - при некорректном вводе
     */
    public void withdraw(String input) throws InsufficientFundsException, IllegalArgumentException{
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Количество не может быть пустым" + "\n");
        }
        try{
            double amount = Double.parseDouble(input);
            if (amount > balance) {
                throw new InsufficientFundsException(amount, balance);
            }
            balance -= amount;
            System.out.println("Ваш баланс: " + balance + "₽" + "\n");
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Некорректный ввод." + "\n");
        }
    }

    /**
     * Функция для пополнения счета
     * @param amount - сумма
     * @throws IllegalArgumentException - при некорректном вводе
     */
    public void topUp(String amount) throws IllegalArgumentException {
        try {
            double value = Double.parseDouble(amount);
            if (value < 0) {
                throw new IllegalArgumentException("Количество должно быть положительным" + "\n");
            }
            balance += value;
            System.out.println("Ваш баланс: " + balance + "₽" + "\n");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректный ввод" + "\n");
        }
    }

    /**
     * Конструктор, при создании счета сразу же пополняет на заданную сумму
     * @param balance - сумма
     * @throws IllegalArgumentException - при некорректном вводе
     */

    public Account(String balance) throws IllegalArgumentException {
        this.topUp(balance);
    }

    /**
     * Конструктор без параметров
     */
    public Account() {
        this.balance = 0;
    }
}
