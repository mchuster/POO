package org.example;

public class FunRisco extends Funcionario{
    private CatRisco catRisco;

    public FunRisco(String matricula, String nome, double salBruto, CatRisco catRisco){
        super (matricula,nome,salBruto);
        this.catRisco = catRisco;
    }

    public CatRisco getCatRisco(){
        return this.catRisco;
    }

    public double getSalarioLiquido(){
        return super.getSalarioLiquido() * 1.25;
    }

    public String toString(){
        return super.toString() + "Categoria de Risco" + getCatRisco();
    }
}
