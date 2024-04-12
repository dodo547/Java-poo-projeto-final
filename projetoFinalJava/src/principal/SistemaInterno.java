package principal;

import java.util.ArrayList;
import java.util.Scanner;

import pessoas.Cliente;



public class SistemaInterno {

	
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	Cliente c = new Cliente();

//    ArrayList<Cliente> listaClientes = new ArrayList<>();
//    
//    listaClientes.add (new Cliente("123456789-10", "12345678", "Felipe Amorim"));
//    listaClientes.add (new Cliente("234567890-11", "23456789", "Douglas Tapajóz"));
//    listaClientes.add (new Cliente("345678901-12", "34567890", "Patrick Lopes"));
//    listaClientes.add (new Cliente("456789012-13", "45678901", "Jonas Bastos"));
//    listaClientes.add (new Cliente("567890123-14", "56789012", "Bernardo Miloski"));
//    listaClientes.add (new Cliente("678901234-15", "67890123", "Bruna Santos"));
//    listaClientes.add (new Cliente("789012345-16", "78901234", "Gabriel Jesus"));
//    listaClientes.add (new Cliente("890123456-17", "89012345", "Neymar Junior"));
//    listaClientes.add (new Cliente("901234567-18", "90123456", "Jim Carrey"));
//    listaClientes.add (new Cliente("012345678-19", "01234578", "Michael Jackson"));
//    listaClientes.add (new Cliente("123456789-20", "87654321", "Arnold semtempo"));
//
//    System.out.println("Lista de Clientes:");
//    for (Cliente cliente : listaClientes) {
//        System.out.println("Nome: " +cliente.getNome() + ", CPF" + cliente.getCpf() + ", Senha: " + cliente.getSenha());
//    }

	System.out.println("Digite seu usuario ");
	
	String usuario = sc.next();
	int contador =0;
	while(!usuario.equals(c.getCpf()) && contador <2) {
		System.out.println("Usuario Incorreto ou inexistente \nTente novamente ");
		contador++;
		usuario = sc.next();
		}
		System.out.println();
		if(usuario.equals(c.getCpf())){
			System.out.println("Seja bem vindo "+c.getNome());	
		}else {
			System.out.println("Acesso usuario incorreto \nTente Novamente mais tarde");
			System.exit(0);	
	}
		
	System.out.println("Digite sua senha ");
	String senha = sc.next();
	contador =0;
	while(!senha.equals(c.getSenha()) && contador <2) {
		System.out.println("Senha Incorreta \nTente novamente");
		contador++;
		senha=sc.next();
		
	}
	System.out.println();
	if(senha.equals(c.getSenha()) && usuario.equals(c.getCpf())){
		System.out.println("Seja bem vindo ao Serra Bank "+ c.getNome());
		
	}else {
		System.out.println("Acesso Negado \nTente Novamente mais tarde");
		System.exit(0);

	}
	System.out.println("Seja bem vindo ao Banco Grupo 50");
////	TESTE DE SISTEMA
}
}

//import java.util.Scanner;
//
//import contas.Conta;
//import contas.ContaCorrente;
//import contas.ContaPoupanca;
//import pessoas.Cliente;
//import pessoas.Diretor;
//import pessoas.Gerente;
//import pessoas.Presidente;
//
//public class SistemaInterno {
//    public static void main(String[] args) {
//        // Populando o sistema com valores de teste
//      
//    
//    	Scanner sc = new Scanner(System.in);
//    	Cliente c = new Cliente("1881", "123");
//
//    	
//    	System.out.println("Digite seu usuario ");
//    	
//    	String usuario = sc.next();
//    	int contador =0;
//    	while(!usuario.equals(c.getCpf()) && contador <2) {
//    		System.out.println("Usuario Incorreto \nTente novamente ");
//    		contador++;
//    		usuario = sc.next();
//    	}
//    	System.out.println("Digite sua senha ");
//    	String senha = sc.next();
//    	contador =0;
//    	while(!senha.equals(c.getSenha()) && contador <2) {
//    		System.out.println("Senha Incorreta \nTente novamente");
//    		contador++;
//    		senha=sc.next();
//    		
//    	}
//    	System.out.println();
//    	if(senha.equals(c.getSenha()) && usuario.equals(c.getCpf())){
//    		System.out.println("Seja bem vindo ao Serra Bank");
//    		
//    	}else {
//    		System.out.println("Acesso Negado \nTente Novamente mais tarde");
//    		System.exit(0);
//    		
//    	}
//  	System.out.println("Seja bem vindo ao Banco Grupo 50");
//    	TESTE DE SISTEMA
//
//Cliente cliente1 = new Cliente("12345678900", "senha123");
//Cliente cliente2 = new Cliente("98765432100", "senha456");
//
//
//Conta conta1 = new ContaCorrente("12345678900", 1000.0, 1, "Corrente");
//Conta conta2 = new ContaPoupanca("98765432100", 500.0, 2, "Poupança");
//
//Gerente gerente1 = new Gerente("11111111111", "gerente123", "Gerente", 1);
//Presidente presidente1 = new Presidente("22222222222", "presidente123", "Presidente");
//Diretor diretor1 = new Diretor("33333333333", "diretor123", "Diretor");
//
//// Menu de login
//Scanner scanner = new Scanner(System.in);
//System.out.println("Bem-vindo ao sistema bancário!");
//System.out.print("Digite seu CPF: ");
//String cpf = scanner.nextLine();
//System.out.print("Digite sua senha: ");
//String senha = scanner.nextLine();
//
//// Verificando tipo de usuário
//if (cliente1.getCpf().equals(cpf) && cliente1.getSenha().equals(senha)) {
//    System.out.println("Bem-vindo, cliente!");
//    // Implementar ações para cliente
//} else if (gerente1.getCpf().equals(cpf) && gerente1.getSenha().equals(senha)) {
//    System.out.println("Bem-vindo, gerente!");
//    // Implementar ações para gerente
//} else if (presidente1.getCpf().equals(cpf) && presidente1.getSenha().equals(senha)) {
//    System.out.println("Bem-vindo, presidente!");
//    // Implementar ações para presidente
//} else if (diretor1.getCpf().equals(cpf) && diretor1.getSenha().equals(senha)) {
//    System.out.println("Bem-vindo, diretor!");
//    // Implementar ações para diretor
//} else {
//    System.out.println("CPF ou senha incorretos. Por favor, tente novamente.");
// Populando o sistema com valores de teste
//}
//