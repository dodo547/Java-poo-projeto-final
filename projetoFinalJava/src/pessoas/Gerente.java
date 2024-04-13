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
            System.out.println("1 - Relatórios disponíveis ao gerente");
            System.out.println("2 - Sair");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Acessar os relatórios disponíveis ao gerente
                    menuRelatoriosGerente();
                    break;
                case 2:
                    System.out.println("Saindo do menu do Gerente.");
                    return;
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
	public void menuDiretor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuPresidente() {
		// TODO Auto-generated method stub
		
	}
}