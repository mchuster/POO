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