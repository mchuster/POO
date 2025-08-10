package com.mhuster;

import java.time.LocalDate;

public class OperacaoBancaria {
    
    private double valor;
    private String tipoOperaçao;
    private LocalDate data;

    public OperacaoBancaria(double valor, String tipo, LocalDate data){
        if (tipo == null){
            throw new IllegalArgumentException("Tipo de operaçao invalida");
        }
        if(valor <= 0){
            throw new IllegalArgumentException("O valor esta invalido");
        }
        if(data == null){
            throw new IllegalArgumentException("Data invalida");
        }

        this.valor = valor;
        this.tipoOperaçao = tipo;
        this.data = data;
    }
    public double getValor(){
        return this.valor;
    }
    public String getTipoOperaçao(){
        return this.tipoOperaçao;
    }
    public LocalDate getData(){
        return this.data;
    }
}
