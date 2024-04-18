package pessoas;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import contas.Conta;
import contas.ContaCorrente;
import enums.FuncionariosEnum;
import io.InOutUtils;


public abstract class Usuario {
	private String cpf;	
    private String senha;
    private String nome;
    double saldo;
    public double custoOperacoes = 0;
   
	
	public Usuario(String cpf, String senha, String nome) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		//this.saldo = saldo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo(String string) {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public static void setUsuarios(HashMap<String, Usuario> usuarios) {
		Usuario.usuarios = usuarios;
		
	}

	public static void setUsuarios(Usuario usuario) {
	    // Verifique se o HashMap 'usuarios' já foi inicializado. Se não, inicialize-o.
	    if (usuarios == null) {
	        usuarios = new HashMap<String, Usuario>();
	    }
	    // Adicione o novo usuário ao HashMap. Use o CPF como chave.
	    usuarios.put(usuario.getCpf(), usuario);
	}
	
		//  Métodos de manipulação de Funcionario
		private static HashMap<String, Usuario> usuarios = new HashMap<>();
		
		public static void adicionarUsuario(Usuario usuario) {
			usuarios.put(usuario.getCpf(), usuario);
		}
	

	    public static Usuario obterUsuarioPorCpf(String cpf) {
	        return usuarios.get(cpf);
	    }

	    public static void removerUsuarioPorCpf(String cpf) {
	        usuarios.remove(cpf);
	    }

	    public static void preencherUsuario() {
	        adicionarUsuario(new Diretor("1", "2", FuncionariosEnum.DIRETOR, "Lula"));
	        adicionarUsuario(new Presidente("3", "4", FuncionariosEnum.PRESIDENTE, "Jair Bolsonaro"));
	        adicionarUsuario(new Gerente("5", "6", FuncionariosEnum.GERENTE, "Dilma", 0));
	        adicionarUsuario(new Cliente("12", "123", "Felipe Amorim"));
	        adicionarUsuario(new Cliente("23", "123", "Douglas Tapajóz"));
	        adicionarUsuario(new Cliente("34", "123", "Patrick Lopes"));
	    }
	  

	    // Método para obter o HashMap de Funcionarios
	    public static HashMap<String, Usuario> getUsuarios() {
	        return usuarios;
	    }
	    
	    public void depositar(double valor) {
	        double custoDeposito = 0.10; // Custo de R$0,10 por depósito
	        if (valor > 0) {
	            saldo += valor + custoDeposito;
	            custoOperacoes += custoDeposito;
	        }
	    }

	    public void sacar(double valor) {
	        double custoSaque = 0.10; // Custo de R$0,10 por saque
	        
			if (valor > 0 && saldo >= valor + custoSaque) {
	            saldo -= valor - custoSaque;
	            custoOperacoes += custoSaque;
	        } else {
	           // System.out.println("\nSaldo Insuficiente!!. \nOperaçao Cancelada");
	        }
	    }

	    public void transferir(double valor, ContaCorrente destino) {
	    	//TODO conferir metodo abaixo
	        double custoTransferencia = 0.20; // Custo de R$0,20 por transferência
	        if (valor <= 0) {
	            System.out.println("Valor inválido para transferência.");
	            return;
	        }
	        if (saldo < valor + custoTransferencia) {
	            System.out.println("Saldo insuficiente para realizar a transferência.");
	            return;
	        }
	        if (destino.getCpfTitular().equals(this.getCpf())) {
	            System.out.println("Você não pode transferir dinheiro para a mesma conta.");
	            return;
	        }
	      
	        saldo -= (valor + custoTransferencia);
	        custoOperacoes += custoTransferencia;
	        destino.depositar(valor);
	        System.out.println("Transferência de " + valor + " realizada com sucesso!");
	    }


		
		public void exibirSaldo() {
			
			//Conta c = new Conta();
			
			ArrayList<Conta> listaConta1 = Conta.listaConta();
			for (Conta conta : listaConta1)
				if (conta.getCpfTitular().equals(cpf)) {
					System.out.println("\n*****************************************");
					System.out.println("\nSaldo disponível de: R$" + conta.getSaldo() + "\n");
					System.out.println("*****************************************");
					break;
				}
			
			
			
			//System.out.println("Saldo de : " + ContaCorrente.listaConta(getSaldo(getCpf())));
			//System.out.println("Saldo de : " +getSaldo(getCpf()));
	        //System.out.println(ContaCorrente.listaConta().equals(getCpf()));
	    }

	    
	    
		public abstract void menuCliente();

	    public abstract void menuDiretor();

	    public abstract void menuGerente();

	    public abstract void menuPresidente();
}
