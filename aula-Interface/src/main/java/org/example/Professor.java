package org.example;

public class Professor implements Comparable<Professor>{
    private int matricula;
    private String nome;
    private int cargaHorariaSemanal;

    public Professor(int matricula, String nome, int cargaHorariaSemanal) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    @Override
    public int compareTo(Professor outro) {
        //return this.getNome().compareTo(outro.getNome());

        if(this.getMatricula() < outro.getMatricula()){return -1;}
        if(this.getMatricula() == outro.getMatricula()){return 0;}
        return 1;
    }
}