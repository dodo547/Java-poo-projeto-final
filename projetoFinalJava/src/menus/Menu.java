package menus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import io.InOutUtils;
import pessoas.Cliente;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Diretor;
import pessoas.Presidente;

public class Menu {

	

    public static void menuLogin() {
        Scanner sc = new Scanner(System.in);
        String path = "//home//administrador//Documentos//Java-poo-projeto-final//projetoFinalJava//src//Relatório1";
        
        // Preencha o HashMap de clientes e Funcionario
        Cliente.preencherClientes();
        Funcionario.preencherFuncionario();

        // Obtenha o HashMap de  clientes e Funcionario
        HashMap<String, Cliente> clientes = Cliente.getClientes();
        HashMap<String, Funcionario> funcionarios = Funcionario.getFuncionario();
        
       

        // Solicitar o CPF do usuário e Funcionario
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();

        // Verifique se o CPF está presente no mapa de clientes e e Funcionarios
        Cliente clienteEncontrado = clientes.get(cpf);
        Funcionario funcionarioEncontrado = funcionarios.get(cpf);
        
        // Verifique se o cliente ou funcionario foi encontrado
        
        if (clienteEncontrado != null) {
        cpf = clienteEncontrado.getCpf();
           // Continue com o processamento...
       } 
        else if (funcionarioEncontrado != null) {
           cpf = funcionarioEncontrado.getCpf();
          // Continue com o processamento...
      }else {
           // Trate a condição onde clienteEncontrado é null
           System.out.println("Cliente não encontrado.");
       }
     
        // Solicitar a senha do usuário ou funcionario
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
   
      
        
        if (clienteEncontrado != null) {
             senha = clienteEncontrado.getSenha();
             System.out.println("Bem Vindo "+ clienteEncontrado.getSenha()); 
             System.out.println("Olá, " + clienteEncontrado.getNome() + "! Seja bem-vindo!");
             clienteEncontrado.menuCliente();
            // Continue com o processamento...
        } 
        else if (funcionarioEncontrado != null) {
            senha = funcionarioEncontrado.getSenha();
            System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
            funcionarioEncontrado.menuGerente();
            funcionarioEncontrado.menuDiretor(); 
            funcionarioEncontrado.menuPresidente();
            // Continue com o processamento...
       }else {
            // Trate a condição onde clienteEncontrado é null
            System.out.println("Cliente não encontrado.");
        }  
    
 // Caminho para o arquivo de texto com os dados dos clientes
   // String path = "/home/administrador/Documentos/Java-poo-projeto-final/projetoFinalJava/src/arquivo/arquivos.txt";
        try {
            // Carregar os clientes do arquivo de texto
            HashMap<String, Cliente> cliente = InOutUtils.leitor(path);
            System.out.println("Clientes foram lidos do arquivo com sucesso!");

            // Atualize a referência de clientes em Cliente para usar o HashMap carregado
            Cliente.setClientes(cliente);
            
            // Após executar o menu de login, salve os clientes de volta ao arquivo de texto
            InOutUtils.escritor(path, clientes);
            System.out.println("Clientes foram salvos no arquivo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler ou salvar os clientes: " + e.getMessage());
        }
    
    }
}