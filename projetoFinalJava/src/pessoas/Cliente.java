package pessoas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import contas.Conta;
import contas.ContaCorrente;
import io.InOutUtils;

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
			System.out.println("1. Saque");
			System.out.println("2. Depósito");
			System.out.println("3. Transferência para outra conta");
			System.out.println("4. Voltar ao menu anterior");

			System.out.print("Escolha uma opção: ");
			String escolha = sc.next();

			// Modo de escolha do menu

			switch (escolha) {
			case "1":
				sacar(custoOperacoes);
				Conta contaSaque = null;
				ArrayList<Conta> contas = Conta.listaConta();
				for (Conta c : contas) {
					if (this.getCpf().equals(c.getCpfTitular())) { // Compara se o CPF é o mesmo do titular
						contaSaque = c;
					}
				}
				// Verificações de saldo e conta
				if (contaSaque != null) {
					System.out.println("\nSaldo disponivel na conta: R$" + contaSaque.getSaldo() + "\n");
					System.out.print("Digite o valor a ser Sacado: ");
					double valorSacar = sc.nextDouble();
					System.out.println("\n");
					contaSaque.sacar(valorSacar);
					if (valorSacar < 0) {
						System.out.println("\nO valor para saque não pode ser negativo. Tente novamente.");
						return; // Volta ao menu anterior sem alterar o saldo
					} else if (valorSacar > contaSaque.getSaldo()) {
						System.out.println("Saldo insuficiente para realizar o saque.");
						return; // Volta ao menu anterior sem alterar o saldo
					}
					System.out
							.println("Saque de R$" + valorSacar + " realizado com sucesso para o cliente " + getNome());

					// Metodo para escrever o relatorio de saque
					try (BufferedWriter writer = new BufferedWriter(
							new FileWriter("../projetoFinalJava/src/Relatorios/RelatorioSaque"))) {
						writer.write("\n *** Relatório de Saque **\n");
						writer.write((int) valorSacar);
						writer.write("\nSaque de R$" + valorSacar + " realizado com sucesso para " + getNome() + "\n");
						writer.write((int) contaSaque.getSaldo());
						writer.write("Saldo disponível R$:" + contaSaque.getSaldo() + "\n");
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("Você não possui uma Conta Corrente.");
				}
				break;
			case "2":
				depositar(custoOperacoes);
				Conta Depositoconta = null;
				ArrayList<Conta> Depositocontas = Conta.listaConta();
				for (Conta c : Depositocontas) {
					if (this.getCpf().equals(c.getCpfTitular())) { // Compara se o CPF é o mesmo do titular
						Depositoconta = c;
					}
				}
				if (Depositoconta != null) {
					System.out.println("Saldo disponivel em conta" + Depositoconta.getSaldo());
					System.out.print("Digite o valor a ser Depositado: ");
					double valorDepositar = sc.nextDouble();
					Depositoconta.depositar(valorDepositar);
					if (valorDepositar < 0) {
						System.out.println("\nO valor para depósito não pode ser negativo. Tente novamente.");
						return; // Volta ao menu anterior sem alterar o saldo
					}
					System.out.println(
							"Deposito de " + valorDepositar + " realizado com sucesso para o cliente " + getNome());

					// Metodo para escrever o relatorio de deposito
					try (BufferedWriter writer = new BufferedWriter(
							new FileWriter("..//projetoFinalJava/src/Relatorios/RelatorioDeposito", true))) {

						writer.write("\n *** Comprovante de Depósito **\n");
						writer.write((int) valorDepositar);
						writer.write("\nDepósito no valor de R$" + valorDepositar + " realizado com sucesso para "
								+ getNome() + "\n");
						writer.write((int) valorDepositar);
						writer.write("Saldo disponível :" + Depositoconta.getSaldo() + "\n");
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("Você não possui uma Conta Corrente.");
				}
				break;
			case "3":
				Conta contaOrigem = null;
				ArrayList<Conta> transferenciaContas = Conta.listaConta();

				// Obter a conta de origem do cliente
				for (Conta t : transferenciaContas) {
					if (this.getCpf().equals(t.getCpfTitular())) {
						contaOrigem = t;
						break; // Encontramos a conta, podemos parar o loop
					}
				}

				// Verificar se a conta de origem foi encontrada
				if (contaOrigem == null) {
					System.out.println("Você não possui uma conta corrente.");
					return; // Encerra a operação
				}

				// Solicitar CPF do destinatário
				System.out.print("Digite o CPF do destinatário: ");
				String cpfDestinatario = sc.next();

				// Obter a conta do destinatário com base no CPF fornecido
				Conta contaDestino = null;
				for (Conta c : transferenciaContas) {
					if (cpfDestinatario.equals(c.getCpfTitular())) {
						contaDestino = c;
						break; // Encontramos a conta de destino, podemos parar o loop
					}
				}

				// Verificar se a conta de destino foi encontrada
				if (contaDestino == null) {
					System.out.println("Conta do destinatário não encontrada.");
					return; // Encerra a operação
				}

				// Solicitar valor da transferência
				System.out.print("Digite o valor a ser transferido: ");
				double valorTransferencia = sc.nextDouble();

				// Verificar se o valor de transferência é válido
				if (valorTransferencia <= 0) {
					System.out.println("Valor inválido. O valor para transferência deve ser maior que zero.");
					return; // Encerra a operação
				}

				// Verificar se a conta de origem tem saldo suficiente
				if (contaOrigem.getSaldo() < valorTransferencia) {
					System.out.println("Saldo insuficiente para realizar a transferência.");
					return; // Encerra a operação
				}

				// Realizar a transferência entre as contas
				contaOrigem.sacar(valorTransferencia);
				contaDestino.depositar(valorTransferencia);

				// Mensagem de sucesso
				System.out.printf("Transferência de R$ %.2f para %s realizada com sucesso!%n", valorTransferencia,
						contaDestino.getCpfTitular());
				// Metodo para escrever o relatorio de Transferencias
				try (BufferedWriter writer = new BufferedWriter(
						new FileWriter("..//projetoFinalJava/src/Relatorios/RelatorioTransferência", true))) {
					writer.write("\n *** Relatório de Transferência ***\n");
					writer.write("Transferência de " + valorTransferencia + " realizada com sucesso para "
							+ contaDestino.getCpfTitular() + "\n");
					writer.write("Saldo disponível na conta de origem: " + contaOrigem.getSaldo() + "\n");
					writer.write("Saldo disponível na conta de destino: " + contaDestino.getSaldo() + "\n");
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

	// Metodo para chamar os relatorios.
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
				exibirSaldo();
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