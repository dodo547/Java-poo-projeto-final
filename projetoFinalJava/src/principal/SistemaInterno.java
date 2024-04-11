package principal;

import java.io.IOException;
import java.util.Scanner;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;
import io.InOutUtils;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Gerente;
import pessoas.Presidente;

public class SistemaInterno {
    public static void main(String[] args) {
        // Populando o sistema com valores de teste
        Cliente cliente1 = new Cliente("12345678900", "senha123");
        Cliente cliente2 = new Cliente("98765432100", "senha456");
        

        Conta conta1 = new ContaCorrente("12345678900", 1000.0, 1, "Corrente");
        Conta conta2 = new ContaPoupanca("98765432100", 500.0, 2, "Poupança");

        Gerente gerente1 = new Gerente("11111111111", "gerente123", "Gerente", 1);
        Presidente presidente1 = new Presidente("22222222222", "presidente123", "Presidente");
        Diretor diretor1 = new Diretor("33333333333", "diretor123", "Diretor");

        // Menu de login
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema bancário!");
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Verificando tipo de usuário
        if (cliente1.getCpf().equals(cpf) && cliente1.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, cliente!");
            // Implementar ações para cliente
        } else if (gerente1.getCpf().equals(cpf) && gerente1.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, gerente!");
            // Implementar ações para gerente
        } else if (presidente1.getCpf().equals(cpf) && presidente1.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, presidente!");
            // Implementar ações para presidente
        } else if (diretor1.getCpf().equals(cpf) && diretor1.getSenha().equals(senha)) {
            System.out.println("Bem-vindo, diretor!");
            // Implementar ações para diretor
        } else {
            System.out.println("CPF ou senha incorretos. Por favor, tente novamente.");
        }

		//	try {
			//	InOutUtils.escritor("./");
			//	InOutUtils.leitor("./");
		//	} catch (IOException e) {
			//	 TODO Auto-generated catch block
			//	e.printStackTrace();
		//	}
     
        }

    }