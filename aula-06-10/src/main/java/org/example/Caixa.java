package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Caixa {

    private Map<Integer, Produtos> catalogo;
    private List<Produtos> carrinho;

    public Caixa(){
        catalogo = new HashMap<>();
        carrinho = new ArrayList<>();
    }

    public void cadastrarProduto(Produtos p){
        catalogo.put(p.getCodigo(), p);
    }

    public void passarProduto(int codigo){
        Produtos p = catalogo.get(codigo);
        if(p != null){
            carrinho.add(p);
            System.out.println(p.getDescricao() + " - R$ " + p.getPreco());
            System.out.println("Total até agora: R$ " + String.format("%.2f", calcularTotal()));
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public double calcularTotal(){
        double total = 0;
        for(Produtos p : carrinho){
            total = total + p.getPreco();
        }
        return total;
    }

    public void imprimirRecibo() {
        System.out.println("\n--- RECIBO ---");
        for (Produtos p : carrinho) {
            System.out.println(p);
        }
        System.out.println("TOTAL: R$ " + String.format("%.2f", calcularTotal()));
    }
}
