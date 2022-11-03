package com.example.Terminal.TerminalDB.entity;

public class Person {

    String name;
    int age;
    int accountNumber;
    double balance;

    public Person(String n, int a, int ac, double b){
        name = n;
        age = a;
        accountNumber = ac;
        balance = b;
    }

    public Person() {
        super();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
