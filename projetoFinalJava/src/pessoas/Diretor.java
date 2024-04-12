package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;

//Classe Diretor

public class Diretor extends Funcionario {
		
		public Diretor(String cpf, String senha, FuncionariosEnum cargo, String nome) {
			super(cpf, senha, FuncionariosEnum.DIRETOR, nome);
			
		}
		 public void menuDiretor() {
		        Scanner sc = new Scanner(System.in);
		        while (true) {
		            System.out.println("\nDeseja acessar relatorios ?");
		            System.out.println("Sim");
		            System.out.println("Não");
		            System.out.println("   b. Depósito");
		            break;
}
}
}