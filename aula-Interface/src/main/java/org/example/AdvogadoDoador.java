package org.example;

public class AdvogadoDoador extends Advogado implements DoadorDeSangue{

    private TipoSanguinio tipoSanguinio;

    public AdvogadoDoador(int nroOAB, String nome, String especialidade, TipoSanguinio tipoSanguinio) {
        super(nroOAB, nome, especialidade);

        if (tipoSanguinio == null) {
            throw new IllegalArgumentException("Tipo sanguíneo não pode ser null");
        }
    }



    @Override
    public TipoSanguinio getTipoSanguinio() {
        return this.tipoSanguinio;
    }
}
