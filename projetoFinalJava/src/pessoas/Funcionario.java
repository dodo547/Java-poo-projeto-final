package pessoas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import menus.Menu;

import enums.FuncionariosEnum;

public abstract class Funcionario extends Usuario {
	protected FuncionariosEnum cargo;

	public Funcionario(String cpf, String senha, FuncionariosEnum cargo, String nome) {
		super(cpf, senha, nome);
		// TODO Auto-generated constructor stub
	}

	public FuncionariosEnum getCargo() {
		return cargo;
	}
}