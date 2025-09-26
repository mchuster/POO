package org.example;

public class ProfessorDoador extends Professor implements DoadorDeSangue {
    private TipoSanguinio tipoSanguinio;

    public ProfessorDoador(int matricula, String nome, int cargaHorariaSemanal, TipoSanguinio tipoSanguinio) {
        super(matricula, nome, cargaHorariaSemanal);
    }

    @Override
    public TipoSanguinio getTipoSanguinio() {
        return this.tipoSanguinio;
    }

    @Override
    public String toString() {
        return "ProfessorDoador{" +
                "tipoSanguinio=" + tipoSanguinio +
                '}';
    }
}
