package pessoas;

import java.util.Scanner;

//Classe Diretor

public class Diretor extends Funcionario {
	
	
	     
		
		public Diretor() {
		super();
		}

		public Diretor(String nome, String cpf, String senha, String cargo) {
		super(nome, cpf, senha, cargo);
		}

		public static void LoginDiretor() {
		Scanner sc = new Scanner(System.in);
		Diretor d = new Diretor("18","18","15", "15");

		
		System.out.println("Digite seu usuario ");
		
		String usuario = sc.next();
		int contador =0;
		while(!usuario.equals(d.getCpf()) && contador <2) {
			System.out.println("Usuario Incorreto ou inexistente \nTente novamente ");
			contador++;
			usuario = sc.next();
			}
			System.out.println();
			if(usuario.equals(d.getCpf())){
				System.out.println("Seja bem vindo "+d.getNome());	
			}else {
				System.out.println("Acesso usuario incorreto \nTente Novamente mais tarde");
				System.exit(0);	
		}
			
		System.out.println("Digite sua senha ");
		String senha = sc.next();
		contador =0;
		while(!senha.equals(d.getSenha()) && contador <2) {
			System.out.println("Senha Incorreta \nTente novamente");
			contador++;
			senha=sc.next();
			
		}
		System.out.println();
		if(senha.equals(d.getSenha()) && usuario.equals(d.getCpf())){
			System.out.println("Seja bem vindo ao Serra Bank "+ d.getNome());
			
		}else {
			System.out.println("Acesso Negado \nTente Novamente mais tarde");
			System.exit(0);
			
		}
//		System.out.println("Seja bem vindo ao Banco Grupo 50");
//		TESTE DE SISTEMA
	}

	
  
}