package Exercicio_7.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter file full path: ");
        String path = sc.nextLine();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            Map<String, Integer> candidates = new TreeMap<>();
            
            String line = bf.readLine();
            while(line != null){
                String[] fields = line.split(",");
                if(candidates.containsKey(fields[0])){
                    candidates.put(fields[0], candidates.get(fields[0]) + Integer.parseInt(fields[1]));
                }
                else{
                    candidates.put(fields[0], Integer.parseInt(fields[1]));
                }
                line = bf.readLine();
            }
            for(String name : candidates.keySet()){
                System.out.println(name + ": " + candidates.get(name));
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
