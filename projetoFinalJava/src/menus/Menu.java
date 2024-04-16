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
        int tentativasIncorretas = 0;
        int tentativasMaximas = 3;
        String path = "//home//administrador//Documentos//Java-poo-projeto-final//projetoFinalJava//src//Relatório1";
        
     // Preencha o HashMap de clientes e funcionários
        Cliente.preencherClientes();
        Funcionario.preencherFuncionario();

        // Obtenha o HashMap de clientes e funcionários
        HashMap<String, Cliente> clientes = Cliente.getClientes();
        HashMap<String, Funcionario> funcionarios = Funcionario.getFuncionario();

        // Solicitar o CPF do usuário
        System.out.println("Digite seu usuário (CPF):");
        String cpf = sc.nextLine();

        // Verifique se o CPF está presente no mapa de clientes ou funcionários
        Cliente clienteEncontrado = clientes.get(cpf);
        Funcionario funcionarioEncontrado = funcionarios.get(cpf);

        // Verifique se o cliente ou funcionário foi encontrado
        if (clienteEncontrado == null && funcionarioEncontrado == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        // Solicitar a senha do usuário
        while (tentativasIncorretas < tentativasMaximas) {
            System.out.println("Digite sua senha:");
            String senhaEntrada = sc.nextLine();
            boolean acessoConcedido = false;

            // Verifique se a senha está correta para o cliente
            if (clienteEncontrado != null && senhaEntrada.equals(clienteEncontrado.getSenha())) {
                System.out.println("Olá, " + clienteEncontrado.getNome() + "! Seja bem-vindo!");
                clienteEncontrado.menuCliente();
                acessoConcedido = true;
                break;
            }

            // Verifique se a senha está correta para o funcionário
            if (funcionarioEncontrado != null && senhaEntrada.equals(funcionarioEncontrado.getSenha())) {
                System.out.println("Olá, " + funcionarioEncontrado.getNome() + "! Seja bem-vindo!");
                funcionarioEncontrado.menuGerente();
                funcionarioEncontrado.menuDiretor();
                funcionarioEncontrado.menuPresidente();
                acessoConcedido = true;
                break;
            }

            // Se a senha estiver incorreta, incremente as tentativas incorretas
            tentativasIncorretas++;
            System.out.println("Senha incorreta. Tente novamente.");

            // Verifique se o número máximo de tentativas foi atingido
            if (tentativasIncorretas >= tentativasMaximas) {
                System.out.println("Você tentou 3 vezes e falhou. O programa será encerrado.");
                sc.close();
                System.exit(1);
            }
        }

        // Carregar e salvar clientes
        try {
            // Carregar os clientes do arquivo de texto
            HashMap<String, Cliente> clientesDoArquivo = InOutUtils.leitor(path);
            System.out.println("Clientes foram lidos do arquivo com sucesso!");

            // Atualize a referência de clientes em Cliente para usar o HashMap carregado
            Cliente.setClientes(clientesDoArquivo);

            // Após executar o menu de login, salve os clientes de volta ao arquivo de texto
            InOutUtils.escritor(path, clientesDoArquivo);
            System.out.println("Clientes foram salvos no arquivo com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler ou salvar os clientes: " + e.getMessage());
        }

        // Fecha o Scanner
        sc.close();
    }
    }