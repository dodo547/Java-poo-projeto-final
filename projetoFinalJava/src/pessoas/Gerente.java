package pessoas;

import java.util.Scanner;

//Classe Gerente
		public class Gerente extends Funcionario {
		private int agenciaResponsavel;

 	public Gerente(String nome, String cpf, String senha, String cargo, int agenciaResponsavel) {
     super(nome,cpf, senha, cargo);
     this.agenciaResponsavel = agenciaResponsavel;
 }

 	public int getAgenciaResponsavel() {
     return agenciaResponsavel;
 }
 	public static void LoginGerente() {
		Scanner sc = new Scanner(System.in);
		Gerente g = new Gerente("18","18","15", "15",1);

		
		System.out.println("Digite seu usuario ");
		
		String usuario = sc.next();
		int contador =0;
		while(!usuario.equals(g.getCpf()) && contador <2) {
			System.out.println("Usuario Incorreto ou inexistente \nTente novamente ");
			contador++;
			usuario = sc.next();
			}
			System.out.println();
			if(usuario.equals(g.getCpf())){
				System.out.println("Seja bem vindo "+g.getNome());	
			}else {
				System.out.println("Acesso usuario incorreto \nTente Novamente mais tarde");
				System.exit(0);	
		}
			
		System.out.println("Digite sua senha ");
		String senha = sc.next();
		contador =0;
		while(!senha.equals(g.getSenha()) && contador <2) {
			System.out.println("Senha Incorreta \nTente novamente");
			contador++;
			senha=sc.next();
			
		}
		System.out.println();
		if(senha.equals(g.getSenha()) && usuario.equals(g.getCpf())){
			System.out.println("Seja bem vindo ao Serra Bank "+ g.getNome());
			
		}else {
			System.out.println("Acesso Negado \nTente Novamente mais tarde");
			System.exit(0);
			
		}
//		System.out.println("Seja bem vindo ao Banco Grupo 50");
//		TESTE DE SISTEMA
	}
}