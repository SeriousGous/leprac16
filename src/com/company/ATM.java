package com.company;

public class ATM implements Runnable{

    private final Account account;

    public ATM(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            synchronized (account) {
                int numba = (int)(( Math.random() * 2001));
                randomAction(numba);
                System.out.println(Thread.currentThread().getName() + " " + account.getBalance());
                account.notify();
                try {
                    account.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void addBalance(int sum){
        account.setBalance(account.getBalance()+sum);
    }

    public void subBalance(int sum){
        account.setBalance(account.getBalance()-sum);
    }

    public void randomAction(int sum){
        int numba = (int)(( Math.random() * (2)));
        if(numba > 0)
            addBalance(sum);
        else if(sum < account.getBalance())
            subBalance(sum);
    }
}