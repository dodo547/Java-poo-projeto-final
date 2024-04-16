package pessoas;

import java.util.Scanner;

import enums.FuncionariosEnum;

public class Presidente extends Funcionario {

    public Presidente(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        super(cpf, senha, FuncionariosEnum.PRESIDENTE, nome);
    }

    public void menuPresidente() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu do Presidente:");
            System.out.println("1 - Relatórios disponíveis ao Presidente.");
            System.out.println("2 - Acessar menu do Diretor.");
            System.out.println("3 - Acessar menu do Gerente.");
            System.out.println("4 - Sair do menu do Presidente.");

            int escolha = sc.nextInt();
            sc.nextLine(); // Limpar a entrada

            switch (escolha) {
                case 1:
                    // Acessar relatórios disponíveis ao presidente
                    menuRelatoriosPresidente();
                    break;
                case 2:
                    // Acessar o menu do diretor
                    acessarMenuDiretor();
                    break;
                case 3:
                    // Acessar o menu do gerente
                    acessarMenuGerente();
                    break;
                case 4:
                    System.out.println("Saindo do menu do Presidente.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para acessar relatórios disponíveis ao presidente
    private void menuRelatoriosPresidente() {
<<<<<<< HEAD
    	SistemaInterno sist= new SistemaInterno();
    	sist.abrirRelatorios();
=======
        System.out.println("Acessando relatórios disponíveis ao Presidente.");
        // Implementar lógica para acessar relatórios disponíveis ao presidente
    }

    // Método para acessar o menu do Gerente
    private void acessarMenuGerente() {
        Gerente gerente = new Gerente(cpf, senha, FuncionariosEnum.GERENTE, nome, 0);
        gerente.menuGerente();
    }

    // Método para acessar o menu do Diretor
    private void acessarMenuDiretor() {
        Diretor diretor = new Diretor(cpf, senha, FuncionariosEnum.DIRETOR, nome);
        diretor.menuDiretor();
>>>>>>> 6d4363cf6eff444f813bdd0c6187154957043d21
    }

	@Override
	public void menuDiretor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuGerente() {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD

	@Override
	public void menuCliente() {
		// TODO Auto-generated method stub
		
	}
}
=======
}
>>>>>>> 6d4363cf6eff444f813bdd0c6187154957043d21
