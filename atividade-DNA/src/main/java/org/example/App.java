package org.example;

public class App {
    public static void main(String[] args) throws Exception {
        //String fname = "caso1";
        String fname = "caso2";
        //String fname = "caso100";
        //String fname = "caso200";
        //String fname = "caso500";

        System.out.println("Carregando dados ...");
        ProcessaDNA pDNA = new ProcessaDNA_String(fname);
        System.out.println("Começou ...");
        long t1 = System.currentTimeMillis();
        String resp = pDNA.degradaDNA();
        long t2 = System.currentTimeMillis();
        long tp = (t2-t1);
        System.out.println("Resultado: "+resp);
        System.out.println("Tempo de processamento: "+tp+" milisegundos");
    }
}
