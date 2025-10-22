package org.example;
/*
 * Os atributos de um carro são:
 * placa, ano, cor, modelo, marca e valor.
 */
class Carro implements Comparable<Carro>{
    public enum Cor {
        AZUL, AMARELO, VERMELHO, VERDE, LARANJA, PRETO, BRANCO
    }

    private String placa;
    private int ano;
    private Cor cor;
    private String modelo;
    private String marca;
    private double valor;

    public Carro(String placa, int ano, Cor cor, String modelo, String marca, double valor) {
        if (placa == null || cor == null || modelo == null || marca == null) {
            throw new IllegalArgumentException("Atributos String não podem ser nulos.");
        }
        if (!placa.matches("^[A-Za-z]{3}\\d{4}$")) {
            throw new IllegalArgumentException("Placa inválida. Deve conter 3 letras seguidas de 4 dígitos.");
        }
        this.placa = placa;
        this.ano = ano;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.valor = valor;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public Cor getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public int compareTo(Carro outro) {
        return (int)(this.getValor() - outro.getValor());
    }
    
    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", ano=" + ano +
                ", cor=" + cor +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", valor=" + valor +
                '}';
    }
}