package com.huster;
import java.util.Scanner;
public class App {
    
        public static Scanner sc = new Scanner(System.in);

public static String entraNome() {
    System.out.print("Digite seu nome: ");
    String nome = sc.nextLine();
     return nome;
    }
     public static void main(String[] args) {
    String nome = entraNome();
    System.out.println("Ola, " + nome + "!");
    sc.close();
    }
}
