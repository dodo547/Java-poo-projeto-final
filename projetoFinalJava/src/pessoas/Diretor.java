package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;
import sistemaInterno.SistemaInterno;

public class Diretor extends Funcionario {

    public Diretor(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        super(cpf, senha, FuncionariosEnum.DIRETOR, nome);
    }

    public void menuDiretor() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Diretor:");
            System.out.println("1 - Relatório com informações de clientes em ordem alfabética.");
            System.out.println("2 - Relatórios do sistema interno.");
            System.out.println("3 - Sair.");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Relatório com informações de clientes em ordem alfabética
                    SistemaInterno.relatorioClientesOrdemAlfabetica();
                    break;
                case 2:
                    // Acessar os mesmos relatórios disponíveis ao gerente
                    SistemaInterno.abrirRelatorios();
                    break;
                case 3:
                    System.out.println("Saindo do menu do Diretor.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Chama os relatórios disponíveis ao gerente
    private void menuRelatoriosGerente() {
        SistemaInterno.abrirRelatorios();
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