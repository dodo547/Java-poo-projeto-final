package contas;

import enums.ContasEnum;

//Classe ContaCorrente
public class ContaCorrente extends Conta {
 private ContasEnum tipo;

 public ContaCorrente(String cpfTitular, double saldo, int agencia, ContasEnum tipo) {
     super(cpfTitular, saldo, agencia);
     this.tipo = tipo;
 }

 @Override
 public void sacar(double valor) {
     if (getSaldo() >= valor) {
         super.depositar(-valor);
     } else {
         System.out.println("Saldo insuficiente");
     }
 }
}