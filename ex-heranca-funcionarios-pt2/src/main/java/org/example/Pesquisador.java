package org.example;

public class Pesquisador extends Funcionario {
    private int catPesq;

    public Pesquisador(String matricula, String nome, double salBruto, int catPesq){
        super (matricula, nome, salBruto);
        if(catPesq < 1 || catPesq > 3){
            throw new IllegalArgumentException("Categoria de Pesquisador invalido");
        }else{
            this.catPesq = catPesq;
        }
    }

    public int getCatPesq(){
        return this.catPesq;
    }

    public double getSalarioLiquido(){
        switch (catPesq){
            case 1 : return super.getSalarioLiquido() * 1.1;
            case 2 : return super.getSalarioLiquido() * 1.2;
            case 3: return super.getSalarioLiquido() * 1.3;
        }
        return 0;
    }
}
