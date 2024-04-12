package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;
import sistemaInterno.SistemaInterno;


public class Diretor extends Funcionario {
		
		public Diretor(String cpf, String senha, FuncionariosEnum cargo, String nome) {
			super(cpf, senha, FuncionariosEnum.DIRETOR, nome);
			
		}
		 public void menuDiretor() {
	        Scanner sc = new Scanner(System.in);

	       while (true) {
	       System.out.println("\nDeseja acessar relatórios?");
	       System.out.println("1 - Sim");
	       System.out.println("2 - Não");

           int escolha = sc.nextInt();
           if (escolha == 1) {
	       SistemaInterno.abrirRelatorios();
	       break;  
    } 
           
           else if (escolha == 2) {
	       System.out.println("Finalizando o programa.");
	       break;  
	       
   } 
           else {
	       System.out.println("Opção inválida. Por favor, tente novamente.");
	       }
	  }
	        sc.close();  // Fecha o scanner
	    }
			 
		}
	