package pessoas;

import java.util.HashMap;
import java.util.Scanner;

// Classe Cliente
public class Cliente {
    private String cpf;
    private String senha;
    private String nome;

    // HashMap para armazenar os clientes com CPF como chave
    private static HashMap<String, Cliente> clientes = new HashMap<>();

    public Cliente() {
        super();
    }

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

    // Preenche o HashMap com clientes
    public static void preencherClientes() {
        clientes.put("123456789-10", new Cliente("123456789-10", "123", "Felipe Amorim"));
        clientes.put("234567890-11", new Cliente("234567890-11", "123", "Douglas Tapajóz"));
        clientes.put("345678901-12", new Cliente("345678901-12", "123", "Patrick Lopes"));
        // Adicione os demais clientes aqui...
    }

    // Retorna o HashMap de clientes
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
                    // Chame o método para saque aqui
                    break;
                case "1b":
                    // Chame o método para depósito aqui
                    break;
                case "1c":
                    // Chame o método para transferência aqui
                    break;
                case "2a":
                    // Chame o método para exibir saldo aqui
                    break;
                case "2b":
                    // Chame o método para relatório de tributação aqui
                    break;
                case "2c":
                    // Chame o método para relatório de rendimento aqui
                    break;
                case "3":
                    System.out.println("Saindo do menu...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
