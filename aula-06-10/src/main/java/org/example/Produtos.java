package org.example;

public class Produtos {

    private final int codigo;
    private final String descricao;
    private final double preco;

    public Produtos(int codigo, String descricao, double preco){
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo(){return codigo;}
    public String getDescricao() {return descricao;}
    public double getPreco() {return preco;}

    @Override
    public String toString() {
        return "Produtos{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
