package org.example;

import java.util.*;

import static org.example.TipoSanguinio.*;

public class App {
        public static void main(String[] args) {

            List<DoadorDeSangue> doadores = new LinkedList<>();
            doadores.add(new ProfessorDoador(100, "Ze", 40, TOPos));
            doadores.add(new AdvogadoDoador(50, "Dr. Ze", "Criminal", TANeg));
            doadores.add(new ProfessorDoador(50, "Outro Ze", 20, TBNeg));
            doadores.add(new AdvogadoDoador(200, "Dr. Outro Ze", "Direito de Familia", TOPos));


            System.out.println("Lista original de doadores:");
            for (DoadorDeSangue d : doadores) {
                System.out.println(d);
            }

            doadores.sort(new Comparator<DoadorDeSangue>() {
                @Override
                public int compare(DoadorDeSangue d1, DoadorDeSangue d2) {
                    return d1.getTipoSanguinio().compareTo(d2.getTipoSanguinio());
                }
            });

            System.out.println("\nLista de doadores ordenada por tipo sanguíneo:");
            for (DoadorDeSangue d : doadores) {
                System.out.println(d);
            }

            List<Professor> profs = new ArrayList<>();
            List<Advogado> advs = new ArrayList<>();

            for (DoadorDeSangue d : doadores) {
                if (d instanceof ProfessorDoador) {
                    profs.add((ProfessorDoador) d);
                } else if (d instanceof AdvogadoDoador) {
                    advs.add((AdvogadoDoador) d);
                }
            }

            profs.add(new Professor(22, "Primo do Ze", 30));
            profs.add(new Professor(12, "Outro Primo do Ze", 15));

            advs.add(new Advogado(500, "Dr. Importante", "Criminal"));
            advs.add(new Advogado(5, "Dr. Muito Importante", "Familia"));


            profs.sort(new Comparator<Professor>() {
                @Override
                public int compare(Professor p1, Professor p2) {
                    return p1.getNome().compareTo(p2.getNome());
                }
            });

            System.out.println("\nProfessores ordenados por nome:");
            for (Professor p : profs) {
                System.out.println(p);
            }

            advs.sort(new Comparator<Advogado>() {
                @Override
                public int compare(Advogado a1, Advogado a2) {
                    return a1.getNome().compareTo(a2.getNome());
                }
            });

            System.out.println("\nAdvogados ordenados por nome:");
            for (Advogado a : advs) {
                System.out.println(a);
            }

            identificarTS(doadores);

            List<Advogado> listaAd = new ArrayList<>();
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

            Collections.sort(listaAd);

            System.out.println("\nLista extra de advogados ordenada por número da OAB:");
            for (Advogado ad : listaAd) {
                System.out.println(ad);
            }
        }

        public static void identificarTS(List<DoadorDeSangue> lista) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getTipoSanguinio() == null && lista.get(i).getTipoSanguinio() == TOPos) {
                    System.out.println("Nome: " + lista.get(i).getNome());
                    System.out.println("Classe:" + lista.get(i).getClass().getSimpleName());
                }
            }
        }
    }

