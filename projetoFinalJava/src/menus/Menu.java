package menus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import io.InOutUtils;
import pessoas.Cliente;
import pessoas.Usuario;

public class Menu {
    // Método para registrar um novo cliente
    public static void registrarLogin() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();
        
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        
        Usuario novoUsuario = new Cliente(cpf, senha, nome);
        
        Usuario.adicionarUsuario(novoUsuario);
        
        System.out.println("\nParabéns! Você é um novo cliente do Serra Bank!");
    }
    
    // Método para realizar o login de um usuário
    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);
        String pathClientes = "..//projetoFinalJava/src/Relatorios/ListaClientes";
        
        // Ler os dados dos clientes do arquivo
        Usuario.preencherUsuario();
        
        // Obtenha o HashMap de usuários
        HashMap<String, Usuario> usuarios = Usuario.getUsuarios();
        
        int tentativas = 0; // Contador de tentativas
        
        while (tentativas < 3) {
            System.out.println("Digite seu usuário (CPF):");
            String cpf = sc.nextLine();
            
            // Verifique se o usuário existe
            Usuario usuarioEncontrado = usuarios.get(cpf);
            
            if (usuarioEncontrado == null) {
                // Usuário não encontrado
                System.out.println("Cliente não encontrado. Tente novamente.");
                tentativas++;
                continue; // Volta para outra tentativa
            }
            
            System.out.println("Digite sua senha:");
            String senha = sc.nextLine();
            
            // Verifique a senha
            if (usuarioEncontrado.getSenha().equals(senha)) {
                System.out.println("Olá, " + usuarioEncontrado.getNome() + "! Seja bem-vindo!");
                
                // Chame os menus apropriados para o usuário
                usuarioEncontrado.menuCliente();
                usuarioEncontrado.menuGerente();
                usuarioEncontrado.menuDiretor();
                usuarioEncontrado.menuPresidente();
                break; // Login bem-sucedido, saia do loop
            } else {
                // Senha incorreta
                System.out.println("Senha incorreta. Tente novamente.");
                tentativas++;
            }
        }
        
        // Se o número de tentativas falhadas atingir 3, volte ao menu inicial
        if (tentativas >= 3) {
            System.out.println("Número de tentativas excedido. Voltando ao menu inicial...");
            // Aqui você pode adicionar um retorno ao menu inicial, se necessário
        }
        
        // Salvar os dados dos clientes no arquivo após a execução do menu de login
        try {
            InOutUtils.escritorUsuario(pathClientes, usuarios);
            System.out.println("Clientes foram salvos no arquivo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os clientes: " + e.getMessage());
        }
    }
    
}
