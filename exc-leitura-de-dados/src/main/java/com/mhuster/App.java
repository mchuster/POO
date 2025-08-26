package com.mhuster;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        
        String caminho = "produtos.txt";
        Path path = Paths.get(caminho);

        try(Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
                System.out.println(linha);
            }
                
            } catch(IOException e){
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
        
    }

