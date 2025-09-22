package org.example;

public class Advogado {
    private int nroOAB;
    private String nome;
    private String especialidade;

    public Advogado(int nroOAB, String nome, String especialidade) {
        this.nroOAB = nroOAB;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getNroOAB() {
        return nroOAB;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "Advogado{" +
                "nroOAB=" + nroOAB +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }
}
