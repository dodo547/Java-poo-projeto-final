package sistemaInterno;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import pessoas.Cliente;

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
            System.out.println("1 - Saldo.");
            System.out.println("2 - Relatório de Tributação da Conta Corrente.");
            System.out.println("3 - Relatório de Rendimento da Poupança.");
           
            int opcaoRelatorio = sc.nextInt();
            		
            switch (opcaoRelatorio) {
                case 1:
                    imprimirSaldo();
                    break;
                case 2:
                    relatorioTributacao();
                    break;
                case 3:

                	String resultado = simularRendimentoPoupanca();
                	try(BufferedWriter writer = new BufferedWriter(new FileWriter("..//projetoFinalJava/src/Relatorios/RendimentoPoupança"))){
                        
        				writer.write(resultado);
        				writer.close();
                    	} catch(IOException e) {
                    		e.printStackTrace();
                    	}
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

    }

	

	
	private static String simularRendimentoPoupanca() {
		// TODO Auto-generated method stub
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