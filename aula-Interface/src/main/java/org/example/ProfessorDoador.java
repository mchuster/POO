package org.example;

public class ProfessorDoador extends Professor implements DoadorDeSangue {
    private final TipoSanguinio tipoSanguinio;

    public ProfessorDoador(int matricula, String nome, int cargaHorariaSemanal, TipoSanguinio tipoSanguinio) {
        super(matricula, nome, cargaHorariaSemanal);

        if(tipoSanguinio == null){
            throw new IllegalArgumentException("Tipo sanguíneo não pode ser null ");
        }

        this.tipoSanguinio = tipoSanguinio;
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
