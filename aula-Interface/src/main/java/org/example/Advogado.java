package org.example;

import java.util.Comparator;
import java.util.List;

public class Advogado implements Comparable<Advogado> {
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

    @Override
    public int compareTo(Advogado ad) {
        return Integer.compare(this.nroOAB, ad.getNroOAB());
    }
}
