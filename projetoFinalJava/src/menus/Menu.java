package menus;

import java.util.HashMap;
import java.util.Scanner;
import pessoas.Cliente;

public class Menu {

    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);

        // Preencha o HashMap de clientes
        Cliente.preencherClientes();

        // Obtenha o HashMap de clientes
        HashMap<String, Cliente> clientes = Cliente.getClientes();

        // Solicitar o CPF do usuário
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();

        // Verifique se o CPF está presente no mapa de clientes
        Cliente clienteEncontrado = clientes.get(cpf);

        // Verifique se o cliente foi encontrado
        if (clienteEncontrado == null) {
            System.out.println("Usuário incorreto ou inexistente. Tente novamente.");
            return;
        }

        // Solicitar a senha do usuário
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();

        // Verificar a senha
        if (!clienteEncontrado.getSenha().equals(senha)) {
            System.out.println("Senha incorreta. Tente novamente.");
            return;
        }

        // Executar o menu do cliente
        System.out.println("Olá, " + clienteEncontrado.getNome() + "! Seja bem-vindo!");
        clienteEncontrado.menuCliente();
    }
}