package com.mhuster;


public class ContaCorrente {
    
    private int numeroConta;
    private String nomeCorrentista;
    private double saldo;
    private boolean estado;

public ContaCorrente(String nomeCorrentista, int numeroConta){
    if (nomeCorrentista.length() < 2){
        throw new IllegalArgumentException("Nome do Correntista invalido");
    }
    
    if (numeroConta <= 0){
        throw new IllegalArgumentException(" Numero da conta invalida");
    }
    this.nomeCorrentista = nomeCorrentista;
    this.numeroConta = numeroConta;
    this.saldo = 0;
    this.estado = true;
}
public String getnomeCorrentista(){
    return this.nomeCorrentista;
}

public int getnumeroConta(){
    return this.numeroConta;
}

public void verificarConta(){
    if(!this.estado){
        throw new IllegalArgumentException("Conta inativa");
    }
}

public void deposito(double valor){
    
    verificarConta();

    if(valor <= 0){
        throw new IllegalArgumentException("Valor invalido");
    }
    
    this.saldo = this.saldo + valor;
}

public void sacar (double valor){
    
    verificarConta();
    
    if(valor <= 0){
        throw new IllegalArgumentException("Valor invalido");
    }
    
    this.saldo = this.saldo - valor;
}

public void transferir(ContaCorrente contaDestino, double valor ){
    verificarConta();
    contaDestino.verificarConta();

    if(valor <= 0){
        throw new IllegalArgumentException("Valor invalido");
    }

    if(valor > this.saldo){
        throw new IllegalArgumentException(" Valor maior que o saldo");
   }

   this.saldo -= valor;
   contaDestino.deposito(valor);
}
}
