package com.mhuster;

public class Carta{

    private Naipe naipe;
    private Numero numero;

    public Carta(Naipe naipe, Numero numero){
        this.naipe = naipe;
        this.numero = numero;
    }

    public Naipe getNaipe(){
        return naipe;
    }
    public Numero getNumero(){
        return numero;
    }

    public int getValor(Carta carta){
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


    
    
    
    
    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carta{");
        sb.append("naipe=").append(naipe);
        sb.append(", numero=").append(numero);
        sb.append('}');
        return sb.toString();
    }

    
}