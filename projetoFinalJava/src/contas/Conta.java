package contas;

import java.util.ArrayList;
import java.util.HashMap;

import enums.ContasEnum;

//Classe Conta (abstrata)

	public abstract class Conta {
	private String cpfTitular;
	protected double saldo;
	private int agencia;
	private double tarifaSaque = 0.10;
	private double tarifaDeposito = 0.10;
	private double tarifaTransferencia = 0.20;

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
     saldo +=   (valor - tarifaDeposito);
    
 }

     public void sacar(double valor) {
    	 saldo -= (valor + tarifaSaque);
     }
     public static ArrayList<Conta> listaConta() {
         ArrayList<Conta> listaConta = new ArrayList<>();
        // (String cpfTitular, double saldo, int agencia, String tipo
         listaConta.add(new ContaCorrente("12", 5000,125,ContasEnum.CONTACORRENTE, 2300));
         listaConta.add(new ContaCorrente("13", 2000, 125,ContasEnum.CONTACORRENTE, 4777));
         listaConta.add(new ContaPoupanca("555555555-23", 45822, 125,ContasEnum.CONTAPOUPANCA));
         listaConta.add(new ContaPoupanca("666666666-33", 52412, 125,ContasEnum.CONTAPOUPANCA));
         
         return listaConta;
     }

	
}
