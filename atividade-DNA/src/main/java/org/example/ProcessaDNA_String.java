package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class ProcessaDNA_String extends ProcessaDNA {

    public ProcessaDNA_String(String fname) {
        super(fname);
    }

    private String antes(String dna, int pos) {
        if (pos == 0)
            return "";
        return dna.substring(0, pos);
    }

    private String depois(String dna, int pos) {
        if (pos >= dna.length() - 2) {
            return "";
        }
        return dna.substring(pos + 2);
    }

    @Override
    //String
    public String degradaDNA() {
        if (getDNA() == null) {
            return "none";
        }
        int pos = 0;
        while (pos < getDNA().length()-1) {
            if (getDNA().charAt(pos) != getDNA().charAt(pos + 1)) {
                char nova = ProcessaDNA.defineNova(getDNA().charAt(pos), getDNA().charAt(pos + 1));
                String antes = antes(getDNA(), pos);
                String depois = depois(getDNA(), pos);
                setDNA(antes + nova + depois);
                //System.out.println("["+getDNA()+"]");
                if (pos > 0){
                    pos--;
                }
            } else {
                pos++;
            }
        }
        return getDNA();
    }

    //ArrayList
    public String degradaDNA2() {
        if (getDNA() == null) {
            return "none";
        }

        ArrayList<Character> lista = new ArrayList<>();
        for(char c : getDNA().toCharArray()){
            lista.add(c);
        }
        boolean mudou = true;
        while(mudou){
            mudou = false;
            for(int i = 0; i < lista.size() - 1; i++) {
                if (lista.get(i) != lista.get(i + 1)) {
                    char nova = defineNova(lista.get(i), lista.get(i + 1));
                    lista.set(i, nova);
                    lista.remove(i + 1);
                    mudou = true;
                }
                if(i > 0){
                    i--;
                }
            }


        }
        return getDNA();
    }

    //LinkedList
    public String degradaDNA3() {
        if (getDNA() == null) {
            return "none";
        }

        LinkedList<Character> lista = new LinkedList<>();

        for(char c : getDNA().toCharArray()){lista.add(c);}

        int pos = 0;
        while(pos < lista.size() - 1){
            if(!lista.get(pos).equals(lista.get(pos + 1))){
                char nova = defineNova(lista.get(pos), lista.get(pos+1));
                lista.set(pos, nova);
                lista.remove(pos+1);
            }
            if(pos > 0){
                pos--;
            }else {pos++;}
        }
        return getDNA();
    }

    //Pilha
    public String degradaDNA4() {
        if (getDNA() == null) {
            return "none";
        }
        final int n = getDNA().length();

        char[] in = getDNA().toCharArray();
        char[] pilha = new char[n];

        int top = -1;

        for(int i = 0; i < n; i++){
            char c = in[i];
            if(top >= 0 && pilha[top] != c){
                pilha[top] = defineNova(pilha[top], c);
                while(top > 0 && pilha[top-1] != pilha[top]){
                    pilha[top -1] = defineNova(pilha[top - 1], pilha[top]);
                    top--;
                }
            }else{
                pilha[++top] = c;
            }
        }
        return new String(pilha, 0, top + 1);
    }
}

