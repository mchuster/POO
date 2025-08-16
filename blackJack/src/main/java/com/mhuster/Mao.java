package com.mhuster;

public class Mao {

    private Carta carta1;
    private Carta carta2;
    private Baralho baralho = new Baralho();
    
    public Carta pegaDeCima(){
       if (carta1 == null) {
            carta1 = baralho.pegaDeCima();
        } else if (carta2 == null) {
            carta2 = baralho.pegaDeCima();
        }
        return (carta2 != null) ? carta2 : carta1;
    }   

    
    public void insereEmbaixo(Carta carta){
     
    }

    public int valor(Carta carta){
        int valor = switch(carta.getNumero()){
            case AS -> 1;
            case DOIS -> 2;
            case TRES -> 3;
            case QUATRO-> 4;
            case CINCO-> 5;
            case SEIS-> 6;
            case SETE-> 7;
            case OITO-> 8;
            case NOVE-> 9;
            case DEZ-> 10;
            case VALETE-> 11;
            case DAMA-> 12;
            case REI-> 13;
        };

        return valor;
    }
    
    public int somatorio(){

        int c1 = valor(carta1);
        int c2 = valor(carta2);

        return c1 + c2;
        
    }


    @Override
    public String toString() {
        return "Mao [carta1=" + carta1 + ", carta2=" + carta2 + ", somatorio()=" + somatorio() + "]";
    }

}
