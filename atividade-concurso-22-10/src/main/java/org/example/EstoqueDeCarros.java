package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class EstoqueDeCarros {
    private List<Carro> carros = new LinkedList<>();

    public EstoqueDeCarros(String nomeArquivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine(); // pula o cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length != 6)
                    continue;
                String placa = campos[0];
                int ano = Integer.parseInt(campos[1]);
                Carro.Cor cor = Carro.Cor.valueOf(campos[2].toUpperCase());
                String modelo = campos[3];
                String marca = campos[4];
                double valor = Double.parseDouble(campos[5]);
                carros.add(new Carro(placa, ano, cor, modelo, marca, valor));
            }
        }
    }

    // Retorna a quantidade de carros no estoque cujo ano é 2023.
    public int quantidadeCarros2023(){
        return carros.stream()
                .filter(c -> c.getAno() == 2023)
                .collect(Collectors.toList())
                .size();
    }
    
    // Retorna o somatório dos valores dos carros produzidos em 2024.
    public double somatorioValores2024() {
        double somaDoValorCarros2024 = carros.stream()
                .filter(c -> c.getAno() == 2024)
                .mapToDouble(Carro :: getValor )
                .sum();

        return somaDoValorCarros2024;
    }

    // Retorna a média dos preços dos carros produzidos entre 2000 e 2010.
    public double precoMedio2000a2010() {
        return carros.stream()
                .filter(c -> c.getAno() >= 2000 && c.getAno() <= 2010)
                .mapToDouble(Carro ::getValor)
                .average()
                .getAsDouble();
    }

    // Retorna a lista de placas dos carros que são pretos ou brancos, modelo "luxo", marca "gm" e ano >= ano atual - 3.
    public List<String> placasPretosOuBrancosLuxoGMMenos3Anos() {
        int anoAtual = Year.now().getValue();
        return carros.stream()
                    .filter(c -> c.getCor() == Carro.Cor.BRANCO || c.getCor() == Carro.Cor.PRETO
                            && c.getModelo().equals("luxo")
                            && c.getMarca().equals("gm")
                            && c.getAno() >= anoAtual - 3)
                    .map(Carro::getPlaca)
                    .toList();
    }

    // Retorna o primeiro carro Ford vermelho encontrado no estoque.
    public Carro primeiroFordVermelho() {
        return carros.stream()
                .filter(c -> c.getMarca().equals("ford") && c.getCor() == Carro.Cor.VERMELHO)
                .findFirst().orElse(null);
    }

    // Retorna se existe um carro da marca "fiat", cor "branco", modelo "luxo" e valor entre 150000 e 180000.
    public boolean existeFiatBrancoLuxoEntre150e180() {
        return carros.stream().anyMatch(c -> c.getMarca().equals("fiat")
                        && c.getCor() == Carro.Cor.BRANCO
                        && c.getModelo().equalsIgnoreCase("luxo")
                        && c.getValor() >= 150000 && c.getValor() <= 180000);
    }

    // Retorna o carro mais barato do estoque.
    public Carro carroMaisBarato() {
        return carros.stream()
                .min((c1, c2) -> Double.compare(c1.getValor(), c2.getValor()))
                .orElse(null);

    }

    // Retorna os 5 carros mais baratos do estoque.
    public List<Carro> cincoCarrosMaisBaratos() {
        return carros.stream()
                .sorted(Comparator.comparingDouble(Carro ::getValor))
                .limit(5)
                .toList();
    }

    // Retorna os carros agrupados por marca.
    // A chave do mapa é a marca e o valor é uma lista de carros daquela marca.
    // Exemplo: { "Ford": [Carro1, Carro2], "Fiat": [Carro3] }
    // Se não houver carros de uma marca, ela não deve aparecer no mapa.
    public Map<String, List<Carro>> agruparPorMarca() {
        Map<String,List<Carro>> resp = new HashMap<>();
        resp.put("Ford",List.of(new Carro("ABC1234", 0, Carro.Cor.VERMELHO, "barato", "marca", 0.0)));
        return resp; // Implementar
    }

    // Retorna a cor do carro com a menor idade média.
    public Carro.Cor corComMenorIdadeMedia() {
        return Carro.Cor.VERMELHO; // Implementar
    }

    // Retorna a lista de cores dos carros ordenadas pela idade média dos carros daquela cor.
    public List<Carro.Cor> coresOrdenadasPorIdadeMedia() {
        return List.of(Carro.Cor.VERMELHO); // Implementar
    }
}