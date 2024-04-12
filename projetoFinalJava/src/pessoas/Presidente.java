package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;

//Classe Presidente

 public class Presidente extends Funcionario {

	
	 public Presidente(String cpf, String senha, FuncionariosEnum cargo, String nome) {
			super(cpf, senha, cargo, nome);
		}
	 public void menuPresidente() { 
	        Scanner sc = new Scanner(System.in);
  }
 }