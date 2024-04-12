package pessoas;

import java.util.ArrayList;

import enums.FuncionariosEnum;


//Classe Funcionario (abstrata)

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected String senha;
    protected FuncionariosEnum cargo;

    public Funcionario(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo =cargo;
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
        ArrayList<Funcionario> listaFuncionario = new ArrayList<>();

        listaFuncionario.add(new Diretor("333333333-12", "5",FuncionariosEnum.DIRETOR ,"Lula"));
        listaFuncionario.add(new Presidente("444444444-13", "5", FuncionariosEnum.PRESIDENTE, "Jair Bolsonaro"));
        listaFuncionario.add(new Gerente("555555555-23", "5", FuncionariosEnum.GERENTE, "Dilma", 0));

        return listaFuncionario;
    }

	public void menuPresidente() {
		// TODO Auto-generated method stub	
	}
	public void menuDiretor() {
		// TODO Auto-generated method stub
	}
	public void menuGerente() {
		// TODO Auto-generated method stub	
	}
}