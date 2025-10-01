package org.example;

import java.util.Comparator;

public class ComparadorAdvogado implements Comparator<Advogado> {
    @Override
    public int compare(Advogado ad1, Advogado ad2) {
        return ad1.getNome().compareTo(ad2.getNome());
    }
}

