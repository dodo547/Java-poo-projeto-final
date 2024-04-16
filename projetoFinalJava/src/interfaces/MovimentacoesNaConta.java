package interfaces;

import java.util.Scanner;

public class MovimentacoesNaConta {
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
}
