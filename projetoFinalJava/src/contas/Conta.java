package contas;

import java.util.ArrayList;
import java.util.HashMap;

import enums.ContasEnum;

//Classe Conta (abstrata)

	public abstract class Conta {
	private String cpfTitular;
	protected double saldo;
	private int agencia;

	public Conta(String cpfTitular, double saldo, int agencia) {
      this.cpfTitular = cpfTitular;
      this.saldo = saldo;
      this.agencia = agencia;
 }

     public String getCpfTitular() {
     return cpfTitular;
 }

     public double getSaldo() {
     return saldo;
 }

     public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor) {
     saldo += valor;
 }

     public void sacar(double valor) {
    	 saldo -= valor;
     }
    	 private static HashMap<String, Conta> contas = new HashMap<>();

    	 public static void adicionarConta(Conta conta) {
    	 	contas.put(conta.getCpfTitular(), conta);
    	 }


    	 public static Conta obterUsuarioPorCpf(String cpf) {
    	     return contas.get(cpf);
    	 }

    	 public static void removerUsuarioPorCpf(String cpf) {
    	     contas.remove(cpf);
    	 }

    	 public static void listaConta() {
    	 // (String cpfTitular, double saldo, int agencia, String tipo
    	 	 adicionarConta(new ContaCorrente("12", 5000,125,ContasEnum.CONTACORRENTE, 2300));
    	 	 adicionarConta(new ContaCorrente("23", 2000, 125,ContasEnum.CONTACORRENTE, 4777));
    	 	 adicionarConta(new ContaPoupanca("34", 45822, 125,ContasEnum.CONTAPOUPANCA));
    	 	 adicionarConta(new ContaPoupanca("1", 52412, 125,ContasEnum.CONTAPOUPANCA));
    	 	 adicionarConta(new ContaPoupanca("3", 52412, 125,ContasEnum.CONTAPOUPANCA));
    	 	 adicionarConta(new ContaPoupanca("5", 52412, 125,ContasEnum.CONTAPOUPANCA));
    	 }
    	 // Método para obter o HashMap de Funcionarios
    	 public static HashMap<String, Conta> getContas() {
    	     return contas;
    	 }
}
