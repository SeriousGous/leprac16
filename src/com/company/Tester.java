package com.company;

public class Tester {

    Account account = new Account(new Person("Nuts Deez"),3000);

    ATM atm1 = new ATM(account);
    ATM atm2 = new ATM(account);
    ATM atm3 = new ATM(account);

    public void run(){
        new Thread(atm1).start();
        new Thread(atm2).start();
        new Thread(atm3).start();
    }

    public static void main(String[] args) {new Tester().run();}

}