package com.mhuster;

import java.util.Random;

public class Baralho {
    
    private static final int TAM_BARALHO = 52;
    private Carta[] cartas;
    private int cartaDeCima;

    public Baralho(){
        cartas = new Carta[TAM_BARALHO];
        cartaDeCima = 0;
        int pos = 0;
        
        for(Naipe n:Naipe.values()){
            for(Numero v: Numero.values()){
                Carta carta = new Carta(n, v);
                cartas[pos] = carta;  // == cartas[pos++] = carta;
                pos++;
            }
        }
    }

    public boolean vazio(){
        return this.cartaDeCima >= TAM_BARALHO;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public Carta[] getCartas(int quantidade) {
        if (quantidade < 1 || quantidade > TAM_BARALHO - cartaDeCima) {
            throw new IllegalArgumentException("Quantidade inválida de cartas solicitadas");
        }
        Carta[] cartasRetiradas = new Carta[quantidade];
        for (int i = 0; i < quantidade; i++) {
            cartasRetiradas[i] = pegaDeCima();
        }
        return cartasRetiradas;
    }

        public boolean isVazio() {
            return cartaDeCima == TAM_BARALHO;
    }


    public Carta pegaDeCima(){
        if(cartaDeCima == TAM_BARALHO){
            throw new IllegalStateException("Baralho vazio");
        }
        Carta c = cartas[cartaDeCima];
        cartaDeCima++;
        return c;
    }

    public void embaralho(){
        Random gerador = new Random();
        
        for(int i = TAM_BARALHO - 1; i > 0; i--){
        int j = gerador.nextInt(i + 1);
        
        Carta temp = cartas[i];
        cartas[i] = cartas[j];
        cartas[j] = temp;
        }
    }

    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Carta carta : cartas) {
        sb.append(carta).append("\n");
    }
    return sb.toString();
}


}
