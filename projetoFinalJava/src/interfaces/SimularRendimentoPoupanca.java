package interfaces;
import java.util.Scanner;

public class SimularRendimentoPoupanca {
	
	
	    public static void CalcularRendimentoPoupança() {
	    	
	    	
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
	    
	}


	
		
			
			
		}