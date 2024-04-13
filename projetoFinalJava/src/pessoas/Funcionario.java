package pessoas;

import java.util.ArrayList;

import enums.FuncionariosEnum;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected String senha;
    protected FuncionariosEnum cargo;

    public Funcionario(String cpf, String senha, FuncionariosEnum cargo, String nome) {
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

    public FuncionariosEnum getCargo() {
        return cargo;
    }
    
    public static ArrayList<Funcionario> listaFuncionario() {
        ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
        
        listaFuncionarios.add(new Diretor("333333333-12", "5", FuncionariosEnum.DIRETOR, "Lula"));
        listaFuncionarios.add(new Presidente("444444444-13", "5", FuncionariosEnum.PRESIDENTE, "Jair Bolsonaro"));
        listaFuncionarios.add(new Gerente("555555555-23", "5", FuncionariosEnum.GERENTE, "Dilma", 0));
        
        return listaFuncionarios;
    }

	public abstract void menuDiretor();

	public abstract void menuGerente();

	public abstract void menuPresidente();

   
		// TODO Auto-generated method stub
		
	}

