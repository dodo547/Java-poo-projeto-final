package pessoas;

import java.util.ArrayList;

//Classe Funcionario (abstrata)

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected String senha;
    protected String cargo;

    public Funcionario(String cpf, String senha, String cargo, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.nome = nome;
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

    public static ArrayList<Funcionario> listaFuncionario() {
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        listaFuncionario.add(new Diretor("333333333-12", "5", "Diretor", "Lula"));
        listaFuncionario.add(new Presidente("444444444-13", "5", "Presidente", "Jair Bolsonaro"));
        listaFuncionario.add(new Gerente("555555555-23", "5", "Gerente", "Dilma", 0));

        return listaFuncionario;
    }
}