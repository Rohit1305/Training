package com.aurionpro.test;

import com.aurionpro.model.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountTest {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, "Akash", 1000.0));
        accounts.add(new Account(2, "Rahul", 2500.0));
        accounts.add(new Account(3, "Ujjwal", 1500.0));
        accounts.add(new Account(4, "Siddhi", 3000.0));
        accounts.add(new Account(5, "Rohit", 500.0));

        // a. Show Account details of account with minimum Balance
        System.out.println("Account with minimum balance:");
        accounts.stream()
            .min((acc1, acc2) -> Double.compare(acc1.getBalance(), acc2.getBalance()))
            .ifPresent(account -> System.out.println(account.getName() + " - " + account.getBalance()));

        // b. Show Account details of account with maximum Balance
        System.out.println("\nAccount with maximum balance:");
        accounts.stream()
            .max((acc1, acc2) -> Double.compare(acc1.getBalance(), acc2.getBalance()))
            .ifPresent(account -> System.out.println(account.getName() + " - " + account.getBalance()));

        // c. Show names greater than 6 characters
        System.out.println("\nNames greater than 6 characters:");
        accounts.stream()
            .filter(account -> account.getName().length() >= 6)
            .forEach(account -> System.out.println(account.getName()));

        // d. Find total balance of all accounts using stream
        double totalBalance = accounts.stream()
            .mapToDouble(Account::getBalance)
            .sum();
        System.out.println("\nTotal balance of all accounts: " + totalBalance);
    }
}
