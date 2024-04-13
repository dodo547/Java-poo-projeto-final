package pessoas;

import java.util.HashMap;
import java.util.Scanner;

public class Cliente {
    private String cpf;
    private String senha;
    private String nome;

    // HashMap para armazenar os clientes com CPF como chave
    private static HashMap<String, Cliente> clientes = new HashMap<>();

    // Construtores
    public Cliente() {}

    public Cliente(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    // Métodos getters
    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    // Métodos de manipulação de clientes
    public static void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public static Cliente obterClientePorCpf(String cpf) {
        return clientes.get(cpf);
    }

    public static void removerClientePorCpf(String cpf) {
        clientes.remove(cpf);
    }

    public static void preencherClientes() {
        adicionarCliente(new Cliente("123456789-10", "123", "Felipe Amorim"));
        adicionarCliente(new Cliente("234567890-11", "123", "Douglas Tapajóz"));
        adicionarCliente(new Cliente("345678901-12", "123", "Patrick Lopes"));
    }

    // Método para obter o HashMap de clientes
    public static HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    // Menu do cliente
    public void menuCliente() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Cliente:");
            System.out.println("1. Movimentações na Conta");
            System.out.println("   a. Saque");
            System.out.println("   b. Depósito");
            System.out.println("   c. Transferência para outra conta");
            System.out.println("2. Relatórios");
            System.out.println("   a. Saldo");
            System.out.println("   b. Relatório de tributação da conta corrente");
            System.out.println("   c. Relatório de rendimento da poupança");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            String escolha = sc.next();

            switch (escolha) {
                case "1a":
                    // Adicione lógica para saque aqui
                    break;
                case "1b":
                    // Adicione lógica para depósito aqui
                    break;
                case "1c":
                    // Adicione lógica para transferência aqui
                    break;
                case "2a":
                    // Adicione lógica para exibir saldo aqui
                    break;
                case "2b":
                    // Adicione lógica para relatório de tributação aqui
                    break;
                case "2c":
                    // Adicione lógica para relatório de rendimento aqui
                    break;
                case "3":
                    System.out.println("Saindo do menu...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

	public static void setClientes(HashMap<String, Cliente> clientes2) {
		// TODO Auto-generated method stub
		
	}
}
