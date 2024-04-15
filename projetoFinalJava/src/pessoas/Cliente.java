package pessoas;

import java.util.HashMap;
import java.util.Scanner;

import contas.ContaPoupanca;
import contas.ContaCorrente;
import contas.Conta;

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
        adicionarCliente(new Cliente("12", "123", "Felipe Amorim"));
        adicionarCliente(new Cliente("23", "123", "Douglas Tapajóz"));
        adicionarCliente(new Cliente("34", "123", "Patrick Lopes"));
    }

    // Método para obter o HashMap de clientes
    public static HashMap<String, Cliente> getClientes() {
        return clientes;
    }

	public static void setClientes(HashMap<String, Cliente> clientes2) {
		// TODO Auto-generated method stub
		  
	}
    // Menu do cliente
    public void menuCliente() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Cliente:");
            System.out.println("1. Movimentações na Conta");
            System.out.println("2. Relatórios");
            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");
            String escolha = sc.next();
        
            switch (escolha) {
            case "1":
                movimentacoesNaConta();
                break;
            case "2":
                relatorios();
                break;
            case "3":
                System.out.println("Saindo do menu do cliente...");
                return; // Sai do método
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}

// Método para tratar as opções de Movimentações na Conta
public void movimentacoesNaConta() {
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("\nMovimentações na Conta:");
        System.out.println("a. Saque");
        System.out.println("b. Depósito");
        System.out.println("c. Transferência para outra conta");
        System.out.println("d. Voltar ao menu anterior");

        System.out.print("Escolha uma opção: ");
        String escolha = sc.next();

        switch (escolha) {
            case "a":
                // Implementar lógica para saque
                System.out.println("Saque escolhido");
                break;
            case "b":
                // Implementar lógica para depósito
                System.out.println("Depósito escolhido");
                break;
            case "c":
                // Implementar lógica para transferência
                System.out.println("Transferência escolhida");
                break;
            case "d":
                // Volta ao menu principal
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }
}
public void relatorios() {
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.println("\nRelatótrios da Conta:");
        System.out.println("a. Relatório de Saldo");
        System.out.println("b. Relatório de tributação da conta corrente");
        System.out.println("c. Relatório de Rendimento da poupança");
        System.out.println("d. Voltar ao menu anterior");
        
        System.out.print("Escolha uma opção: ");
        String escolha = sc.next();

        switch (escolha) {
            case "a":
                // Implementar lógica para saque
                System.out.println("Relatório de Saldo");
                break;
            case "b":
                // Implementar lógica para depósito
                System.out.println("Relatório de tributação da conta corrente");
                break;
            case "c":
                // Implementar lógica para transferência
                System.out.println("Relatório de Rendimento da poupança");
                break;
            case "d":
                // Volta ao menu principal
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
       		}
    	}
 	}
}