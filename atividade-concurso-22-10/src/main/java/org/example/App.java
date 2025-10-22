package org.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        EstoqueDeCarros estoque;
       
        try {
            estoque = new EstoqueDeCarros("carros.csv");
        } catch (IOException e) {
            System.err.println("Erro ao carregar o estoque de carros: " + e.getMessage());
            return;
        }

        System.out.println("\nQuantidade de carros fabricados em 2023: " + estoque.quantidadeCarros2023());

        System.out.printf("\nSomatório dos valores: R$ %.2f%n", estoque.somatorioValores2024());

        System.out.printf("\nPreço médio dos carros fabricados entre 2000 e 2010: R$ %.2f%n",estoque.precoMedio2000a2010());

        var placas = estoque.placasPretosOuBrancosLuxoGMMenos3Anos();
        System.out.printf("\nPlacas de carros pretos ou branco, modelo luxo, marca GM, com menos de 3 anos (%d):%n",placas.size());
        System.out.println(" " + String.join(", ", placas));

        System.out.println("\nPrimeiro carro Ford vermelho: " + estoque.primeiroFordVermelho());

        System.out.println("\nExiste Fiat branco, modelo luxo, entre R$ 150.000 e R$ 180.000? "
                + estoque.existeFiatBrancoLuxoEntre150e180());

        System.out.println("\nCarro mais barato: " + estoque.carroMaisBarato());

        System.out.println("\nCinco carros mais baratos:");
        estoque.cincoCarrosMaisBaratos().forEach(c -> System.out.println(" " + c));

        System.out.println("\nAgrupamento por marca:");
        estoque.agruparPorMarca()
                .forEach((marca, lista) -> System.out.println(" " + marca + ": " + lista.size() + " carros"));

        System.out.println("\nCor com menor idade média: " + estoque.corComMenorIdadeMedia());

        System.out.println("\nCores ordenadas por idade média:");
        estoque.coresOrdenadasPorIdadeMedia().forEach(c -> System.out.println(" " + c));
    }
}
