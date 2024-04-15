package sistemaInterno;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaInterno {

	public SistemaInterno() {
		super();
	}

    public static void abrirRelatorios() {
    	
    	Scanner sc = new Scanner(System.in);
    	int escolha = 1;

        System.out.println("Abrindo relatórios...");
        // Verifica a escolha do usuário
        if (escolha == 1) {
            // Oferece opções de relatórios
            System.out.println("\nEscolha o relatório desejado:");
            System.out.println("1 - Saldo");
            System.out.println("2 - Relatório de Tributação da Conta Corrente");
            System.out.println("3 - Relatório de Rendimento da Poupança");
           
            int opcaoRelatorio = sc.nextInt();
            		
            switch (opcaoRelatorio) {
                case 1:
                    imprimirSaldo();
                    break;
                case 2:
                    relatorioTributacao();
                    break;
                case 3:
                    simularRendimentoPoupanca();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }

	private static void simularRendimentoPoupanca() {
		// TODO Auto-generated method stub		
	}
	private static void relatorioTributacao() {
		// TODO Auto-generated method stub
	}
	private static void imprimirSaldo() {
		// TODO Auto-generated method stub
	}

	public static void relatorioClientesOrdemAlfabetica() {
		// TODO Auto-generated method stub
		
	}


}