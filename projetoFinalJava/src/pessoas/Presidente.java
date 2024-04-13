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
            System.out.println("1 - Relatórios disponíveis ao presidente");
            System.out.println("2 - Sair");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Acessar os relatórios disponíveis ao presidente
                    menuRelatoriosPresidente();
                    break;
                case 2:
                    System.out.println("Saindo do menu do Presidente.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Chama os relatórios disponíveis ao presidente
    private void menuRelatoriosPresidente() {
        SistemaInterno.abrirRelatorios();
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