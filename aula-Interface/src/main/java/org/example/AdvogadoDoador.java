package org.example;

public class AdvogadoDoador extends Advogado implements DoadorDeSangue{

    private TipoSanguinio tipoSanguinio;

    public AdvogadoDoador(int nroOAB, String nome, String especialidade) {
        super(nroOAB, nome, especialidade);
    }

    @Override
    public TipoSanguinio getTipoSanguinio() {
        return this.tipoSanguinio;
    }
}
