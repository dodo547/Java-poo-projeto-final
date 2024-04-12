package principal;

import java.util.ArrayList;
import java.util.Scanner;

import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;


public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Obter a lista de clientes e funcionários
        ArrayList<Cliente> listaClientes = Cliente.listaClientes();
        ArrayList<Funcionario> listaFuncionarios = Funcionario.listaFuncionario();

        // Solicitar o CPF do usuário
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.next();

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
        if (clienteEncontrado == null && funcionarioEncontrado == null) {
            System.out.println("Usuário incorreto ou inexistente. Tente novamente mais tarde.");
            System.exit(0);
        }
     // Verificar a senha do usuário
        System.out.println("Digite sua senha:");
        String senha = sc.next();

        boolean senhaCorreta = false;

        if (clienteEncontrado != null) {
            senhaCorreta = clienteEncontrado.getSenha().equals(senha);
        } else if (funcionarioEncontrado != null) {
            senhaCorreta = funcionarioEncontrado.getSenha().equals(senha);
        }

        if (!senhaCorreta) {
            System.out.println("Senha incorreta. Tente novamente mais tarde.");
            System.exit(0);
        }

        // Verificar o cargo do funcionário
        if (funcionarioEncontrado != null) {
            if (funcionarioEncontrado instanceof Diretor) {
            	System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
            	funcionarioEncontrado.menuDiretor(); // Menu Gerente
            } else if (funcionarioEncontrado instanceof Gerente) {
            	System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
            	funcionarioEncontrado.menuGerente(); // Menu Gerente
            } else if (funcionarioEncontrado instanceof Presidente) {
            	System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
            	 funcionarioEncontrado.menuPresidente(); // Menu Presidente
            } else {
            	
            }
        }

        // Caso contrário, é um cliente
        if (clienteEncontrado != null) {
            System.out.println("Olá, " + clienteEncontrado.getNome() + "! Seja bem-vindo!");
            clienteEncontrado.menuCliente(); // Chame o menu do cliente
        }
   }
}
