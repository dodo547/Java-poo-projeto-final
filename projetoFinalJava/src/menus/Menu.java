package menus;

import java.util.ArrayList;
import java.util.Scanner;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

public class Menu {

    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);

        // Obter a lista de clientes e funcionários
        ArrayList<Cliente> listaClientes = Cliente.listaClientes();
        ArrayList<Funcionario> listaFuncionarios = Funcionario.listaFuncionario();

        // Solicitar o CPF do usuário
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();  // Use nextLine para evitar problemas de leitura

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
            return; // Voltar ao menu ou encerrar
        }

        // Solicitar a senha do usuário
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();  // Use nextLine para evitar problemas de leitura

        // Verificar a senha
        boolean senhaCorreta = false;
        if (clienteEncontrado != null) {
            senhaCorreta = clienteEncontrado.getSenha().equals(senha);
        } else if (funcionarioEncontrado != null) {
            senhaCorreta = funcionarioEncontrado.getSenha().equals(senha);
        }

        if (!senhaCorreta) {
            System.out.println("Senha incorreta. Tente novamente mais tarde.");
            return; // Voltar ao menu ou encerrar
        }

        // Executar o menu apropriado com base no tipo de usuário
        if (funcionarioEncontrado != null) {
            System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
            if (funcionarioEncontrado instanceof Diretor) {
                funcionarioEncontrado.menuDiretor(); 
            } else if (funcionarioEncontrado instanceof Gerente) {
                funcionarioEncontrado.menuGerente();
            } else if (funcionarioEncontrado instanceof Presidente) {
                funcionarioEncontrado.menuPresidente();
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("Olá, " + clienteEncontrado.getNome() + "! Seja bem-vindo!");
            clienteEncontrado.menuCliente();
        }
    }
}