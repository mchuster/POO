package org.example;

import java.io.IOException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Atividade 1:
        try {
            CadastroUsuarios cd = new CadastroUsuarios();

            cd.ordena();

            Usuario novo = new Usuario(1212, "Huguinho", "Pato", "zp@disney.com", "Male", "334.255.176");
            cd.insere("Zelda", "Trimnell", novo);


            Iterator<Usuario> it = cd.iterator();
            while(it.hasNext()){
                Usuario u = it.next();
                System.out.println(u);
            }


            for(Usuario u:cd) {
                System.out.println(u);
            }


            int qtdadeRemovidos = cd.removePorIp(200);
            System.out.println("Removidos: "+qtdadeRemovidos);

        } catch (IOException e) {
            System.out.println("Arquivo de dados não encontrado!!");
            System.exit(0);
        }

        //Atividade 3e8:
        List<Integer> matriculas = Arrays.asList(101, 203, 101, 405, 203, 507, 507);
        System.out.println("Lista original: " + matriculas);

        List<Integer> semRepeticao = RemoverRepeticao(matriculas);
        System.out.println("Lista sem repetição (ordenada): " + semRepeticao);

        List<String> d1 = Arrays.asList("Ana", "Bruno", "Carlos", "Daniela", "Fernanda");
        List<String> d2 = Arrays.asList("Bruno", "Carlos", "Eduarda", "Fernanda");
        List<String> d3 = Arrays.asList("Carlos", "Fernanda", "Gustavo", "Helena");

        Alunos(d1, d2, d3);

        //Atividade 4:
        Caixa caixa = new Caixa();

        caixa.cadastrarProduto(new Produtos(101, "Arroz 5kg", 25.90));
        caixa.cadastrarProduto(new Produtos(102, "Feijão 1kg", 8.50));
        caixa.cadastrarProduto(new Produtos(103, "Leite 1L", 4.80));

        caixa.passarProduto(101);
        caixa.passarProduto(103);
        caixa.passarProduto(102);
        caixa.passarProduto(103);

        caixa.imprimirRecibo();
    }

    //Atividade 3:
    public static List<Integer> RemoverRepeticao(List<Integer> numeroMatricula){
        Set<Integer> aux = new TreeSet<>(numeroMatricula);
        List<Integer> nova = new ArrayList<>(aux);
        return nova;
    }

    //Atividade 8:
    public static void Alunos(List<String> d1, List<String> d2, List<String> d3){
        //aljnos das tres materias
        Set<String> todas = new HashSet<>(d1);
        todas.retainAll(d2);
        todas.retainAll(d3);
        System.out.println("Alunos em todas as diciplinas: " + todas);

        //apenas os alunos da materia d1
        Set<String> apenasD1 = new HashSet<>(d1);
        apenasD1.removeAll(d2);
        apenasD1.removeAll(d3);
        System.out.println("Apenas os alunos de D1: " + apenasD1);

        //alunos da diciplina d1 e d2, mas nao esta em d3
        Set<String> alunosD1eD2 = new HashSet<>(d1);
        alunosD1eD2.retainAll(d2);
        alunosD1eD2.removeAll(d3);
        System.out.println("Alunos da diciplina d1 e d2: " + alunosD1eD2);
    }

    //Atividade 6:
    public List<String> listaAlunos(Map<Integer, Aluno> mapa){

        List<String> alunos = new ArrayList<>();
        Set<Aluno> ordenado = new TreeSet<>(mapa.values());

        for(Aluno a : ordenado){
            alunos.add(a.getNome());
        }

        return alunos;
    }
}