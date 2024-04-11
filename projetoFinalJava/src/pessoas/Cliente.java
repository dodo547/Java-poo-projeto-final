package pessoas;

// Classe Cliente
    public class Cliente {
    private String cpf;
    private String senha;
    private String nome;

    public Cliente() {
		super();
	}

	public Cliente(String cpf, String senha, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome=nome;
    }

    public String getCpf() {
        return cpf;
    }
	public String getSenha() {
        return senha;
    }

    public String getNome() {
		return nome;
	}

}