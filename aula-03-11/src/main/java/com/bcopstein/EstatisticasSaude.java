package com.bcopstein;

public class EstatisticasSaude {
    public static String classificaPeso(Pessoa pessoa){
        int pesoNormal = pessoa.getAltura() - 100;
        if (pessoa.getPeso() < pesoNormal * 0.5) return("Subnutricao");
        if (pessoa.getPeso() >=  pesoNormal * 0.5 && pessoa.getPeso() < pesoNormal * 0.9) return("Abaixo do peso");
        if (pessoa.getPeso() >=  pesoNormal * 0.9 && pessoa.getPeso() <= pesoNormal) return("Otimo");
        if (pessoa.getPeso() >=  pesoNormal && pessoa.getPeso() <= pesoNormal * 1.1) return("Bom");
        if (pessoa.getPeso() >=  pesoNormal * 1.1 && pessoa.getPeso() <= pesoNormal * 1.3) return("Atenção: acima do peso");
        return("Sobrepeso");
    }

    public static String classificaAltura(Pessoa pessoa){
        if(pessoa.getAltura() <= 150) return("baixa");
        if(pessoa.getAltura() >= 180) return("Alta");
        if(pessoa.getAltura() > 150 && pessoa.getAltura() < 180) return("Media");
        return("");
    }
}
