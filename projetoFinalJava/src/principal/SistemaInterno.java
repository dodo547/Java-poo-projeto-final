package principal;

import java.util.ArrayList;
import java.util.Scanner;

import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;


public class SistemaInterno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Obter a lista de clientes e funcionários
        ArrayList<Cliente> listaClientes = Cliente.listaClientes();
        ArrayList<Funcionario> listaFuncionarios = Funcionario.listaFuncionario();

        // Solicitar o CPF do usuário
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.next();
        int contador =0;
    	while(!cpf.equals(null)) {
    		System.out.println("Usuario Incorreta ou inexistente \nTente novamente ");
    		contador++;
    		cpf = sc.next();
    	}

        // Procurar o cliente ou funcionário na lista de clientes e funcionários
        Cliente clienteEncontrado = null;
        Funcionario funcionarioEncontrado = null;
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                funcionarioEncontrado = funcionario;
                break;
            }
        }

        // Verificar se o usuário foi encontrado
        if (clienteEncontrado == null && funcionarioEncontrado == null ) {
            System.out.println("Usuário incorreto ou inexistente. Tente novamente mais tarde.");
            System.exit(0);
        }
        // Verificar a senha do usuário
        System.out.println("Digite sua senha:");
        String senha = sc.next();
        if (clienteEncontrado != null && !clienteEncontrado.getSenha().equals(senha)) {
            System.out.println("Senha incorreta. Tente novamente mais tarde.");

        } else if (funcionarioEncontrado != null && !funcionarioEncontrado.getSenha().equals(senha)) {
            System.out.println("Senha incorreta. Tente novamente mais tarde.");
            
         
            // Verificar o cargo do funcionário
            if (funcionarioEncontrado instanceof Diretor) {
                System.out.println("Olá diretor, Seja bem vindo!");

            } else if (funcionarioEncontrado instanceof Gerente) {
                System.out.println("Olá gerente, Seja bem vindo!");

            } else if (funcionarioEncontrado instanceof Presidente) {
                System.out.println("Olá presidente, Seja bem vindo!");
            }
        } else {
            
            if (clienteEncontrado != null) {
               
            } else {
                
            }
        }
    }
}