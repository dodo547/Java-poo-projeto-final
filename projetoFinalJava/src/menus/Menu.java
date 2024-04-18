package menus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import io.InOutUtils;
import pessoas.Cliente;
import pessoas.Usuario;

public class Menu {
	
    public static void registrarLogin() {
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();
        
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        
        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();
        
        Usuario novousuario = new Cliente(cpf, senha, nome);
        
        Usuario.adicionarUsuario(novousuario);
        
        System.out.println("\nParabéns você é um novo cliente do Serra bank!");
        
        Usuario.setUsuarios(novousuario);
    }
	
    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);
        String pathClientes = "..//projetoFinalJava/src/Relatorios/ListaClientes";
        
        // Preencha o HashMap de clientes e Funcionario
        Usuario.preencherUsuario();
//        Funcionario.preencherFuncionario();

        // Obtenha o HashMap de  clientes e Funcionario
        HashMap<String, Usuario> usuario = Usuario.getUsuarios();
//        HashMap<String, Funcionario> funcionarios = Funcionario.getFuncionario();
        
       

        // Solicitar o CPF do usuário e Funcionario
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();

        // Verifique se o CPF está presente no mapa de clientes e e Funcionarios
        Usuario usuarioEncontrado = usuario.get(cpf);
//        Funcionario funcionarioEncontrado = funcionarios.get(cpf);
       
        // Verifique se o cliente ou funcionario foi encontrado
        
       
        
        if (usuarioEncontrado != null) {
        cpf = usuarioEncontrado.getCpf();
           // Continue com o processamento...
        
       
      }else {
           // Trate a condição onde clienteEncontrado é null
           System.out.println("Cliente não encontrado.");
       }
     
        // Solicitar a senha do usuário ou funcionario
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        //TODO fazer a verificação de senha!
      
        
        if (usuarioEncontrado != null) {
             senha = usuarioEncontrado.getSenha();
//             System.out.println("Bem Vindo "+ clienteEncontrado.getSenha());
             System.out.println("Olá, " + usuarioEncontrado.getNome() + "! Seja bem-vindo!");
             usuarioEncontrado.menuCliente();
             usuarioEncontrado.menuGerente();
             usuarioEncontrado.menuDiretor();
             usuarioEncontrado.menuPresidente();
            // Continue com o processamento...
        } 
//        else if (funcionarioEncontrado != null) {
//            senha = funcionarioEncontrado.getSenha();
//            System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
           
            // Continue com o processamento...
       else {
            // Trate a condição onde clienteEncontrado é null
            System.out.println("Cliente não encontrado.");
        }  
    
  //Caminho para o arquivo de texto com os dados dos clientes
    String path = "..//projetoFinalJava/src/Relatorios/ListaClientes";
        try {
            // Carregar os clientes do arquivo de texto
            HashMap<String, Cliente> usuarios = InOutUtils.leitorCliente(path);
            System.out.println("Clientes foram lidos do arquivo com sucesso!");

            // Atualize a referência de clientes em Cliente para usar o HashMap carregado
            Usuario.setUsuarios(usuario);
            
            // Após executar o menu de login, salve os clientes de volta ao arquivo de texto
            InOutUtils.escritorUsuario(path , usuario);
            System.out.println("Clientes foram salvos no arquivo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler ou salvar os clientes: " + e.getMessage());
        }
    
}
}
