package pessoas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


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
                // Implementar lógica para saque
                System.out.println("Saque escolhido");
                break;
            case "b":
                // Implementar lógica para depósito
                System.out.println("Depósito escolhido");
                break;
            case "c":
                // Implementar lógica para transferência
                System.out.println("Transferência escolhida");
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
        System.out.println("a. Relatório de Saldo");
        System.out.println("b. Relatório de tributação da conta corrente");
        System.out.println("c. Relatório de Rendimento da poupança");
        System.out.println("d. Voltar ao menu anterior");
        
        System.out.print("Escolha uma opção: ");
        String escolha = sc.next();

        switch (escolha) {
            case "a":
                // Implementar lógica para saque
                System.out.println("Relatório de Saldo");
                break;
            case "b":
                // Implementar lógica para depósito
                System.out.println("Relatório de tributação da conta corrente");
                break;
            case "c":
            	//SimularRendimentoPoupanca();
            	
            	String resultado = SimularRendimentoPoupanca();
            	
            	try(BufferedWriter writer = new BufferedWriter(new FileWriter("..//projetoFinalJava/src/Relatorios/RendimentoPoupança"))){
               
				writer.write(resultado);
				writer.close();
            	} catch(IOException e) {
            		e.printStackTrace();
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
        
        String resultado = String.format("Valor inicial: %.2f\nDias: %d\nValor após %d dias: %.2f\n",
                valorInicial, dias, dias, valorFinal);

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