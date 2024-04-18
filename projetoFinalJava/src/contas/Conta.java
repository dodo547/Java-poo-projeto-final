package contas;

import java.util.ArrayList;
import java.util.HashMap;

import enums.ContasEnum;

//Classe Conta (abstrata)

	public abstract class Conta {
	protected String cpfTitular;
	protected double saldo;
	protected int agencia;
	protected double tarifaSaque = 0.10;
	protected double tarifaDeposito = 0.10;
	protected double tarifaTransferencia = 0.20;
	protected String nome;

	public Conta( String cpfTitular, double saldo, int agencia) {
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

     public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void depositar(double valor) {
     saldo +=   (valor - tarifaDeposito);
    
 }

     public void sacar(double valor) {
    	 saldo -= (valor + tarifaSaque);
     }
     public static ArrayList<Conta> listaConta() {
         ArrayList<Conta> listaConta = new ArrayList<>();
        // (String cpfTitular, double saldo, int agencia, String tipo
         listaConta.add(new ContaCorrente("12", 5000,125,ContasEnum.CONTACORRENTE, 5600));
         listaConta.add(new ContaCorrente("5", 9000,125,ContasEnum.CONTACORRENTE, 1300));
         listaConta.add(new ContaCorrente("13", 2000, 125,ContasEnum.CONTACORRENTE, 4500));
         listaConta.add(new ContaCorrente("3", 12000, 125,ContasEnum.CONTACORRENTE, 98077));
         listaConta.add(new ContaCorrente("1", 12000, 125,ContasEnum.CONTACORRENTE, 98077));
         listaConta.add(new ContaPoupanca("555555555-23", 45822, 125,ContasEnum.CONTAPOUPANCA));
         listaConta.add(new ContaPoupanca("666666666-33", 52412, 125,ContasEnum.CONTAPOUPANCA));
         
         return listaConta;
     }
     

     public static void adicionarConta(ArrayList<Conta> listaContas, Conta novaConta) {
     	    if (listaContas == null) {
     	        System.out.println("Erro na Lista de contas.");
     	        return;
     	    }
     	    
     	    listaContas.add(novaConta);
     	}
	
}
