package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App{
public static List<String> processaNomes(List<String> nomes, Function<String, String> operacao, Predicate<String> condicao) {
        List<String> resultado = new LinkedList<>();
        for (String nome : nomes) {
            String aux = operacao.apply(nome);
            if (condicao.test(aux)) {
                resultado.add(aux);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();

        nomes.add("Ana Silva");
        nomes.add("Bruno Costa");
        nomes.add("Carla Souza");
        nomes.add("Diego Pereira");
        nomes.add("Eduarda Lima");
        nomes.add("Elisa Vieira");
        nomes.add("Felipe Rocha");
        nomes.add("Gabriela Mendes");
        nomes.add("Henrique Alves");
        nomes.add("Isabela Martins");
        nomes.add("João Batista");
        nomes.add("Berenice Fisher");

        // Funções base
        Function<String, String> extraiNome = n -> n.substring(0, n.indexOf(" "));
        Function<String, String> extraiSobrenome = n -> n.substring(n.indexOf(" ") + 1);
        Predicate<String> tudo = n -> true;

        // 1) Nomes completos que começam pela letra "B"
        Predicate<String> comecaComB = n -> n.startsWith("B");
        System.out.println("1) Nomes completos que começam por B:");
        processaNomes(nomes, Function.identity(), comecaComB)
                .forEach(System.out::println);
        System.out.println();

        // 2) Primeiros nomes com mais de 5 letras
        Predicate<String> maisDe5 = n -> extraiNome.apply(n).length() > 5;
        System.out.println("2) Primeiros nomes com mais de 5 letras:");
        processaNomes(nomes, extraiNome, maisDe5)
                .forEach(System.out::println);
        System.out.println();

        // 3) Primeiros nomes que começam por "B" e têm mais de 5 letras
        Predicate<String> comecaComBEMaisDe5 = comecaComB.and(maisDe5);
        System.out.println("3) Primeiros nomes que começam por B e têm mais de 5 letras:");
        processaNomes(nomes, extraiNome, comecaComBEMaisDe5)
                .forEach(System.out::println);
        System.out.println();

        // 4) Nomes completos em maiúsculas
        Function<String, String> maiusculo = String::toUpperCase;
        System.out.println("4) Nomes completos em maiúsculas:");
        processaNomes(nomes, maiusculo, tudo)
                .forEach(System.out::println);
        System.out.println();

        // 5) Primeiros nomes em maiúsculas
        System.out.println("5) Primeiros nomes em maiúsculas:");
        processaNomes(nomes, extraiNome.andThen(String::toUpperCase), tudo)
                .forEach(System.out::println);
        System.out.println();

        // 6) Iniciais do primeiro nome e do sobrenome concatenadas
        Function<String, String> iniciais = n ->
                "" + n.charAt(0) + n.charAt(n.indexOf(" ") + 1);
        System.out.println("6) Iniciais do primeiro nome e sobrenome:");
        processaNomes(nomes, iniciais, tudo)
                .forEach(System.out::println);
        System.out.println();

        // 7) Iniciais apenas dos nomes cujo primeiro nome começa por "B" ou "E"
        Predicate<String> comecaComBouE = n -> {
            String nome = extraiNome.apply(n);
            return nome.startsWith("B") || nome.startsWith("E");
        };
        System.out.println("7) Iniciais dos nomes que começam por B ou E:");
        processaNomes(nomes, iniciais, comecaComBouE)
                .forEach(System.out::println);
    }
}


