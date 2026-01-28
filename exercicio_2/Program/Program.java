package exercicio_2.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import exercicio_2.entities.*;

public class Program {
    
    public static void main(String[] args){
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Pessoa> people = new ArrayList<>();
        
        System.out.println("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for(int i = 1; i<=n; i++){
            System.out.println("TAX payer #" + i + " data");
            System.out.print("Individual or company(i/c)?");
            char option = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.println("Anual income: ");
            Double income = sc.nextDouble();
            if(option == 'i'){
                System.out.print("Health expeditures: ");
                Double health = sc.nextDouble();
                people.add(new PessoaFisica(name, income, health));
            }
            else{
                System.out.print("Number of employees: ");
                Integer employees = sc.nextInt();
                people.add(new PessoaJuridica(name, income, employees));
            }


        }
            System.out.println("TAXES PAID: ");
            for(Pessoa person: people){
                System.out.println(person.getName() + ": $ " + String.format("%.2f", person.imposto()));
            }
        
        sc.close();
    }
}
