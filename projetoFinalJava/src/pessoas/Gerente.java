package pessoas;

import java.util.Scanner;
import enums.FuncionariosEnum;
import sistemaInterno.SistemaInterno;

public class Gerente extends Funcionario {
    private int agenciaResponsavel;

    public Gerente(String cpf, String senha, FuncionariosEnum cargo, String nome, int agenciaResponsavel) {
        super(cpf, senha, cargo, nome);
        this.agenciaResponsavel = agenciaResponsavel;
    }

    public int getAgenciaResponsavel() {
        return agenciaResponsavel;
    }

    public void menuGerente() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Gerente:");
            System.out.println("1 - Movimentações e Informações da Conta");
            System.out.println("2 - Relatórios");
            System.out.println("3 - Sair");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Relatório com informações de clientes em ordem alfabética
                    movimentacaoeInfoConta();
                    break;
                case 2:
                    // Acessar os mesmos relatórios disponíveis ao gerente
                    menuRelatoriosGerente();
                    break;
                case 3:
                    System.out.println("Saindo do menu do Gerente.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    public void movimentacaoeInfoConta() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMovimentações e Informações da Conta:");
            System.out.println("a. Saque.");
            System.out.println("b. Depósito.");
            System.out.println("c. Transferência para outra conta.");
            System.out.println("d. Voltar ao menu anterior.");
            
            System.out.print("Escolha uma opção: ");
            String escolha = sc.next();

            switch (escolha) {
                case "a":
                    // Implementar lógica para saque
                    System.out.println("Saque escolhido.");
                    break;
                case "b":
                    // Implementar lógica para depósito
                    System.out.println("Depósito escolhido.");
                    break;
                case "c":
                    // Implementar lógica para transferência
                    System.out.println("Transferência escolhida.");
                    break;
                case "d":
                    // Volta ao menu principal
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
           		}
        	}
     	}

    // Chama os relatórios disponíveis ao gerente
    private void menuRelatoriosGerente() {
        SistemaInterno.abrirRelatorios();
    }

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuPresidente() {
		// TODO Auto-generated method stub
		
	}
}