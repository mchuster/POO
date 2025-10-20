package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CadastroFuncionarios {
	private List<Funcionario> lstf;

	public CadastroFuncionarios() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 40; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3) + 1;
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		return Collections.unmodifiableList(lstf);
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios [lstf=" + lstf + "]";
	}

	// 1 - Retorna lista dos funcionários que recebem insalubridade e tem dependentes
	public List<Funcionario> getInsalubridadeDependentes() {
        List<Funcionario> funcionarioInsalubridadeDependentes = lstf.stream()
                .filter(f -> f.getInsalubridade() && f.getNroDependentes() > 0)
                .toList();
        return funcionarioInsalubridadeDependentes;
	}

	// 2 - Retorna a quantidade de funcionarios que tem dependentes
	public long quantidadeFuncionariosComDependentes() {
		long quantidadeComDependentes = lstf.stream()
                .filter(f -> f.getNroDependentes() > 0)
                .count();
        return quantidadeComDependentes;
	}

	// 3 - Retorna o somatório do salario bruto de todos os funcionários
	public double somatorioSalarioBruto() {
        return lstf.stream()
                .mapToDouble(Funcionario::getSalarioBruto) // == f -> f.getSalarioBruto
                .sum();
	}

	// 4 - Aumenta o salário dos funcionários que tem insalubridade em 10%
	public void aumentaSalarioInsalubres() {
	}

	// 5 - Retorna uma lista de strings com nome e matrícula dos funcionários
	// que recebem salario bruto maior que "val"
	public List<String> getNomeMatriculaSalarioBrutoMaiorQue(double val) {
		return null;
	}

	// 6 - Retorna o valor médio do salário dos que não tem insalubridade
	public double mediaSalarialDosQueNaoTemInsalubridade() {
		return 0;
	}

	// 7 - Retorna o nome dos funcionários que tem número de matrícula menor que 500
	public List<String> nomesDosQueTemMatriculaMenorQue500() {
		return null;
	}

	// 8 - Retorna o salário líquido do funcionário que tem o número de matrícula informado
	public double getSalarioLiquido(int matricula) {
		return 0;
	}
}
