package Teste_1.Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Teste_1.Entities.*;

public class teste {
    
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>(); 


        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            sc.nextLine();
            System.out.printf("Product #%d data: ", i);
            System.out.print("Common, used or imported(c/u/i)?");
            char type = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            Double fee;
            LocalDate date;
            Product product;
            
            switch (type) {
                case 'i':
                    System.out.println("Custom fee: ");
                    fee = sc.nextDouble();
                    product = new ImportedProduct(name, price, fee);
                    break;
                case 'u':
                    sc.nextLine();
                    System.out.print("Manufactured date(DD/MM/YYYY): ");
                    date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    product = new UsedProduct(name, price, date);
                    break;
                default:
                    product = new Product(name, price);
                    break;
                
            }
            products.add(product);

            
        }
        System.out.println(products.size());
        System.out.println("PRICE TAGS: ");
        for(Product product : products){
            System.out.println(product.priceTag());
        }

        sc.close();
    }
}
