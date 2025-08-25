package com.mhuster;

import java.util.ArrayList;

public class AgenciaBancaria {
    private int numero;
    private String nome;
    private ArrayList<ContaCorrente> contas;
    private int proxLivre;

    public AgenciaBancaria(int numero, String nome) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Número da agência deve ser positivo.");
        }
        if (nome == null || nome.length() < 2) {
            throw new IllegalArgumentException("Nome da agência deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.proxLivre = 0;
    }

    public void cadastrarConta(ContaCorrente conta) {
        
        for (int c = 0; c<proxLivre; c++) {
            if (contas.get(c).getNumero() == conta.getNumero()) {
                throw new IllegalArgumentException("Já existe uma conta com esse número.");
            }
        }
        contas.add(conta);
    }

    public ContaCorrente recuperarConta(int numeroConta) {
        for (int i=0;i<proxLivre;i++) {
            if (contas.get(i).getNumero() == numeroConta) {
                return contas.get(i);
            }
        }
        return null;
    }

    public void encerrarConta(int numeroConta) {
        ContaCorrente conta = recuperarConta(numeroConta);
        if (conta == null) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        if (!conta.isAtiva()) {
            throw new IllegalStateException("Conta já está encerrada.");
        }
        conta.fecha();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }
}