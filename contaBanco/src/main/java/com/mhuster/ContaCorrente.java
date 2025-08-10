package com.mhuster;

import java.time.LocalDate;


public class ContaCorrente {
    
    private int numeroConta;
    private String nomeCorrentista;
    private double saldo;
    private boolean estado;
    private OperacaoBancaria[] operacoes = new OperacaoBancaria[100];

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

/**
 * @param valor
 */
public void deposito(double valor){
    
    verificarConta();

    if(valor <= 0){
        throw new IllegalArgumentException("Valor invalido");
    }
    
    this.saldo = this.saldo + valor;
    
    OperacaoBancaria operacao = new OperacaoBancaria(valor, "Deposito", LocalDate.now());
    for(int i = 0; i < operacoes.length; i++){
        if(operacoes[i] == null){
            operacoes[i] = operacao;
            break;
        }
    }
}

public void sacar (double valor){
    
    verificarConta();
    
    if(valor <= 0){
        throw new IllegalArgumentException("Valor invalido");
    }
    
    this.saldo = this.saldo - valor;

    OperacaoBancaria operacao = new OperacaoBancaria(valor, "Saque", LocalDate.now());
        for (int i = 0; i < operacoes.length; i++) {
            if (operacoes[i] == null) {
                operacoes[i] = operacao;
                break;

        }
    }
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

public void desativarConta(){
        this.estado = false;
    }
    public OperacaoBancaria[] getOperacoes() {
        return operacoes;
    }

public OperacaoBancaria[] getOperacoesMes(int mes, int ano) {
        OperacaoBancaria[] operacoesMes = new OperacaoBancaria[100];
        int index = 0;

    for (OperacaoBancaria operacao : operacoes) {
            if (operacao != null && operacao.getData().getMonthValue() == mes && operacao.getData().getYear() == ano) {
                operacoesMes[index++] = operacao;
            }
        }

        return operacoesMes;
    }

public String exibirOperacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operações da conta ").append(numeroConta).append(":\n");
        for (OperacaoBancaria operacao : operacoes) {
            if (operacao != null) {
                sb.append(operacao.toString()).append("\n");
            }
        }
        return sb.toString();
    }

}