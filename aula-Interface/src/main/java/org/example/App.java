package org.example;

import java.util.*;

import static org.example.TipoSanguinio.*;

public class App {
    public static void main(String[] args) {
        List<DoadorDeSangue> doadores = new LinkedList<>();

        doadores.add(new ProfessorDoador(100,"Ze", 40, TOPos));
        doadores.add(new AdvogadoDoador(50,"Dr. Ze", "Criminal", TANeg));
        doadores.add(new ProfessorDoador(50,"Outro Ze", 20, TBNeg));
        doadores.add(new AdvogadoDoador(200,"Dr. Outro Ze","Direito de Familia", TOPos));



        System.out.println("--------");
        for(DoadorDeSangue d:doadores){
            System.out.println(d);
        }

        List<Professor> profs = new ArrayList<>();
        profs.add((Professor)doadores.getFirst());
        profs.add((Professor)doadores.get(2));
        profs.add(new Professor(22,"Primo do Ze",30));
        profs.add(new Professor(12,"Outro Primo do Ze",15));

        System.out.println("--------");
        for(Professor p:profs){
            System.out.println(p);
        }

        //List<String> lst = List.of("Ze","Ana","Pedro");
        //Collections.sort(lst);

        Collections.sort(profs);

        System.out.println("--------");
        for(Professor p:profs){
            System.out.println(p);
        }

        List<Advogado> advs = new ArrayList<>();
        advs.add((Advogado)doadores.get(1));
        advs.add((Advogado)doadores.get(3));
        advs.add(new Advogado(500,"Dr. Importante","Criminal"));
        advs.add(new Advogado(5,"Dr. Muito Importante","Familia"));

        //Collections.sort(advs,new ComparadorAdvogado());

        Collections.sort(advs,new Comparator<Advogado>(){
            @Override
            public int compare(Advogado o1, Advogado o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });

        System.out.println("\nAdvogados ordenados:");
        for(Advogado ad:advs){
            System.out.println(ad);
        }

        System.out.println("--------");
        identificarTS(doadores);

        List<Advogado> listaAd= new ArrayList<>();
        listaAd.add(new Advogado(5120, "Ana Silva", "Direito Civil"));
        listaAd.add(new Advogado(3011, "Bruno Costa", "Direito Penal"));
        listaAd.add(new Advogado(7422, "Carla Mendes", "Direito Trabalhista"));
        listaAd.add(new Advogado(2100, "Diego Rocha", "Direito Tributário"));
        listaAd.add(new Advogado(6333, "Fernanda Alves", "Direito Empresarial"));
        listaAd.add(new Advogado(1502, "Gustavo Lima", "Direito Ambiental"));
        listaAd.add(new Advogado(8890, "Helena Duarte", "Direito Digital"));
        listaAd.add(new Advogado(4321, "Igor Martins", "Direito Internacional"));
        listaAd.add(new Advogado(2789, "Juliana Ribeiro", "Direito Constitucional"));
        listaAd.add(new Advogado(3675, "Lucas Pereira", "Direito da Família"));

        System.out.println("--------");
        Collections.sort(listaAd);
        for(Advogado ad : listaAd){
            System.out.println(ad);
        }
    }

    public static void identificarTS(List<DoadorDeSangue> lista) {
        for(int i = 0; i < lista.size(); i++){
            if( lista.get(i).getTipoSanguinio() == null && lista.get(i).getTipoSanguinio() == TOPos){
                System.out.println("Nome: " + lista.get(i).getNome());
                System.out.println("Classe:" + lista.get(i).getClass().getSimpleName());
            }
        }
    }
}
