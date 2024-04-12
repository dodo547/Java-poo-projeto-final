package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;

//Classe Presidente

 public class Presidente extends Funcionario {

	
	 public Presidente(String cpf, String senha, FuncionariosEnum cargo, String nome) {
			super(cpf, senha, cargo, nome);
		}

	public static void LoginPresidente() {
		Scanner sc = new Scanner(System.in);
		Presidente p = new Presidente("18484","123",FuncionariosEnum.PRESIDENTE, "anderson");

		
		System.out.println("Digite seu usuario ");
		
		String usuario = sc.next();
		int contador =0;
		while(!usuario.equals(p.getCpf()) && contador <2) {
			System.out.println("Usuario Incorreto ou inexistente \nTente novamente ");
			contador++;
			usuario = sc.next();
			}
			System.out.println();
			if(usuario.equals(p.getCpf())){
				System.out.println("Seja bem vindo "+p.getNome());	
			}else {
				System.out.println("Acesso usuario incorreto \nTente Novamente mais tarde");
				System.exit(0);	
		}
			
		System.out.println("Digite sua senha ");
		String senha = sc.next();
		contador =0;
		while(!senha.equals(p.getSenha()) && contador <2) {
			System.out.println("Senha Incorreta \nTente novamente");
			contador++;
			senha=sc.next();
			
		}
		System.out.println();
		if(senha.equals(p.getSenha()) && usuario.equals(p.getCpf())){
			System.out.println("Seja bem vindo ao Serra Bank "+ p.getNome());
			
		}else {
			System.out.println("Acesso Negado \nTente Novamente mais tarde");
			System.exit(0);
			
		}
//		System.out.println("Seja bem vindo ao Banco Grupo 50");
//		TESTE DE SISTEMA
	}

}