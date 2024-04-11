package pessoas;

//Classe Funcionario (abstrata)

public abstract class Funcionario {
 private String nome;
 private String cpf;
 private String senha;
 private String cargo;

 
 public Funcionario() {
	super();
}

public Funcionario(String nome,String cpf, String senha, String cargo) {
	 this.cpf = nome;
     this.cpf = cpf;
     this.senha = senha;
     this.cargo = cargo;
 }

 public String getCpf() {
     return cpf;
 }

 public String getNome() {
	return nome;
}

public String getSenha() {
     return senha;
 }

 public String getCargo() {
     return cargo;
 }
}