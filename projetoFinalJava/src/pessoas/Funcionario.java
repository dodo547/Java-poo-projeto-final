package pessoas;

//Classe Funcionario (abstrata)

public abstract class Funcionario {
 private String cpf;
 private String senha;
 private String cargo;

 public Funcionario(String cpf, String senha, String cargo) {
     this.cpf = cpf;
     this.senha = senha;
     this.cargo = cargo;
 }

 public String getCpf() {
     return cpf;
 }

 public String getSenha() {
     return senha;
 }

 public String getCargo() {
     return cargo;
 }
}