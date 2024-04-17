package pessoas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import contas.Conta;
import contas.ContaCorrente;

public class Cliente extends Usuario {

	public Cliente(String cpf, String senha, String nome) {
		super(cpf, senha, nome);
		// TODO Auto-generated constructor stub
	}

	// Menu do cliente
	public void menuCliente() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMenu do Cliente:");
			System.out.println("1. Movimentações na Conta");
			System.out.println("2. Relatórios");
			System.out.println("3. Sair");

			System.out.print("Escolha uma opção: ");
			String escolha = sc.next();

			switch (escolha) {
			case "1":
				movimentacoesNaConta();
				break;
			case "2":
				relatorios();
				break;
			case "3":
				System.out.println("Saindo do menu do cliente...");
				return; // Sai do método
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	// Método para tratar as opções de Movimentações na Conta
	public void movimentacoesNaConta() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nMovimentações na Conta:");
			System.out.println("a. Saque");
			System.out.println("b. Depósito");
			System.out.println("c. Transferência para outra conta");
			System.out.println("d. Voltar ao menu anterior");

			System.out.print("Escolha uma opção: ");
			String escolha = sc.next();

			switch (escolha) {
			case "a":
				if (Usuario.getUsuarios() != null && Conta.listaConta() != null) {
					ContaCorrente contaCorrente = null;
					for (Conta conta : Conta.listaConta()) {
						if (conta.getCpfTitular().equals(getCpf())) {
							contaCorrente = (ContaCorrente) conta;
							break;
						}
					}

					if (contaCorrente != null) {
						System.out.print("Digite o valor a ser Sacado: ");
						double valorSacar = sc.nextDouble();
						contaCorrente.sacar(valorSacar);
						System.out.println(
								"Saque de " + valorSacar + " realizado com sucesso para o cliente " + getNome());
					} else {
						System.out.println("Você não possui uma Conta Corrente.");
					}
				}
				break;
			case "b":
				if (Usuario.getUsuarios() != null && Conta.listaConta() != null) {
					System.out.print("Digite o valor a ser depositado: ");
					double valorDeposito = sc.nextDouble();
					System.out.println(
							"Depósito de " + valorDeposito + " realizado com sucesso para o cliente " + getNome());
				}
				break;
			case "c":
				if (Usuario.getUsuarios() != null && Conta.listaConta() != null) {
					ContaCorrente contaCorrenteOrigem = null;
					ContaCorrente contaCorrenteDestino = null;

					// Encontrar a conta corrente do usuário logado
					for (Conta conta : Conta.listaConta()) {
						if (conta.getCpfTitular().equals(getCpf())) {
							contaCorrenteOrigem = (ContaCorrente) conta;
							break;
						}
					}

					if (contaCorrenteOrigem != null) {
						System.out.print("Digite o CPF do destinatário: ");
						String cpfDestinatario = sc.next();

						// Encontrar a conta corrente do destinatário
						for (Conta conta : Conta.listaConta()) {
							if (conta.getCpfTitular().equals(cpfDestinatario)) {
								contaCorrenteDestino = (ContaCorrente) conta;
								break;
							}
						}

						if (contaCorrenteDestino != null) {
							System.out.print("Digite o valor a ser transferido: ");
							double valorTransferencia = sc.nextDouble();

							// Realizar a transferência
							contaCorrenteOrigem.transferir(valorTransferencia, contaCorrenteDestino);

						} else {
							System.out.println("Conta do destinatário não encontrada.");
						}
					} else {
						System.out.println("Você não possui uma Conta Corrente.");
					}
				}
				break;
			case "d":
				// Volta ao menu principal
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	public void relatorios() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nRelatótrios da Conta:");
			System.out.println("1. Relatório de Saldo");
			System.out.println("2. Relatório de tributação da conta corrente");
			System.out.println("3. Relatório de Rendimento da poupança");
			System.out.println("4. Voltar ao menu anterior");

			System.out.print("Escolha uma opção: ");
			String escolha = sc.next();

			switch (escolha) {
			case "1":
				// Implementar lógica para saque
				System.out.println("Relatório de Saldo");
				break;
			case "2":
				// Implementar lógica para depósito
				System.out.println("Relatório de tributação da conta corrente");
				break;
			case "3":
				// SimularRendimentoPoupanca();

				String resultado = SimularRendimentoPoupanca();

				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("..//projetoFinalJava/src/Relatorios/RendimentoPoupança", true))) {
					writer.write("\n **** Simulação de Rendimento da Poupança *****\n");
					writer.write(resultado);
					writer.write("\nSimulação de Rendimento para " + getNome() + "\n");
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				break;
			case "4":
				// Volta ao menu principal
				return;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		}
	}

	private String SimularRendimentoPoupanca() {
		{

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
	}

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub
	}

	@Override
	public void menuGerente() {
		// TODO Auto-generated method stub
	}

	@Override
	public void menuPresidente() {
		// TODO Auto-generated method stub
	}
}