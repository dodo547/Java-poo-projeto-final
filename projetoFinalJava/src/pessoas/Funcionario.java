package pessoas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import menus.Menu;

import enums.FuncionariosEnum;

public abstract class Funcionario {
    protected String cpf;
    protected String senha;
    protected FuncionariosEnum cargo;
    protected String nome;
    
    // HashMap para armazenar os Funcionarios com CPF como chave
    private static HashMap<String, Funcionario> funcionarios = new HashMap<>();
    

    public Funcionario(String cpf, String senha, FuncionariosEnum cargo, String nome) {
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public FuncionariosEnum getCargo() {
        return cargo;
    }
    public String getNome() {
        return nome;
    }
    
    // Métodos de manipulação de Funcionario
    public static void adicionarFuncionario(Funcionario funcionario) {
       funcionarios.put(funcionario.getCpf(), funcionario);
    }

    public static Funcionario obterFuncionarioPorCpf(String cpf) {
        return funcionarios.get(cpf);
    }

    public static void removerFuncionarioPorCpf(String cpf) {
        funcionarios.remove(cpf);
    }

    public static void preencherFuncionario() {
        adicionarFuncionario(new Diretor("1", "2", FuncionariosEnum.DIRETOR, "Lula"));
        adicionarFuncionario(new Presidente("3", "4", FuncionariosEnum.PRESIDENTE, "Jair Bolsonaro"));
        adicionarFuncionario(new Gerente("5", "6", FuncionariosEnum.GERENTE, "Dilma", 0));
    }

    // Método para obter o HashMap de Funcionarios
    public static HashMap<String, Funcionario> getFuncionario() {
        return funcionarios;
    }
    
	public abstract void menuDiretor();

	public abstract void menuGerente();

	public abstract void menuPresidente();

	public static Funcionario get(String cpf2) {
		// TODO Auto-generated method stub
		return null;
	}		
}

//public static ArrayList<Funcionario> listaFuncionario() {
//ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
//
//listaFuncionarios.add(new Diretor("333333333-12", "5", FuncionariosEnum.DIRETOR, "Lula"));
//listaFuncionarios.add(new Presidente("444444444-13", "5", FuncionariosEnum.PRESIDENTE, "Jair Bolsonaro"));
//listaFuncionarios.add(new Gerente("555555555-23", "5", FuncionariosEnum.GERENTE, "Dilma", 0));
//
//return listaFuncionarios;
//}