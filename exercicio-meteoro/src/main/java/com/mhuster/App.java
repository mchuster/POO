package com.mhuster;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       
        String fName = "Meteorite_Landings.cvs";
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nomeCompleto = currDir+"/"+fName;
        Path path = Paths.get(nomeCompleto);
        ArrayList<Meteoro> meteoros = new ArrayList<>();

        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))){
            if(sc.hasNext()){
                sc.nextLine();
            }
            
            while(sc.hasNext()){
                String linha = sc.nextLine();
                String dados[] = linha.split(",");


            }
        } catch (Exception e) {
        }
    }

    public static Meteoro parse(String[] campos){

        String name = campos[0];
        int id = Integer.parseInt(campos[1]);
        String nametype = campos[2];
        String recclass = campos[3];
        double mass = Double.parseDouble(campos[4]);
        String fall = campos[5];
        int year = Integer.parseInt(campos[6]);
        double reclat = Double.parseDouble(campos[7]);
        double reclong = Double.parseDouble(campos[8]);
        String GeoLocation =campos[9];

        return new Meteoro(name, id, nametype,recclass,mass,fall,year,reclat,reclong,GeoLocation);
    }
}

