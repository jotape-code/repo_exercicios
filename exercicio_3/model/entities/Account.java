package exercicio_3.model.entities;

import exercicio_3.model.exceptions.TesteException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public Double getBalance(){
        return balance;
    }
    public void deposit(Double amount){
        balance += amount;
    }
    public void withdraw(Double amount) throws TesteException{
        if(amount > withdrawLimit){
            throw new TesteException("The amount exceeds the withdraw limit");
        }
        if(amount > balance){
            throw new TesteException("Not enough balance");
        }
        balance -= amount;
    }
}
