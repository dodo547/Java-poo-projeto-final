package pessoas;
import java.util.HashMap;

import enums.FuncionariosEnum;


public abstract class Usuario {
	private String cpf;	
    private String senha;
    private String nome;
	
	
	public String getCpf() {
		return cpf;
	}
	public String getSenha() {
		return senha;
	}
	public String getNome() {
		return nome;
	}
	
	
	public Usuario(String cpf, String senha, String nome) {
		super();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}
	public static void setUsuarios(HashMap<String, Usuario> usuarios) {
		Usuario.usuarios = usuarios;
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
	    public abstract void menuCliente();
	    
	    public abstract void menuDiretor();

		public abstract void menuGerente();

		public abstract void menuPresidente();
}