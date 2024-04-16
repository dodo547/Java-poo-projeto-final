package pessoas;

import java.util.Scanner;
import enums.FuncionariosEnum;
import sistemaInterno.SistemaInterno;

public class Presidente extends Funcionario {

    public Presidente(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        super(cpf, senha, cargo, nome);
    }

    public void menuPresidente() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Presidente:");
            System.out.println("1 - Relatórios disponíveis ao Presidente.");
            System.out.println("2 - Relatórios disponíveis ao Diretor.");
            System.out.println("3 - Relatórios disponíveis ao Gerente.");
            System.out.println("4 - Sair do menu do Presidente.");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Acessar os relatórios disponíveis ao presidente
                    menuRelatoriosPresidente();
                    break;
                case 2:
                    // Acessar os relatórios disponíveis ao DIRETOR
                	SistemaInterno.relatorioClientesOrdemAlfabetica();
                    break;
                case 3:
                    // Acessar os relatórios disponíveis ao GERENTE
                    SistemaInterno.abrirRelatorios();
                    break;
                case 4:
                    System.out.println("Saindo do menu do Presidente.");
                    System.exit(0);;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Chama os relatórios disponíveis ao presidente
    private void menuRelatoriosPresidente() {

    }

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuGerente() {
		// TODO Auto-generated method stub
		
	}
}