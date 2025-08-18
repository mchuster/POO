package com.mhuster;

import java.util.Scanner;

public class Jogador {
    private String nome;
    private Carta[] deck;

    public Jogador(String nome, Carta[] deckInicial){
        
        this.nome = nome;
        this.deck = deckInicial;
    }

    public String getNome() {
        return nome;
    }

    public Carta[] getDeck() {
        return deck;
    }

    public int getPontos(){
        int pontos = 0;
        for (Carta carta : deck) {
            pontos += carta.getValor(carta);
        }
        return pontos;
    }

    public boolean escolherAcao(Scanner input) {
        // Lógica para o jogador escolher entre comprar uma carta ou passar a vez
        while (true) { 
            try {
                System.out.println(nome + ", você tem " + getPontos() + " pontos. Deseja comprar uma carta? (s/n/d - ver deck)");
                String escolha = input.nextLine().trim().toLowerCase();
                if (escolha.equals("s")) {
                    return true; // Jogador escolhe comprar uma carta
                } else if (escolha.equals("n")) {
                    return false; // Jogador escolhe passar a vez
                } else if (escolha.equals("d")) {
                    System.out.println("Seu deck:");
                    for (Carta carta : deck) {
                        System.out.println(carta.toString());
                    }
                    return 
                    escolherAcao(
                        input
                    );
                } else {
                    System.out.println("Opção inválida. Por favor, digite 's' para sim ou 'n' para não.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao processar a entrada. Tente novamente.");
            }
        }
    }

    public void adicionarCartas(Carta[] cartas){
        for (Carta carta : cartas) {
            Carta[] novoDeck = new Carta[deck.length + 1];
            System.arraycopy(deck, 0, novoDeck, 0, deck.length);
            novoDeck[deck.length] = carta;
            deck = novoDeck;
        }
    }
}
