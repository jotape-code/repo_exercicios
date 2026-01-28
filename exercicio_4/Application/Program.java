package exercicio_4.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercicio_4.model.entities.Product;

public class Program {
    
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Type the file path: ");
        String path = sc.nextLine();
        
        List<Product> products = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            while(line != null){
                String[] columns = new String[3];
                columns = line.split(",");
                products.add(new Product(columns[0], Double.parseDouble(columns[1]), Integer.parseInt(columns[2])));
                line = bf.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        File path1 = new File(path);
        new File(path1.getParent() + "\\out").mkdir();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path1.getParent() + "\\out" + "\\Summary.csv"))){
            for(Product product: products){
                bw.write(product.getName() + "," + product.totalValue());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println("Error1: " + e.getMessage());
        }
        sc.close();

    }
}
