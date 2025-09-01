package org.example;

public class Funcionario {
    public static final double LIM_ISENCAO_IR = 2000;
    private String matricula;
    private String nome;
    private double salarioBruto;
    private double risco;
    private int categoriaPesquisador;

    public Funcionario(String matricula, String nome, double salarioBruto, double risco, int categoriaPesquisador){
        this.matricula = matricula;
        this.nome = nome;
        this. salarioBruto = salarioBruto;
        this.risco = risco;
        this.categoriaPesquisador = categoriaPesquisador;

    }

    public int getCategoriaPesquisador(){
        if(categoriaPesquisador < 1 || categoriaPesquisador > 3){
            return 0;
        }else {
            return categoriaPesquisador;
        }
    }

    public double getRisco(){
        return risco;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getINSS(){
        return salarioBruto*0.1;
    }

    public double getImpRenda(){
        if (salarioBruto <= LIM_ISENCAO_IR){
            return 0.0;
        }else{
            double aux = salarioBruto - LIM_ISENCAO_IR;
            double ir = aux * 0.2;
            return ir;
        }
    }

    public double getValorRisco() {
        if (this.risco < 0) {
            return 0.0;
        } else {
            return (salarioBruto - getINSS() - getImpRenda()) * 0.25;
        }
    }

    public double getBonosPesquisador(){
        if(categoriaPesquisador == 1){
            return (salarioBruto - getINSS() - getImpRenda())*0.05;
        }
        if(categoriaPesquisador == 2){
            return (salarioBruto - getINSS() - getImpRenda())*0.10;
        }
        if(categoriaPesquisador == 3){
            return (salarioBruto - getINSS() - getImpRenda())*0.20;
        }
        return 0.0;
    }

    public double getSalarioLiquido(){
        salarioBruto = salarioBruto - getINSS() - getImpRenda() + getBonosPesquisador();
        if(this.risco > 0.0){
            return salarioBruto + getValorRisco();
        }else{
         return salarioBruto;
        }
    }

    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Categoria do Pesquisador: "+this.getCategoriaPesquisador()+"\n";
        aux += "Risco: "+this.getRisco()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "(-) IR: "+this.getImpRenda()+"\n";
        aux += "(+) Valor de Risco: "+this.getValorRisco()+"\n";
        aux += "(+) Bonos Pesquisador: "+this.getBonosPesquisador()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;
    }

}
