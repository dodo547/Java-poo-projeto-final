package principal;

import java.util.ArrayList;
import java.util.Scanner;

import pessoas.Cliente;



public class SistemaInterno {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    // Obter a lista de clientes
	    ArrayList<Cliente> listaClientes = Cliente.listaClientes();

	    // Solicitar o CPF do usuário
	    System.out.println("Digite seu usuário (CPF):");
	    String usuario = sc.next();

	    // Procurar o cliente na lista de clientes
	    Cliente clienteEncontrado = null;
	    for (Cliente cliente : listaClientes) {
	        if (cliente.getCpf().equals(usuario)) {
	            clienteEncontrado = cliente;
	            break;
	        }
	    }

	    // Verificar se o usuário foi encontrado
	    if (clienteEncontrado == null) {
	        System.out.println("Usuário incorreto ou inexistente. Tente novamente mais tarde.");
	        System.exit(0);
	    }

	    // Solicitar a senha do usuário
	    System.out.println("Digite sua senha:");
	    String senha = sc.next();

	    // Verificar a senha do usuário
	    if (!clienteEncontrado.getSenha().equals(senha)) {
	        System.out.println("Senha incorreta. Tente novamente mais tarde.");
	        System.exit(0);
	    }

	    // Usuário autenticado com sucesso
	    System.out.println("Seja bem-vindo ao Serra Bank, " + clienteEncontrado.getNome() + "!");
	    System.out.println("Seja bem-vindo ao Banco Grupo 50!");
	
	}
}