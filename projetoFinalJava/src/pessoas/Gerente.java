package pessoas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import contas.ContaCorrente;
import enums.FuncionariosEnum;

public class Gerente extends Funcionario {
	private int agenciaResponsavel;

	public Gerente(String cpf, String senha, FuncionariosEnum cargo, String nome, int agenciaResponsavel) {
		super(cpf, senha, cargo, nome);
		this.agenciaResponsavel = agenciaResponsavel;
	}

	public int getAgenciaResponsavel() {
		return agenciaResponsavel;
	}

	public void menuGerente() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu do Gerente:");
			System.out.println("1 - Movimentações e Informações da Conta.");
			System.out.println("2 - Relatórios.");
			System.out.println("3 - Relatórios de Rendimento da Poupança.");
			System.out.println("4 - Relatórios do n° de contas na sua agencia.");
			System.out.println("5 - Sair.");

			int escolha = sc.nextInt();
			sc.nextLine(); // Limpar a entrada

			switch (escolha) {
			case 1:
				Cliente cliente = new Cliente(getCpf(), getSenha(), getNome());
				cliente.movimentacoesNaConta();
				break;
			case 2:
				// Acessar os mesmos relatórios disponíveis ao gerente
				ContaCorrente.relatorioTributacao();

				break;
			case 3:
				// Acessar os mesmos Simulação do redimento da poupança
				String resultado = SimularRendimentoPoupanca();

				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("..//projetoFinalJava/src/Relatorios/RendimentoPoupança", true))) {
					writer.write("\n *********** Simulação de Rendimento da Poupança **********\n");
					writer.write(resultado);
					writer.write("\nSimulação de Rendimento para " + getNome() + "\n");
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				// Acessar os mesmos relatórios disponíveis ao gerente
				// n° de contas na sua agencia.
				menuRelatoriosGerente();
				break;
			case 5:
				System.out.println("Encerrando Operações.");
				System.exit(0);
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private String SimularRendimentoPoupanca() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o valor inicial:");
		double valorInicial = scanner.nextDouble();

		System.out.println("Digite a quantidade de dias:");
		int dias = scanner.nextInt();

		double taxaJuros = 0.005; // 0,5% ao mês
		int meses = dias / 30; // Aproximação para a quantidade de meses

		double valorFinal = valorInicial;

		// Calcula o rendimento para cada mês
		for (int i = 0; i < meses; i++) {
			valorFinal += valorFinal * taxaJuros;
		}

		System.out.printf("O valor após %d dias será de: %.2f\n", dias, valorFinal);

		String resultado = String.format("Valor inicial: %.2f\nDias: %d\nValor após %d dias: %.2f\n", valorInicial,
				dias, dias, valorFinal);

		return resultado;
	}

	// Chama os relatórios disponíveis ao gerente
	private void menuRelatoriosGerente() {

	}

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuPresidente() {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub

	}


}