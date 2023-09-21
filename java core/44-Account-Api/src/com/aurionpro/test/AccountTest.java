package com.aurionpro.test;  
  
import java.util.ArrayList;  
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;  
import java.util.stream.Collectors;  
import java.util.stream.Stream;  
  
import com.aurionpro.model.Account;  
import com.aurionpro.model.Gender;  
  
public class AccountTest {  
 public static void main(String args[]) {  
  // List<Account> accounts = new ArrayList<>();  
  // accounts.add(new Account(1, "Sahil", Gender.Male, 200000));  
  // accounts.add(new Account(2, "Umaid", Gender.Male, 150000));  
  // accounts.add(new Account(3, "Tanish", Gender.Male, 250000));  
  // accounts.add(new Account(4, "Siddhi", Gender.Female, 300000));  
  // accounts.add(new Account(5, "Rasika", Gender.Female, 100000));  
  // accounts.add(new Account(6, "Tanuja", Gender.Female, 90000));  
  // accounts.add(new Account(7, "Sarvesh", Gender.Male, 80000));  
  // accounts.add(new Account(8, "Rohan", Gender.Male, 90000));  
  // accounts.add(new Account(9, "Rohit", Gender.Male, 50000));  
  // accounts.add(new Account(10, "Rahul", Gender.Male, 60000));  
  // accounts.add(new Account(11, "Suswar", Gender.Male, 200000));  
  // accounts.add(new Account(12, "Aniket", Gender.Male, 250000));  
  
  Account[] accounts = {   
    new Account(1, "Sahil", Gender.Male, 200000),  
    new Account(2, "Umaid", Gender.Male, 150000),   
    new Account(3, "Tanish", Gender.Male, 250000),  
    new Account(4, "Siddhi", Gender.Female, 300000),   
    new Account(5, "Rasika", Gender.Female, 100000),  
    new Account(6, "Tanuja", Gender.Female, 90000),   
    new Account(7, "Sarvesh", Gender.Male, 80000),  
    new Account(8, "Rohan", Gender.Male, 90000),   
    new Account(9, "Rohit", Gender.Male, 50000),  
    new Account(10, "Rahul", Gender.Male, 60000),   
    new Account(11, "Suswar", Gender.Male, 200000),  
    new Account(12, "Aniket", Gender.Male, 250000)   
    };  
  
  System.out.println("**************MALE*****************");  
  
  List<Account> collectMale = Arrays.stream(accounts)
    .filter((acc) -> (acc.getGender() == Gender.Male))  
    .collect(Collectors.toList());  
  
  collectMale.forEach( System.out::println);  
  
  System.out.println("*****************FEMALE*******************");  
  
  List<Account> collectFemale = Arrays.stream(accounts)
	.filter((acc) -> (acc.getGender() == Gender.Female))  
    .collect(Collectors.toList());  
  
  collectFemale.forEach((acc) -> System.out.println(acc));  
  
  System.out.println("**************BALANCE****************");  
  
  List<Account> collectBalance = Arrays.stream(accounts)
	.filter((acc) -> (acc.getBalance() >= 100000))  
    .collect(Collectors.toList());  
  
  collectBalance.forEach((acc) -> System.out.println(acc));  
  
  System.out.println("***************getingBalance********************"); 
  
  List<Integer> getingBalance = Arrays.stream(accounts)
  .map((account)->account.getBalance())
  .collect(Collectors.toList());
  
  getingBalance.forEach( System.out::println);
  
  System.out.println("*******get name with high balance**********"); 
  
  List<String> topthree = Arrays.stream(accounts)
  .sorted(Comparator.comparingDouble(Account::getBalance).reversed())
  .map((account)->account.getName())
  .limit(3)
  .collect(Collectors.toList());
  
  topthree.forEach( System.out::println);
  
 }  
  
}
