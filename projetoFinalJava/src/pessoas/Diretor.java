package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;

//Classe Diretor

public class Diretor extends Funcionario {
		
		public Diretor(String cpf, String senha, FuncionariosEnum cargo, String nome) {
			super(cpf, senha, FuncionariosEnum.DIRETOR, nome);
			
		}
 
}