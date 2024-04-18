package contas;

import enums.ContasEnum;

//Classe ContaPoupanca
public class ContaPoupanca extends Conta {
	private ContasEnum tipo;

//Construtor da Conta Poupança
	public ContaPoupanca(String cpfTitular, double saldo, int agencia, ContasEnum tipo) {
		super(cpfTitular, saldo, agencia);
		this.tipo = tipo;
	}

}