package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class ProcessaDNA {
    private String sDna;

    public ProcessaDNA(String fname){
        // Assume que o arquivo esta no diretório de execução
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nomeCaminhoCompleto = currDir + "/" + fname;
        Path path = Paths.get(nomeCaminhoCompleto);

        //System.out.println("Vai ler o arquivo: "+path.getFileName());
        // Usa a classe scanner para fazer a leitura do arquivo
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {
            sDna = sc.nextLine();
            //System.out.println("Leu a linha: ["+sDna+"]");
        } catch (IOException e) {
            throw new IllegalArgumentException("Arquivo inválido: "+nomeCaminhoCompleto);
        }
    }

    public static char defineNova(char l1, char l2) {
        if ((l1 == 'D' && l2 == 'N') || (l1 == 'N' && l2 == 'D'))
            return 'A';
        if ((l1 == 'N' && l2 == 'A') || (l1 == 'A' && l2 == 'N'))
            return 'D';
        return 'N';
    }

    public String getDNA() {
        return sDna;
    }

    public void setDNA(String dna){
        sDna = dna;
    }

    public abstract String degradaDNA();
}
