package contas;

import java.util.ArrayList;

import enums.ContasEnum;
import enums.FuncionariosEnum;
import pessoas.Diretor;
import pessoas.Funcionario;
import pessoas.Gerente;
import pessoas.Presidente;

//Classe Conta (abstrata)

	public abstract class Conta {
	private String cpfTitular;
	private double saldo;
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

     public void depositar(double valor) {
     saldo += valor;
 }

     public abstract void sacar(double valor);

	public static ArrayList<Conta> listaConta() {
        ArrayList<Conta> listaConta = new ArrayList<>();
       // (String cpfTitular, double saldo, int agencia, String tipo
        listaConta.add(new ContaCorrente("333333333-12", 5000,125,ContasEnum.CONTACORRENTE));
        listaConta.add(new ContaCorrente("444444444-13", 2000, 125,ContasEnum.CONTACORRENTE));
        listaConta.add(new ContaPoupanca("555555555-23", 45822, 125,ContasEnum.CONTAPOUPANCA));
        listaConta.add(new ContaPoupanca("666666666-33", 52412, 125,ContasEnum.CONTAPOUPANCA));

        return listaConta;
    }
}
