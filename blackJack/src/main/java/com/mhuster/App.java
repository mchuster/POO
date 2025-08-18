package com.mhuster;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

       

        Jogador[] jogadores = new Jogador[2];

        Baralho baralho = new Baralho();

        jogadores[0] = new Jogador("Jogador 1", baralho.getCartas(1));

        jogadores[1] = new Jogador("Jogador 2", baralho.getCartas(1));

        

        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + " - " + jogador.getDeck()[0].toString());
        }

        
        int vezesPassadas = 0;
        while (!baralho.isVazio() && verificarStatus(jogadores) && vezesPassadas < 2) {
            for (Jogador jogador : jogadores) {
                if (baralho.isVazio()) {
                    break;
                }

                
                if (jogador.escolherAcao(input)) {
                    vezesPassadas = 0; // Resetar contagem de vezes passadas
                    jogador.adicionarCartas(baralho.getCartas(1));
                }else{
                    vezesPassadas++;
                }
            }
        }

      

        if (jogadores[0].getPontos() > jogadores[1].getPontos() && jogadores[0].getPontos() <= 21) {
            System.out.println(jogadores[0].getNome() + " venceu com " + jogadores[0].getPontos() + " pontos!");
        } else if (jogadores[0].getPontos() < jogadores[1].getPontos() && jogadores[1].getPontos() <= 21) {
            System.out.println(jogadores[1].getNome() + " venceu com " + jogadores[1].getPontos() + " pontos!");
        } else {
            System.out.println("Empate!");
        }

    }

    private static boolean verificarStatus(Jogador[] jogadores) {
        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() >= 21) {
                return false; 
            }

            if(jogador.getDeck().length >= 5){
            
                return false;
            }
        }
        return true; 
    }
}

