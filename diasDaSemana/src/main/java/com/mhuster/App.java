package com.mhuster;

import java.util.Scanner;

public class App {
    
    
    public static String int2Day(int dia, boolean traduçao){

        if(traduçao){
            return switch (dia){
            case 1 -> "Dia do senhor";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Dia de descanso";
            default-> throw new IllegalArgumentException("Dia invalido");
        };
    }
        return switch (dia){
            case 1 -> "Domingo";
            case 2 -> "Segunda-Feira";
            case 3 -> "Terça-Feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> throw new IllegalArgumentException("Dia inválido");
        };
    }    
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe o numero do dia da semana: ");
        int dia = in.nextInt();
        
        System.out.print("\nDeseja traduzir ? 1-Sim / 2-Nao: ");
        int t = in.nextInt();
        
        boolean traduçao = false;
        in.close();

        if(t > 2 || t < 1){
            throw new IllegalArgumentException("Resposta invalida");
        }
        if (t == 1){
            traduçao = true;
        }

        String resultado = int2Day(dia, traduçao);

        System.out.println("\n " + resultado);

    }
}
