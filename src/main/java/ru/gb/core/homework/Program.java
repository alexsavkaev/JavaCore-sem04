package ru.gb.core.homework;

import ru.gb.core.homework.exceptions.IllegalArgumentException;
import ru.gb.core.homework.exceptions.InsufficientFundsException;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner chooser = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Account account = null;
        boolean flag;
        do {
            flag = true;
            System.out.println("""
                    Управление аккаунтом.\s
                    Выберите действие:\s
                    1. Создать аккаунт\s
                    2. Пополнить счет\s
                    3. Снять деньги с счета\s
                    0. Выход\s
                    """);
            int action = chooser.nextInt();
            switch (action) {
                case 1 -> {
                    System.out.print("Создание аккаунта. Введите начальный баланс: ");
                    try{
                        account = new Account(input.nextLine());
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Пополнение счета. Введите сумму пополнения: ");
                    String amount = input.nextLine();
                    try {
                        assert account != null;
                        account.topUp(amount);
                    } catch (NullPointerException e) {
                        System.out.println("Сначала создайте аккаунт!" + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.print("Снятие денег с счета. Введите сумму снятия: ");
                    String amount = input.nextLine();
                    try {
                        assert account != null;
                        account.withdraw(amount);
                    } catch (NullPointerException e) {
                        System.out.println("Сначала создайте аккаунт!" + "\n");
                    } catch (InsufficientFundsException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 0 -> flag = false;
                default -> System.out.println("Выберите действие из списка (0-3)");
            }
        } while (flag);
    }
}
