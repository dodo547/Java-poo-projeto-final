package contas;

import enums.ContasEnum;

//Classe ContaCorrente
public class ContaCorrente extends Conta {
 private ContasEnum tipo;
 private double saldoInicial;
 
 public ContaCorrente(String cpfTitular, double saldo, int agencia, ContasEnum tipo, double saldoInicial) {
	super(cpfTitular, saldo, agencia);
	this.tipo = tipo;
	this.saldoInicial = saldoInicial;
}

 @Override
 public void sacar(double valor) {
     if (getSaldo() >= valor) {
         super.sacar(-valor);
     } else {
         System.out.println("Saldo insuficiente");
     }
 }
}