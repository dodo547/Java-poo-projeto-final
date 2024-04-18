package pessoas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import contas.Conta;
import enums.FuncionariosEnum;

public class Diretor extends Funcionario {

    public Diretor(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        super(cpf, senha, FuncionariosEnum.DIRETOR, nome);
    }

    public void menuDiretor() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Diretor:");
            System.out.println("1 - Relatório com informações de clientes em ordem alfabética.");
            System.out.println("2 - Acessar menu do Gerente.");
            System.out.println("3 - Sair.");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Chama o método específico para gerar relatório com informações de clientes em ordem alfabética
                    relatorioClientesOrdemAlfabetica();
                    break;
                case 2:
                    // Cria uma instância de Gerente e chama o método menuGerente
                    Gerente gerente = new Gerente(getCpf(), getSenha(), FuncionariosEnum.GERENTE, getNome(), 0);
                    gerente.menuGerente();
                    break;
                case 3:
                    System.out.println("Encerrando Operação.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


	// Outros construtores e métodos omitidos

    public void relatorioClientesOrdemAlfabetica() {
        // Obter a lista de contas
        ArrayList<Conta> listaContas = Conta.listaConta();

        // Ordenar a lista de contas por CPF
        Collections.sort(listaContas, Comparator.comparing(Conta::getCpfTitular));

        //for( listaContas : clie );
        // Definir o caminho do arquivo de saída
        String arquivoRelatorio = "..//projetoFinalJava/src/Relatorios/Relatório_em_Ordem_Alfabetica";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoRelatorio, true))) {
            // Escrever cabeçalho do relatório
            writer.write("Relatório de Clientes em Ordem Alfabética\n");
            
            writer.write("-------------------------------\n");

            // Escrever informações de cada cliente
            for (Conta conta : listaContas) {
                // Obter o nome do titular pelo CPF
            	String cpfUser = conta.getCpfTitular();
               Usuario pessoa = pessoas.Cliente.obterUsuarioPorCpf(getNome());
                
            	
                		
                // Escrever informações no arquivo
                
                writer.write("\n Nome do Titular da conta: " + pessoa);
                writer.write("\n Cpf do Titular da conta: " + conta.getCpfTitular());
                writer.write("\n Agencia da conta: " + conta.getAgencia() + "\n");
                writer.write("***************************************************\n");
               
            }

            // Fechar o arquivo
            System.out.println("**********************************");
            System.out.println("  Relatório gerado com sucesso! ");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o relatório: " + e.getMessage());
        }
    }

    // Método fictício para obter o nome do titular pelo CPF
    private String obterNomePorCpf(String cpf) {
        // Implemente sua lógica específica aqui para obter o nome pelo CPF
        return "nome"; // Exemplo
    }

    // Outros métodos omitidos


	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuGerente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuPresidente() {
		// TODO Auto-generated method stub
		
	}
}