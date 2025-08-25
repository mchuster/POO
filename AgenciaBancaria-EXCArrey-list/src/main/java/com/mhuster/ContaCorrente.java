package com.mhuster;

import java.time.LocalDateTime;

public class ContaCorrente{
    private static final int MAXENTRADAS = 10000;
    private int numero;
    private String correntista;
    private double saldo;
    private boolean ativa;
    private EntradaExtrato[] extrato;
    private int proxLivre;

    public ContaCorrente(int numero, String correntista) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número da conta não pode ser negativo.");
        }
        if (correntista == null || correntista.length() < 2) {
            throw new IllegalArgumentException("Correntista não pode ser nulo e deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = 0.0;
        this.ativa = true;
        this.extrato = new EntradaExtrato[MAXENTRADAS];
        this.proxLivre = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getCorrentista() {
        return correntista;
    }

    public double getSaldo() {
        return saldo;
    }

    public EntradaExtrato[] getExtrato(){
        EntradaExtrato[] copia = new EntradaExtrato[proxLivre];
        for (int i = 0; i < proxLivre; i++) {
            copia[i] = extrato[i];
        }
        // Comando alternativo
        //copia = Arrays.copyOf(extrato, proxLivre);
        return copia;
    }
    
    public boolean isAtiva() {
        return ativa;
    }

    public void deposita(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;
        extrato[proxLivre] = new EntradaExtrato(LocalDateTime.now(), TipoOperacao.DEPOSITO, valor);
        proxLivre++;
    }

    public void saca(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        extrato[proxLivre] = new EntradaExtrato(LocalDateTime.now(), TipoOperacao.RETIRADA, valor);
        proxLivre++;
    }

    public void transfere(double valor, ContaCorrente contaDestino) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;
        extrato[proxLivre] = new EntradaExtrato(LocalDateTime.now(), TipoOperacao.RETIRADA, valor);
        proxLivre++;
        contaDestino.deposita(valor);
    }

    public void fecha() {
        if (saldo > 0.0){
            throw new IllegalArgumentException("A conta ainda tem saldo e não pode ser fechada");
        }
        ativa = false;
    }
    
    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", correntista='" + correntista + '\'' +
                ", saldo=" + saldo +
                ", ativa=" + ativa +
                '}';
    }
}