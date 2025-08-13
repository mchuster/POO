package com.mhuster;

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

    public Carta pegaDeCima(){
        if(cartaDeCima == TAM_BARALHO){
            throw new IllegalStateException("Baralho vazio");
        }
        Carta c = cartas[cartaDeCima];
        cartaDeCima++;
        return c;
    }

    public void embaralho(){
        
    }

}
