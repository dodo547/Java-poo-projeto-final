package pessoas;

import java.util.Scanner;
import enums.FuncionariosEnum;

//Classe Gerente
		public class Gerente extends Funcionario {
		private int agenciaResponsavel;

	

 	public Gerente(String cpf, String senha, FuncionariosEnum cargo, String nome,int agenciaResponsavel) {
			super(cpf, senha, cargo, nome);
			this.agenciaResponsavel = agenciaResponsavel;
		}
	public int getAgenciaResponsavel() {
     return agenciaResponsavel;
 }
	 public void menuGerente() {
	        Scanner sc = new Scanner(System.in); 	
	}
		}
