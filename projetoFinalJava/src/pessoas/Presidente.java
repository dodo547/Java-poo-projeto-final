package pessoas;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import enums.FuncionariosEnum;
import contas.Conta;

//import sistemaInterno.SistemaInterno;

public class Presidente extends Funcionario {

	public Presidente(String cpf, String senha, FuncionariosEnum cargo, String nome) {
		super(cpf, senha, cargo, nome);
	}

	public void menuPresidente() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu do Presidente:");
			System.out.println("1 - Relatórios disponíveis ao Presidente.");
			System.out.println("2 - Relatórios disponíveis ao Diretor.");
			System.out.println("3 - Relatórios disponíveis ao Gerente.");
			System.out.println("4 - Sair do menu do Presidente.");

			int escolha = sc.nextInt();
			sc.nextLine(); // Limpar a entrada

			switch (escolha) {
			case 1:
				// Acessar os relatórios disponíveis ao presidente
				String relatorio = menuRelatoriosPresidente();
				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("..//projetoFinalJava/src/Relatorios/RelatorioPresidencial", true))) {
					writer.write("\n*************** Relatório Presidencial ***************\n");
					writer.write(relatorio + "\n");
					writer.write(LocalDateTime.now().toString() + "\n");
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("\n*************** Relatório Presidencial ***************");
				System.out.println(relatorio);
				break;

			case 2:
				// Acessar os relatórios disponíveis ao DIRETOR
				Diretor diretor = new Diretor(getCpf(), getSenha(), FuncionariosEnum.DIRETOR, getNome());
                diretor.menuDiretor();
				break;
			case 3:
				// Cria uma instância de Gerente e chama o método menuGerente
                Gerente gerente = new Gerente(getCpf(), getSenha(), FuncionariosEnum.GERENTE, getNome(), 0);
                gerente.menuGerente();
                break;
				
			case 4:
				System.out.println("Encerrando Operação.");
				System.exit(0);
				;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	// Chama os relatórios disponíveis ao presidente

	String menuRelatoriosPresidente() {
		double saldoTotal = calcularSaldoTotal(contas.Conta.listaConta());
		String resultado = String.format("O valor total de capital armazenado no banco é de: %.2f", saldoTotal);
		return resultado;
	}

	private double calcularSaldoTotal(ArrayList<Conta> listaConta) {
		double saldoTotal = 0;
		for (Conta conta : listaConta) {
			saldoTotal += conta.getSaldo();
		}
		return saldoTotal;
	}

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuGerente() {
	}

	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub

	}


}