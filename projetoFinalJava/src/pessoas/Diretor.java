package pessoas;

import java.util.Scanner;
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

    private void relatorioClientesOrdemAlfabetica() {
        // Implementação do relatório com informações de clientes em ordem alfabética
        System.out.println("Relatório com informações de clientes em ordem alfabética...");
    }

    @Override
    public void menuGerente() {
        // Implementação do método menuGerente, caso necessário
    }

    @Override
    public void menuPresidente() {
        // Implementação do método menuPresidente
    }

    @Override
    public void menuCliente() {
        // Implementação do método menuCliente
    }
}
