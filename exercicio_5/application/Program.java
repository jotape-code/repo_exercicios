package exercicio_5.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import exercicio_5.model.entities.Contract;
import exercicio_5.model.services.ContractService;
import exercicio_5.model.services.PaypalService;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Enter the contract date: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date(dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Contract value: ");
        Double value = sc.nextDouble();
        System.out.print("Type the number of installments: ");
        Integer months = sc.nextInt();

        Contract contract = new Contract(number, date, value);
        ContractService cs = new ContractService(new PaypalService());
        cs.ProcessContract(contract, months);
        
        for(int j = 0; j < months; j++){
            System.out.println(fmt.format(contract.getInstallments()[j].getDueDate()) + " - " + String.format("%.2f", contract.getInstallments()[j].getAmount()));
        }

        sc.close();
    }    
}
