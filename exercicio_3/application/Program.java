package exercicio_3.application;

import java.util.Locale;
import java.util.Scanner;

import exercicio_3.model.entities.Account;
import exercicio_3.model.exceptions.TesteException;

public class Program {
    public static void main(String[] args){
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    try{
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double balance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double limit = sc.nextDouble();
        System.out.println("\n");
        
        Account account = new Account(number, holder, balance, limit);

        System.out.print("Enter amount for withdraw: ");
        Double withdraw = sc.nextDouble();
        account.withdraw(withdraw);
        System.out.print("New balance: " + account.getBalance());
    }
    catch(TesteException e){
        System.out.println("Withdraw error: " + e.getMessage());
    }
    sc.close();
    }
}
