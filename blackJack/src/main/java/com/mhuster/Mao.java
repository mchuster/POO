package com.mhuster;

public class Mao {

    private Carta carta1;
    private Carta carta2;
    private Carta[] mao;
    private Baralho baralho = new Baralho();
    
    public Carta[] pegaDeCima(){
        if(carta1 == null){
            carta1 = baralho.pegaDeCima();
        }else if(carta2 == null){
            carta2 = baralho.pegaDeCima();
        }else{
        throw new IllegalStateException("A mão já está cheia");
    }

    mao = new Carta[2];
    mao[1] = carta1;
    mao[2] = carta2;
        
     return mao;
    }   

    
    public void insereEmbaixo(){

    }

    public int somatorio(){
        return 0; 
    }

    public String toString(){
        // devolver uma mao com as cartas do Deck
        return "oi";
    }
}
