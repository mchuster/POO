package com.bcopstein;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {
    private TextField nomeTf;
    private TextField pesoTf;
    private TextField alturaTf;

    private List<Pessoa> pessoas;
    private Grid<Pessoa> gridPessoas;
    public MainView() {
        nomeTf = new TextField("Nome");
        pesoTf = new TextField("Peso");
        alturaTf = new TextField("Altura");

        pessoas = new ArrayList<>();

        setSpacing(true);
        setPadding(true);

        add(new H2("Verificação de Saúde"));

        FormLayout formularioLT = new FormLayout(nomeTf, pesoTf, alturaTf);

        Button calcPesoButton = new Button("Estatisticas de Saude");
        calcPesoButton.addClickListener(e->exibirEstatisticasDeSaude(extraiDadosPessoa()));
        
        HorizontalLayout botaoLayout = new HorizontalLayout(calcPesoButton);
        botaoLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        botaoLayout.setWidthFull();

        gridPessoas = new Grid<>(Pessoa.class, false);
        gridPessoas.addColumn(Pessoa::getNome).setHeader("Nome").setAutoWidth(true);
        gridPessoas.addColumn(Pessoa::getPeso).setHeader("Peso Kg").setAutoWidth(true);

        add(formularioLT);
        add(botaoLayout);
    }

    private Pessoa extraiDadosPessoa(){
        String nome = nomeTf.getValue();
        int peso = Integer.parseInt(pesoTf.getValue());
        int altura = Integer.parseInt(alturaTf.getValue());
        Pessoa p = new Pessoa(nome,peso,altura);
        pessoas.add(p);
        return p;
    }

    private void exibirEstatisticasDeSaude(Pessoa p){
        String classPeso = EstatisticasSaude.classificaPeso(p);
        String classAltura = EstatisticasSaude.classificaAltura(p);
        
        // Criar o diálogo
        Dialog dialogo = new Dialog();
        dialogo.setWidth("400px");
        
        // Título do diálogo
        H3 titulo = new H3("Estatísticas de Saúde");
        
        // Layout vertical para o conteúdo
        VerticalLayout conteudo = new VerticalLayout();
        conteudo.setSpacing(true);
        conteudo.setPadding(false);
        
        // Adicionar as estatísticas
        Paragraph pesoInfo = new Paragraph("Classificação do Peso: " + classPeso);
        Paragraph alturaInfo = new Paragraph("Classificação da Altura: " + classAltura);
        
        // Aqui no futuro podemos adicionar mais estatísticas
        // Paragraph alturaInfo = new Paragraph("Altura: " + ...);
        // Paragraph outrasInfo = new Paragraph("Outras informações...");
        
        conteudo.add(pesoInfo);
        conteudo.add(alturaInfo);
        
        // Botão para fechar o diálogo
        Button fecharButton = new Button("Fechar", e -> dialogo.close());
        fecharButton.getStyle().set("margin-top", "10px");
        
        HorizontalLayout botoesLayout = new HorizontalLayout(fecharButton);
        botoesLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        botoesLayout.setWidthFull();
        
        // Adicionar componentes ao diálogo
        dialogo.add(titulo, conteudo, botoesLayout);
        
        // Abrir o diálogo
        dialogo.open();
    }
}
