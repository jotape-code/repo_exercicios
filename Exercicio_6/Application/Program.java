package Exercicio_6.Application;


import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;



public class Program {
    
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int num;
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> C = new HashSet<>();



        System.out.print("How many students in course A?");
        num = sc.nextInt();
        for(int i = 0; i < num; i++){
            A.add(sc.nextInt());
        }

        System.out.print("How many students in course B?");
        num = sc.nextInt();
        for(int i = 0; i < num; i++){
            B.add(sc.nextInt());
        }

        System.out.print("How many students in course C?");
        num = sc.nextInt();
        for(int i = 0; i < num; i++){
            C.add(sc.nextInt());
        }
       
        Set<Integer> total = new HashSet<>(A);
        total.addAll(B);
        total.addAll(C);

        System.out.printf("Total Students: %d", total.size());
        sc.close();
    }
}
