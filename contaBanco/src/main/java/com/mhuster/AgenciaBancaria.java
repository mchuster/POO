package com.mhuster;

public class AgenciaBancaria {

    private int numero;
    private String nome;
    private ContaCorrente[] contas;

    public void agenciaBancaria(int numero, String nome){

        if(nome.length() < 2){
            throw new IllegalArgumentException("nome de conta invalido");
        }
        this.nome = nome;
        
        if(numero <= 0){
            throw new IllegalArgumentException("numero de conta invalido");
        }
        this.numero = numero;
        this.contas = new ContaCorrente[1000];

       

    }

    public void cadastrarConta(ContaCorrente conta){

         for(int i = 0; i < contas.length; i++){

            if(conta.getnumeroConta() == contas[i].getnumeroConta()){
                throw new IllegalArgumentException("numero de conta ja existente");
            }    
        }

        for(int i = 0; i < contas.length; i++){
            if(contas[i] == null){
                contas[i] = conta;
            }
        }
    }

    public ContaCorrente recuperarConta(int numero){
        for(int i = 0; i < contas.length; i++){

            if(contas[i].getnumeroConta() == numero){
                return contas[i];
            }
        }

        throw new IllegalArgumentException("esta conta nao existe");
    }

    public void encerrarConta(int numero){
        
    }

}
