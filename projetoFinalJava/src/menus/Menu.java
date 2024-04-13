package menus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import io.InOutUtils;
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
    
    
 // Caminho para o arquivo de texto com os dados dos clientes
    String path = "/home/administrador/Documentos/Java-poo-projeto-final/projetoFinalJava/src/arquivo/arquivos.txt";
     
    try {
        // Carregar os clientes do arquivo de texto
        HashMap<String, Cliente> cliente = InOutUtils.leitor(path);
        System.out.println("Clientes foram lidos do arquivo com sucesso!");

        // Atualize a referência de clientes em Cliente para usar o HashMap carregado
        Cliente.setClientes(cliente);

        // Após executar o menu de login, salve os clientes de volta ao arquivo de texto
        InOutUtils.escritor(path, cliente);
        System.out.println("Clientes foram salvos no arquivo com sucesso!");

    } catch (IOException e) {
        System.err.println("Erro ao ler ou salvar os clientes: " + e.getMessage());
    }
}
}