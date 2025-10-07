package org.example;

public class Aluno implements Comparable<Aluno> {

    private int matricula;
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno(int matricula, String nome, double nota1, double nota2, double nota3){
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public int getMatricula(){return matricula;}
    public double getNota1() {return nota1;}
    public double getNota2() {return nota2;}
    public double getNota3() {return nota3;}
    public String getNome() {return nome;}

    public double mediaAluno(){
        return (nota1 + nota2 + nota3) / 3.0;
    }

    @Override
    public int compareTo(Aluno outro) {
        if(this.mediaAluno() < outro.mediaAluno()) {return -1;}
        else if(this.mediaAluno() > outro.mediaAluno()){return 1;}
        else{return this.nome.compareTo(outro.getNome());}
    }

    @Override
    public String toString() {
        return nome + " - Média: " + String.format("%.2f", mediaAluno());
    }
}
